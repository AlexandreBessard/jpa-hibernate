package jpa.hibernate.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generate id value automatically
    private Long id;

    private String description, source, url, directions;
    private Integer prepTime, cookTime, servings;

    @Lob
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL) //Delete recipe, we delete recipe Notes
    private Notes notes;

    @ManyToMany
    @JoinTable(
            name = "recipe_category", //create table
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")) //category_id created by hibernate
    private Set<Category> categories;

    @Enumerated(value = EnumType.STRING) //Ordinal is default value (1, 2, 3): EASY, MODERATE, HARD  / STRING
    private Difficulty difficulty;

}
