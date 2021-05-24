package jpa.hibernate.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter @Setter @NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private BigDecimal amount;

    @ManyToOne //Many ingredients in one Recipe
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER) //Load it everytime
    private UnitOfMeasure uom;

}
