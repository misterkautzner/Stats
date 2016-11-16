package stats.domain;

public class SeasonStat {
	Player player;
	int season_number;
	int total_shots;
	int total_goals;
	int total_saves;
	int max_shots;
	int max_goals;
	int max_saves;
	
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public int getSeason_number() {
		return season_number;
	}
	public void setSeason_number(int season_number) {
		this.season_number = season_number;
	}
	public int getTotal_shots() {
		return total_shots;
	}
	public void setTotal_shots(int total_shots) {
		this.total_shots = total_shots;
	}
	public int getTotal_goals() {
		return total_goals;
	}
	public void setTotal_goals(int total_goals) {
		this.total_goals = total_goals;
	}
	public int getTotal_saves() {
		return total_saves;
	}
	public void setTotal_saves(int total_saves) {
		this.total_saves = total_saves;
	}
	public int getMax_shots() {
		return max_shots;
	}
	public void setMax_shots(int max_shots) {
		this.max_shots = max_shots;
	}
	public int getMax_goals() {
		return max_goals;
	}
	public void setMax_goals(int max_goals) {
		this.max_goals = max_goals;
	}
	public int getMax_saves() {
		return max_saves;
	}
	public void setMax_saves(int max_saves) {
		this.max_saves = max_saves;
	}

	
}
