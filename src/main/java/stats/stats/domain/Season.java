package stats.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "season")
public class Season implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "season_number")
	private Integer season_number;
	@Column(name = "season_name")
	private String season_name;
	
	@OneToMany
	private Set<Game> games;
	
	
	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}
	
	public Integer getSeason_number() {
		return season_number;
	}

	public void setSeason_number(Integer season_number) {
		this.season_number = season_number;
	}

	public String getSeason_name() {
		return season_name;
	}

	public void setSeason_name(String season_name) {
		this.season_name = season_name;
	}
}
