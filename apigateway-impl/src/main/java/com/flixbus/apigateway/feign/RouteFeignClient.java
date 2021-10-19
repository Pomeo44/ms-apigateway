package com.flixbus.apigateway.feign;

import com.flixbus.apigateway.feign.dto.Routes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "route")
public interface RouteFeignClient {

    @RequestMapping(value = "/bestroute",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<Routes> bestrouteroutesGet(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @RequestParam(value = "cityFrom", required = false) String cityFrom,
            @RequestParam(value = "cityTo", required = false) String cityTo);

}
