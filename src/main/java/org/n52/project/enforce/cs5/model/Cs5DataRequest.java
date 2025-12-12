package org.n52.project.enforce.cs5.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Cs5DataRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-12T14:19:19.299882+01:00[Europe/Berlin]", comments = "Generator version: 7.13.0")
public class Cs5DataRequest implements Serializable {

  private static final long serialVersionUID = 1L;

  private @Nullable Integer unnamed0;

  private UUID id;

  private @Nullable Double _long;

  private @Nullable Double lat;

  private @Nullable String waterBodyType;

  private @Nullable Boolean dynamicRiskAssessment;

  private @Nullable Double estimatedWidth;

  private @Nullable Double estimatedDepth;

  private @Nullable String waterFlow;

  private @Nullable String waterLevel;

  private @Nullable Double temperature;

  private @Nullable Double totalDissolvedSolids;

  private @Nullable Double turbidity;

  private @Nullable Double phosphate;

  private @Nullable Double ph;

  private @Nullable String nitrate;

  private @Nullable String ammonia;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate date;

  @Valid
  private List<String> pollutionEvidence = new ArrayList<>();

  @Valid
  private List<String> pollutionSource = new ArrayList<>();

  @Valid
  private List<String> flowImpedance = new ArrayList<>();

  @Valid
  private List<String> invasivePlant = new ArrayList<>();

  @Valid
  private List<String> wildlife = new ArrayList<>();

  @Valid
  private List<String> bankVegetation = new ArrayList<>();

  @Valid
  private List<String> landUse = new ArrayList<>();

  public Cs5DataRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Cs5DataRequest(UUID id) {
    this.id = id;
  }

  public Cs5DataRequest unnamed0(Integer unnamed0) {
    this.unnamed0 = unnamed0;
    return this;
  }

  /**
   * Get unnamed0
   * @return unnamed0
   */
  
