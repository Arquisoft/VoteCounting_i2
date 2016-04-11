package main.java.es.uniovi.asw.dbmanagement.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "polling_station")
public class PollingStation implements Serializable {
    @Id
    @GeneratedValue
    private long polling_station_code;

    private String province;
    private String city;
    private String district;
    private String country;

    @OneToMany(mappedBy = "pollingStation")
    private List<Voter> voters=new ArrayList<Voter>();

    @OneToMany(mappedBy = "pollingStation")
    private List<Vote> votes=new ArrayList<Vote>();

    public PollingStation() {
    }

    public PollingStation(String province, String city, String district, String country) {
        this.province = province;
        this.city = city;
        this.district = district;
        this.country = country;
    }

    public PollingStation(String province, String city, String district, String country, List<Voter> voters, List<Vote> votes) {
        this.province = province;
        this.city = city;
        this.district = district;
        this.country = country;
        this.voters = voters;
        this.votes=votes;

        for(Voter v: voters)
            v.setPollingStation(this);
        for(Vote v: votes)
            v.setPollingStation(this);
    }


    public long getPolling_station_code() {
        return polling_station_code;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private List<Voter> getOriginalVoters() {
        return voters;
    }

    public List<Voter> getVoters() {
        return new ArrayList(voters);
    }

    public void addVoter(Voter v)
    {
        this.voters.add(v);
    }

    public void removeVoter(Voter v)
    {
        this.voters.remove(v);
    }

    public void setVoters(List<Voter> voters) {
        this.voters = voters;
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

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        PollingStation that = (PollingStation) object;

        if (polling_station_code != that.polling_station_code) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (polling_station_code ^ (polling_station_code >>> 32));
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "PollingStation{" +
                "polling_station_code=" + polling_station_code +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", country='" + country + '\'' +
                ", voters=" + voters +
                '}';
    }
}
