package org.n52.project.enforce.cs5.utils;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.n52.project.enforce.cs5.api.impl.data.Cs5Data;
import org.n52.project.enforce.cs5.api.impl.data.Cs5DataRepository;
import org.n52.project.enforce.cs5.api.impl.types.Cs5Types;
import org.n52.project.enforce.cs5.api.impl.types.Cs5TypesRepository;
import org.n52.project.enforce.cs5.api.impl.types_names.Cs5TypesNames;
import org.n52.project.enforce.cs5.api.impl.types_names.Cs5TypesNamesRepository;
import org.n52.project.enforce.cs5.model.Cs5DataRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Component
public class Cs5Utils {

    private Cs5DataRepository cs5DataRepository;
    
    private Cs5TypesRepository cs5TypesRepository;
    
    private Cs5TypesNamesRepository cs5TypesNamesRepository;

    DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd'T'HH:MM:SS");

    ZoneId zoneIdEuropeRome = ZoneId.of("Europe/Rome");
    
    GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);

    ObjectMapper objectMapper = new ObjectMapper();
    
    private static Logger LOG = LoggerFactory.getLogger(Cs5Utils.class);

    public Cs5Utils(Cs5DataRepository cs5DataRepository, Cs5TypesRepository cs5TypesRepository, Cs5TypesNamesRepository cs5TypesNamesRepository) {
        this.cs5DataRepository = cs5DataRepository;
        this.cs5TypesRepository = cs5TypesRepository;
        this.cs5TypesNamesRepository = cs5TypesNamesRepository;
    }

    public void readJson(InputStream inputStream) throws IOException {        
        JsonNode tree = objectMapper.reader().readTree(inputStream);        
        if(tree instanceof ObjectNode) {
            ObjectNode objectNode = (ObjectNode)tree;
            Iterator<JsonNode> elements = objectNode.elements();
            while (elements.hasNext()) {
                JsonNode jsonNode = (JsonNode) elements.next();
                cs5DataRepository.saveAndFlush(createCs5Data(jsonNode));
            }
        }        
    }
    
    public void readMap(Map<String, Cs5DataRequest> inputMap) {
        Collection<Cs5DataRequest> values = inputMap.values();
        for (Cs5DataRequest cs5DataRequest : values) {
            cs5DataRepository.saveAndFlush(createCs5Data(cs5DataRequest));
        }
    }
    
    private Cs5Data createCs5Data(JsonNode node) {
        Cs5Data result = new Cs5Data();
        String id = getNodeValue(node, "id");
        result.setId(UUID.fromString(id));
        String unamed0 = getNodeValue(node, "Unnamed: 0");
        result.setUnnamed0(unamed0 != null ? Integer.parseInt(unamed0) : null);
        String lng = getNodeValue(node, "long");
        String lat = getNodeValue(node, "lat");
        result.setCoordinate(createPoint(lng + "," + lat));        
        String waterBodyType = getNodeValue(node, "waterBodyType");
        result.setWaterBodyType(waterBodyType);
        String dynamicRiskAssessment = getNodeValue(node, "dynamicRiskAssessment");
        result.setDynamicRiskAssessment(dynamicRiskAssessment != null ? Boolean.parseBoolean(dynamicRiskAssessment) : null);
        String estimatedWidth = getNodeValue(node, "estimatedWidth");
        result.setEstimatedWidth(estimatedWidth != null ? Double.parseDouble(estimatedWidth) : null);        
        String estimatedDepth = getNodeValue(node, "estimatedDepth");
        result.setEstimatedDepth(estimatedDepth != null ? Double.parseDouble(estimatedDepth) : null);        
        String waterFlow = getNodeValue(node, "waterFlow");
        result.setWaterFlow(waterFlow);        
        String waterLevel = getNodeValue(node, "waterLevel");
        result.setWaterLevel(waterLevel);        
        String temperature = getNodeValue(node, "temperature");
        result.setTemperature(temperature != null ? Double.parseDouble(temperature) : null);        
        String totalDissolvedSolids = getNodeValue(node, "totalDissolvedSolids");
        result.setTotalDissolvedSolids(totalDissolvedSolids != null ? Double.parseDouble(totalDissolvedSolids) : null);        
        String turbidity = getNodeValue(node, "turbidity");
        result.setTurbidity(turbidity != null ? Double.parseDouble(turbidity) : null);        
        String phosphate = getNodeValue(node, "phosphate");
        result.setPhosphate(phosphate != null ? Double.parseDouble(phosphate) : null);        
        String ph = getNodeValue(node, "ph");
        result.setPh(ph != null ? Double.parseDouble(ph) : null);        
        String nitrate = getNodeValue(node, "nitrate");
        result.setNitrate(nitrate != null ? Double.parseDouble(nitrate) : null);        
        String ammonia = getNodeValue(node, "ammonia");
        result.setAmmonia(ammonia != null ? Double.parseDouble(ammonia) : null);        
        String date = getNodeValue(node, "Date");
        result.setDate(date != null ? LocalDate.parse(date) : null);        
        result.setPollutionEvidence(getNodeValueAsList(node, "pollutionEvidence"));
        result.setPollutionSource(getNodeValueAsList(node, "pollutionSource"));
        result.setFlowImpedance(getNodeValueAsList(node, "flowImpedance"));
        result.setInvasivePlant(getNodeValueAsList(node, "invasivePlant"));
        result.setWildlife(getNodeValueAsList(node, "wildlife"));
        result.setBankVegetation(getNodeValueAsList(node, "bankVegetation"));
        result.setLandUse(getNodeValueAsList(node, "landUse"));        
        return result;
    }
    
    private Cs5Data createCs5Data(Cs5DataRequest node) {
        Cs5Data result = new Cs5Data();
        result.setId(node.getId());
        result.setUnnamed0(node.getUnnamed0());
        result.setCoordinate(createPoint(node.getLong() + "," + node.getLat()));    
        result.setWaterBodyType(node.getWaterBodyType());
        result.setDynamicRiskAssessment(node.getDynamicRiskAssessment());
        result.setEstimatedWidth(node.getEstimatedWidth());        
        result.setEstimatedDepth(node.getEstimatedDepth());        
        result.setWaterFlow(node.getWaterFlow());        
        result.setWaterLevel(node.getWaterLevel());
        result.setTemperature(node.getTemperature());
        result.setTotalDissolvedSolids(node.getTotalDissolvedSolids());        
        result.setTurbidity(node.getTurbidity());        
        result.setPhosphate(node.getPhosphate());        
        result.setPh(node.getPh());
        result.setNitrate(node.getNitrate());
        result.setAmmonia(node.getAmmonia());
        result.setDate(node.getDate());
        
//        result.setPollutionEvidence(getNodeValueAsList(node, "pollutionEvidence"));
//        result.setPollutionSource(getNodeValueAsList(node, "pollutionSource"));
//        result.setFlowImpedance(getNodeValueAsList(node, "flowImpedance"));
//        result.setInvasivePlant(getNodeValueAsList(node, "invasivePlant"));
//        result.setWildlife(getNodeValueAsList(node, "wildlife"));
//        result.setBankVegetation(getNodeValueAsList(node, "bankVegetation"));
//        result.setLandUse(getNodeValueAsList(node, "landUse"));        
        return result;
    }
    
    public Integer getIdForTypeName(String name) {
        Optional<Cs5TypesNames> cs5TypesName = cs5TypesNamesRepository.findByName(name);
        if(cs5TypesName.isPresent()) {
            return cs5TypesName.get().getId();
        }
        return null;
    }
    
    private String getNodeValue(JsonNode node, String fieldName) {        
        JsonNode valueNode = node.get(fieldName);        
        if(!(valueNode instanceof NullNode)) {
            return valueNode.asText();
        }
        return null;
    }
    
    private List<Integer> getNodeValueAsList(JsonNode node, String fieldName) {        
        List<Integer> result = new ArrayList<>();
        List<Integer> defaultList = Arrays.asList(new Integer[]{1});
        JsonNode valueNode = node.get(fieldName);        
        Integer id = getIdForTypeName(fieldName);
        if(id == null) {
            //TODO
            return defaultList;
        }
       
        if(valueNode instanceof ArrayNode) {
            ArrayNode valueArrayNode = (ArrayNode)valueNode;
            if(valueArrayNode.size() == 0) {
                return defaultList;
            }
            for (int i = 0; i < valueArrayNode.size(); i++) {
                JsonNode valueNodeI = valueNode.get(i);
                if(valueNodeI instanceof NullNode) {
                    result.add(1);
                }
                String valueNodeIAsString = valueNodeI.asText();
                if(valueNodeIAsString.equals("None")) {
                    result.add(1);
                } else {                    
                    Optional<Cs5Types> cs5TypeFromDb = cs5TypesRepository.findByTypeAndName(id, valueNodeIAsString);
                    if(cs5TypeFromDb.isPresent()) {
                        result.add(cs5TypeFromDb.get().getId());
                    } else {
                        Cs5Types newCs5Type = new Cs5Types(id, valueNodeIAsString);
                        newCs5Type = cs5TypesRepository.saveAndFlush(newCs5Type);
                        result.add(newCs5Type.getId());
                    }
                }                   
            }
        }
        return defaultList;
    }
    
    private Point createPoint(String pointAsString) {
        if (pointAsString != null) {
            String[] coordinateArray = pointAsString.split(",");
            if (coordinateArray.length == 2) {
                String latStrg = coordinateArray[1];
                String lngStrg = coordinateArray[0];
                if ((latStrg != null && !latStrg.isEmpty()) && (lngStrg != null && !lngStrg.isEmpty())) {
                    double lat = Double.parseDouble(latStrg);
                    double lng = Double.parseDouble(lngStrg);
                    return geometryFactory.createPoint(new Coordinate(lat, lng));
                }
            }
        }
        return geometryFactory.createPoint(new Coordinate(0, 0));
    }

}
