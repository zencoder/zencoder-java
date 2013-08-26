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
package com.brightcove.zencoder.client;

/**
 * Wrapper for all possible exceptions the ZencoderClient can produce.
 */
public class ZencoderClientException extends Exception {

    private static final long serialVersionUID = 1L;

    public ZencoderClientException() {
        super();
    }

    public ZencoderClientException(String reason) {
        super(reason);
    }

    public ZencoderClientException(Throwable cause) {
        super(cause);
    }

    public ZencoderClientException(String reason, Throwable cause) {
        super(reason, cause);
    }
}
