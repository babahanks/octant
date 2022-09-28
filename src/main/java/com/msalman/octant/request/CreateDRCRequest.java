package com.msalman.octant.request;

import java.util.List;

public class CreateDRCRequest {
    private String cell_line;
    private List<String> chemicals;
    private float min_concentration;
    private float max_concentration;
    private int n_points;
    private String control_chemical;
    private float control_concentration;

    public CreateDRCRequest(
        String cell_line,
        List<String> chemicals,
        float min_concentration,
        float max_concentration,
        int n_points,
        String control_chemical,
        float control_concentration)
    {
        this.cell_line = cell_line;
        this.chemicals = chemicals;
        this.min_concentration = min_concentration;
        this.max_concentration = max_concentration;
        this.n_points = n_points;
        this.control_chemical = control_chemical;
        this.control_concentration = control_concentration;
    }

    public String getCell_line() {
        return cell_line;
    }

    public List<String> getChemicals() {
        return chemicals;
    }

    public float getMin_concentration() {
        return min_concentration;
    }

    public float getMax_concentration() {
        return max_concentration;
    }

    public int getN_points() {
        return n_points;
    }

    public String getControl_chemical() {
        return control_chemical;
    }

    public float getControl_concentration() {
        return control_concentration;
    }
}
