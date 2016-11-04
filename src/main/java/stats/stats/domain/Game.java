package stats.domain;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@IdClass(GameId.class)
public class Game {
	
	@Id
	private int gameId;

	private int season_number;
	private int game_number;
	private String special_name;
	private java.sql.Date date;
	
	public void calculateGameId() {
		gameId = season_number*100+game_number;
	}
	
	public void breakDownGameId() {
		season_number = gameId/100;
		game_number = gameId%100;
	}

	public int getGameId() {
		return gameId;
	}
	
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	
	
	public int getSeason_number() {
		return season_number;
	}

	public void setSeason_number(int season) {
		this.season_number = season;
	}

	public int getGame_number() {
		return game_number;
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
