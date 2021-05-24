package jpa.hibernate.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generate id value automatically
    private Long id;

    @Lob
    private String directions;

    private String description, source, url;
    private Integer prepTime, cookTime, servings;

    //One Recipe can have multiple ingredients
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>(); // Avoid NullPointerException

    @Lob
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL) //Delete recipe, we delete recipe Notes
    private Notes notes;

    @ManyToMany
    @JoinTable(
            name = "recipe_category", //create table
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")) //category_id created by hibernate
    private Set<Category> categories = new HashSet<>();

    @Enumerated(value = EnumType.STRING) //Ordinal is default value (1, 2, 3): EASY, MODERATE, HARD  / STRING
    private Difficulty difficulty;


    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }

}
