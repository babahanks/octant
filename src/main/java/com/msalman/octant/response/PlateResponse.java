package com.msalman.octant.response;

import com.msalman.octant.model.Plate;
import com.msalman.octant.model.Well;

import java.util.LinkedList;
import java.util.List;

public class PlateResponse {

    private int id;
    private String name;
    private int size;
    private List<WellResponse> wells;

    public PlateResponse(Plate plate)
    {
        this.id = plate.getId();;
        this.name = plate.getName();
        this.size = plate.getSize().getNumOfWells();
        wells = new LinkedList<>();

        Well[][] wellsMatrix = plate.getWells();
        int rowSize = wellsMatrix.length;
        int colSize = wellsMatrix[0].length;

        for (int r=0; r<rowSize; r++) {
            for (int c=0; c<colSize; c++) {
                if (wellsMatrix[r][c] != null) {
                    WellResponse wellResponse = new WellResponse(wellsMatrix[r][c]);
                    wells.add(wellResponse);
                }
            }
        }
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

    public List<WellResponse> getWells() {
        return wells;
    }
}
