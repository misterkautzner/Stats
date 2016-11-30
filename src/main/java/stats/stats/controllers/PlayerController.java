package stats.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import stats.domain.Player;
import stats.services.PlayerService;



@Controller
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;

    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("players", playerService.listAllPlayers());
        model.addAttribute("player", new Player());
        return "players";
    }



    @RequestMapping("player/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("player", playerService.getPlayerById(id));
        return "playerform";
    }

    @RequestMapping("player/new")
    public String newplayer(Model model){
        model.addAttribute("player", new Player());
        return "playerform";
    }

    @RequestMapping(value = "player", method = RequestMethod.POST)
    public String savePlayer(Player player, Model model){

        playerService.savePlayer(player);
        model.addAttribute("players", playerService.listAllPlayers());
        model.addAttribute("player", new Player());
        return "redirect:/players";
    }
    
    @RequestMapping("player/delete/{player_id}")
    public String deletePlayer(@PathVariable Integer player_id, Model model){
    	try {
    		playerService.deletePlayer(player_id);
    	}
    	catch (DataIntegrityViolationException e) {
    		model.addAttribute("player", playerService.getPlayerById(player_id));
    		return "playernodelete";
    	}
        model.addAttribute("players", playerService.listAllPlayers());
        return "redirect:/players";
    }

}