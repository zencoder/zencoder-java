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
 * @see https://app.zencoder.com/docs/api/encoding/aac
 * @see https://app.zencoder.com/docs/api/encoding/aac/max-aac-profile
 * @see https://app.zencoder.com/docs/api/encoding/aac/force-aac-profile
 */
public enum AACProfile {

    AAC_LC("aac-lc"),
    HE_AAC("he-aac"),
    HE_AAC_V2("he-aac-v2");

    private String name;
    
    private AACProfile(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
