package domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Season {
	
	@Id
	private Integer season_number;
	
	private String season_name;

	public Integer getSeasonNumber() {
		return season_number;
	}

	public void setSeasonNumber(Integer season_number) {
		this.season_number = season_number;
	}

	public String getSeasonName() {
		return season_name;
	}

	public void setSeasonName(String season_name) {
		this.season_name = season_name;
	}
}
