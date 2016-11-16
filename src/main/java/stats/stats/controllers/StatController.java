package stats.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import stats.domain.Game;
import stats.domain.Player;
import stats.domain.SeasonStat;
import stats.domain.Stat;
import stats.services.GameService;
import stats.services.PlayerService;
import stats.services.StatService;

@Controller
public class StatController {

	@Autowired
	StatService statService;
	@Autowired
	GameService gameService;
	@Autowired
	PlayerService playerService;
	
	@RequestMapping("/season/{season_number}/game/{game_id}/stat/new")
	public String newStat(@PathVariable("season_number") Integer season_number, @PathVariable("game_id")
	Integer game_id, Model model) {
		List<Player> players = playerService.listAllPlayers();
		Stat newStat = new Stat();
		Game newGame = new Game();
		newGame.setGame_id(game_id);
		newStat.setGame(newGame);
		model.addAttribute("players", players);
		model.addAttribute("stat", newStat);
		return "statform";
	}
	
	@RequestMapping("/season/{season_number}/game/{game_id}/stat/{stat_id}/edit")
	public String editStat(@PathVariable Integer stat_id, Model model) {
		List<Player> players = playerService.listAllPlayers();
		model.addAttribute("players", players);
		model.addAttribute("stat", statService.getStatById(stat_id));
		return "statform";
	}
	
    @RequestMapping(value = "stat", method = RequestMethod.POST)
    public String saveStat(Stat stat){
    	statService.saveStat(stat);
    	Game game = gameService.getGameById(stat.getGame().getGame_id());
        return "redirect:/season/" + game.getSeason().getSeason_number() + "/game/" + game.getGame_id();
    }
    
    
	@RequestMapping("/season/{season_number}/game/{game_id}")
	public String showGame(@PathVariable Integer season_number, @PathVariable Integer game_id, Model model) {
		ArrayList<Stat> gameStats = (ArrayList<Stat>) statService.listStatsByGame(game_id);
		List<Player> players = playerService.listAllPlayers();
		Stat newStat = new Stat();
		Game newGame = new Game();
		newGame.setGame_id(game_id);
		newStat.setGame(newGame);
		model.addAttribute("stat", newStat);
		model.addAttribute("players", players);
		model.addAttribute("game", gameService.getGameById(game_id));
		model.addAttribute("stats", gameStats);
		return "gameshow";
	}
	
	
	@RequestMapping("/season/{season_number}/game/{game_id}/stat/{stat_id}/delete")
	public String deleteStat(@PathVariable Integer season_number, @PathVariable Integer game_id, @PathVariable Integer stat_id, Model model) {
		statService.deleteStatById(stat_id);
		model.addAttribute("stats", statService.listStatsByGame(game_id));
		return "redirect:/season/" + season_number + "/game/" + game_id;
	}
	
    @RequestMapping("player/{id}")
    public String showplayer(@PathVariable Integer id, Model model){
        List<Stat> stats = statService.listPlayerStats(id);
        ArrayList<SeasonStat> seasonStats = statService.listPlayerSeasonStat(id);
        SeasonStat careerStat = statService.getCareerStat(id);
//    	int maxShots = 0;
//    	int maxGoals = 0;
//    	int maxSaves = 0;
//        for (SeasonStat seasonStat : seasonStats) {
//        	
//        	if (seasonStat.getMaxShots() > maxShots)			// Setting career max stats
//    		maxShots = seasonStat.getMaxShots();
//
//        	if (seasonStat.getMaxGoals() > maxGoals)
//        		maxGoals = seasonStat.getMaxGoals();
//    	
//        	if (seasonStat.getMaxSaves() > maxSaves)
//        		maxSaves = seasonStat.getMaxSaves();
//        }
        
        
//    	int maxShots = 0;
//    	int maxGoals = 0;
//    	int maxSaves = 0;
//    	int totalShots = 0;
//    	int totalGoals = 0;
//    	int totalSaves = 0;
//    	
//    	int thisSog;
//    	int thisGoals;
//    	int thisSaves;
//        
//        SeasonStat seasonStat = new SeasonStat();
//        int season_number = stats.get(0).getGame().getSeason().getSeason_number();
//        int sog = 0;
//        int goals = 0;
//        int saves = 0;
//        List<SeasonStat> seasonStats = new ArrayList<SeasonStat>();
//        for (Stat stat : stats) {
//        	
//        	if (stat.getGame().getSeason().getSeason_number() != season_number) {	// If new Season save old
//        		seasonStat.setSeason_number(season_number);							// and reset for new
//        		seasonStat.setTotalShots(sog);
//        		seasonStat.setTotalGoals(goals);
//        		seasonStat.setTotalSaves(saves);
//        		
//        		seasonStats.add(seasonStat);
//        		
//        		seasonStat = new SeasonStat();
//        		season_number = stat.getGame().getSeason().getSeason_number();
//        		sog = 0;
//        		goals = 0;
//        		saves = 0;
//        	}
//        	
//        	thisSog = stat.getSog();		// Used below
//        	thisGoals = stat.getGoals();
//        	thisSaves = stat.getSaves();
//        	
//        	sog += thisSog;					// Incrementing this season's stats
//        	goals += thisGoals;
//        	saves += thisSaves;
//        	
//        	if (thisSog > maxShots)			// Setting career max stats
//    		maxShots = thisSog;
//
//        	if (thisGoals > maxGoals)
//        		maxGoals = thisGoals;
//    	
//        	if (thisSaves > maxSaves)
//        		maxSaves = thisSaves;
//    	
//    	totalShots += thisSog;				// Setting career totals
//    	totalGoals += thisGoals;
//    	totalSaves += thisSaves;
//        	
//        }
//		seasonStat.setSeason_number(season_number);		//  Last seasonStat set here
//		seasonStat.setTotalShots(sog);
//		seasonStat.setTotalGoals(goals);
//		seasonStat.setTotalSaves(saves);
//        
//        seasonStats.add(seasonStat);
        
//        for (SeasonStat tSS : seasonStats) {
//          System.out.println("");
//          System.out.println("season number = " + tSS.getSeason_number());
//          System.out.println("total shots = " + tSS.getTotalShots());
//          System.out.println("total goals = " + tSS.getTotalGoals());
//          System.out.println("total saves = " + tSS.getTotalSaves());
//          System.out.println("");}
        
//    	int last3AvgGoals; // Have them enter the number?
//    	int last6AvgGoals;
//    	int last9avgGoals;
//    	
//    	int last3AvgSaves;
//    	int last6AvgSaves;
//    	int last9avgSaves;
        
        //Generic Stats Page
        //Highest of each stats per season (with player name)
        //Club records
        //Incorporate Wins in stats (team)
        
        //Twilo  (free text messages)
        //Twitter BootStrap (Make front end look better)
        //Mailgun (send out free emails with link to stats)
        //Include Contact Info on the last page
        
        //In gmail, add signature with contact information
        model.addAttribute("seasonStats", seasonStats);
        model.addAttribute("careerStat", careerStat);
//    	model.addAttribute("max_shots", maxShots);
//        model.addAttribute("max_goals", maxGoals);
//        model.addAttribute("max_saves", maxSaves);
//        model.addAttribute("total_shots", totalShots);
//        model.addAttribute("total_goals", totalGoals);
//        model.addAttribute("total_saves", totalSaves);
        model.addAttribute("stats", stats);
        model.addAttribute("player", playerService.getPlayerById(id));
        return "playershow";
    }
	
	
}
