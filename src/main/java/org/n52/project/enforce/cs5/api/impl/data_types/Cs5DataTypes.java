package org.n52.project.enforce.cs5.api.impl.data_types;

import java.util.UUID;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
        name = "cs5_data_types")
public class Cs5DataTypes {

    @EmbeddedId
    private Cs5DataTypesPkey cs5DataTypesPkey;
    
    public Cs5DataTypes() {}
    
    public Cs5DataTypes(Cs5DataTypesPkey cs5DataTypesPkey) {
        this.cs5DataTypesPkey = cs5DataTypesPkey;
    }
    
    public Cs5DataTypes(UUID data_id, Integer types_id) {
        this(new Cs5DataTypesPkey(data_id, types_id));
    }
}