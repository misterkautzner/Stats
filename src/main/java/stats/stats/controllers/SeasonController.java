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

//    @RequestMapping("season/{season_id}")
//    public String showSeason(@PathVariable Integer season_id, Model model){
//        model.addAttribute("season", seasonService.getSeasonById(season_id));
//        return "seasonshow";
//    }
    
    @RequestMapping("season/{season_id}")
    public String showSeason(@PathVariable Integer season_id, Model model){
    	Season thisSeason = seasonService.getSeasonById(season_id);
    	Set<Game> theseGames = thisSeason.getGames();
    	model.addAttribute("games", theseGames);
        model.addAttribute("season", thisSeason);
        return "seasonshow";
    }
    
	

    @RequestMapping("season/edit/{season_id}")
    public String edit(@PathVariable Integer season_id, Model model){
        model.addAttribute("season", seasonService.getSeasonById(season_id));
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

        return "redirect:/season/" + season.getSeason_id();
    }

    @RequestMapping("season/delete/{season_id}")
    public String deleteSeason(@PathVariable Integer season_id, Model model){
    	seasonService.deleteSeasonById(season_id);
    	model.addAttribute("seasons", seasonService.listAllSeasons());
    	return "redirect:/seasons";
    }

}

