package com.msalman.octant.request;

public class CreateWellRequest {

    private int row;
    private int col;
    private String cell_line;
    private String chemical;
    private float concentration;

    public CreateWellRequest(
        int row,
        int col,
        String cell_line,
        String chemical,
        float concentration)
    {
        this.row = row;
        this.col = col;
        this.cell_line = cell_line;
        this.chemical = chemical;
        this.concentration = concentration;
    }


    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String getCell_line() {
        return cell_line;
    }

    public String getChemical() {
        return chemical;
    }

    public float getConcentration() {
        return concentration;
    }
}
