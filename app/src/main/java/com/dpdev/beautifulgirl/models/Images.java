package com.dpdev.beautifulgirl.models;

/**
 * Created by User on 1/14/2018.
 */

public class Images {
    private int checkLike;
    private int checkSave;
    private String id;
    private String image;
    private int likes;
    private String title;

    public Images() {
    }

    public Images(int checkLike, int checkSave, String id, String image, int likes, String title) {
        this.checkLike = checkLike;
        this.checkSave = checkSave;
        this.id = id;
        this.image = image;
        this.likes = likes;
        this.title = title;
    }

    public int getCheckLike() {
        return checkLike;
    }

    public void setCheckLike(int checkLike) {
        this.checkLike = checkLike;
    }

    public int getCheckSave() {
        return checkSave;
    }

    public void setCheckSave(int checkSave) {
        this.checkSave = checkSave;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
