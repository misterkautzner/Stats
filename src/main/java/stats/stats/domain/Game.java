package stats.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game {
	
	@Id
	@Column(name = "game_id")
	private int gameId;

	@ManyToOne
	@JoinColumn(name = "season_id")
	private Season season;
//	private int season_number;
	@Column(name = "game_number")
	private int game_number;
	@Column(name = "special_name")
	private String special_name;
	@Column(name = "game_date")
	private java.sql.Date date;
	
//	public void calculateGameId() {
//		gameId = season_number*100+game_number;
//		//season.getSeason_number()
//	}
	
//	public void breakDownGameId() {
//		season_number = gameId/100;
//		game_number = gameId%100;
//	}
//	@ManyToOne
//	@JoinColumn(name = "season_number")
//	public Season getSeason() {
//		return season;
//	}
	
	public void setSeason(Season season) {
		this.season = season;
	}

	public int getGameId() {
		return gameId;
	}
	
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	
	
//	public int getSeason_number() {
//		return season_number;
//	}

//	public void setSeason_number(int season) {
//		this.season_number = season;
//	}

	public int getGame_number() {
		return game_number;
	}

	public Season getSeason() {
		return season;
	}

	public void setGame_number(int game_number) {
		this.game_number = game_number;
	}

	public String getSpecial_name() {
		return special_name;
	}

	public void setSpecial_name(String special_name) {
		this.special_name = special_name;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

}