  @Schema(name = "Unnamed: 0", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("Unnamed: 0")
  public Integer getUnnamed0() {
    return unnamed0;
  }

  public void setUnnamed0(Integer unnamed0) {
    this.unnamed0 = unnamed0;
  }

  public Cs5DataRequest id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @NotNull @Valid 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Cs5DataRequest _long(Double _long) {
    this._long = _long;
    return this;
  }

  /**
   * Get _long
   * @return _long
   */
  
  @Schema(name = "long", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("long")
  public Double getLong() {
    return _long;
  }

  public void setLong(Double _long) {
    this._long = _long;
  }

  public Cs5DataRequest lat(Double lat) {
    this.lat = lat;
    return this;
  }

  /**
   * Get lat
   * @return lat
   */
  
  @Schema(name = "lat", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lat")
  public Double getLat() {
    return lat;
  }

  public void setLat(Double lat) {
    this.lat = lat;
  }

  public Cs5DataRequest waterBodyType(String waterBodyType) {
    this.waterBodyType = waterBodyType;
    return this;
  }

  /**
   * Get waterBodyType
   * @return waterBodyType
   */
  
  @Schema(name = "waterBodyType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("waterBodyType")
  public String getWaterBodyType() {
    return waterBodyType;
  }

  public void setWaterBodyType(String waterBodyType) {
    this.waterBodyType = waterBodyType;
  }

  public Cs5DataRequest dynamicRiskAssessment(Boolean dynamicRiskAssessment) {
    this.dynamicRiskAssessment = dynamicRiskAssessment;
    return this;
  }

  /**
   * Get dynamicRiskAssessment
   * @return dynamicRiskAssessment
   */
  
  @Schema(name = "dynamicRiskAssessment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dynamicRiskAssessment")
  public Boolean getDynamicRiskAssessment() {
    return dynamicRiskAssessment;
  }

  public void setDynamicRiskAssessment(Boolean dynamicRiskAssessment) {
    this.dynamicRiskAssessment = dynamicRiskAssessment;
  }

  public Cs5DataRequest estimatedWidth(Double estimatedWidth) {
    this.estimatedWidth = estimatedWidth;
    return this;
  }

  /**
   * Get estimatedWidth
   * @return estimatedWidth
   */
  
  @Schema(name = "estimatedWidth", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("estimatedWidth")
  public Double getEstimatedWidth() {
    return estimatedWidth;
  }

  public void setEstimatedWidth(Double estimatedWidth) {
    this.estimatedWidth = estimatedWidth;
  }

  public Cs5DataRequest estimatedDepth(Double estimatedDepth) {
    this.estimatedDepth = estimatedDepth;
    return this;
  }

  /**
   * Get estimatedDepth
   * @return estimatedDepth
   */
  
  @Schema(name = "estimatedDepth", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("estimatedDepth")
  public Double getEstimatedDepth() {
    return estimatedDepth;
  }

  public void setEstimatedDepth(Double estimatedDepth) {
    this.estimatedDepth = estimatedDepth;
  }

  public Cs5DataRequest waterFlow(String waterFlow) {
    this.waterFlow = waterFlow;
    return this;
  }

  /**
   * Get waterFlow
   * @return waterFlow
   */
  
  @Schema(name = "waterFlow", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("waterFlow")
  public String getWaterFlow() {
    return waterFlow;
  }

  public void setWaterFlow(String waterFlow) {
    this.waterFlow = waterFlow;
  }

  public Cs5DataRequest waterLevel(String waterLevel) {
    this.waterLevel = waterLevel;
    return this;
  }

  /**
   * Get waterLevel
   * @return waterLevel
   */
  
  @Schema(name = "waterLevel", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("waterLevel")
  public String getWaterLevel() {
    return waterLevel;
  }

  public void setWaterLevel(String waterLevel) {
    this.waterLevel = waterLevel;
  }

  public Cs5DataRequest temperature(Double temperature) {
    this.temperature = temperature;
    return this;
  }

  /**
   * Get temperature
   * @return temperature
   */
  
  @Schema(name = "temperature", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("temperature")
  public Double getTemperature() {
    return temperature;
  }

  public void setTemperature(Double temperature) {
    this.temperature = temperature;
  }

  public Cs5DataRequest totalDissolvedSolids(Double totalDissolvedSolids) {
    this.totalDissolvedSolids = totalDissolvedSolids;
    return this;
  }

  /**
   * Get totalDissolvedSolids
   * @return totalDissolvedSolids
   */
  
  @Schema(name = "totalDissolvedSolids", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalDissolvedSolids")
  public Double getTotalDissolvedSolids() {
    return totalDissolvedSolids;
  }

  public void setTotalDissolvedSolids(Double totalDissolvedSolids) {
    this.totalDissolvedSolids = totalDissolvedSolids;
  }

  public Cs5DataRequest turbidity(Double turbidity) {
    this.turbidity = turbidity;
    return this;
  }

  /**
   * Get turbidity
   * @return turbidity
   */
  
  @Schema(name = "turbidity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("turbidity")
  public Double getTurbidity() {
    return turbidity;
  }

  public void setTurbidity(Double turbidity) {
    this.turbidity = turbidity;
  }

  public Cs5DataRequest phosphate(Double phosphate) {
    this.phosphate = phosphate;
    return this;
  }

  /**
   * Get phosphate
   * @return phosphate
   */
  
  @Schema(name = "phosphate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("phosphate")
  public Double getPhosphate() {
    return phosphate;
  }

  public void setPhosphate(Double phosphate) {
    this.phosphate = phosphate;
  }

  public Cs5DataRequest ph(Double ph) {
    this.ph = ph;
    return this;
  }

  /**
   * Get ph
   * @return ph
   */
  
  @Schema(name = "ph", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ph")
  public Double getPh() {
    return ph;
  }

  public void setPh(Double ph) {
    this.ph = ph;
  }

  public Cs5DataRequest nitrate(String nitrate) {
    this.nitrate = nitrate;
    return this;
  }

  /**
   * Get nitrate
   * @return nitrate
   */
  
  @Schema(name = "nitrate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nitrate")
  public String getNitrate() {
    return nitrate;
  }

  public void setNitrate(String nitrate) {
    this.nitrate = nitrate;
  }

  public Cs5DataRequest ammonia(String ammonia) {
    this.ammonia = ammonia;
    return this;
  }

  /**
   * Get ammonia
   * @return ammonia
   */
  
  @Schema(name = "ammonia", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ammonia")
  public String getAmmonia() {
    return ammonia;
  }

  public void setAmmonia(String ammonia) {
    this.ammonia = ammonia;
  }

  public Cs5DataRequest date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
   */
  @Valid 
  @Schema(name = "Date", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("Date")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Cs5DataRequest pollutionEvidence(List<String> pollutionEvidence) {
    this.pollutionEvidence = pollutionEvidence;
    return this;
  }

  public Cs5DataRequest addPollutionEvidenceItem(String pollutionEvidenceItem) {
    if (this.pollutionEvidence == null) {
      this.pollutionEvidence = new ArrayList<>();
    }
    this.pollutionEvidence.add(pollutionEvidenceItem);
    return this;
  }

  /**
   * Get pollutionEvidence
   * @return pollutionEvidence
   */
  
  @Schema(name = "pollutionEvidence", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pollutionEvidence")
  public List<String> getPollutionEvidence() {
    return pollutionEvidence;
  }

  public void setPollutionEvidence(List<String> pollutionEvidence) {
    this.pollutionEvidence = pollutionEvidence;
  }

  public Cs5DataRequest pollutionSource(List<String> pollutionSource) {
    this.pollutionSource = pollutionSource;
    return this;
  }

  public Cs5DataRequest addPollutionSourceItem(String pollutionSourceItem) {
    if (this.pollutionSource == null) {
      this.pollutionSource = new ArrayList<>();
    }
    this.pollutionSource.add(pollutionSourceItem);
    return this;
  }

  /**
   * Get pollutionSource
   * @return pollutionSource
   */
  
  @Schema(name = "pollutionSource", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pollutionSource")
  public List<String> getPollutionSource() {
    return pollutionSource;
  }

  public void setPollutionSource(List<String> pollutionSource) {
    this.pollutionSource = pollutionSource;
  }

  public Cs5DataRequest flowImpedance(List<String> flowImpedance) {
    this.flowImpedance = flowImpedance;
    return this;
  }

  public Cs5DataRequest addFlowImpedanceItem(String flowImpedanceItem) {
    if (this.flowImpedance == null) {
      this.flowImpedance = new ArrayList<>();
    }
    this.flowImpedance.add(flowImpedanceItem);
    return this;
  }

  /**
   * Get flowImpedance
   * @return flowImpedance
   */
  
  @Schema(name = "flowImpedance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("flowImpedance")
  public List<String> getFlowImpedance() {
    return flowImpedance;
  }

  public void setFlowImpedance(List<String> flowImpedance) {
    this.flowImpedance = flowImpedance;
  }

  public Cs5DataRequest invasivePlant(List<String> invasivePlant) {
    this.invasivePlant = invasivePlant;
    return this;
  }

  public Cs5DataRequest addInvasivePlantItem(String invasivePlantItem) {
    if (this.invasivePlant == null) {
      this.invasivePlant = new ArrayList<>();
    }
    this.invasivePlant.add(invasivePlantItem);
    return this;
  }

  /**
   * Get invasivePlant
   * @return invasivePlant
   */
  
  @Schema(name = "invasivePlant", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("invasivePlant")
  public List<String> getInvasivePlant() {
    return invasivePlant;
  }

  public void setInvasivePlant(List<String> invasivePlant) {
    this.invasivePlant = invasivePlant;
  }

  public Cs5DataRequest wildlife(List<String> wildlife) {
    this.wildlife = wildlife;
    return this;
  }

  public Cs5DataRequest addWildlifeItem(String wildlifeItem) {
    if (this.wildlife == null) {
      this.wildlife = new ArrayList<>();
    }
    this.wildlife.add(wildlifeItem);
    return this;
  }

  /**
   * Get wildlife
   * @return wildlife
   */
  
  @Schema(name = "wildlife", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("wildlife")
  public List<String> getWildlife() {
    return wildlife;
  }

  public void setWildlife(List<String> wildlife) {
    this.wildlife = wildlife;
  }

  public Cs5DataRequest bankVegetation(List<String> bankVegetation) {
    this.bankVegetation = bankVegetation;
    return this;
  }

  public Cs5DataRequest addBankVegetationItem(String bankVegetationItem) {
    if (this.bankVegetation == null) {
      this.bankVegetation = new ArrayList<>();
    }
    this.bankVegetation.add(bankVegetationItem);
    return this;
  }

  /**
   * Get bankVegetation
   * @return bankVegetation
   */
  
  @Schema(name = "bankVegetation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bankVegetation")
  public List<String> getBankVegetation() {
    return bankVegetation;
  }

  public void setBankVegetation(List<String> bankVegetation) {
    this.bankVegetation = bankVegetation;
  }

  public Cs5DataRequest landUse(List<String> landUse) {
    this.landUse = landUse;
    return this;
  }

  public Cs5DataRequest addLandUseItem(String landUseItem) {
    if (this.landUse == null) {
      this.landUse = new ArrayList<>();
    }
    this.landUse.add(landUseItem);
    return this;
  }

  /**
   * Get landUse
   * @return landUse
   */
  
  @Schema(name = "landUse", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("landUse")
  public List<String> getLandUse() {
    return landUse;
  }

  public void setLandUse(List<String> landUse) {
    this.landUse = landUse;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cs5DataRequest cs5DataRequest = (Cs5DataRequest) o;
    return Objects.equals(this.unnamed0, cs5DataRequest.unnamed0) &&
        Objects.equals(this.id, cs5DataRequest.id) &&
        Objects.equals(this._long, cs5DataRequest._long) &&
        Objects.equals(this.lat, cs5DataRequest.lat) &&
        Objects.equals(this.waterBodyType, cs5DataRequest.waterBodyType) &&
        Objects.equals(this.dynamicRiskAssessment, cs5DataRequest.dynamicRiskAssessment) &&
        Objects.equals(this.estimatedWidth, cs5DataRequest.estimatedWidth) &&
        Objects.equals(this.estimatedDepth, cs5DataRequest.estimatedDepth) &&
        Objects.equals(this.waterFlow, cs5DataRequest.waterFlow) &&
        Objects.equals(this.waterLevel, cs5DataRequest.waterLevel) &&
        Objects.equals(this.temperature, cs5DataRequest.temperature) &&
        Objects.equals(this.totalDissolvedSolids, cs5DataRequest.totalDissolvedSolids) &&
        Objects.equals(this.turbidity, cs5DataRequest.turbidity) &&
        Objects.equals(this.phosphate, cs5DataRequest.phosphate) &&
        Objects.equals(this.ph, cs5DataRequest.ph) &&
        Objects.equals(this.nitrate, cs5DataRequest.nitrate) &&
        Objects.equals(this.ammonia, cs5DataRequest.ammonia) &&
        Objects.equals(this.date, cs5DataRequest.date) &&
        Objects.equals(this.pollutionEvidence, cs5DataRequest.pollutionEvidence) &&
        Objects.equals(this.pollutionSource, cs5DataRequest.pollutionSource) &&
        Objects.equals(this.flowImpedance, cs5DataRequest.flowImpedance) &&
        Objects.equals(this.invasivePlant, cs5DataRequest.invasivePlant) &&
        Objects.equals(this.wildlife, cs5DataRequest.wildlife) &&
        Objects.equals(this.bankVegetation, cs5DataRequest.bankVegetation) &&
        Objects.equals(this.landUse, cs5DataRequest.landUse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(unnamed0, id, _long, lat, waterBodyType, dynamicRiskAssessment, estimatedWidth, estimatedDepth, waterFlow, waterLevel, temperature, totalDissolvedSolids, turbidity, phosphate, ph, nitrate, ammonia, date, pollutionEvidence, pollutionSource, flowImpedance, invasivePlant, wildlife, bankVegetation, landUse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cs5DataRequest {\n");
    sb.append("    unnamed0: ").append(toIndentedString(unnamed0)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    _long: ").append(toIndentedString(_long)).append("\n");
    sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
    sb.append("    waterBodyType: ").append(toIndentedString(waterBodyType)).append("\n");
    sb.append("    dynamicRiskAssessment: ").append(toIndentedString(dynamicRiskAssessment)).append("\n");
    sb.append("    estimatedWidth: ").append(toIndentedString(estimatedWidth)).append("\n");
    sb.append("    estimatedDepth: ").append(toIndentedString(estimatedDepth)).append("\n");
    sb.append("    waterFlow: ").append(toIndentedString(waterFlow)).append("\n");
    sb.append("    waterLevel: ").append(toIndentedString(waterLevel)).append("\n");
    sb.append("    temperature: ").append(toIndentedString(temperature)).append("\n");
    sb.append("    totalDissolvedSolids: ").append(toIndentedString(totalDissolvedSolids)).append("\n");
    sb.append("    turbidity: ").append(toIndentedString(turbidity)).append("\n");
    sb.append("    phosphate: ").append(toIndentedString(phosphate)).append("\n");
    sb.append("    ph: ").append(toIndentedString(ph)).append("\n");
    sb.append("    nitrate: ").append(toIndentedString(nitrate)).append("\n");
    sb.append("    ammonia: ").append(toIndentedString(ammonia)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    pollutionEvidence: ").append(toIndentedString(pollutionEvidence)).append("\n");
    sb.append("    pollutionSource: ").append(toIndentedString(pollutionSource)).append("\n");
    sb.append("    flowImpedance: ").append(toIndentedString(flowImpedance)).append("\n");
    sb.append("    invasivePlant: ").append(toIndentedString(invasivePlant)).append("\n");
    sb.append("    wildlife: ").append(toIndentedString(wildlife)).append("\n");
    sb.append("    bankVegetation: ").append(toIndentedString(bankVegetation)).append("\n");
    sb.append("    landUse: ").append(toIndentedString(landUse)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

