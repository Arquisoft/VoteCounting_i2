package es.uniovi.asw.resultsdb.business.impl.voter;

import es.uniovi.asw.resultsdb.business.exception.BusinessException;
import es.uniovi.asw.resultsdb.business.exception.VoterNotFoundException;
import es.uniovi.asw.resultsdb.business.impl.Command;
import es.uniovi.asw.resultsdb.domain.Voter;
import es.uniovi.asw.resultsdb.persistence.VoterFinder;

import javax.persistence.NoResultException;

public class GetVoter implements Command<Voter> {

    private String email;
    private String password;

    public GetVoter(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public Voter execute() throws BusinessException {
        try {
            return VoterFinder.findByEmailAndPassword(email, password);
        } catch (NoResultException e) {
            throw new VoterNotFoundException();
        }
    }
}
