package org.example.springmysql.controller;

import org.example.springmysql.interfaces.IFurniture;
import org.example.springmysql.model.entity.Furniture;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meuble")
public class FurnitureController {
    private final IFurniture furnitureService;

    public FurnitureController(IFurniture furnitureService) {
        this.furnitureService = furnitureService;
    }

    @GetMapping
public ResponseEntity<List<Furniture>> getAllFurniture() {
        return new ResponseEntity<>(furnitureService.getAllFurniture(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Furniture> addFurniture(@Validated @RequestBody Furniture furniture) {
    return new ResponseEntity<>(furnitureService.saveFurniture(furniture), HttpStatus.CREATED);
    }
}
