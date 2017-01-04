package com.anudeepsamaiya.urbancarnival;

/**
 * Created by anudeepsamaiya on 4/1/17.
 */

public class PhotoItem {

    String title;
    String description;
    String data;
    String dateAdded;
    String dateTaken;
    String mimeType;
    long size;

    public PhotoItem(String title, String description, String data, String dateAdded,
                     String dateTaken, String mimeType, long size) {
        this.title = title;
        this.description = description;
        this.data = data;
        this.dateAdded = dateAdded;
        this.dateTaken = dateTaken;
        this.mimeType = mimeType;
        this.size = size;
    }

    public PhotoItem(String data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
