package domain;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(GameId.class)
public class Game {
	
//	@Column(name="season_number")
	@Id
	private int season_number;
	
	@Id
	private int game_number;
	
	private String special_name;
	private java.sql.Date date;

	
	
	public int getSeasonNumber() {
		return season_number;
	}

	public void setSeasonNumber(int season) {
		this.season_number = season;
	}

	public int getGameNumber() {
		return game_number;
	}

	public void setGameNumber(int game_number) {
		this.game_number = game_number;
	}

	public String getSpecialName() {
		return special_name;
	}

	public void setSpecialName(String special_name) {
		this.special_name = special_name;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

}
