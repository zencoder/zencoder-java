/**
 * Copyright (C) 2013 Brightcove Inc. All Rights Reserved. No use, copying or distribution of this
 * work may be made except in accordance with a valid license agreement from Brightcove Inc. This
 * notice must be included on all copies, modifications and derivatives of this work.
 * 
 * Brightcove Inc MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT. BRIGHTCOVE SHALL NOT BE
 * LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS
 * SOFTWARE OR ITS DERIVATIVES.
 * 
 * "Brightcove" is a registered trademark of Brightcove Inc.
 */
package com.brightcove.zencoder.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.type.TypeFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.brightcove.zencoder.client.account.ZencoderAccount;
import com.brightcove.zencoder.client.account.ZencoderAccountDetails;
import com.brightcove.zencoder.client.reports.ZencoderAllUsage;
import com.brightcove.zencoder.client.reports.ZencoderDate;
import com.brightcove.zencoder.client.reports.ZencoderLiveUsage;
import com.brightcove.zencoder.client.reports.ZencoderVodUsage;
import com.brightcove.zencoder.client.request.ZencoderCreateJobRequest;
import com.brightcove.zencoder.client.response.ZencoderCreateJobResponse;
import com.brightcove.zencoder.client.response.ZencoderInputOutputProgress;
import com.brightcove.zencoder.client.response.ZencoderJobDetail;
import com.brightcove.zencoder.client.response.ZencoderJobDetailResponse;
import com.brightcove.zencoder.client.response.ZencoderJobProgress;
import com.brightcove.zencoder.client.response.ZencoderMediaFile;

public class ZencoderClient {

    public static final String API_URL = "https://app.zencoder.com/api/v2";

    private String api_key;
    private String api_url;

    private RestTemplate rt;
    private ObjectMapper mapper;

    @SuppressWarnings("deprecation")
    public ZencoderClient(String api_key) {
        this.api_key = api_key;
        this.api_url = API_URL;
        this.rt = new RestTemplate();
        this.mapper = new ObjectMapper();

        mapper.configure(SerializationConfig.Feature.WRITE_NULL_PROPERTIES, false);
        mapper.configure(SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING, true);
        mapper.configure(DeserializationConfig.Feature.READ_ENUMS_USING_TO_STRING, true);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
        // If Zencoder adds a new field before we have a chance to update, silently ignore these fields.
        // NOTE: disable this during testing
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public String getApiKey() {
        return api_key;
    }

    public void setApiKey(String api_key) {
        this.api_key = api_key;
    }

    public String getApiUrl() {
        return api_url;
    }

    public void setApiUrl(String api_url) {
        this.api_url = api_url;
    }

    public RestTemplate getRestTemplate() {
        return rt;
    }

    public void setRestTemplate(RestTemplate rt) {
        this.rt = rt;
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        headers.add("Zencoder-Api-Key", api_key);
        headers.add("User-Agent", "zencoder-java-2.0");
        return headers;
    }

    /**
     * Creates a VOD transcode job.
     * 
     * @see https://app.zencoder.com/docs/api/jobs/create
     * @param job
     * @return ZencoderJobResponse
     * @throws ZencoderClientException
     */
    public ZencoderCreateJobResponse createZencoderJob(ZencoderCreateJobRequest job)
            throws ZencoderClientException {
        String url = api_url + "/jobs";
        String body = null;
        try {
            body = mapper.writeValueAsString(job);

        } catch (Exception e) {
            throw new ZencoderClientException(
                    "Unable to serialize ZencoderCreateJobRequest as JSON",
                    e);
        }

        HttpHeaders headers = getHeaders();
        @SuppressWarnings("rawtypes")
        HttpEntity entity = new HttpEntity<String>(body, headers);

        ResponseEntity<String> response = null;
        try {
            response = rt.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    String.class,
                    new HashMap<String, Object>());

        } catch (HttpClientErrorException hcee) {
            throw new ZencoderClientException(hcee.getResponseBodyAsString(), hcee);
        }

        ZencoderCreateJobResponse zencoderJobResponse = null;
        try {
            zencoderJobResponse = mapper.readValue(
                    response.getBody(),
                    ZencoderCreateJobResponse.class);

        } catch (Exception e) {
            throw new ZencoderClientException(
                    "Unable to deserialize ZencoderCreateJobResponse as JSON",
                    e);
        }

        return zencoderJobResponse;
    }

