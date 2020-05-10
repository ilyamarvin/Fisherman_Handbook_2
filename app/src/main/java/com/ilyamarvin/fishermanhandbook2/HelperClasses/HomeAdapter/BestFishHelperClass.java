package com.ilyamarvin.fishermanhandbook2.HelperClasses.HomeAdapter;

public class BestFishHelperClass {
    int image;
    String title, description;

    public BestFishHelperClass(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
