package com.msalman.octant.model;

import com.msalman.octant.model.validator.ValidatorUtil;
import com.msalman.octant.request.CreateWellRequest;

public class Well {

    private Plate plate;
    private int row;
    private int column;
    private String cellLine;
    private String chemical;
    private float concentration;


    public Well(
        Plate plate,
        CreateWellRequest createWellRequest)
    {
        ValidatorUtil.validateWellsIndices(
                plate,
                createWellRequest.getRow(),
                createWellRequest.getCol());

        this.plate = plate;
        this.row = createWellRequest.getRow();
        this.column = createWellRequest.getCol();
        this.cellLine = createWellRequest.getCell_line();
        this.chemical = createWellRequest.getChemical();
        this.concentration = createWellRequest.getConcentration();
    }

    public Plate getPlate() {
        return plate;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getCellLine() {
        return cellLine;
    }

    public String getChemical() {
        return chemical;
    }

    public float getConcentration() {
        return concentration;
    }
}
