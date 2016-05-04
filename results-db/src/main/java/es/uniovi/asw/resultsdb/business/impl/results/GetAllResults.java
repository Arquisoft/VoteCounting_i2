package es.uniovi.asw.resultsdb.business.impl.results;

import es.uniovi.asw.resultsdb.business.exception.BusinessException;
import es.uniovi.asw.resultsdb.business.impl.Command;
import es.uniovi.asw.resultsdb.domain.Results;
import es.uniovi.asw.resultsdb.persistence.ResultsFinder;

import java.util.List;

public class GetAllResults implements Command<List<Results>> {

    @Override
    public List<Results> execute() throws BusinessException {
        return ResultsFinder.findAllResults();
    }

}
