package com.diabetes.murat.diabetes;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodItemService {
    @Autowired
    private final FoodItemRepository repository;

    public List<FoodItem> getFoodItems() {
        return repository.findAll();
    }

    public FoodItem getFoodItemById(long id) {
        return repository.findById(id);
    }

    public void addFoodItem(FoodItem foodItem) {
        repository.save(foodItem);
    }

    public void deleteFoodItemById(long id) {
        repository.deleteById(id);
    }

    public void updateFoodItem(long id, FoodItem foodItem) {
        FoodItem fi = getFoodItemById(id);
        fi.setFoodName(foodItem.getFoodName());
        fi.setCalories(foodItem.getCalories());
        repository.save(fi);
    }
}
