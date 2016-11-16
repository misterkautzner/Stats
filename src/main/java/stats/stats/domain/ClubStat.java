package stats.domain;

public class ClubStat {
	Season season;
	Stat maxShooter;
	Stat maxGoaler;
	Stat maxSaver;
	Stat totalShooter;
	Stat totalGoaler;
	Stat totalSaver;


	public Season getSeason() {
		return season;
	}
	public void setSeason(Season season) {
		this.season = season;
	}
	public Stat getMaxShooter() {
		return maxShooter;
	}
	public void setMaxShooter(Stat maxShooter) {
		this.maxShooter = maxShooter;
	}
	public Stat getMaxGoaler() {
		return maxGoaler;
	}
	public void setMaxGoaler(Stat maxGoaler) {
		this.maxGoaler = maxGoaler;
	}
	public Stat getMaxSaver() {
		return maxSaver;
	}
	public void setMaxSaver(Stat maxSaver) {
		this.maxSaver = maxSaver;
	}
	public Stat getTotalShooter() {
		return totalShooter;
	}
	public void setTotalShooter(Stat totalShooter) {
		this.totalShooter = totalShooter;
	}
	public Stat getTotalGoaler() {
		return totalGoaler;
	}
	public void setTotalGoaler(Stat totalGoaler) {
		this.totalGoaler = totalGoaler;
	}
	public Stat getTotalSaver() {
		return totalSaver;
	}
	public void setTotalSaver(Stat totalSaver) {
		this.totalSaver = totalSaver;
	}

	
}
