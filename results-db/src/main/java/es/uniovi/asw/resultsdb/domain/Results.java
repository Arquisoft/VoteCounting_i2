package es.uniovi.asw.resultsdb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "results")
public class Results {

	@Id
    @GeneratedValue
    private long id;
	
	@Column(unique = true, nullable = false)//pendiente de confirmar con el otro grupo
    private String name;

    private String comment;
    
    private int votos;
    
    public Results() {} //para el mapeador
    
    public Results (String name,  String comment){
    	this.name = name;
    	this.comment = comment;
    	this.votos = 0;
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
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}
	
	public void addVote(){
		this.votos++;
	}
	
	//puede que sea problematico
	public void removeVote(){
		this.votos--;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + votos;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Results other = (Results) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (votos != other.votos)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Results [id=" + id + ", name=" + name + ", comment=" + comment + ", votos=" + votos + "]";
	}
}
