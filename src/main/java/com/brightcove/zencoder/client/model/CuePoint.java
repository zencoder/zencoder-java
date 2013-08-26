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

import java.util.Map;

/**
 * @see https://app.zencoder.com/docs/api/encoding/flv/cue-points
 */
public class CuePoint {

    private CuePointType type;
    private Float time;
    private String name;
    private Map<String, String> data;

    public CuePointType getType() {
        return type;
    }

    public void setType(CuePointType type) {
        this.type = type;
    }

    public Float getTime() {
        return time;
    }

    public void setTime(Float time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

}
