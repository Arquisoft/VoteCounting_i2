package es.uniovi.asw.results.model;



/**
 * Created by Roberto on 17/4/16.
 */
public class ResultsDTO {

    private String name;
    private String comment;
    private int votes;


    public ResultsDTO (String name,  String comment){
        this.name = name;
        this.comment = comment;
        this.votes = 0;
    }

    public ResultsDTO (String name,  String comment, int votes){
        this.name = name;
        this.comment = comment;
        this.votes = votes;
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

    public int getVotos() {
        return votes;
    }

    public void setVotos(int votos) {
        this.votes = votos;
    }
}
