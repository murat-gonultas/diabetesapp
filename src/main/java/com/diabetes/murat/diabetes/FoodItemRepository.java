package com.diabetes.murat.diabetes;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface FoodItemRepository extends CrudRepository<FoodItem, Long> {
    List<FoodItem> findByFoodName(String foodName);

    FoodItem findById(long id);

    List<FoodItem> findAll();
}
