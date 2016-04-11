package es.uniovi.asw.votingdb.infrastructure;

import es.uniovi.asw.votingdb.business.VoterService;
import es.uniovi.asw.votingdb.business.impl.VoterServiceImpl;

public class ServicesFactory {

    public static VoterService createVoterService() {
        return new VoterServiceImpl();
    }
}
