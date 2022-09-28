package com.msalman.octant.controller;

import com.msalman.octant.model.Plate;
import com.msalman.octant.model.Well;
import com.msalman.octant.request.CreateDRCRequest;
import com.msalman.octant.request.CreatePlateRequest;
import com.msalman.octant.request.CreateWellRequest;
import com.msalman.octant.response.NewPlateResponse;
import com.msalman.octant.response.WellResponse;
import com.msalman.octant.response.PlateResponse;
import com.msalman.octant.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("")
public class Controller {

    @Autowired
    Service service;


    @PostMapping("/plates")
    public ResponseEntity<NewPlateResponse> createPlate(
        @RequestBody CreatePlateRequest createPlateRequest)
    {
        Plate plate = service.createPlate(createPlateRequest);

        NewPlateResponse newPlateResponse = new NewPlateResponse(plate);
        return new ResponseEntity<>(newPlateResponse, HttpStatus.CREATED);
    }


    @PostMapping("/plates/{plateId}/wells")
    public ResponseEntity<WellResponse> createWell(
        @PathVariable String plateId,
        @RequestBody CreateWellRequest createWellRequest)
    {
        Well well = null;
        try {
            well = service.createWell(Integer.parseInt(plateId), createWellRequest);
        }
        catch (NoSuchElementException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
        catch (IllegalArgumentException e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }

        WellResponse newWellResponse = new WellResponse(well);
        return new ResponseEntity<>(newWellResponse, HttpStatus.CREATED);
    }


    @GetMapping("/plates/{plateId}")
    public ResponseEntity<PlateResponse> getPlate(
        @PathVariable String plateId)
    {
        Plate plate = null;

        try {
            plate = service.getPlate(Integer.parseInt(plateId));
        }
        catch (NoSuchElementException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }

        PlateResponse plateResponse = new PlateResponse(plate);
        return new ResponseEntity<>(plateResponse, HttpStatus.OK);
    }


    @DeleteMapping("/plates/{plateId}/wells/{row}/{col}")
    public ResponseEntity deletePlate(
        @PathVariable String plateId,
        @PathVariable String row,
        @PathVariable String col)
    {
        try {
            service.deleteWell( Integer.parseInt(plateId),
                                Integer.parseInt(row),
                                Integer.parseInt(col));
        }
        catch (NoSuchElementException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
        catch (IllegalArgumentException e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/plates/{plateId}/drc")
    public ResponseEntity createDRC(
        @PathVariable String plateId,
        @RequestBody CreateDRCRequest createDRCRequest)
    {
        try {
            service.createDRC(Integer.parseInt(plateId), createDRCRequest);
        }
        catch (NoSuchElementException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
        catch (IllegalArgumentException e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
