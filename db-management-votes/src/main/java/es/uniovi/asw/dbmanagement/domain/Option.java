package main.java.es.uniovi.asw.dbmanagement.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    private List<Vote> votes=new ArrayList<Vote>();

    public Option() {
    }

    public Option(String comment, String name) {
        this.comment = comment;
        this.name = name;
    }

    public Option(String name, String comment, List<Vote> votes) {
        this.name = name;
        this.comment = comment;
        this.votes = votes;

        for(Vote v: votes)
            v.setOption(this);
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

    private List<Vote> getOriginalVotes() {
        return votes;
    }

    public List<Vote> getVotes() {
        return new ArrayList(votes);
    }

    public void addVote(Vote v)
    {
        this.votes.add(v);
    }

    public void removeVote(Vote v)
    {
        this.votes.remove(v);
    }

    public void setVotes(List<Vote> votes) {
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
