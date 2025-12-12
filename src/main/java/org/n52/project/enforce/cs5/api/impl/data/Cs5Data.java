package org.n52.project.enforce.cs5.api.impl.data;

import java.time.LocalDate;
import java.util.UUID;

import org.locationtech.jts.geom.Point;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * <p>
 * Data DTO.
 * </p>
 *
 * @author Benjamin Pross (b.pross @52north.org)
 * @since 1.0.0
 */
@Entity
@Table(
        name = "cs5_data")
public class Cs5Data {

    @Id
    private UUID id;

    @Column(
            name = "unnamed_0")
    private Integer unnamed0;
    
    @Column(
            name = "water_body_type")
    private String waterBodyType;

    @Column(
            name = "dynamic_risk_assessment")
    private Boolean dynamicRiskAssessment;

    @Column(
            name = "estimated_width")
    private Double estimatedWidth;
    
    @Column(
            name = "estimated_depth")
    private Double estimatedDepth;
    
    @Column(
            name = "water_flow")
    private String waterFlow;
    
    @Column(
            name = "water_level")
    private String waterLevel;
    
    @Column(
            name = "temperature")
    private Double temperature;
    
    @Column(
            name = "total_dissolved_solids")
    private Double totalDissolvedSolids;
    
    @Column(
            name = "turbidity")
    private Double turbidity;
    
    @Column(
            name = "phosphate")
    private Double phosphate;
    
    @Column(
            name = "ph")
    private Double ph;
    
    @Column(
            name = "nitrate")
    private String nitrate;
    
    @Column(
            name = "ammonia")
    private String ammonia;
    @Column(
            name = "date")
    private LocalDate date;

    @Column(
            name = "coordinate",
            columnDefinition = "geometry(Point,4326)")
    private Point coordinate;

    public Cs5Data() { }

    public Cs5Data(UUID id) {
        this.id = id;
    }

    public Cs5Data(UUID id, LocalDate date, Point coordinate) {
        this(id);
        this.date = date;
        this.coordinate = coordinate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getUnnamed0() {
        return unnamed0;
    }

    public void setUnnamed0(Integer unnamed0) {
        this.unnamed0 = unnamed0;
    }

    public String getWaterBodyType() {
        return waterBodyType;
    }

    public void setWaterBodyType(String waterBodyType) {
        this.waterBodyType = waterBodyType;
    }

    public Boolean getDynamicRiskAssessment() {
        return dynamicRiskAssessment;
    }

    public void setDynamicRiskAssessment(Boolean dynamicRiskAssessment) {
        this.dynamicRiskAssessment = dynamicRiskAssessment;
    }

    public Double getEstimatedWidth() {
        return estimatedWidth;
    }

    public void setEstimatedWidth(Double estimatedWidth) {
        this.estimatedWidth = estimatedWidth;
    }

    public Double getEstimatedDepth() {
        return estimatedDepth;
    }

    public void setEstimatedDepth(Double estimatedDepth) {
        this.estimatedDepth = estimatedDepth;
    }

    public String getWaterFlow() {
        return waterFlow;
    }

    public void setWaterFlow(String waterFlow) {
        this.waterFlow = waterFlow;
    }

    public String getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(String waterLevel) {
        this.waterLevel = waterLevel;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getTotalDissolvedSolids() {
        return totalDissolvedSolids;
    }

    public void setTotalDissolvedSolids(Double totalDissolvedSolids) {
        this.totalDissolvedSolids = totalDissolvedSolids;
    }

    public Double getTurbidity() {
        return turbidity;
    }

    public void setTurbidity(Double turbidity) {
        this.turbidity = turbidity;
    }

    public Double getPhosphate() {
        return phosphate;
    }

    public void setPhosphate(Double phosphate) {
        this.phosphate = phosphate;
    }

    public Double getPh() {
        return ph;
    }

    public void setPh(Double ph) {
        this.ph = ph;
    }

    public String getNitrate() {
        return nitrate;
    }

    public void setNitrate(String nitrate) {
        this.nitrate = nitrate;
    }

    public String getAmmonia() {
        return ammonia;
    }

    public void setAmmonia(String ammonia) {
        this.ammonia = ammonia;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: " + id + ", ");
        sb.append("date: " + date + ", ");
        return sb.toString();
    }
}
