package com.msalman.octant.response;

import com.msalman.octant.model.Well;

public class WellResponse {

    private String plateName;
    private int plateId;
    private int row;
    private int column;
    private String cellLine;
    private String chemical;
    private float concentration;


    public WellResponse(Well well)
    {
        this.plateName = well.getPlate().getName();
        this.plateId = well.getPlate().getId();
        this.row = well.getRow();
        this.column = well.getColumn();
        this.cellLine = well.getCellLine();
        this.chemical = well.getChemical();
        this.concentration = well.getConcentration();
    }

    public String getPlateName() {
        return plateName;
    }

    public int getPlateId() {
        return plateId;
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
