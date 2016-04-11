package es.uniovi.asw.resultsdb.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vote")
public class Vote implements Serializable {


    @Id
    @GeneratedValue
    private long vote_id;

    @ManyToOne
    private Option option;

    @ManyToOne
    private PollingStation pollingStation;

    public Vote() {
    }

    public Vote(Option option, PollingStation pollingStation) {
        this.option = option;
        this.pollingStation = pollingStation;

        option.addVote(this);
        pollingStation.addVote(this);
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public PollingStation getPollingStation() {
        return pollingStation;
    }

    public void setPollingStation(PollingStation pollingStation) {
        this.pollingStation = pollingStation;
    }

    public long getVote_id() {
        return vote_id;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        Vote vote = (Vote) object;

        if (vote_id != vote.vote_id) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (vote_id ^ (vote_id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "vote_id=" + vote_id +
                ", option=" + option +
                ", pollingStation=" + pollingStation +
                '}';
    }
}
