package es.uniovi.asw.resultsdb.business;

import java.util.List;

import es.uniovi.asw.resultsdb.domain.Results;

public interface ResultsService {
	
	List<Results> getAllResults();
	
	Results getResultByName(String name);
}
