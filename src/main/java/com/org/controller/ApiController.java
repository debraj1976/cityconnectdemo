package com.org.controller;

import com.org.model.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@RestController
public class ApiController {

    @GetMapping(value = "/connected")
    public <T> ResponseEntity<Data> handlePostRequest(@RequestParam("origin") String origin, @RequestParam("destination") String destination) {

        String isRoadExist = isRoadExist(origin, destination);
        Data data = new Data();
        data.setStatus(isRoadExist);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    private String isRoadExist(String origin, String destination) {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("city.txt");

        try (InputStreamReader streamReader =
                     new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] cityArray = line.split(",");
                if ((origin.equalsIgnoreCase(cityArray[0]) && destination.equalsIgnoreCase(cityArray[1])) ||
                        (destination.equalsIgnoreCase(cityArray[0]) && origin.equalsIgnoreCase(cityArray[1]))) {
                    return "Yes";
                }
            }

        } catch (IOException e) {
            return "Internal server error.";
            //e.printStackTrace();
        }
        return "No";
    }
}
