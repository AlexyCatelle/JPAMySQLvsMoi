package org.example.springmysql.service;

import org.example.springmysql.interfaces.IFurniture;
import org.example.springmysql.model.entity.Furniture;
import org.example.springmysql.repository.FurnitureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FurnitureService implements IFurniture {
    private final FurnitureRepository furnitureRepository;

    public FurnitureService(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    @Override
    public List<Furniture> getAllFurniture() {
        List<Furniture> furnitures = furnitureRepository.findAll();
        return furnitures.stream().map(furniture -> furniture).collect(Collectors.toList());
    }

    @Override
    public Furniture getFurnitureById(UUID id) throws Exception{
       Furniture furniture = furnitureRepository.findById(id).orElse(null);

       if(furniture == null)
           throw new Exception("Meuble non trouvé.");
       return furniture;
    }

    @Override
    public Furniture saveFurniture(Furniture furniture) {
        return furnitureRepository.save(furniture);
    }

    @Override
    public void deleteFurniture(UUID id) throws Exception {
        if (!furnitureRepository.existsById(id)) {
            throw new Exception("Impossible de supprimer : meuble non trouvé.");
        }
        furnitureRepository.deleteById(id);
    }
}
