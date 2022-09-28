package com.msalman.octant.model;

import com.msalman.octant.model.validator.ValidatorUtil;
import com.msalman.octant.request.CreateDRCRequest;
import com.msalman.octant.request.CreatePlateRequest;
import com.msalman.octant.request.CreateWellRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Lab {

    private int nextPlateId = 1;
    private Map<Integer, Plate> plateMap = new HashMap<>();

    public Map<Integer, Plate> getPlateMap() {
        return plateMap;
    }

    public Plate createPlate(CreatePlateRequest createPlateRequest)
    {
        int newId = nextPlateId;
        Plate plate = new Plate(newId, createPlateRequest);
        plateMap.put(newId, plate);
        nextPlateId++;
        return plate;
    }

    public Well createWell(
        int plateId,
        CreateWellRequest createWellRequest)
    {
        Plate plate = plateMap.get(plateId);

        if (plate == null){
            throw new NoSuchElementException(String.format("Plate with id: %s not found", plateId));
        }
        return createWell(plate, createWellRequest);
    }

    public Well createWell(
        Plate plate,
        CreateWellRequest createWellRequest)
    {
        Well well = new Well(plate, createWellRequest);
        int row = createWellRequest.getRow();
        int column = createWellRequest.getCol();

        plate.getWells()[row][column] = well;

        return well;
    }



    public Plate getPlate(int plateId)
    {
        Plate plate = plateMap.get(plateId);

        if (plate == null){
            throw new NoSuchElementException(String.format("Plate with id: %s not found", plateId));
        }

        return plate;
    }


    public void deleteWell(
        int plateId,
        int row,
        int col)
    {
        Plate plate = plateMap.get(plateId);

        if (plate == null){
            throw new NoSuchElementException(String.format("Plate with id: %s not found", plateId));
        }

        ValidatorUtil.validateWellsIndices(plate, row, col);

        plate.getWells()[row][col] = null;
    }


    public void createDRC(
        int plateId,
        CreateDRCRequest drc)
    {
        Plate plate = plateMap.get(plateId);

        if (plate == null){
            throw new NoSuchElementException(String.format("Plate with id: %s not found", plateId));
        }

        if (drc.getChemicals().size() * drc.getN_points() > plate.getSize().getNumOfWells()){
            throw new IllegalArgumentException("Not enough wells for DRC");
        }

        float increment = (drc.getMax_concentration() - drc.getMin_concentration()) / drc.getN_points();

        List<String> chemicals = drc.getChemicals();
        int chemicalIndex = 0;
        float currentConcentration = drc.getMin_concentration();

        CreateWellRequest createWellRequest;
        boolean chemicalListDone = false;

        for (int row=0; row < plate.getSize().getMaxRows()-1; row++) {
            for (int col=0; col < plate.getSize().getMaxColumn() -1; col++) {

                if (!chemicalListDone) {
                    createWellRequest = new CreateWellRequest(
                            row,
                            col,
                            drc.getCell_line(),
                            chemicals.get(chemicalIndex),
                            currentConcentration);

                    createWell(plate, createWellRequest);

                    currentConcentration = currentConcentration + increment;
                    if (currentConcentration > drc.getMax_concentration()) {
                        currentConcentration = drc.getMin_concentration();
                        chemicalIndex = chemicalIndex + 1;
                        if (chemicalIndex >= chemicals.size()) {
                            chemicalListDone = true;
                        }
                    }
                }
                else {
                    createWellRequest = new CreateWellRequest(
                            row,
                            col,
                            drc.getCell_line(),
                            drc.getControl_chemical(),
                            drc.getControl_concentration());

                    createWell(plate, createWellRequest);
                }
            }
        }
    }


}
