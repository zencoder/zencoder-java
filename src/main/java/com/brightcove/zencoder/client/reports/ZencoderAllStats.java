package com.brightcove.zencoder.client.reports;

import java.util.List;

public class ZencoderAllStats {

    private List<ZencoderLiveStats> live;
    private List<ZencoderVodStats> vod;

    public List<ZencoderLiveStats> getLive() {
        return live;
    }
    public void setLive(List<ZencoderLiveStats> live) {
        this.live = live;
    }
    public List<ZencoderVodStats> getVod() {
        return vod;
    }
    public void setVod(List<ZencoderVodStats> vod) {
        this.vod = vod;
    }
}
