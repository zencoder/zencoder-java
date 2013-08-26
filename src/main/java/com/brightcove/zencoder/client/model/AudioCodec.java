package com.brightcove.zencoder.client.model;


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
    WMA("wma");

    private String name;
    AudioCodec(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
