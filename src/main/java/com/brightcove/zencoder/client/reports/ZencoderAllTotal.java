package com.brightcove.zencoder.client.reports;

/**
 * @see https://app.zencoder.com/docs/api/reports/all
 */
public class ZencoderAllTotal {

    private ZencoderLiveStats live;
    private ZencoderVodStats vod;

    public ZencoderLiveStats getLive() {
        return live;
    }
    public void setLive(ZencoderLiveStats live) {
        this.live = live;
    }
    public ZencoderVodStats getVod() {
        return vod;
    }
    public void setVod(ZencoderVodStats vod) {
        this.vod = vod;
    }

}
