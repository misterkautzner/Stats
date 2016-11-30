package stats.controllers;

import java.util.ArrayList;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import stats.domain.Game;
import stats.domain.Season;
import stats.services.GameService;
import stats.services.SeasonService;

@Controller
public class GameController {

	@Autowired
	private GameService gameService;
	@Autowired
	private SeasonService seasonService;
	
	public GameService getGameService() {
		return gameService;
	}
				
	@RequestMapping(value = "season/{season_number}", method = RequestMethod.GET)
	public String list(@PathVariable Integer season_number, Model model) {		// Get a list of all games
		ArrayList<Game> seasonGames = gameService.listBySeason(season_number);
		Season season = seasonService.getSeasonByNumber(season_number);
		Game newGame = new Game();
    	newGame.setSeason(season);
        model.addAttribute("game", newGame);
		model.addAttribute("season", season);
		model.addAttribute("games", seasonGames);
		return "seasonshow";
	}	
	
	

	
    @RequestMapping("season/{season_number}/game/{game_id}/edit")
    public String edit(@PathVariable Integer season_number, @PathVariable Integer game_id, Model model){
        model.addAttribute("game", gameService.getGameById(game_id));
        return "gameform";
    }

    @RequestMapping("season/{season_number}/game/new")
    public String newGame(@PathVariable Integer season_number, Model model){
    	Game newGame = new Game();
    	Season newSeason = new Season();
    	newSeason.setSeason_number(season_number);
    	newGame.setSeason(newSeason);
        model.addAttribute("game", newGame);	// Give a new (blank) game object to the form
        return "gameform";
    }

    @RequestMapping(value = "game", method = RequestMethod.POST)
    public String saveGame(Game game){

    	gameService.saveGame(game);
    	Season season = seasonService.getSeasonByNumber(game.getSeason().getSeason_number());
        return "redirect:/season/" + game.getSeason().getSeason_number();
    }
    
    @RequestMapping("season/{season_number}/game/{game_id}/delete")
    public String deleteGame(@PathVariable Integer game_id, Model model){
    	Game game = gameService.getGameById(game_id);
    	try {
    	gameService.deleteGameById(game_id);
    	}
    	catch (DataIntegrityViolationException e) {
    		model.addAttribute("game", game);
    		return "/gamenodelete";
    	}
    	model.addAttribute("games", gameService.listBySeason(game.getSeason().getSeason_number()));
    	return "redirect:/season/" + game.getSeason().getSeason_number();
    }
    

}
