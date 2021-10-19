package com.flixbus.apigateway.feign.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Route
 */
public class Route   {
  @JsonProperty("num_lines")
  private Integer numLines;

  @JsonProperty("total_bus_cost")
  private java.math.BigDecimal totalBusCost = null;

  @JsonProperty("total_driver_cost")
  private java.math.BigDecimal totalDriverCost = null;

  @JsonProperty("total_cost")
  private java.math.BigDecimal totalCost = null;

  public Route numLines(Integer numLines) {
    this.numLines = numLines;
    return this;
  }

  /**
   * num_lines
   * @return numLines
  */
  public Integer getNumLines() {
    return numLines;
  }

  public void setNumLines(Integer numLines) {
    this.numLines = numLines;
  }

  public Route totalBusCost(java.math.BigDecimal totalBusCost) {
    this.totalBusCost = totalBusCost;
    return this;
  }

  /**
   * total_bus_cost
   * @return totalBusCost
  */
  public java.math.BigDecimal getTotalBusCost() {
    return totalBusCost;
  }

  public void setTotalBusCost(java.math.BigDecimal totalBusCost) {
    this.totalBusCost = totalBusCost;
  }

  public Route totalDriverCost(java.math.BigDecimal totalDriverCost) {
    this.totalDriverCost = totalDriverCost;
    return this;
  }

  /**
   * total_driver_cost
   * @return totalDriverCost
  */
  public java.math.BigDecimal getTotalDriverCost() {
    return totalDriverCost;
  }

  public void setTotalDriverCost(java.math.BigDecimal totalDriverCost) {
    this.totalDriverCost = totalDriverCost;
  }

  public Route totalCost(java.math.BigDecimal totalCost) {
    this.totalCost = totalCost;
    return this;
  }

  /**
   * total_cost
   * @return totalCost
  */
  public java.math.BigDecimal getTotalCost() {
    return totalCost;
  }

  public void setTotalCost(java.math.BigDecimal totalCost) {
    this.totalCost = totalCost;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Route route = (Route) o;
    return Objects.equals(this.numLines, route.numLines) &&
        Objects.equals(this.totalBusCost, route.totalBusCost) &&
        Objects.equals(this.totalDriverCost, route.totalDriverCost) &&
        Objects.equals(this.totalCost, route.totalCost);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numLines, totalBusCost, totalDriverCost, totalCost);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Route {\n");
    
    sb.append("    numLines: ").append(toIndentedString(numLines)).append("\n");
    sb.append("    totalBusCost: ").append(toIndentedString(totalBusCost)).append("\n");
    sb.append("    totalDriverCost: ").append(toIndentedString(totalDriverCost)).append("\n");
    sb.append("    totalCost: ").append(toIndentedString(totalCost)).append("\n");
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

