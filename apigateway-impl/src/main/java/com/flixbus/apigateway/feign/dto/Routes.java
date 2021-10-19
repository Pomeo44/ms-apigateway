package com.flixbus.apigateway.feign.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Routes
 */
public class Routes   {
  @JsonProperty("routes")
  @Valid
  private List<Route> routes = null;

  public Routes routes(List<Route> routes) {
    this.routes = routes;
    return this;
  }

  public Routes addRoutesItem(Route routesItem) {
    if (this.routes == null) {
      this.routes = new ArrayList<>();
    }
    this.routes.add(routesItem);
    return this;
  }

  /**
   * routes
   * @return routes
  */
  @Valid
  public List<Route> getRoutes() {
    return routes;
  }

  public void setRoutes(List<Route> routes) {
    this.routes = routes;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Routes routes = (Routes) o;
    return Objects.equals(this.routes, routes.routes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(routes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Routes {\n");
    
    sb.append("    routes: ").append(toIndentedString(routes)).append("\n");
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

