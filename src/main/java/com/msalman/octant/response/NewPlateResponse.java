package com.msalman.octant.response;

import com.msalman.octant.model.Plate;

public class NewPlateResponse {

     int id;
     String name;
     int size;

    public NewPlateResponse(Plate plate) {
        this.id = plate.getId();
        this.name = plate.getName();
        this.size = plate.getSize().getNumOfWells();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
