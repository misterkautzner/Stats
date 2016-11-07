package stats.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "season")
public class Season {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer season_id;
	@Column(name = "season_number")
	private Integer season_number;
	@Column(name = "season_name")
	private String season_name;
	
//	@ManyToOne
//	@JoinColumn(name = "gameId")
//	private Set<Game> games;
	
	public Integer getSeason_id() {
		return season_id;
	}

	public void setSeason_id(Integer season_id) {
		this.season_id = season_id;
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
