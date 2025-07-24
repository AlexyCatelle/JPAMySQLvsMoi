package org.example.springmysql.repository;

import org.example.springmysql.model.entity.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, UUID> {
}
