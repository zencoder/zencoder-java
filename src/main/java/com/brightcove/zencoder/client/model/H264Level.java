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
 * @see https://app.zencoder.com/docs/api/encoding/h264/h264-level
 * @see http://en.wikipedia.org/wiki/H.264#Levels
 */
public enum H264Level {

    _1("1"),
    _1B("1b"),
    _1_1("1.1"),
    _1_2("1.2"),
    _1_3("1.3"),
    _2("2"),
    _2_1("2.1"),
    _2_2("2.2"),
    _3("3"),
    _3_1("3.1"),
    _3_2("3.2"),
    _4("4"),
    _4_1("4.1"),
    _4_2("4.2"),
    _5("5"),
    _5_1("5.1"),
    _5_2("5.2");

    private String name;

    private H264Level(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
