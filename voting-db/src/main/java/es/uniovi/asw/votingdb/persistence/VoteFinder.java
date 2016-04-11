package es.uniovi.asw.votingdb.persistence;

import es.uniovi.asw.votingdb.domain.Option;
import es.uniovi.asw.votingdb.domain.PollingStation;
import es.uniovi.asw.votingdb.persistence.util.Jpa;

import java.util.List;
import java.util.Set;

/**
 * Created by Fabio on 12/04/2016.
 */
public class VoteFinder {
    public static List<Option> findByPollingStation(PollingStation pollingStation) {
        return Jpa.getManager()
                .createNamedQuery("Vote.findByPollingStation", Option.class)
                .setParameter(1, pollingStation)
                .getResultList();
    }
}