    /**
     * Lists the most recent jobs created (up to 50)
     *
     * @return A list of jobs.
     * @throws ZencoderClientException
     */
    public List<ZencoderJobDetail> listJobs() throws ZencoderClientException {
        return listJobs(1, 50);
    }

    /**
     * Lists jobs with pagination.
     *
     * @param page Which page to return
     * @param per_page How many jobs per page to return
     * @return A list of jobs.
     * @throws ZencoderClientException
     */
    public List<ZencoderJobDetail> listJobs(Integer page, Integer per_page) throws ZencoderClientException {
        String url = api_url + "/jobs";
        if (page != null || per_page != null) {
            if (page == null) {
                page = 1;
            }
            if (per_page == null) {
                per_page = 50;
            }
            url = url + "?page=" + page + "&per_page=" + per_page;
        }

        HttpHeaders headers = getHeaders();
        @SuppressWarnings("rawtypes")
        HttpEntity entity = new HttpEntity<String>("", headers);

        ResponseEntity<String> response = null;
        try {
            response = rt.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    String.class,
                    new HashMap<String, Object>());

        } catch (HttpClientErrorException hcee) {
            throw new ZencoderClientException(hcee.getResponseBodyAsString(), hcee);
        }

        List<ZencoderJobDetailResponse> jobs = null;
        try {
            TypeFactory typeFactory = TypeFactory.defaultInstance();
            jobs = mapper.readValue(
                    response.getBody(),
                    typeFactory.constructCollectionType(List.class, ZencoderJobDetailResponse.class));

        } catch (Exception e) {
            throw new ZencoderClientException(
                    "Unable to deserialize ZencoderCreateJobResponse as JSON",
                    e);
        }

        List<ZencoderJobDetail> job_details = new ArrayList<ZencoderJobDetail>();
        for (ZencoderJobDetailResponse job : jobs) {
            job_details.add(job.getJob());
        }

