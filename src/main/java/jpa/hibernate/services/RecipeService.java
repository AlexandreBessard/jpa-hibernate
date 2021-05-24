package jpa.hibernate.services;

import jpa.hibernate.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipe();

}
