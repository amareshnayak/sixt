package com.inducesmile.androidgsonparser;

import com.google.gson.annotations.SerializedName;

public class ItemObject {

    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private String id;
    @SerializedName("series")
    private String series;
    @SerializedName("modelIdentifier")
    private String modelIdentifier;
    @SerializedName("color")
    private String color;
    @SerializedName("latitude")
    private double latitude;
    @SerializedName("longitude")
    private double longitude;

    public String getCarImageUrl() {
        return carImageUrl;
    }

    @SerializedName("carImageUrl")
    private String carImageUrl;
    public ItemObject(String name, String id, String series,String color,String carImageUrl,String modelIdentifier,double latitude,double longitude) {
        this.name = name;
        this.id = id;
        this.series = series;
        this.color=color;
        this.latitude=latitude;
        this.longitude=longitude;
        this.modelIdentifier=modelIdentifier;
        this.carImageUrl=carImageUrl;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getSeries() {
        return series;
    }
    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getColor() {
        return color;
    }

    public String getModelIdentifier() {
        return modelIdentifier;
    }

}
