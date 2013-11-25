package com.brightcove.zencoder.client.reports;

import java.text.ParseException;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @see https://app.zencoder.com/docs/api/reports/vod
 */
public class ZencoderVodStats {

    private String grouping;
    private String collected_on;
    private Long encoded_minutes;
    private Long billable_minutes;

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

    public Long getEncodedMinutes() {
        return encoded_minutes;
    }

    public void setEncodedMinutes(Long encoded_minutes) {
        this.encoded_minutes = encoded_minutes;
    }

    public Long getBillableMinutes() {
        return billable_minutes;
    }

    public void setBillableMinutes(Long billable_minutes) {
        this.billable_minutes = billable_minutes;
    }
}
