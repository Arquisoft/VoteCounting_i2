package es.uniovi.asw.votingdb.domain.types;

import java.io.Serializable;

/**
 * Created by Fabio on 11/04/2016.
 */
public class VoteKey implements Serializable {
    private static final long serialVersionUID = 1L;

    Long pollingStation;
    Long option;

    public VoteKey() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VoteKey voteKey = (VoteKey) o;

        if (!pollingStation.equals(voteKey.pollingStation)) return false;
        return option.equals(voteKey.option);

    }

    @Override
    public int hashCode() {
        int result = pollingStation.hashCode();
        result = 31 * result + option.hashCode();
        return result;
    }
}
