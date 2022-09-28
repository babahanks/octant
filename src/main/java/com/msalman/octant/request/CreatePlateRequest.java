package com.msalman.octant.request;

import com.msalman.octant.model.PlateSize;

public class CreatePlateRequest {
    String name;
    PlateSize size;

    public String getName() {
        return name;
    }

    public PlateSize getSize() {
        return size;
    }

    public CreatePlateRequest(String name, PlateSize size) {
        this.name = name;
        this.size = size;
    }


}
