package es.uniovi.asw.results.model;


import es.uniovi.asw.results.service.exceptions.PartieNotFound;

import java.util.Map;

/**
 * Created by Roberto on 17/4/16.
 */
public class ResultsDTO {

    private Map<String,Long> parties;

    public ResultsDTO(){}

    public ResultsDTO(Map<String,Long> parties){
        this.parties=parties;
    }

    public long getResultsOfPartie(String partieName){

        if(parties.containsKey(partieName)) {
            return parties.get(partieName);
        }else throw new PartieNotFound();
    }

    public long getTotalNumberOfVotes(){
        return parties.entrySet().stream().mapToLong(Map.Entry::getValue).reduce(0, (a, b) -> a + b);
    }

    public Map<String, Long> getParties() {
        return parties;
    }

    public void setParties(Map<String, Long> parties) {
        this.parties = parties;
    }



}
