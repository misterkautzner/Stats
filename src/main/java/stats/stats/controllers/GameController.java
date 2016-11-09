package stats.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import stats.domain.Game;
import stats.services.GameService;

@Controller
public class GameController {

	@Autowired
	private GameService gameService;
	
	
//	public void setGameService(GameService gameService) {
//		this.gameService = gameService;
//	}
	
	public GameService getGameService() {
		return gameService;
	}
				  //value was "games"
	@RequestMapping(value = "season/{season_number}", method = RequestMethod.GET)
	public String list(@PathVariable Integer season_number, Model model) {		// Get a list of all games
		ArrayList<Game> seasonGames = (ArrayList<Game>) gameService.listAllGames();
		for (Game game : seasonGames) {
			
			System.out.println("");
			System.out.println("game.getSeason_number() = " + game.getSeason_number() + "   vs " + season_number);
			System.out.println("");
			
			if (game.getSeason_number() != season_number) {
				seasonGames.remove(game);
			}
		}
		model.addAttribute("games", seasonGames);	// Add them to the page ?
		System.out.println("Returning games:");
		return "games";		// Reload the page?
	}
	
	@RequestMapping("game/{game_id}")
	public String showGame(@PathVariable Integer game_id, Model model) {
		System.out.println("");
		System.out.println("");
		System.out.println("GameId = " + game_id);
		System.out.println("");
		System.out.println("");
		model.addAttribute("game", gameService.getGameById(game_id));
		return "gameshow";
	}
	
    @RequestMapping("game/edit/{game_id}")
    public String edit(@PathVariable Integer game_id, Model model){
        model.addAttribute("game", gameService.getGameById(game_id));
        return "gameform";
    }

    @RequestMapping("/game/new")
    public String newGame(Model model){
    	System.out.println("");
    	//System.out.println("SEASON ID = " + season_number);
    	System.out.println("");
    	// ?? model.addAttribute(season, seasonService(season_number));
        model.addAttribute("game", new Game());	// Give a new (blank) game object to the form
        return "gameform";
    }

    @RequestMapping(value = "game", method = RequestMethod.POST)
    public String saveGame(Game game){
    	gameService.saveGame(game);

        return "redirect:/game/" + game.getGame_id();
    }
    
    @RequestMapping("game/delete/{game_id}")
    public String deleteGame(@PathVariable Integer game_id, Model model){
    	gameService.deleteGameById(game_id);
    	model.addAttribute("games", gameService.listAllGames());
    	return "redirect:/games";
    }
    

}
