package com.brightcove.zencoder.client;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.brightcove.zencoder.client.account.ZencoderAccountDetails;
import com.brightcove.zencoder.client.account.ZencoderAccountState;
import com.brightcove.zencoder.client.account.ZencoderBillingState;
import com.brightcove.zencoder.client.model.AACProfile;
import com.brightcove.zencoder.client.model.AudioCodec;
import com.brightcove.zencoder.client.model.ContainerFormat;
import com.brightcove.zencoder.client.model.EmailNotification;
import com.brightcove.zencoder.client.model.State;
import com.brightcove.zencoder.client.model.Thumbnail;
import com.brightcove.zencoder.client.model.ThumbnailCollection;
import com.brightcove.zencoder.client.model.UrlNotification;
import com.brightcove.zencoder.client.model.VideoCodec;
import com.brightcove.zencoder.client.reports.ZencoderAllUsage;
import com.brightcove.zencoder.client.reports.ZencoderLiveUsage;
import com.brightcove.zencoder.client.reports.ZencoderVodUsage;
import com.brightcove.zencoder.client.request.ZencoderCreateJobRequest;
import com.brightcove.zencoder.client.request.ZencoderOutput;
import com.brightcove.zencoder.client.response.ZencoderCreateJobResponse;
import com.brightcove.zencoder.client.response.ZencoderInputOutputProgress;
import com.brightcove.zencoder.client.response.ZencoderJobDetail;
import com.brightcove.zencoder.client.response.ZencoderMediaFile;

public class ZencoderClientTest {

    // This is an integration-mode only test key, please do not abuse it.
    public static final String TEST_API_KEY = "e7ee309db6ec095e4b14dd2291c7b303";

    @Test
    public void testSimpleTranscode() throws ZencoderClientException {
        ZencoderClient client = new ZencoderClient(TEST_API_KEY);

        ZencoderCreateJobRequest job = new ZencoderCreateJobRequest();
        job.setInput("s3://zencodertesting/test.mov");
        job.setTest(true);
        List<ZencoderOutput> outputs = new ArrayList<ZencoderOutput>();

        ZencoderOutput output1 = new ZencoderOutput();
        output1.setFormat(ContainerFormat.MP4);
        outputs.add(output1);

        ZencoderOutput output2 = new ZencoderOutput();
        output2.setFormat(ContainerFormat.WEBM);
        outputs.add(output2);

        job.setOutputs(outputs);
        ZencoderCreateJobResponse response = client.createZencoderJob(job);

        String jobId = response.getId();
        ZencoderJobDetail details = client.getZencoderJob(jobId);
        String inputId = details.getInputMediaFile().getId();
        String outputId1 = response.getOutputs().get(0).getId();
        String outputId2 = response.getOutputs().get(1).getId();

        ZencoderInputOutputProgress inputProgress = client.getInputProgress(inputId);
        assertNotNull(inputProgress);
        ZencoderInputOutputProgress outputProgress1 = client.getOutputProgress(outputId1);
        assertNotNull(outputProgress1);
        ZencoderInputOutputProgress outputProgress2 = client.getOutputProgress(outputId2);
        assertNotNull(outputProgress2);
    }

    @Test
    public void testAccounts() throws ZencoderClientException {
        ZencoderClient client = new ZencoderClient(TEST_API_KEY);
        ZencoderAccountDetails details = client.getAccountDetails();
        assertEquals(ZencoderAccountState.ACTIVE, details.getAccountState());
        assertEquals(ZencoderBillingState.NONE, details.getBillingState());
        assertTrue(details.getIntegrationMode());
        assertEquals((Long) 0L, details.getMinutesIncluded());
        assertTrue(details.getMinutesUsed() > -1);
    }

    @Test
    public void testReports() throws ZencoderClientException {
        ZencoderClient client = new ZencoderClient(TEST_API_KEY);
        ZencoderVodUsage vodUsage = client.getUsageForVod(null, null, null);
        assertNotNull(vodUsage);
        assertNotNull(vodUsage.getTotal());
        assertTrue(vodUsage.getTotal().getBillableMinutes() == 0);
        assertTrue(vodUsage.getTotal().getEncodedMinutes() >= 0);
        assertNotNull(vodUsage.getStatistics());

        ZencoderLiveUsage liveUsage = client.getUsageForLive(null, null, null);
        assertNotNull(liveUsage);
        assertNotNull(liveUsage.getTotal());
        assertTrue(liveUsage.getTotal().getBillableStreamHours() == 0);
        assertTrue(liveUsage.getTotal().getStreamHours() >= 0);
        assertNotNull(liveUsage.getStatistics());

        ZencoderAllUsage allUsage = client.getUsageForVodAndLive(null, null, null);
        assertNotNull(allUsage);
        assertNotNull(allUsage.getTotal());
        assertTrue(allUsage.getTotal().getVod().getBillableMinutes() == 0);
        assertTrue(allUsage.getTotal().getVod().getEncodedMinutes() >= 0);
        assertTrue(allUsage.getTotal().getLive().getBillableEncodedHours() == 0);
        assertTrue(allUsage.getTotal().getLive().getEncodedHours() >= 0);
    }

