package com.melisnurverir.amazonprimeclone.model;

public class BannerMovies {

    Integer bannerCategoryId;
    Integer id;
    String movieName;
    String imageUrl;
    String fileUrl;

    /*public BannerMovies(Integer id, String movieName, String imageUrl, String fileUrl) {
        this.id = id;
        this.movieName = movieName;
        this.imageUrl = imageUrl;
        this.fileUrl = fileUrl;
    }*/

    public Integer getBannerCategoryId() {
        return bannerCategoryId;
    }

    public void setBannerCategoryId(Integer bannerCategoryId) {
        this.bannerCategoryId = bannerCategoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
