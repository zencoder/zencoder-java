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
    FLV("flv"),
    HIGHWINDS("highwinds"),
    ISM("ism"),
    M4A("m4a"),
    M4B("m4b"),
    M4R("m4r"),
    M4V("m4v"),
    MKV("mkv"),
    MOV("mov"),
    MP3("mp3"),
    MP4("mp4"),
    /**
     * NOTE: Use 'mp4' for submitting requests.
     * The API only uses this 'mpeg4' value in responses, not requests.
     */
    MPEG4("mpeg4"),
    /**
     * NOTE: User 'ts' for submitting requests.
     * The API only uses this 'mpeg-ts' value in responses, not requests.
     */
    MPEG_TS("mpeg-ts"),
    OGA("oga"),
    OGG("ogg"),
    OGV("ogv"),
    OGX("ogx"),
    TS("ts"),
    WEBM("webm"),
    WMA("wma"),
    WMV("wmv");

    private String name;

    ContainerFormat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
