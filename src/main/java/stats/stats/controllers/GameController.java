package stats.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import stats.domain.Game;
import stats.services.GameService;

@Controller
public class GameController {

	private GameService gameService;
	
	@Autowired
	public void setGameService(GameService gameService) {
		this.gameService = gameService;
	}
	
	@RequestMapping(value = "/games", method = RequestMethod.GET)
	public String list(Model model) {		// Get a list of all games
		model.addAttribute("games", gameService.listAllGames());	// Add them to the page ?
		System.out.println("Returning games:");
		return "games";		// Reload the page?
	}
	
//	@RequestMapping("game/{season_number}/{game_number}")
//	public String showGame(@PathVariable Integer season_number, @PathVariable Integer game_number, Model model) {
//		model.addAttribute("game", gameService.getGameById(season_number, game_number));
//		return "gameshow";
//	}
	
//    @RequestMapping("game/edit/{season_number}/{game_number}")
//    public String edit(@PathVariable Integer season_number, Integer game_number, Model model){
//        model.addAttribute("product", gameService.getGameById(season_number, game_number));
//        return "gameform";
//    }

    @RequestMapping("game/new")
    public String newGame(Model model){
        model.addAttribute("game", new Game());	// Give a new (blank) game object to the form
        return "gameform";
    }

    @RequestMapping(value = "game", method = RequestMethod.POST)
    public String saveGame(Game game){

    	gameService.saveGame(game);

        return "redirect:/game/" + game.getSeasonNumber() + "/" + game.getGameNumber();
    }
    
//    @RequestMapping("game/delete/{...........}")
//    public String deleteGame(@PathVariable Integer ............, Model model){
//    	gameService.deleteSeasonByNumber(............);
//    	model.addAttribute("games", gameService.listAllGames());
//    	return "redirect:/games";
//    }
    
    
		
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
