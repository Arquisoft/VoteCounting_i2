package es.uniovi.asw.resultsdb.business;

import es.uniovi.asw.resultsdb.domain.Results;

import java.util.List;

public interface ResultsService {

    List<Results> getAllResults();

    Results getResultByName(String name);

    Results createResultEntry(String name, String comment);

    Results createResultEntry(String name, String comment, int votes);

    void removeResultEntry(Results r);

    Results updateResultEntry(Results r);
}
