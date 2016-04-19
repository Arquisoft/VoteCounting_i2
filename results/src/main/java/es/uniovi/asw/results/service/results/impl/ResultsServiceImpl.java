package es.uniovi.asw.results.service.results.impl;

import es.uniovi.asw.results.model.ResultsDTO;
import es.uniovi.asw.results.service.exceptions.PartieNotFoundException;
import es.uniovi.asw.results.service.results.ResultsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Andrea on 19/04/2016.
 */
public class ResultsServiceImpl implements ResultsService{

    @Value("$results.api}")
    private String API;

    @Override
    public ResultsDTO find(ResultsDTO result) {
        try{
            RestTemplate restTemplate = new RestTemplate();
            String uri = API + "/";
            result = restTemplate.postForObject(uri, result, ResultsDTO.class);
        } catch (HttpClientErrorException e){
            throw new PartieNotFoundException();
        }
        return result;
    }

}
