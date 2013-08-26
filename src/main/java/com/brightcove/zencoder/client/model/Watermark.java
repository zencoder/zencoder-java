package com.brightcove.zencoder.client.model;

/**
 * @see https://app.zencoder.com/docs/api/encoding/watermarks
 * @see https://app.zencoder.com/docs/api/encoding/watermarks/watermarks
 */
public class Watermark {

    private String url;
    private String x;
    private String y;
    private String height;
    private String width;
    private String origin;
    private Double opacity;

    /**
     * @see https://app.zencoder.com/docs/api/encoding/watermarks/watermark-url
     * @param url The URL of a remote image file to use as a watermark.
     */
    public Watermark(String url) {
        this.url = url;
    }
    
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public Double getOpacity() {
        return opacity;
    }

    public void setOpacity(Double opacity) {
        this.opacity = opacity;
    }
}
