package stats.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

//    public void setplayerService(PlayerService playerService) {
//        this.playerService = playerService;
//    }

    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("players", playerService.listAllPlayers());
        System.out.println("Returning players:");
        return "players";
    }

    @RequestMapping("player/{id}")
    public String showplayer(@PathVariable Integer id, Model model){
        model.addAttribute("player", playerService.getPlayerById(id));
        return "playershow";
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
    public String savePlayer(Player player){

        playerService.savePlayer(player);

        return "redirect:/player/" + player.getPlayer_id();
    }
    
    @RequestMapping("player/delete/{player_id}")
    public String deletePlayer(@PathVariable Integer player_id, Model model){
    	playerService.deletePlayer(player_id);
        model.addAttribute("players", playerService.listAllPlayers());
        return "redirect:/players";
    }

}