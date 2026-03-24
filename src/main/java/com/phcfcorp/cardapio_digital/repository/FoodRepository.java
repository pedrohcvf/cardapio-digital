package com.phcfcorp.cardapio_digital.repository;
import com.phcfcorp.cardapio_digital.entity.Food;
import com.phcfcorp.cardapio_digital.enums.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findByFoodCategory(FoodCategory category);
}
