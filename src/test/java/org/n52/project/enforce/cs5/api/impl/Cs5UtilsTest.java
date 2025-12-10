package org.n52.project.enforce.cs5.api.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.n52.project.enforce.cs5.api.impl.types.Cs5Types;
import org.n52.project.enforce.cs5.api.impl.types.Cs5TypesRepository;
import org.n52.project.enforce.cs5.api.impl.types_names.Cs5TypesNamesRepository;
import org.n52.project.enforce.cs5.utils.Cs5Utils;
import org.springframework.beans.factory.annotation.Autowired;

public class Cs5UtilsTest extends DBTest{
    
    @Autowired
    Cs5Utils cs5Utils;
    
    @Autowired
    Cs5TypesRepository cs5TypesRepository;
    
    @Autowired
    Cs5TypesNamesRepository cs5TypesNamesRepository;
    
    @Test
    void testReadExcelFile() {
        try {
            cs5Utils.readJson(getClass().getResourceAsStream("test.json"));
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }    
    
    @Test
    void testTypesAndNames() {
                
        Cs5Types cs5Type = new Cs5Types(8, "UrbanResidential");
        
        cs5TypesRepository.saveAndFlush(cs5Type);
        
        String fieldName = "landUse";
        
        Integer idForTypeName = cs5Utils.getIdForTypeName(fieldName);
        
        Optional<Cs5Types> cs5TypeFromDb = cs5TypesRepository.findByTypeAndName(idForTypeName, "UrbanResidential");
        
        assertTrue(cs5TypeFromDb.isPresent());
        
        cs5TypeFromDb = cs5TypesRepository.findByTypeAndName(idForTypeName, "IndustrialOrCommercial");
        
        assertFalse(cs5TypeFromDb.isPresent());
        
        cs5Type = new Cs5Types(idForTypeName, "IndustrialOrCommercial");

        cs5TypesRepository.saveAndFlush(cs5Type);
        
        cs5TypeFromDb = cs5TypesRepository.findByTypeAndName(idForTypeName, "IndustrialOrCommercial");
        
        assertTrue(cs5TypeFromDb.isPresent());
        
    }
    
}
