package com.brightcove.zencoder.client.reports;

import java.util.List;

/**
 * @see https://app.zencoder.com/docs/api/reports/live
 */
public class ZencoderLiveUsage {

    private ZencoderLiveStats total;
    private List<ZencoderLiveStats> statistics;

    /**
     * No-arg constructor needed for serialization/deserialization.
     */
    public ZencoderLiveUsage() {
    }

    public ZencoderLiveStats getTotal() {
        return total;
    }

    public void setTotal(ZencoderLiveStats total) {
        this.total = total;
    }

    public List<ZencoderLiveStats> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<ZencoderLiveStats> statistics) {
        this.statistics = statistics;
    }

}
