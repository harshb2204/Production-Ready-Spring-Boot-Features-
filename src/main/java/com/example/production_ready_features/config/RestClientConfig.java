package com.example.production_ready_features.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

import static org.apache.tomcat.util.http.fileupload.FileUploadBase.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration  // Indicates that this class contains Spring configuration and bean definitions
public class RestClientConfig {

    @Value("${employeeService.base.url}")  // Injects the value of the property 'employeeService.base.url' from the application properties
    private String BASE_URL;  // Base URL for the employee service API

    @Bean  // Marks this method as a bean definition; Spring will manage the created bean
    @Qualifier("employeeRestClient")  // Qualifies this bean with the name 'employeeRestClient' for injection purposes
    RestClient getEmployeeServiceRestClient() {
        // Creates and configures a RestClient instance
        return RestClient.builder()  // Starts building a new RestClient instance
                .baseUrl(BASE_URL)  // Sets the base URL for all requests made with this RestClient
                .defaultHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)  // Sets the default 'Content-Type' header to
                // 'application/json'
                .defaultStatusHandler(HttpStatusCode::is5xxServerError, (request, response) -> {
                    throw new RuntimeException("Server error occured");
                })
                .build();  // Builds and returns the configured RestClient instance
    }
}