    @Test
    public void testThumbnails() throws ZencoderClientException, InterruptedException {
        ZencoderClient client = new ZencoderClient(TEST_API_KEY);

        ZencoderCreateJobRequest job = new ZencoderCreateJobRequest();
        job.setInput("s3://zencodertesting/test.mov");
        job.setTest(true);
        List<ZencoderOutput> outputs = new ArrayList<ZencoderOutput>();

        ZencoderOutput output1 = new ZencoderOutput();
        output1.setFormat(ContainerFormat.MP4);
        List<Thumbnail> thumbnails = new ArrayList<Thumbnail>();

        Thumbnail thumb1 = new Thumbnail();
        thumb1.setLabel("thumb1");
        thumb1.setHeight(64);
        thumb1.setWidth(64);
        thumbnails.add(thumb1);

        Thumbnail thumb2 = new Thumbnail();
        thumb2.setLabel("thumb2");
        thumb2.setHeight(640);
        thumb2.setWidth(480);
        thumbnails.add(thumb2);
        output1.setThumbnails(thumbnails);

        outputs.add(output1);
        job.setOutputs(outputs);
        ZencoderCreateJobResponse response = client.createZencoderJob(job);

        String jobId = response.getId();
        String outputId = response.getOutputs().get(0).getId();

        boolean done = false;
        while (!done) {
            ZencoderInputOutputProgress progress = client.getOutputProgress(outputId);
            if (progress.getState().equals(State.FINISHED)) {
                done = true;
            }
            Thread.sleep(1000);
        }

        ZencoderJobDetail details = client.getZencoderJob(jobId);
        assertEquals(1, details.getOutputMediaFiles().size());
        assertEquals(2, details.getThumbnails().size());

        ZencoderMediaFile outputDetails = client.getOutputDetails(outputId);
        assertNotNull(outputDetails.getThumbnails());
        assertEquals(2, outputDetails.getThumbnails().size());
        for (ThumbnailCollection col : outputDetails.getThumbnails()) {
            if (col.getLabel().equals("thumb1")) {
                assertNotNull(col.getImages());
                assertEquals(1, col.getImages().size());
                assertEquals("64x36", col.getImages().get(0).getDimensions());

            } else if (col.getLabel().equals("thumb2")) {
                assertNotNull(col.getImages());
                assertEquals(1, col.getImages().size());
                assertEquals("480x270", col.getImages().get(0).getDimensions());

            } else {
                fail("Invalid thumbnail recived");
            }
        }
    }

    @Test
    public void testEnumsWithMultipleRepresentations() throws Exception {
        ZencoderClient client = new ZencoderClient(TEST_API_KEY);
        ObjectMapper mapper = client.createObjectMapper();

        assertEquals(ContainerFormat.MP4, mapper.readValue("\"mp4\"", ContainerFormat.class));
        assertEquals(ContainerFormat.MP4, mapper.readValue("\"mpeg4\"", ContainerFormat.class));

        assertEquals(ContainerFormat.FLV, mapper.readValue("\"flv\"", ContainerFormat.class));
        assertEquals(ContainerFormat.FLV, mapper.readValue("\"flash video\"", ContainerFormat.class));

        assertEquals(ContainerFormat.TS, mapper.readValue("\"ts\"", ContainerFormat.class));
        assertEquals(ContainerFormat.TS, mapper.readValue("\"mpeg-ts\"", ContainerFormat.class));
    }

    @Test
    public void testEnumsWithUnsupportedRepresentations() throws Exception {
        ZencoderClient client = new ZencoderClient(TEST_API_KEY);
        ObjectMapper mapper = client.createObjectMapper();

        assertEquals(ContainerFormat.UNKNOWN, mapper.readValue("\"avi\"", ContainerFormat.class));
        assertEquals(VideoCodec.UNKNOWN, mapper.readValue("\"flv1\"", VideoCodec.class));
        assertEquals(AudioCodec.UNKNOWN, mapper.readValue("\"wav\"", AudioCodec.class));
    }

    @Test
    public void testNotificationSerialization() throws Exception {
        ZencoderClient client = new ZencoderClient(TEST_API_KEY);
        ObjectMapper mapper = client.createObjectMapper();

        ZencoderCreateJobRequest job = new ZencoderCreateJobRequest();
        job.setInput("s3://zencodertesting/test.mov");
        job.setTest(true);

        EmailNotification emailNotification = new EmailNotification("foo@example.com");
        job.getNotifications().add(emailNotification);
        UrlNotification urlNotification = new UrlNotification("http://www.example.com/");
        job.getNotifications().add(urlNotification);

        ZencoderOutput output1 = new ZencoderOutput();
        output1.setFormat(ContainerFormat.MP4);
        output1.setForceAACProfile(AACProfile.AAC_LC);
        job.getOutputs().add(output1);

        final String emailNotificationJson = mapper.writeValueAsString(job);
        assertEquals("{\"input\":\"s3://zencodertesting/test.mov\",\"outputs\":[{\"format\":\"mp4\",\"force_aacprofile\":\"aac-lc\"}],\"test\":true,\"notifications\":[\"foo@example.com\",{\"format\":\"json\",\"url\":\"http://www.example.com/\"}]}", emailNotificationJson);
    }
}
