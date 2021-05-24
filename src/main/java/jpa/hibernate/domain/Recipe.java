package jpa.hibernate.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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


}
