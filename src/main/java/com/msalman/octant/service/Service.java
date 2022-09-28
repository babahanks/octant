package com.msalman.octant.service;

import com.msalman.octant.model.Lab;
import com.msalman.octant.model.Plate;
import com.msalman.octant.request.CreateDRCRequest;
import com.msalman.octant.model.Well;
import com.msalman.octant.request.CreatePlateRequest;
import com.msalman.octant.request.CreateWellRequest;

@org.springframework.stereotype.Service
public class Service {

    Lab lab = new Lab();

    public Plate createPlate(CreatePlateRequest createPlateRequest)
    {
        Plate plate = lab.createPlate(createPlateRequest);
        return plate;
    }

    public Well createWell(
        int plateId,
        CreateWellRequest createWellRequest)
    {
        Well well = lab.createWell(plateId, createWellRequest);
        return well;
    }


    public Plate getPlate(int plateId)
    {
        Plate plate = lab.getPlate(plateId);
        return plate;
    }

    public void deleteWell(
        int plateId,
        int row,
        int col)
    {
        lab.deleteWell(plateId, row, col);
    }

    public void createDRC(
        int plateId,
        CreateDRCRequest createDRCRequest)
    {
        lab.createDRC(plateId, createDRCRequest);
    }


}
