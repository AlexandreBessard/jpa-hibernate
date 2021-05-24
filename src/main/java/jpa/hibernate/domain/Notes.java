package jpa.hibernate.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter @NoArgsConstructor
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne //No cascade, don't want if deletes node object to delete recipe
    private Recipe recipe;

    @Lob //Allow to store for large object over 254 characters (CLOB field)
    private String recipeNotes;

}
