package com.msalman.octant.model;

import com.msalman.octant.request.CreatePlateRequest;

public class Plate {

    final int id;
    String name;
    final PlateSize size;

    Well[][] wells;

    public Plate(
        int id,
        CreatePlateRequest createPlateRequest)
    {
        this.id = id;
        this.name = createPlateRequest.getName();
        this.size = createPlateRequest.getSize();
        wells = new Well[size.getMaxRows() - 1][size.getMaxColumn()-1];
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PlateSize getSize() {
        return size;
    }

    public Well[][] getWells() {
        return wells;
    }
}
