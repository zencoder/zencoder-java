package com.brightcove.zencoder.client.request;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.brightcove.zencoder.client.model.AsperaTransferPolicy;
import com.brightcove.zencoder.client.model.Notification;
import com.brightcove.zencoder.client.model.Region;

/**
 * @see https://app.zencoder.com/docs/api/jobs/create
 * @see https://app.zencoder.com/docs/api/encoding/job
 */
public class ZencoderCreateJobRequest {

    private String api_key;
    private String input;
    private List<ZencoderOutput> outputs = new ArrayList<ZencoderOutput>();
    private Region region;
    private Boolean test;
    @JsonProperty("private") private Boolean privacy;
    private Integer download_connections;
    private String pass_through;
    private Boolean mock;
    private String grouping;
    private AsperaTransferPolicy aspera_transfer_policy;
    private Long transfer_minimum_rate;
    private Long transfer_maximum_rate;
    private String expected_md5_checksum;
    private String credentials;
    private List<Notification> notifications = new ArrayList<Notification>();
    private Boolean live_stream;
    private Integer event_length;
    private Integer reconnect_time;

    public ZencoderCreateJobRequest() {
    }

    public String getApiKey() {
        return api_key;
    }

    public void setApiKey(String api_key) {
        this.api_key = api_key;
    }

    public Integer getDownloadConnections() {
        return download_connections;
    }

    public void setDownloadConnections(Integer download_connections) {
        this.download_connections = download_connections;
    }

    public String getExpectedMD5Checksum() {
        return expected_md5_checksum;
    }

    public void setExpectedMD5Checksum(String expectedMD5Checksum) {
        this.expected_md5_checksum = expectedMD5Checksum;
    }

    public String getGrouping() {
        return grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping;
    }

    public AsperaTransferPolicy getAsperaTransferPolicy() {
        return aspera_transfer_policy;
    }

    public void setAsperaTransferPolicy(AsperaTransferPolicy aspera_transfer_policy) {
        this.aspera_transfer_policy = aspera_transfer_policy;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Boolean getMock() {
        return mock;
    }

    public void setMock(Boolean mock) {
        this.mock = mock;
    }

    public List<ZencoderOutput> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<ZencoderOutput> outputs) {
        this.outputs = outputs;
    }

    public String getPassThrough() {
        return pass_through;
    }

    public void setPassThrough(String passThrough) {
        this.pass_through = passThrough;
    }

    public Boolean getPrivate() {
        return privacy;
    }

    public void setPrivate(Boolean privacy) {
        this.privacy = privacy;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Boolean getTest() {
        return test;
    }

    public void setTest(Boolean test) {
        this.test = test;
    }

    public Long getTransferMaximumRate() {
        return transfer_maximum_rate;
    }

    public void setTransferMaximumRate(Long transferMaximumRate) {
        this.transfer_maximum_rate = transferMaximumRate;
    }

    public Long getTransferMinimumRate() {
        return transfer_minimum_rate;
    }

    public void setTransferMinimumRate(Long transferMinimumRate) {
        this.transfer_minimum_rate = transferMinimumRate;
    }

    public ZencoderCreateJobRequest(String input) {
        this.input = input;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public Boolean getLiveStream() {
        return live_stream;
    }

    public void setLiveStream(Boolean live_stream) {
        this.live_stream = live_stream;
    }

    public Integer getEventLength() {
        return event_length;
    }

    public void setEventLength(Integer event_length) {
        this.event_length = event_length;
    }

    public Integer getReconnectTime() {
        return reconnect_time;
    }

    public void setReconnectTime(Integer reconnect_time) {
        this.reconnect_time = reconnect_time;
    }

}
