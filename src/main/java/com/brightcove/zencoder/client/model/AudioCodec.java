package com.brightcove.zencoder.client.model;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.map.JsonMappingException;


/**
 * @see https://app.zencoder.com/docs/api/encoding/format-and-codecs/audio-codec
 */
public enum AudioCodec {

    AAC("aac"),
    AC3("ac3"),
    AMR("amr"),
    EAC3("eac3"),
    MP3("mp3"),
    VORBIS("vorbis"),
    WMA("wma", "wmav2"),

    /**
     * This is necessary to support every possible input format Zencoder can
     * consume, but not produce as outputs.
     */
    UNKNOWN("null");

    private String name;
    private List<String> others;

    AudioCodec(String name) {
        this.name = name;
    }

    /**
     * Zencoder does not always return the same String for output formats.
     * This 'other' string fixes the deserialization issues caused by that.
     */
    AudioCodec(String name, String... others) {
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
    public static AudioCodec fromValue(String other) throws JsonMappingException {
        for (AudioCodec format : AudioCodec.values()) {
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
