package com.msalman.octant.model;

public enum PlateSize {
    Size_96(96, 12, 8),
    Size_384(384, 24, 16);

    private int numOfWells;
    private int maxRows;
    private int maxColumn;

    PlateSize(
        int numberOfWells,
        int maxRows,
        int maxColumn)
    {
        this.numOfWells = numberOfWells;
        this.maxRows = maxRows;
        this.maxColumn = maxColumn;
    }


    public int getNumOfWells() {
        return numOfWells;
    }

    public int getMaxRows() {
        return maxRows;
    }

    public int getMaxColumn() {
        return maxColumn;
    }
}
