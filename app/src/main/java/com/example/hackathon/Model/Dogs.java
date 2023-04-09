package com.example.hackathon.Model;

import android.view.View;

public class Dogs {
    int pic;
    String location, description, map;

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public Dogs(String map) {
        this.map = map;
    }

    public Dogs(int pic, String location, String description) {
        this.pic = pic;
        this.location = location;
        this.description = description;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
