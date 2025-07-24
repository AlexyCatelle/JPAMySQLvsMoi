package org.example.springmysql.controller;

import org.example.springmysql.interfaces.IFurnitureService;
import org.example.springmysql.model.entity.Furniture;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/furniture")
public class FurnitureController {
    private final IFurnitureService furnitureService;

    public FurnitureController(IFurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @GetMapping
public ResponseEntity<List<Furniture>> getAllFurniture() {
        return new ResponseEntity<>(furnitureService.getAllFurniture(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Furniture> getFurnitureById(@PathVariable UUID id) {
     Furniture furniture;
      try {
          furniture = furnitureService.getFurnitureById(id);

      } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }

      return new ResponseEntity<>(furniture, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Furniture> addFurniture(@Validated @RequestBody Furniture furniture) {
    return new ResponseEntity<>(furnitureService.saveFurniture(furniture), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Furniture> deleteFurniture(@PathVariable UUID id) {
        try {
            furnitureService.deleteFurniture(id);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
