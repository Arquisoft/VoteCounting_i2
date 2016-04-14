package es.uniovi.asw.votingdb.domain;

import es.uniovi.asw.votingdb.domain.types.VoteKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@IdClass(VoteKey.class)
@Table(name = "vote")
public class Vote implements Serializable {


    @Id
    @GeneratedValue
    private long id;

    //@Id
    @ManyToOne
    private Option option;

    //@Id
    @ManyToOne
    private PollingStation pollingStation;

    public Vote() {
    }

    public Vote(Option option, PollingStation pollingStation) {
        this.option = option;
        this.pollingStation = pollingStation;

        Association.InFavorOf.link(option, this);
        Association.Exercise.link(pollingStation,this);
    }

    public Long getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vote vote = (Vote) o;

        if (!option.equals(vote.option)) return false;
        return pollingStation.equals(vote.pollingStation);

    }

    @Override
    public int hashCode() {
        int result = option.hashCode();
        result = 31 * result + pollingStation.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "option=" + option +
                ", pollingStation=" + pollingStation +
                '}';
    }
}
