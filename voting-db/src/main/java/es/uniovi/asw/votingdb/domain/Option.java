package es.uniovi.asw.votingdb.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "option")
public class Option implements Serializable {
    @Id
    @GeneratedValue
    private long option_id;

    @Column(unique = true, nullable = false)
    private String name;

    private String comment;

    @OneToMany(mappedBy = "option")
    private Set<Vote> votes=new HashSet<Vote>();

    public Option() {
    }

    public Option(String comment, String name) {
        this.comment = comment;
        this.name = name;
    }

    public long getOption_id() {
        return option_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    protected Set<Vote> _getVotes() {
        return votes;
    }

    public Set<Vote> getVotes() {
        return new HashSet(votes);
    }

    public void addVote(Vote v)
    {
        Association.InFavorOf.link(this,v);
    }

    public void removeVote(Vote v)
    {
        Association.InFavorOf.unlink(this,v);
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Option option = (Option) o;

        return name.equals(option.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Option{" +
                "option_id=" + option_id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", votes=" + votes +
                '}';
    }
}
