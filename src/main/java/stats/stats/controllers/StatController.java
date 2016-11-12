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
		//ArrayList<String> playerNames = playerService.listAllPlayerNames();
		List<Player> players = playerService.listAllPlayers();
//		Map<Integer, String> playerMap = new HashMap<Integer, String>();
//		
//		for(Player player : players) {
//			playerMap.put(player.getPlayer_id(), player.getPlayer_name());
//		}
		
		Stat newStat = new Stat();
		newStat.setGame_id(game_id);
		
//		System.out.println("");
//		for(Integer i : playerMap.keySet()) {
//			System.out.println("(" + i + ", " + playerMap.get(i) + ")");
//		}
//		System.out.println("");
		
		model.addAttribute("players", players);
		model.addAttribute("stat", newStat);
		return "statform";
	}
	
    @RequestMapping(value = "stat", method = RequestMethod.POST)
    public String saveStat(Stat stat){
    	System.out.println("stat = " + stat);
    	statService.saveStat(stat);
    	Game game = gameService.getGameById(stat.getGame_id());
        return "redirect:/season/" + game.getSeason_number() + "/game/" + game.getGame_id();
    }
    
    
	@RequestMapping("/season/{season_number}/game/{game_id}")
	public String showGame(@PathVariable Integer season_number, @PathVariable Integer game_id, Model model) {
		ArrayList<Stat> gameStats = (ArrayList<Stat>) statService.listStatsByGame(game_id);
		model.addAttribute("game", gameService.getGameById(game_id));
		model.addAttribute("stats", gameStats);
		return "gameshow";
	}
	
	
	@RequestMapping("/season/{season_number}/game/{game_id}/stat/{stat_id}/edit")
	public String editStat(@PathVariable Integer stat_id, Model model) {
		model.addAttribute("stat", statService.getStatById(stat_id));
		return "statform";
	}
	
	
	@RequestMapping("/season/{season_number}/game/{game_id}/stat/{stat_id}/delete")
	public String deleteStat(@PathVariable Integer season_number, @PathVariable Integer game_id, @PathVariable Integer stat_id, Model model) {
		statService.deleteStatById(stat_id);
		model.addAttribute("stats", statService.listStatsByGame(game_id));
		return "redirect:/season/" + season_number + "/game/" + game_id;
	}
	
	
}
