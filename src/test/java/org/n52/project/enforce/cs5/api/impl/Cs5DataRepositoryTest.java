package org.n52.project.enforce.cs5.api.impl;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.n52.project.enforce.cs5.api.impl.data.Cs5Data;
import org.n52.project.enforce.cs5.api.impl.data.Cs5DataRepository;
import org.n52.project.enforce.cs5.api.impl.types.Cs5Types;
import org.n52.project.enforce.cs5.api.impl.types.Cs5TypesRepository;
import org.n52.project.enforce.cs5.api.impl.types_names.Cs5TypesNamesRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Cs5DataRepositoryTest extends DBTest {

    @Autowired
    Cs5DataRepository cs5DataRepository;
    
    @Autowired
    Cs5TypesRepository cs5TypesRepository;
    
    @Autowired
    Cs5TypesNamesRepository cs5TypesNamesRepository;
    
    GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
    
    Random random = new Random();
    
    @Test
    void testCreateData() {
        
        Cs5Types cs5Types = new Cs5Types(8, "UrbanResidential");
        
        cs5TypesRepository.saveAndFlush(cs5Types);
        
        double x = random.nextDouble(50d);
        double y = random.nextDouble(8d);
        Cs5Data cs1Data = new Cs5Data(UUID.randomUUID());
        
        cs5DataRepository.saveAndFlush(cs1Data);
                
        
    }
    
}
