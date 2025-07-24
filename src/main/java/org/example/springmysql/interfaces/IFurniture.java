package org.example.springmysql.interfaces;

import org.example.springmysql.model.entity.Furniture;

import java.util.List;
import java.util.UUID;

public interface IFurniture {
    List<Furniture> getAllFurniture();
    Furniture getFurnitureById(UUID id) throws Exception;
    Furniture saveFurniture(Furniture furniture);
    void deleteFurniture(UUID id) throws Exception;
}
