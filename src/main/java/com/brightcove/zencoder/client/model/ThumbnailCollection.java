package com.brightcove.zencoder.client.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * "thumbnails": [
    {
      "images": [
        {
          "dimensions": "WIDTHxHEIGHT",
          "file_size_bytes": SIZE,
          "format": "PNG",
          "url": "URL"
        }
      ],
      "label": "thumb1"
    },
    {
      "images": [
        {
          "dimensions": "WIDTHxHEIGHT",
          "file_size_bytes": SIZE,
          "format": "PNG",
          "url": "URL"
        }
      ],
      "label": "thumb2"
    }
  ],
 *
 */
public class ThumbnailCollection {

    private String label;
    private List<Thumbnail> images = new ArrayList<Thumbnail>();

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Thumbnail> getImages() {
        return images;
    }

    public void setImages(List<Thumbnail> images) {
        this.images = images;
    }

}
