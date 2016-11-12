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
@Table(name = "game")
public class Game implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "game_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int game_id;
	
	@JoinColumn(name="season_number", table = "season")
	private int season_number;

	@Column(name = "game_number")
	private int game_number;
	@Column(name = "special_name")
	private String special_name;
	@Column(name = "game_date")
	private java.sql.Date date;
	
//	@OneToMany
//	private Set<Stat> stats;
	
	
//	public int getSeason_id() {
//		return season_id;
//	}
//	
//	public void setSeason_id(int s_id) {
//		season_id = s_id;
//	}
	
//	public void setSeason_id(int s_id) {
//		System.out.println("");
//		System.out.println("Set season_id from Game.  Problems??");
//		System.out.println("");
//		season.setSeason_id(s_id);
//	}
	
//	public void calculateGameId() {
//		gameId = season_number*10000+game_number;
////		season.getSeason_number()
//	}
//	
//	public void breakDownGameId() {
//		season_number = gameId/10000;
//		game_number = gameId%10000;
//	}
//	@ManyToOne
//	@JoinColumn(name = "season_number")
	
//	public Season getSeason() {
//		return season;
//	}
	
//	public void setSeason(Season season) {
//		this.season = season;
//	}

	public int getGame_id() {
		return game_id;
	}
	
	public void setGame_id(int game_id) {
		this.game_id = game_id;
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

//	public Season getSeason() {
//		return season;
//	}

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
