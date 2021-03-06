package es.uniovi.asw.resultsdb.persistence;

import es.uniovi.asw.resultsdb.domain.Results;
import es.uniovi.asw.resultsdb.persistence.util.Jpa;

import java.util.List;

public class ResultsFinder {

    public static Results findByOptionName(String name) {
        return Jpa.getManager()
                .createNamedQuery("Results.findByOptionName", Results.class)
                .setParameter(1, name)
                .getSingleResult();
    }

    public static List<Results> findAllResults() {
        return Jpa.getManager()
                .createQuery("select r from Results r", Results.class)
                .getResultList();
    }
}
