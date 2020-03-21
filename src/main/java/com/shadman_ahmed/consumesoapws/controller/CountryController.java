package com.shadman_ahmed.consumesoapws.controller;

import com.example.consumingwebservice.wsdl.Country;
import com.example.consumingwebservice.wsdl.GetCountryResponse;
import com.shadman_ahmed.consumesoapws.client.CountryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Objects;

@RestController
@Slf4j
public class CountryController {

    @Autowired
    CountryClient countryClient;

    @GetMapping(value = "/countries")
    public Country getCountry(@RequestParam(required = true, name = "country") String name) {
        GetCountryResponse response = countryClient.getCountry(name);

        Country country = response.getCountry();

        if (Objects.isNull(country)) {
            throw new NullPointerException();
        }

        return country;
    }
}
