package com.diabetes.murat.diabetes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FoodItem {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String foodName;
    private double calories;

    protected FoodItem() {}

    public FoodItem(String foodName, double calories) {
        this.foodName = foodName;
        this.calories = calories;
    }

    @Override
    public String toString() {
        return String.format(
                "FoodItem[id=%d, foodName='%s', carbs='%f']",
                id, foodName, calories);
    }

    public Long getId() {
        return id;
    }

    public String getFoodName() {
        return foodName;
    }

    public double getCalories() {
        return calories;
    }

    public void setFoodName(String name) {
        foodName = name;
    }

    public void setCalories(double cal) {
        calories = cal;
    }
}