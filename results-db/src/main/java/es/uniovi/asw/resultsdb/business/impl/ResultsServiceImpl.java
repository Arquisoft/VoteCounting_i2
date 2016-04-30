package es.uniovi.asw.resultsdb.business.impl;

import es.uniovi.asw.resultsdb.business.ResultsService;
import es.uniovi.asw.resultsdb.business.impl.results.*;
import es.uniovi.asw.resultsdb.domain.Results;

import java.util.List;

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

    @Override
    public Results createResultEntry(String name, String comment) {
        // TODO Auto-generated method stub
        return CommandExecutor.execute(new CreateResult(name, comment));
    }

    @Override
    public Results createResultEntry(String name, String comment, int votes) {
        // TODO Auto-generated method stub
        return CommandExecutor.execute(new CreateResult(name, comment, votes));
    }

    @Override
    public void removeResultEntry(Results r) {
        CommandExecutor.execute(new RemoveResult(r));
    }

    @Override
    public Results updateResultEntry(Results r) {
        return CommandExecutor.execute(new UpdateResult(r));
    }
}
