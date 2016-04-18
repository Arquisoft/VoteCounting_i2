package es.uniovi.asw.resultsdb.business.impl;

import java.util.List;

import es.uniovi.asw.resultsdb.business.ResultsService;
import es.uniovi.asw.resultsdb.business.impl.results.GetAllResults;
import es.uniovi.asw.resultsdb.business.impl.results.GetResultByName;
import es.uniovi.asw.resultsdb.domain.Results;

public class ResultsServiceImpl implements ResultsService {

	@Override
	public List<Results> getAllResults() {
		// TODO Auto-generated method stub
		return CommandExecutor.execute(new GetAllResults());
	}

	@Override
	public Results getResultByName(String name) {
		return CommandExecutor.execute(new GetResultByName(name));
	}

}
