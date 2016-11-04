package stats.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Season {
	
	@Id
	private Integer season_number;
	
	private String season_name;

	
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
