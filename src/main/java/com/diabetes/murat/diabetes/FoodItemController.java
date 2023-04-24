package com.diabetes.murat.diabetes;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
//@RequiredArgsConstructor
public class FoodItemController {

    List<FoodItem> mymenu = new ArrayList<>();
    Double totalCalories = 0.0;

    @Autowired
    private FoodItemService foodItemService;

    @GetMapping("/listfooditems") //j
    public String getFoodItems(Model model){
        List<FoodItem> foodItems=foodItemService.getFoodItems();
        model.addAttribute("foods", foodItems);
        return "fooditem";
    }

    @GetMapping("/addfooditem")
    public String greetingForm(Model model) {
        model.addAttribute("foodItem", new FoodItem());
        return "add-fooditem";
    }

    @PostMapping("/addfooditem")
    public String addFoodItem(@ModelAttribute FoodItem foodItem) {
        //model.addAttribute("foodItem", foodItem);
        foodItemService.addFoodItem(foodItem);
        return "redirect:/listfooditems";
    }

    @GetMapping("/delete/{id}")
    public String deleteFoodItem(@PathVariable("id") long id, Model model) {
        foodItemService.deleteFoodItemById(id);
        return "redirect:/listfooditems";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateFoodItemForm(@PathVariable("id") long id, Model model) {

        FoodItem foodItem = foodItemService.getFoodItemById(id);
        model.addAttribute("foodItem", foodItem);

        return "edit-fooditem";
    }

    @PostMapping("/update/{id}")
    public String updateFoodItem(@PathVariable("id") long id,
                                 @ModelAttribute FoodItem foodItem, Model model) {
        foodItemService.updateFoodItem(id, foodItem);
        return "redirect:/listfooditems";
    }

    @GetMapping("/")
    public String showIndex(Model model) {
        List<FoodItem> foodItems=foodItemService.getFoodItems();
        model.addAttribute("foods", foodItems);
        model.addAttribute("mytotalCalories", totalCalories);
        return "menu";
    }

    @GetMapping("/menu")
    public String showMyMenu(Model model) {
        List<FoodItem> foodItems=foodItemService.getFoodItems();
        model.addAttribute("foods", foodItems);
        model.addAttribute("mytotalCalories", totalCalories);
        return "menu";
    }

    @GetMapping("/menu/clear")
    public String clearMyMenu(Model model) {
        List<FoodItem> foodItems=foodItemService.getFoodItems();
        model.addAttribute("foods", foodItems);
        mymenu.clear();
        totalCalories = 0.0;
        model.addAttribute("mytotalCalories", totalCalories);
        return "menu";
    }

    @GetMapping("/menu/{id}")
    public String addToMenu(@PathVariable("id") long id, Model model) {
        List<FoodItem> foodItems=foodItemService.getFoodItems();
        model.addAttribute("foods", foodItems);


        FoodItem fi = foodItemService.getFoodItemById(id);

        mymenu.add(fi);
        double totalCalories = 0;
        for (FoodItem i : mymenu)
            totalCalories += i.getCalories();

        this.totalCalories = totalCalories;
        System.out.println("Total calories: " + totalCalories);

        model.addAttribute("mytotalCalories", totalCalories);

        return "menu";
    }
}
