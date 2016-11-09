package stats.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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
public class SeasonController {

	@Autowired
	private SeasonService seasonService;
	
	
//    public void setSeasonService(SeasonService seasonService) {
//        this.seasonService = seasonService;
//    }

    @RequestMapping(value = "/seasons", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("seasons", seasonService.listAllSeasons());
        System.out.println("Returning seasons:");
        return "seasons";
    }

//    @RequestMapping("season/{season_number}")
//    public String showSeason(@PathVariable Integer season_number, Model model){
//        model.addAttribute("season", seasonService.getSeasonById(season_number));
//        return "seasonshow";
//    }
    
    @RequestMapping("season/{season_number}")
    public String showSeason(@PathVariable Integer season_number, Model model){
    	System.out.println("");
    	System.out.println("Entering showSeason()");
    	System.out.println("");
    	Season thisSeason = seasonService.getSeasonByNumber(season_number);
    	
    	System.out.println("");
    	System.out.println("Season: " + season_number + "   : " + thisSeason.getSeason_name());
//    	Set<Game> theseGames = thisSeason.getGames();
    	//GameService gameService = GameController.getGameService();
//    	System.out.println("Past Gameservice!!!");
    	//Set<Game> games = (Set<Game>) gameService.listAllGames();
//    	System.out.println("games are set!");
//    	System.out.println("");
    	
//    	for (Game game : games) {
//    		if (game.getSeason_number() != thisSeason.getSeason_number()) {
//    			games.remove(game);
//    		}
//    	}
    	
//    	for (Game game : games) {
//    		System.out.println("||||");
//    		System.out.println("||||  Game = " + game.getSpecial_name());
//    		System.out.println("||||");
//    	}

//    	model.addAttribute("games", games);
        model.addAttribute("season", thisSeason);
        return "seasonshow";
    }
    
	

    @RequestMapping("season/edit/{season_number}")
    public String edit(@PathVariable Integer season_number, Model model){
        model.addAttribute("season", seasonService.getSeasonByNumber(season_number));
        return "seasonform";
    }

    @RequestMapping("season/new")
    public String newSeason(Model model){
        model.addAttribute("season", new Season());
        return "seasonform";
    }

    @RequestMapping(value = "season", method = RequestMethod.POST)
    public String saveSeason(Season season){

        seasonService.saveSeason(season);

        return "redirect:/season/" + season.getSeason_number();
    }

    @RequestMapping("season/delete/{season_number}")
    public String deleteSeason(@PathVariable Integer season_number, Model model){
    	seasonService.deleteSeasonByNumber(season_number);
    	model.addAttribute("seasons", seasonService.listAllSeasons());
    	return "redirect:/seasons";
    }

}

