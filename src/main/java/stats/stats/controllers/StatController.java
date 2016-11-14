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
        
//        for(Stat stat : stats) {
//        	System.out.println("");
//        	System.out.println("Season number = " + stat.getGame().getSeason().getSeason_number());
//        	System.out.println("Game number = " + stat.getGame().getGame_number());
//        	System.out.println("");
//        }
        		
        model.addAttribute("stats", stats);
        model.addAttribute("player", playerService.getPlayerById(id));
        return "playershow";
    }
	
	
}
