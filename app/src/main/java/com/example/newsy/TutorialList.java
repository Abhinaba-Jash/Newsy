package com.example.newsy;

public class TutorialList {
    String description;
    String urlToImage;
    String title;

    public TutorialList(String title, String urlToImage, String description) {
        this.title=title;
        this.urlToImage=urlToImage;
        this.description=description;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
