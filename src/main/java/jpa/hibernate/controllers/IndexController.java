package jpa.hibernate.controllers;

import jpa.hibernate.domain.Category;
import jpa.hibernate.domain.UnitOfMeasure;
import jpa.hibernate.repositories.CategoryRepository;
import jpa.hibernate.repositories.UnitOfMeasureRepository;
import jpa.hibernate.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        model.addAttribute("recipes", recipeService.getRecipe());
        return "index";
    }

}
