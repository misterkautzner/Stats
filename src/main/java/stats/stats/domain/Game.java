package stats.domain;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "game_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int game_id;
	
	@ManyToOne
	@JoinColumn(name="season_number")
	private Season season;

	@Column(name = "game_number")
	private int game_number;
	@Column(name = "special_name")
	private String special_name;
	@Column(name = "game_date")
	private java.sql.Date date;
	

	public int getGame_id() {
		return game_id;
	}
	
	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}
	
	
	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
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
