package org.n52.project.enforce.cs5.api.impl.data_types;

import java.util.UUID;

public class Cs5DataTypesPkey {
    
    private UUID data_id;
    
    private Integer types_id;
    
    public Cs5DataTypesPkey() {}
    
    public Cs5DataTypesPkey(UUID data_id, Integer types_id) {
        this.data_id = data_id;
        this.types_id = types_id;
    }

    public UUID getData_id() {
        return data_id;
    }

    public void setData_id(UUID data_id) {
        this.data_id = data_id;
    }

    public Integer getTypes_id() {
        return types_id;
    }

    public void setTypes_id(Integer types_id) {
        this.types_id = types_id;
    }
}
