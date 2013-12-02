package com.brightcove.zencoder.client.model;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.map.JsonMappingException;


/**
 * @see https://app.zencoder.com/docs/api/encoding/format-and-codecs/video-codec
 */
public enum VideoCodec {

    H264("h264"),
    MPEG4("mpeg4"),
    THEORA("theora"),
    VP6("vp6", "vp6f"),
    VP8("vp8"),
    WMV("wmv", "wmv2"),

    /**
     * This is necessary to support every possible input format Zencoder can
     * consume, but not produce as outputs.
     */
    UNKNOWN("null");

    private String name;
    private List<String> others;

    VideoCodec(String name) {
        this.name = name;
    }

    /**
     * Zencoder does not always return the same String for output formats.
     * This 'other' string fixes the deserialization issues caused by that.
     */
    VideoCodec(String name, String... others) {
        this.name = name;
        this.others = new ArrayList<String>();
        for (String other : others) {
            this.others.add(other);
        }
    }

    @JsonValue
    @Override
    public String toString() {
        return this.name;
    }

    public List<String> otherNames() {
        return others;
    }

    @JsonCreator
    public static VideoCodec fromValue(String other) throws JsonMappingException {
        for (VideoCodec format : VideoCodec.values()) {
            if (format.toString().equalsIgnoreCase(other)) {
                return format;
            }
            if (format.otherNames() != null && format.otherNames().contains(other)) {
                return format;
            }
        }
        return UNKNOWN;
    }

}
