package com.brightcove.zencoder.client.model;


/**
 * @see https://app.zencoder.com/docs/api/encoding/format-and-codecs/video-codec
 */
public enum VideoCodec {

    H264("h264"),
    MPEG4("mpeg4"),
    THEORA("theora"),
    VP6("vp6"),
    VP8("vp8"),
    WMV("wmv");

    private String name;

    VideoCodec(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
