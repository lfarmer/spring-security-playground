package uk.co.leafdevelopment.beercatalog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Beer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Beer(String name) {
        this.name = name;
    }
}
