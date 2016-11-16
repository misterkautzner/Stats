package stats.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stats.domain.Player;
import stats.domain.SeasonStat;
import stats.domain.Stat;
import stats.repositories.StatRepository;

@Service
public class StatServiceImpl implements StatService {
	
	@Autowired
	StatRepository statRepository;

	@Override
	public ArrayList<Stat> listStatsByGame(Integer game_id) {
		return statRepository.findAllByGameId(game_id);
	}

	@Override
	public Stat getStatById(Integer stat_id) {
		return statRepository.findOne(stat_id);
	}

	@Override
	public Stat saveStat(Stat stat) {
		return statRepository.save(stat);
	}

	@Override
	public void deleteStatById(Integer stat_id) {
		statRepository.delete(stat_id);
	}

	@Override
	public ArrayList<Stat> listPlayerStats(Integer player_id) {
		return statRepository.findAllByPlayerId(player_id);
	}

	@Override
	public ArrayList<SeasonStat> listPlayerSeasonStat(Integer player_id) {
		ArrayList<Stat> stats = statRepository.findAllByPlayerId(player_id);
        
    	int maxShots = 0;
    	int maxGoals = 0;
    	int maxSaves = 0;
    	int totalShots = 0;
    	int totalGoals = 0;
    	int totalSaves = 0;
    	
    	int thisSog;
    	int thisGoals;
    	int thisSaves;
        
        SeasonStat seasonStat = new SeasonStat();
        int season_number = stats.get(0).getGame().getSeason().getSeason_number();
        int sog = 0;
        int goals = 0;
        int saves = 0;
        ArrayList<SeasonStat> seasonStats = new ArrayList<SeasonStat>();
        for (Stat stat : stats) {
        	
        	if (stat.getGame().getSeason().getSeason_number() != season_number) {	// If new Season save old
        		seasonStat.setSeason_number(season_number);							// and reset for new
        		seasonStat.setTotal_shots(sog);
        		seasonStat.setTotal_goals(goals);
        		seasonStat.setTotal_saves(saves);
        		
        		seasonStats.add(seasonStat);
        		
        		seasonStat = new SeasonStat();
        		season_number = stat.getGame().getSeason().getSeason_number();
        		sog = 0;
        		goals = 0;
        		saves = 0;
        	}
        	
        	thisSog = stat.getSog();		// Used below
        	thisGoals = stat.getGoals();
        	thisSaves = stat.getSaves();
        	
        	sog += thisSog;					// Incrementing this season's stats
        	goals += thisGoals;
        	saves += thisSaves;
        	
        	if (thisSog > maxShots)			// Setting career max stats
    		maxShots = thisSog;

        	if (thisGoals > maxGoals)
        		maxGoals = thisGoals;
    	
        	if (thisSaves > maxSaves)
        		maxSaves = thisSaves;
    	
    	totalShots += thisSog;				// Setting career totals
    	totalGoals += thisGoals;
    	totalSaves += thisSaves;
        	
        }
		seasonStat.setSeason_number(season_number);		//  Last seasonStat set here
		seasonStat.setTotal_shots(sog);
		seasonStat.setTotal_goals(goals);
		seasonStat.setTotal_saves(saves);
        
        seasonStats.add(seasonStat);
		return seasonStats;
	}

	@Override
	public SeasonStat getCareerStat(Integer player_id) {
		ArrayList<Stat> stats = statRepository.findAllByPlayerId(player_id);
        
    	int maxShots = 0;
    	int maxGoals = 0;
    	int maxSaves = 0;
    	int totalShots = 0;
    	int totalGoals = 0;
    	int totalSaves = 0;
    	
    	int thisSog;
    	int thisGoals;
    	int thisSaves;
 
        for (Stat stat : stats) {
        	
        	thisSog = stat.getSog();		// Used below
        	thisGoals = stat.getGoals();
        	thisSaves = stat.getSaves();
        	
        	if (thisSog > maxShots)			// Setting career max stats
    		maxShots = thisSog;

        	if (thisGoals > maxGoals)
        		maxGoals = thisGoals;
    	
        	if (thisSaves > maxSaves)
        		maxSaves = thisSaves;
    	
    	totalShots += thisSog;				// Setting career totals
    	totalGoals += thisGoals;
    	totalSaves += thisSaves;
        }
        
        SeasonStat careerStat = new SeasonStat();
        Player player = new Player();
        player.setPlayer_id(player_id);
        careerStat.setPlayer(player);
        
        careerStat.setMax_shots(maxShots);
        careerStat.setMax_goals(maxGoals);
        careerStat.setMax_saves(maxSaves);
        
        careerStat.setTotal_shots(totalShots);
        careerStat.setTotal_goals(totalGoals);
        careerStat.setTotal_saves(totalSaves);

		return careerStat;
	}

}
