package com.brightcove.zencoder.client.reports;

/**
 * @see https://app.zencoder.com/docs/api/reports/all
 */
public class ZencoderAllUsage {

    private ZencoderAllTotal total;
    private ZencoderAllStats statistics;

    public ZencoderAllTotal getTotal() {
        return total;
    }
    public void setTotal(ZencoderAllTotal total) {
        this.total = total;
    }
    public ZencoderAllStats getStatistics() {
        return statistics;
    }
    public void setStatistics(ZencoderAllStats statistics) {
        this.statistics = statistics;
    }

}