        return job_details;
    }

    /**
     * Gets details about an existing VOD transcode job.
     * 
     * @see https://app.zencoder.com/docs/api/jobs/show
     * @param id
     * @return
     * @throws ZencoderClientException
     */
    public ZencoderJobDetail getZencoderJob(String id) throws ZencoderClientException {
        String url = api_url + "/jobs/" + id + ".json";

        HttpHeaders headers = getHeaders();
        @SuppressWarnings("rawtypes")
        HttpEntity entity = new HttpEntity<String>("", headers);

        ResponseEntity<String> response = null;
        try {
            response = rt.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    String.class,
                    new HashMap<String, Object>());

        } catch (HttpClientErrorException hcee) {
            throw new ZencoderClientException(hcee.getResponseBodyAsString(), hcee);
        }

        ZencoderJobDetailResponse job_details = null;
        try {
            job_details = mapper.readValue(response.getBody(), ZencoderJobDetailResponse.class);

        } catch (Exception e) {
            throw new ZencoderClientException(
                    "Unable to deserialize ZencoderCreateJobResponse as JSON",
                    e);
        }

        return job_details.getJob();
    }

    /**
     * Gets progress information about an existing VOD transcode job.
     * 
     * @see https://app.zencoder.com/docs/api/jobs/progress
     * @param id
     * @return
     * @throws ZencoderClientException
     */
    public ZencoderJobProgress getJobProgress(String id) throws ZencoderClientException {
        String url = api_url + "/jobs/" + id + "/progress.json";

        HttpHeaders headers = getHeaders();
        @SuppressWarnings("rawtypes")
        HttpEntity entity = new HttpEntity<String>("", headers);

        ResponseEntity<String> response = null;
        try {
            response = rt.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    String.class,
                    new HashMap<String, Object>());

        } catch (HttpClientErrorException hcee) {
            throw new ZencoderClientException(hcee.getResponseBodyAsString(), hcee);
        }

        ZencoderJobProgress job_progress = null;
        try {
            job_progress = mapper.readValue(response.getBody(), ZencoderJobProgress.class);

        } catch (Exception e) {
            throw new ZencoderClientException(
                    "Unable to deserialize ZencoderCreateJobResponse as JSON",
                    e);
        }

        return job_progress;
    }

    /**
     * Gets progress information about an existing VOD transcode input.
     * 
     * @see https://app.zencoder.com/docs/api/inputs/progress
     * @param id
     * @return
     * @throws ZencoderClientException
     */
    public ZencoderInputOutputProgress getInputProgress(String id) throws ZencoderClientException {
        String url = api_url + "/inputs/" + id + "/progress.json";

        HttpHeaders headers = getHeaders();
        @SuppressWarnings("rawtypes")
        HttpEntity entity = new HttpEntity<String>("", headers);

        ResponseEntity<String> response = null;
        try {
            response = rt.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    String.class,
                    new HashMap<String, Object>());

        } catch (HttpClientErrorException hcee) {
            throw new ZencoderClientException(hcee.getResponseBodyAsString(), hcee);
        }

        ZencoderInputOutputProgress input_progress = null;
        try {
            input_progress = mapper.readValue(response.getBody(), ZencoderInputOutputProgress.class);

        } catch (Exception e) {
            throw new ZencoderClientException(
                    "Unable to deserialize ZencoderInputOutputProgress as JSON",
                    e);
        }

        return input_progress;
    }

    /**
     * Gets progress information about an existing VOD transcode output.
     * 
     * @see https://app.zencoder.com/docs/api/outputs/progress
     * @param id
     * @return
     * @throws ZencoderClientException
     */
    public ZencoderInputOutputProgress getOutputProgress(String id) throws ZencoderClientException {
        String url = api_url + "/outputs/" + id + "/progress.json";

        HttpHeaders headers = getHeaders();
        @SuppressWarnings("rawtypes")
        HttpEntity entity = new HttpEntity<String>("", headers);

        ResponseEntity<String> response = null;
        try {
            response = rt.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    String.class,
                    new HashMap<String, Object>());

        } catch (HttpClientErrorException hcee) {
            throw new ZencoderClientException(hcee.getResponseBodyAsString(), hcee);
        }

        ZencoderInputOutputProgress output_progress = null;
        try {
            output_progress = mapper.readValue(
                    response.getBody(),
                    ZencoderInputOutputProgress.class);

        } catch (Exception e) {
            throw new ZencoderClientException(
                    "Unable to deserialize ZencoderInputOutputProgress as JSON",
                    e);
        }

        return output_progress;
    }

    /**
     * Gets the details of a given input.
     *
     * @param id
     * @return
     * @throws ZencoderClientException
     */
    public ZencoderMediaFile getInputDetails(String id) throws ZencoderClientException {
        String url = api_url + "/inputs/" + id + ".json";

        HttpHeaders headers = getHeaders();
        @SuppressWarnings("rawtypes")
        HttpEntity entity = new HttpEntity<String>("", headers);

        ResponseEntity<String> response = null;
        try {
            response = rt.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    String.class,
                    new HashMap<String, Object>());

        } catch (HttpClientErrorException hcee) {
            throw new ZencoderClientException(hcee.getResponseBodyAsString(), hcee);
        }

        ZencoderMediaFile input_details = null;
        try {
            input_details = mapper.readValue(
                    response.getBody(),
                    ZencoderMediaFile.class);

        } catch (Exception e) {
            throw new ZencoderClientException(
                    "Unable to deserialize ZencoderMediaFile as JSON",
                    e);
        }

        return input_details;
    }

    /**
     * Gets the details of a given output.
     *
     * @see https://app.zencoder.com/docs/api/outputs/show
     * @param id
     * @return
     * @throws ZencoderClientException
     */
    public ZencoderMediaFile getOutputDetails(String id) throws ZencoderClientException {
        String url = api_url + "/outputs/" + id + ".json";

        HttpHeaders headers = getHeaders();
        @SuppressWarnings("rawtypes")
        HttpEntity entity = new HttpEntity<String>("", headers);

        ResponseEntity<String> response = null;
        try {
            response = rt.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    String.class,
                    new HashMap<String, Object>());

        } catch (HttpClientErrorException hcee) {
            throw new ZencoderClientException(hcee.getResponseBodyAsString(), hcee);
        }

        ZencoderMediaFile output_details = null;
        try {
            output_details = mapper.readValue(
                    response.getBody(),
                    ZencoderMediaFile.class);

        } catch (Exception e) {
            throw new ZencoderClientException(
                    "Unable to deserialize ZencoderMediaFile as JSON",
                    e);
        }

        return output_details;
    }

    /**
     * If a job has failed processing you may request that it be attempted again.
     *
     * @see https://app.zencoder.com/docs/api/jobs/resubmit
     * @param id
     * @throws ZencoderClientException
     */
    public void resubmitJob(String id) throws ZencoderClientException {
        String url = api_url + "/jobs/" + id + "/resubmit.json";

        HttpHeaders headers = getHeaders();
        @SuppressWarnings("rawtypes")
        HttpEntity entity = new HttpEntity<String>("", headers);

        try {
            rt.exchange(
                    url,
                    HttpMethod.PUT,
                    entity,
                    String.class,
                    new HashMap<String, Object>());

        } catch (HttpClientErrorException hcee) {
            throw new ZencoderClientException(hcee.getResponseBodyAsString(), hcee);
        }
    }

    /**
     * If you wish to cancel a job that has not yet finished processing.
     *
     * @see https://app.zencoder.com/docs/api/jobs/cancel
     * @param id
     * @throws ZencoderClientException
     */
    public void cancelJob(String id) throws ZencoderClientException {
        String url = api_url + "/jobs/" + id + "/resubmit.json";

        HttpHeaders headers = getHeaders();
        @SuppressWarnings("rawtypes")
        HttpEntity entity = new HttpEntity<String>("", headers);

        try {
            rt.exchange(
                    url,
                    HttpMethod.PUT,
                    entity,
                    String.class,
                    new HashMap<String, Object>());

        } catch (HttpClientErrorException hcee) {
            throw new ZencoderClientException(hcee.getResponseBodyAsString(), hcee);
        }
    }

    /**
     * Finishes the input on a Live streaming job. Has no effect on non-Live jobs.
     *
     * @see https://app.zencoder.com/docs/api/jobs/finish
     * @param id
     * @throws ZencoderClientException
     */
    public void finishLiveJob(String id) throws ZencoderClientException {
        String url = api_url + "/jobs/" + id + "/finish";

        HttpHeaders headers = getHeaders();
        @SuppressWarnings("rawtypes")
        HttpEntity entity = new HttpEntity<String>("", headers);

        try {
            rt.exchange(
                    url,
                    HttpMethod.PUT,
                    entity,
                    String.class,
                    new HashMap<String, Object>());

        } catch (HttpClientErrorException hcee) {
            throw new ZencoderClientException(hcee.getResponseBodyAsString(), hcee);
        }
    }

    // Accounts API - https://app.zencoder.com/docs/api/accounts

    /**
     * Creates a Zencoder Account.
     * New accounts will be created under the Test (Free) plan.
     * NOTE: A password will be generated and returned if not specified.
     *
     * @see https://app.zencoder.com/docs/api/accounts/create
     * @see http://zencoder.com/en/terms
     * @param account The account to create.
     * @return The created account with it's API key and password.
     * @throws ZencoderClientException
     */
    public ZencoderAccount createAccount(ZencoderAccount account) throws ZencoderClientException {
        String url = api_url + "/account";

        String body = null;
        try {
            body = mapper.writeValueAsString(account);

        } catch (Exception e) {
            throw new ZencoderClientException(
                    "Unable to serialize ZencoderAccount as JSON", e);
        }

        HttpHeaders headers = getHeaders();
        @SuppressWarnings("rawtypes")
        HttpEntity entity = new HttpEntity<String>(body, headers);

        ResponseEntity<String> response = null;
        try {
            response = rt.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    String.class,
                    new HashMap<String, Object>());

        } catch (HttpClientErrorException hcee) {
            throw new ZencoderClientException(hcee.getResponseBodyAsString(), hcee);
        }

        ZencoderAccount zencoderAccountResponse = null;
        try {
            zencoderAccountResponse = mapper.readValue(response.getBody(),
                    ZencoderAccount.class);

        } catch (Exception e) {
            throw new ZencoderClientException(
                    "Unable to deserialize ZencoderAccount as JSON", e);
        }
        return zencoderAccountResponse;
    }

    /**
     * Retrieve your Zencoder Account Details
     *
     * @see https://app.zencoder.com/docs/api/accounts/show
     * @return The status and billing details for this account.
     * @throws ZencoderClientException
     */
    public ZencoderAccountDetails getAccountDetails() throws ZencoderClientException {
        String url = api_url + "/account";

        HttpHeaders headers = getHeaders();
        @SuppressWarnings("rawtypes")
        HttpEntity entity = new HttpEntity<String>("", headers);

        ResponseEntity<String> response = null;
        try {
            response = rt.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    String.class,
                    new HashMap<String, Object>());

        } catch (HttpClientErrorException hcee) {
            throw new ZencoderClientException(hcee.getResponseBodyAsString(), hcee);
        }

        ZencoderAccountDetails account_details = null;
        try {
            account_details = mapper.readValue(
                    response.getBody(),
                    ZencoderAccountDetails.class);

        } catch (Exception e) {
            throw new ZencoderClientException(
                    "Unable to deserialize ZencoderAccountDetails as JSON",
                    e);
        }

        return account_details; 
    }

    /**
     * Sets whether or not your account should be in the limited integration mode.
     * Use 'true' to make your account limited to integration mode.
     * Use 'false' to make your account a regular account.
     *
     * @see https://app.zencoder.com/docs/api/accounts/integration
     * @param integration_mode Integration Mode setting.
     * @throws ZencoderClientException 
     */
    public void setAccountIntegrationMode(boolean integration_mode) throws ZencoderClientException {
        String url = null;
        if (integration_mode) {
            url = api_url + "/account/integration";
        } else {
            url = api_url + "/account/live";
        }

        HttpHeaders headers = getHeaders();
        @SuppressWarnings("rawtypes")
        HttpEntity entity = new HttpEntity<String>("", headers);

        try {
            rt.exchange(
                    url,
                    HttpMethod.PUT,
                    entity,
                    String.class,
                    new HashMap<String, Object>());

        } catch (HttpClientErrorException hcee) {
            throw new ZencoderClientException(hcee.getResponseBodyAsString(), hcee);
        }
    }

    // Reports API - https://app.zencoder.com/docs/api/reports

    /**
     * The VOD usage for the specified time period.
     *
     * NOTE: It's important to note that our service operates in the UTC time zone
     * (including billing periods). All dates and times reported will be in UTC.
     *
     * @see https://app.zencoder.com/docs/api/reports/vod
     * @see https://app.zencoder.com/docs/api/encoding/job/grouping
     * @param from
     *            (optional) Start date (default: 30 days ago).
     * @param to
     *            (optional) End date (default: yesterday).
     * @param grouping
     *            (optional) Minute usage for only one report grouping (default: none).
     * @return The VOD usage for the specified time period.
     * @throws ZencoderClientException
     */
    public ZencoderVodUsage getUsageForVod(Date from, Date to, String grouping) throws ZencoderClientException {
        String url = api_url + "/reports/vod" + createUsageQueryArgString(from, to, grouping);

        HttpHeaders headers = getHeaders();
        @SuppressWarnings("rawtypes")
        HttpEntity entity = new HttpEntity<String>("", headers);

        ResponseEntity<String> response = null;
        try {
            response = rt.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    String.class,
                    new HashMap<String, Object>());

        } catch (HttpClientErrorException hcee) {
            throw new ZencoderClientException(hcee.getResponseBodyAsString(), hcee);
        }

        ZencoderVodUsage usage = null;
        try {
            usage = mapper.readValue(
                    response.getBody(),
                    ZencoderVodUsage.class);

        } catch (Exception e) {
            throw new ZencoderClientException(
                    "Unable to deserialize ZencoderVodUsage as JSON",
                    e);
        }

        return usage;
    }

    /**
     * The Live usage for the specified time period.
     *
     * NOTE: It's important to note that our service operates in the UTC time zone
     * (including billing periods). All dates and times reported will be in UTC.
     *
     * @see https://app.zencoder.com/docs/api/reports/live
     * @see https://app.zencoder.com/docs/api/encoding/job/grouping
     * @param from
     *            (optional) Start date (default: 30 days ago).
     * @param to
     *            (optional) End date (default: yesterday).
     * @param grouping
     *            (optional) Minute usage for only one report grouping (default: none).
     * @return The Live usage for the specified time period.
     * @throws ZencoderClientException
     */
    public ZencoderLiveUsage getUsageForLive(Date from, Date to, String grouping) throws ZencoderClientException {
        String url = api_url + "/reports/live" + createUsageQueryArgString(from, to, grouping);

        HttpHeaders headers = getHeaders();
        @SuppressWarnings("rawtypes")
        HttpEntity entity = new HttpEntity<String>("", headers);

        ResponseEntity<String> response = null;
        try {
            response = rt.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    String.class,
                    new HashMap<String, Object>());

        } catch (HttpClientErrorException hcee) {
            throw new ZencoderClientException(hcee.getResponseBodyAsString(), hcee);
        }

        ZencoderLiveUsage usage = null;
        try {
            usage = mapper.readValue(
                    response.getBody(),
                    ZencoderLiveUsage.class);

        } catch (Exception e) {
            throw new ZencoderClientException(
                    "Unable to deserialize ZencoderLiveUsage as JSON",
                    e);
        }

        return usage;
    }


    /**
     * The VOD+Live usage for the specified time period.
     *
     * NOTE: It's important to note that our service operates in the UTC time zone
     * (including billing periods). All dates and times reported will be in UTC.
     *
     * @see https://app.zencoder.com/docs/api/reports/all
     * @see https://app.zencoder.com/docs/api/encoding/job/grouping
     * @param from
     *            (optional) Start date (default: 30 days ago).
     * @param to
     *            (optional) End date (default: yesterday).
     * @param grouping
     *            (optional) Minute usage for only one report grouping (default: none).
     * @return The VOD+Live usage for the specified time period.
     * @throws ZencoderClientException
     */
    public ZencoderAllUsage getUsageForVodAndLive(Date from, Date to, String grouping) throws ZencoderClientException {
        String url = api_url + "/reports/all" + createUsageQueryArgString(from, to, grouping);

        HttpHeaders headers = getHeaders();
        @SuppressWarnings("rawtypes")
        HttpEntity entity = new HttpEntity<String>("", headers);

        ResponseEntity<String> response = null;
        try {
            response = rt.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    String.class,
                    new HashMap<String, Object>());

        } catch (HttpClientErrorException hcee) {
            throw new ZencoderClientException(hcee.getResponseBodyAsString(), hcee);
        }

        ZencoderAllUsage usage = null;
        try {
            usage = mapper.readValue(
                    response.getBody(),
                    ZencoderAllUsage.class);

        } catch (Exception e) {
            throw new ZencoderClientException(
                    "Unable to deserialize ZencoderLiveUsage as JSON",
                    e);
        }

        return usage;
    }

    /**
     * Helper method to generate URL query args String.
     * TODO: refactor this to use some query args library.
     */
    private String createUsageQueryArgString(Date from, Date to, String grouping) {
        String query = "";
        if (from != null || to != null || grouping != null) {
            query += "?";
        }
        if (from != null) {
            query += "from=" + ZencoderDate.toZC(from);
            if (to != null || grouping != null) {
                query += "&";
            }
        }
        if (to != null) {
            query += "to=" + ZencoderDate.toZC(to);
            if (grouping != null) {
                query += "&";
            }
        }
        if (grouping != null) {
            query += "grouping=" + grouping;
        }
        return query;
    }

}
