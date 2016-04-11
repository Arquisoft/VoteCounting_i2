package es.uniovi.asw.resultsdb.persistence;

import es.uniovi.asw.resultsdb.domain.Voter;
import es.uniovi.asw.resultsdb.persistence.util.Jpa;

public class VoterFinder {

    public static Voter findByEmailAndPassword(String email, String password) {
        return Jpa.getManager()
                .createNamedQuery("Voter.findByEmailAndPassword", Voter.class)
                .setParameter(1, email)
                .setParameter(2, password)
                .getSingleResult();
    }

    public static Voter findByEmail(String email) {
        return Jpa.getManager()
                .createNamedQuery("Voter.findByEmail", Voter.class)
                .setParameter(1, email)
                .getSingleResult();
    }
}
