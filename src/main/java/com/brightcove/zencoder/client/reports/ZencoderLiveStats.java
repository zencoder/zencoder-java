package com.brightcove.zencoder.client.reports;

import java.text.ParseException;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @see https://app.zencoder.com/docs/api/reports/live
 */
public class ZencoderLiveStats {

    private String grouping;
    private String collected_on;
    private Long stream_hours;
    private Long billable_stream_hours;
    private Long encoded_hours;
    private Long billable_encoded_hours;
    private Long total_hours;
    private Long total_billable_hours;

    public String getGrouping() {
        return grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping;
    }

    public String getCollectedOn() {
        return collected_on;
    }

    /**
     * Convenience method for parsing Zencoder dates.
     * NOTE: All Date's a in UTC.
     * @throws ParseException
     */
    @JsonIgnore
    public Date getCollectedOnDate() throws ParseException {
        return ZencoderDate.fromZC(collected_on);
    }

    public void setCollectedOn(String collected_on) {
        this.collected_on = collected_on;
    }

    public Long getStreamHours() {
        return stream_hours;
    }

    public void setStreamHours(Long stream_hours) {
        this.stream_hours = stream_hours;
    }

    public Long getBillableStreamHours() {
        return billable_stream_hours;
    }

    public void setBillableStreamHours(Long billable_stream_hours) {
        this.billable_stream_hours = billable_stream_hours;
    }

    public Long getEncodedHours() {
        return encoded_hours;
    }

    public void setEncodedHours(Long encoded_hours) {
        this.encoded_hours = encoded_hours;
    }

    public Long getBillableEncodedHours() {
        return billable_encoded_hours;
    }

    public void setBillableEncodedHours(Long billable_encoded_hours) {
        this.billable_encoded_hours = billable_encoded_hours;
    }

    public Long getTotalHours() {
        return total_hours;
    }

    public void setTotalHours(Long total_hours) {
        this.total_hours = total_hours;
    }

    public Long getTotalBillableHours() {
        return total_billable_hours;
    }

    public void setTotalBillableHours(Long total_billable_hours) {
        this.total_billable_hours = total_billable_hours;
    }

}
