package stats.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import stats.domain.ClubStat;
import stats.domain.Game;
import stats.domain.Player;
import stats.domain.Season;
import stats.domain.SeasonStat;
import stats.domain.Stat;
import stats.services.GameService;
import stats.services.PlayerService;
import stats.services.SeasonService;
import stats.services.StatService;

@Controller
public class StatController {

	@Autowired
	StatService statService;
	@Autowired
	SeasonService seasonService;
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

//    	int last3AvgGoals; // Have them enter the number?
//    	int last6AvgGoals;
//    	int last9avgGoals;
//    	
//    	int last3AvgSaves;
//    	int last6AvgSaves;
//    	int last9avgSaves;

        //Incorporate Wins in stats (team)
        
        //Twilo  (free text messages)
        //Twitter BootStrap (Make front end look better)
        //Mailgun (send out free emails with link to stats)
        
        //Include Contact Info on the last page of Presentation
        
        //In gmail, add signature with contact information
        
        model.addAttribute("seasonStats", seasonStats);
        model.addAttribute("careerStat", careerStat);
        model.addAttribute("stats", stats);
        model.addAttribute("player", playerService.getPlayerById(id));
        return "playershow";
    }
    
    
    @RequestMapping("/stats")
    public String clubStats(Model model) {
    	
    	ArrayList<Player> players = playerService.listAllPlayers();
    	
    	Stat maxShooter = new Stat();
    	Stat maxGoaler = new Stat();
    	Stat maxSaver = new Stat();
    	Stat totalShooter = new Stat();
    	Stat totalGoaler = new Stat();
    	Stat totalSaver = new Stat();
    	
    	for (Player player : players) {
    		SeasonStat careerStat = statService.getCareerStat(player.getPlayer_id());
    		if (careerStat.getMax_shots() > maxShooter.getSog()) {
//    			System.out.println("");
//    			System.out.println("careerStat player name = " + careerStat.getPlayer().getPlayer_name());
//    			System.out.println("");
    			maxShooter.setPlayer(player);
    			maxShooter.setSog(careerStat.getMax_shots());
    		}
    		if (careerStat.getMax_goals() > maxGoaler.getGoals()) {
    			maxGoaler.setPlayer(player);
    			maxGoaler.setGoals(careerStat.getMax_goals());
//    			System.out.println("");
//    			System.out.println("maxGoaler = " + maxGoaler.getPlayer().getPlayer_name() +
//    					"   " + maxGoaler.getGoals());
//    			System.out.println("");
    		}
    		if (careerStat.getMax_saves() > maxShooter.getSaves()) {
    			maxSaver.setPlayer(player);
    			maxSaver.setSaves(careerStat.getMax_saves());
    		}
    		if (careerStat.getTotal_shots() > totalShooter.getSog()) {
    			totalShooter.setPlayer(player);
    			totalShooter.setSog(careerStat.getTotal_shots());
    		}
    		if (careerStat.getTotal_goals() > totalGoaler.getGoals()) {
    			totalGoaler.setPlayer(player);
    			totalGoaler.setGoals(careerStat.getTotal_goals());
    		}
    		if (careerStat.getTotal_saves() > totalSaver.getSaves()) {
    			totalSaver.setPlayer(player);
    			totalSaver.setSaves(careerStat.getTotal_saves());
    		}
    	}	
//		System.out.println("");
//		System.out.println("maxShooter player name = " + maxShooter.getPlayer().getPlayer_name());
//		System.out.println("");
    	model.addAttribute("maxShooter", maxShooter);
    	model.addAttribute("maxGoaler", maxGoaler);
    	model.addAttribute("maxSaver", maxSaver);
    	model.addAttribute("totalShooter", totalShooter);
    	model.addAttribute("totalGoaler", totalGoaler);
    	model.addAttribute("totalSaver", totalSaver);
    	
    	maxShooter = new Stat();
    	maxGoaler = new Stat();
    	maxSaver = new Stat();
    	totalShooter = new Stat();
    	totalGoaler = new Stat();
    	totalSaver = new Stat();
    	ArrayList<ClubStat> clubStats = new ArrayList<ClubStat>();
    	
    	ArrayList<Season> seasons = seasonService.listAllSeasons();
    	for (Season season : seasons) {
    	
    		for (Player player : players) {
    			ArrayList<SeasonStat> seasonStats = statService.listPlayerSeasonStat(player.getPlayer_id());
            
    			for(SeasonStat seasonStat : seasonStats) {
    				if (seasonStat.getSeason_number() == season.getSeason_number()) {
    					if (seasonStat.getMax_shots() > maxShooter.getSog()) {
    						maxShooter.setPlayer(player);
    						maxShooter.setSog(seasonStat.getMax_shots());
    					}
    					if (seasonStat.getMax_goals() > maxGoaler.getGoals()) {
    						maxGoaler.setPlayer(player);
    						maxGoaler.setGoals(seasonStat.getMax_goals());
    					}
    					if (seasonStat.getMax_saves() > maxSaver.getSaves()) {
    						maxSaver.setPlayer(player);
    						maxSaver.setSaves(seasonStat.getMax_saves());
    					}
    					if (seasonStat.getTotal_shots() > totalShooter.getSog()) {
    						totalShooter.setPlayer(player);
    						totalShooter.setSog(seasonStat.getTotal_shots());
    					}
    					if (seasonStat.getTotal_goals() > totalGoaler.getGoals()) {
    						totalGoaler.setPlayer(player);
    						totalGoaler.setGoals(seasonStat.getTotal_goals());
    					}
    					if (seasonStat.getTotal_saves() > totalSaver.getSaves()) {
    						totalSaver.setPlayer(player);
    						totalSaver.setSaves(seasonStat.getTotal_saves());
    					}
    				}
    			}
    		}
    		
    		ClubStat clubStat = new ClubStat();
    		clubStat.setMaxShooter(maxShooter);
    		clubStat.setMaxGoaler(maxGoaler);
    		clubStat.setMaxSaver(maxSaver);
    		clubStat.setTotalShooter(totalShooter);
    		clubStat.setTotalGoaler(totalGoaler);
    		clubStat.setTotalSaver(totalSaver);
    		
    		clubStats.add(clubStat);
    		
        	maxShooter = new Stat();
        	maxGoaler = new Stat();
        	maxSaver = new Stat();
        	totalShooter = new Stat();
        	totalGoaler = new Stat();
        	totalSaver = new Stat();
    		
    	}
    	
    	model.addAttribute("clubStats", clubStats);
    	
    	return "stats";
    }
	
	
}
