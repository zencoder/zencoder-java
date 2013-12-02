/**
 * Copyright (C) 2013 Brightcove Inc. All Rights Reserved. No use, copying or distribution of this
 * work may be made except in accordance with a valid license agreement from Brightcove Inc. This
 * notice must be included on all copies, modifications and derivatives of this work.
 * 
 * Brightcove Inc MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT. BRIGHTCOVE SHALL NOT BE
 * LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS
 * SOFTWARE OR ITS DERIVATIVES.
 * 
 * "Brightcove" is a registered trademark of Brightcove Inc.
 */
package com.brightcove.zencoder.client.model;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.map.JsonMappingException;

/**
 * @see https://app.zencoder.com/docs/api/encoding/format-and-codecs/format
 */
public enum ContainerFormat {

    // NOTE: Java does not support enums that start with numbers

    _3G2("3g2"),
    _3GP("3gp"),
    _3GP2("3gp2"),
    _3GPP("3gpp"),
    _3GPP2("3gpp2"),
    AAC("aac"),
    AC3("ac3"),
    EAC3("eac3"),
    EC3("ec3"),
    F4A("f4a"),
    F4B("f4b"),
    F4V("f4v"),
    FLV("flv", "flash video"),
    /**
     * Playlist Format.
     * @see https://app.zencoder.com/docs/guides/encoding-settings/highwinds-smil
     */
    HIGHWINDS("highwinds"),
    /**
     * Playlist Format.
     * @see https://app.zencoder.com/docs/guides/encoding-settings/microsoft-smooth-streaming
     */
    ISM("ism"),
    M4A("m4a"),
    M4B("m4b"),
    M4R("m4r"),
    M4V("m4v"),
    MKV("mkv", "matroska"),
    MOV("mov"),
    MP3("mp3", "mpeg audio"),
    MP4("mp4", "mpeg4"),
    OGA("oga"),
    OGG("ogg"),
    OGV("ogv", "mpeg-ps"), // BUG: 'mpeg-ps' will always become 'OGV' never 'OGX'
    OGX("ogx", "mpeg-ps"),
    TS("ts", "mpeg-ts"),
    WEBM("webm"),
    WMA("wma", "asf"),
    WMV("wmv"),

    /**
     * This is necessary to support every possible input format Zencoder can
     * consume, but not produce as outputs.
     */
    UNKNOWN("null");

    private String name;
    private List<String> others;

    ContainerFormat(String name) {
        this.name = name;
    }

    /**
     * Zencoder does not always return the same String for output formats.
     * This 'other' string fixes the deserialization issues caused by that.
     */
    ContainerFormat(String name, String... others) {
        this.name = name;
        this.others = new ArrayList<String>();
        for (String other : others) {
            this.others.add(other);
        }
    }

    @JsonValue
    @Override
    public String toString() {
        return name;
    }

    public List<String> otherNames() {
        return others;
    }

    @JsonCreator
    public static ContainerFormat fromValue(String other) throws JsonMappingException {
        for (ContainerFormat format : ContainerFormat.values()) {
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
