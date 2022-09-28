package com.msalman.octant.model.validator;

import com.msalman.octant.model.Plate;
import com.msalman.octant.request.CreateDRCRequest;

public class ValidatorUtil {

    public static void validateWellsIndices(
        Plate plate,
        int row,
        int col)
    {
        if (row < 0 || row >= plate.getSize().getMaxRows()) {
            throw new IllegalArgumentException(
                    String.format("row index for this plate should be between 0 and %s",
                            plate.getSize().getMaxRows() -1));
        }

        if (col < 0 || col >= plate.getSize().getMaxColumn()) {
            throw new IllegalArgumentException(
                    String.format("column index for this plate should be between 0 and : %s",
                            plate.getSize().getMaxColumn() -1));
        }
    }

    public static void validateCreateDRCRequest(CreateDRCRequest request)
    {
        if (request.getChemicals().size() == 0) {
            throw new IllegalArgumentException(" chemicals list has no elements");
        }

        if (request.getMax_concentration() < request.getMin_concentration()) {
            throw new IllegalArgumentException(" min_concentrtion is greater than max_concentration");
        }

        if (request.getCell_line() == null) {
            throw new IllegalArgumentException(" cell_line is not given");
        }

        // so on and so forth.
    }
}
