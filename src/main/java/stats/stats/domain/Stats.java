package stats.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "stats")
public class Stats implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "stats_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stats_id;
	
	@JoinColumn(name = "game_id", table = "game")
	private int game_id;
	
	@JoinColumn(name = "player_id", table = "player")
	private int player_id;
	
	@Column(name = "team")
	private int team;
	@Column(name = "sog")
	private int sog;
	@Column(name = "goals")
	private int goals;
	@Column(name = "saves")
	private int saves;
	
	
	public int getStats_id() {
		return stats_id;
	}
	public void setStats_id(int stats_id) {
		this.stats_id = stats_id;
	}
	public int getGame_id() {
		return game_id;
	}
	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}
	public int getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}
	public int getTeam() {
		return team;
	}
	public void setTeam(int team) {
		this.team = team;
	}
	public int getSog() {
		return sog;
	}
	public void setSog(int sog) {
		this.sog = sog;
	}
	public int getGoals() {
		return goals;
	}
	public void setGoals(int goals) {
		this.goals = goals;
	}
	public int getSaves() {
		return saves;
	}
	public void setSaves(int saves) {
		this.saves = saves;
	}
	

}
