package es.uniovi.asw.resultsdb.business.impl.results;

import java.util.List;

import javax.persistence.NoResultException;

import es.uniovi.asw.resultsdb.business.exception.BusinessException;
import es.uniovi.asw.resultsdb.business.exception.ResultsNotFoundException;
import es.uniovi.asw.resultsdb.business.impl.Command;
import es.uniovi.asw.resultsdb.domain.Results;
import es.uniovi.asw.resultsdb.persistence.ResultsFinder;

public class GetAllResults implements Command<List<Results>>{

	@Override
	public List<Results> execute() throws BusinessException {
		try {
			return ResultsFinder.findAllResults();
		} catch(NoResultException e){
			throw new ResultsNotFoundException();
		}
	}

}
