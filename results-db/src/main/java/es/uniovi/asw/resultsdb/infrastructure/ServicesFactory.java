package es.uniovi.asw.resultsdb.infrastructure;

import es.uniovi.asw.resultsdb.business.VoterService;
import es.uniovi.asw.resultsdb.business.impl.VoterServiceImpl;

public class ServicesFactory {

    public static VoterService createVoterService() {
        return new VoterServiceImpl();
    }
}
