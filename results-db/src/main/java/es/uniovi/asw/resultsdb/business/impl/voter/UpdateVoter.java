package es.uniovi.asw.resultsdb.business.impl.voter;

import es.uniovi.asw.resultsdb.business.exception.BusinessException;
import es.uniovi.asw.resultsdb.business.impl.Command;
import es.uniovi.asw.resultsdb.domain.Voter;
import es.uniovi.asw.resultsdb.persistence.util.Jpa;

public class UpdateVoter implements Command<Voter> {
    private Voter voter;

    public UpdateVoter(Voter voter) {
        this.voter = voter;
    }

    @Override
    public Voter execute() throws BusinessException {
        try {
            return Jpa.getManager().merge(voter);
        } catch (Exception e) {
            throw new BusinessException();
        }
    }
}
