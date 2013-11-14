package com.brightcove.zencoder.client.model;

import java.util.Map;

/**
 * @see https://app.zencoder.com/docs/api/encoding/notifications
 * @see https://app.zencoder.com/docs/api/encoding/notifications/notifications
 */
public class UrlNotification extends Notification {

    private NotificationFormat format;
    private String url;
    private Map<String, String> headers;
    private NotificationEvent event;

    /**
     * No-arg constructor needed for serialization/deserialization.
     */
    public UrlNotification() {
    }

    public UrlNotification(String url) {
        this.format = NotificationFormat.JSON;
        this.url = url;
    }

    public UrlNotification(String url, NotificationFormat format) {
        this.format = format;
        this.url = url;
    }

    public NotificationFormat getFormat() {
        return format;
    }

    public void setFormat(NotificationFormat format) {
        this.format = format;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * NOTE: Only certains HTTP Headers are allowed.
     *
     * HTTP headers to send with your file when we upload it. This feature is currently supported
     * when using S3 and Cloud Files. Zencoder supports setting a limited subset of these headers:
     *   Cache-Control
     *   Content-Disposition
     *   Content-Encoding
     *   Content-Type
     *   Expires
     *   x-amz-acl
     *   x-amz-storage-class
     *   x-amz-server-side-encryption
     *   x-amz-meta-*
     *
     * Headers will be ignored when an output location is not specified.
     *
     * @see https://app.zencoder.com/docs/api/encoding/general-output-settings/headers
     */
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public NotificationEvent getEvent() {
        return event;
    }

    public void setEvent(NotificationEvent event) {
        this.event = event;
    }
}
