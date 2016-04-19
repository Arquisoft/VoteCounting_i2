package es.uniovi.asw.results.model;

import es.uniovi.asw.results.service.exceptions.PartieNotFoundException;

/**
 * Created by Andrea on 19/04/2016.
 */
public class CurrentResults {
    private ResultsDTO[] parties;

    public CurrentResults(){}

    public CurrentResults(ResultsDTO[] parties){
        this.parties=parties;
    }

    public long getResultsOfPartie(String partieName){
        for (ResultsDTO p: parties)
        {
            if(p.getName().equals(partieName))
                return p.getVotos();
        }
        throw new PartieNotFoundException();
    }

    public long getTotalNumberOfVotes(){
        long total = 0;
        for (ResultsDTO p: parties) {
            total+=p.getVotos();
        }
        return total;
    }

    public ResultsDTO[] getParties() {
        return parties;
    }

    public void setParties(ResultsDTO[] parties) {
        this.parties = parties;
    }
}
