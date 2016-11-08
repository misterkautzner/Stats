package stats.controllers;

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
	
	@RequestMapping(value = "/games", method = RequestMethod.GET)
	public String list(Model model) {		// Get a list of all games
		model.addAttribute("games", gameService.listAllGames());	// Add them to the page ?
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

    @RequestMapping("game/new")
    public String newGame(Model model){
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
    
    
		
		// Format the date
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date regDate = null;
//		try {
//			regDate = sdf.parse(date);
//		} catch (ParseException e) {
//			e.printStackTrace();
//			System.out.println("There's a problem with the date");
//		}
//		java.sql.Date sqlDate = new java.sql.Date(regDate.getTime());
//
//		// Create a Game object
//		Game newGame = new Game(Integer.parseInt(season_number), Integer.parseInt(game_number), special_name, sqlDate);
//
//		// Do I want this line?
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		
//		// Pass most of this information to the next page
//	}
    
	
//	@RequestMapping("/")
//	public String enterGame(Map<String, Object> model) {
////		model.put("time", new Date());
//		return "EnterGame";
//	}


	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		processRequest(request, response);
//	}

}
