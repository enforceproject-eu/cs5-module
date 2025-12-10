package org.n52.project.enforce.cs5.api.impl.types_names;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * <p>
 * Cs1IncidentTypes DTO.
 * </p>
 *
 * @author Benjamin Pross (b.pross @52north.org)
 * @since 1.0.0
 */
@Entity
@Table(
        name = "cs5_types_names")
public class Cs5TypesNames {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cs5_types_names_generator")
    @SequenceGenerator(name = "cs5_types_names_generator", sequenceName = "cs5_types_names_seq", allocationSize = 1)
    private Integer id;

    @Column(
            name = "name")
    private String name;
    
    public Cs5TypesNames() {}
    
    public Cs5TypesNames(String name) {
        this.name = name;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: " + id + ", ");
        sb.append("name: " + name + ", ");
        return sb.toString();
    }
}
