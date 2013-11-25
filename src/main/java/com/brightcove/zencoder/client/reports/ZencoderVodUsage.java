package com.brightcove.zencoder.client.reports;

import java.util.List;

/**
 * @see https://app.zencoder.com/docs/api/reports/vod
 */
public class ZencoderVodUsage {

    private ZencoderVodStats total;
    private List<ZencoderVodStats> statistics;

    /**
     * No-arg constructor needed for serialization/deserialization.
     */
    public ZencoderVodUsage() {
    }

    public ZencoderVodStats getTotal() {
        return total;
    }

    public void setTotal(ZencoderVodStats total) {
        this.total = total;
    }

    public List<ZencoderVodStats> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<ZencoderVodStats> statistics) {
        this.statistics = statistics;
    }

}
