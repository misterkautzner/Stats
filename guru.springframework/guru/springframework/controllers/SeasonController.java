package guru.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guru.springframework.domain.Season;
import guru.springframework.services.SeasonService;

@Controller
public class SeasonController {

	private SeasonService seasonService;
	
	@Autowired
    public void setSeasonService(SeasonService seasonService) {
        this.seasonService = seasonService;
    }

    @RequestMapping(value = "/seasons", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("seasons", seasonService.listAllSeasons());
        System.out.println("Returning Seasons:");
        return "seasons";
    }

    @RequestMapping("season/{season_number}")
    public String showSeason(@PathVariable Integer season_number, Model model){
        model.addAttribute("season", seasonService.getSeasonByNumber(season_number));
        return "seasonshow";
    }

    @RequestMapping("Season/edit/{season_number}")
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

        return "redirect:/season/" + season.getSeasonNumber();
    }
    


}

