package com.example.production_ready_features.clients.implementations;

import com.example.production_ready_features.advices.ApiResponse;
import com.example.production_ready_features.clients.EmployeeClient;
import com.example.production_ready_features.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
@Service
@RequiredArgsConstructor

public class EmployeeClientImpl implements EmployeeClient {

    Logger logger = LoggerFactory.getLogger(EmployeeClientImpl.class);

    private final RestClient restClient;
    @Override
    public List<EmployeeDTO> getAllEmployees() {

        logger.trace("trying to retrieve all employees ");
//        logger.error("error log ");
//        logger.warn("warn log");
//        logger.info("info log");
//        logger.debug("debug log");
//        logger.trace("trace log");

        try {

            ApiResponse<List<EmployeeDTO>> list=restClient.get().
                    uri("employees").retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                        logger.error(new String(response.getBody().readAllBytes()));
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            logger.debug("Successfully retrieved employees in getAllEmployees");
            logger.trace("Retrieved employees list {}", list.getData());

            return list.getData();

        }
        catch (Exception e){
            logger.error("Exception occured", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO getEmployeebyid(Long employeeId) {
        logger.trace("trying to get employee by id with id: {}", employeeId);
        try{
            ApiResponse<EmployeeDTO> employeeResponse =restClient.get().
                    uri("employees/{employeeid}", employeeId)
                    .retrieve().onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                        logger.error(new String(response.getBody().readAllBytes()));
                    })

                    .body( new ParameterizedTypeReference<>(){

            });

            return employeeResponse.getData();

        }
        catch (Exception e){
            logger.error("Exception occured", e);
            throw new RuntimeException();
        }
    }

    @Override
    public EmployeeDTO createnewemployee(EmployeeDTO employeeDTO) {
        logger.trace("trying to create employee by information: {}", employeeDTO);
        try {
            ResponseEntity<ApiResponse<EmployeeDTO>> employeeDTOApiResponse = restClient.post()
                    .uri("employees")
                    .body(employeeDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, ((request, response) -> {
                        logger.debug("4xx Client error occured during creatnewemployee()");
                        logger.error(new String(response.getBody().readAllBytes()));
                    }))
                    .toEntity(new ParameterizedTypeReference<ApiResponse<EmployeeDTO>>() {
                    });
            logger.trace("successfully created a new employeee: {}", employeeDTOApiResponse.getBody());

            return employeeDTOApiResponse.getBody().getData();
        }
        catch (Exception e){
            logger.error("exception occured in createnewemployee", e);
            throw new RuntimeException();
        }
    }
}
