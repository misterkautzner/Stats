package stats.controllers;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import stats.domain.Game;
import stats.domain.Player;
import stats.domain.Season;
import stats.domain.Stat;
import stats.repositories.GameRepository;
import stats.repositories.PlayerRepository;
import stats.repositories.SeasonRepository;
import stats.repositories.StatRepository;

@Component	// Loads dummy data for people who want to try out the app.
public class DataLoader implements ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	private SeasonRepository seasonRepository;
	@Autowired
	private GameRepository gameRepository;
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private StatRepository statRepository;
	
	private Logger log = Logger.getLogger(DataLoader.class);
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Season season1 = new Season();
		season1.setSeason_number(1);
		season1.setSeason_name("Winter 2015");
        seasonRepository.save(season1);
        
        log.info("Saved Season 1");

        
		Season season2 = new Season();
		season2.setSeason_number(2);
		season2.setSeason_name("Spring 2016");
        seasonRepository.save(season2);
        
        log.info("Saved Season 2");
        
        
		Season season3 = new Season();
		season3.setSeason_number(3);
		season3.setSeason_name("Summer 2016");
        seasonRepository.save(season3);
        
        log.info("Saved Season 3");
        
        ///////////////////////////////////////////////////////////////////
        ArrayList<Season> seasons = new ArrayList<Season>();
        seasons.add(season1);
        seasons.add(season2);
        seasons.add(season3);
        
        ArrayList<Game> games = new ArrayList<Game>(); // Used when entering stats
        
        int gameId = 1;
        for (Season season : seasons) {
        	
        	for (int g = 1; g < 4; g++) {
        		Game game = new Game();
        		game.setGame_id(gameId);
        		game.setSeason(season);
        		game.setGame_number(g);
        		
        		if (season == season1 && g == 1) {
        			game.setSpecial_name("First Game Ever!");
        		}
        		else if (season == season2 && g == 2) {
        			game.setSpecial_name("Spring Cleaner");
        		}
        		else if (season == season3 && g == 3) {
        			game.setSpecial_name("The Game Dustin Broke His Arm");
        		}
        		else {
        			game.setSpecial_name("Game " + g);
        		}
        		
        		String sDate;
        		if (season == season1) {
        			sDate = "2015-12-";
        		}
        		else {
        			sDate = "2016-0" + (season.getSeason_number() + 2) + "-";
        		}
        		sDate += g*4+6;
        		
        		java.sql.Date date = java.sql.Date.valueOf(sDate);
        		game.setDate(date);

        		gameRepository.save(game);
        		games.add(game);
        		
        		gameId++;
        		/////////////////////////////////////////////////////////
        		ArrayList<Player> players = new ArrayList<Player>();
        		
        		Player john = new Player();
        		john.setPlayer_id(1);
        		john.setPlayer_name("John K");
        		john.setPhone_number("314-808-5302");
        		
        		playerRepository.save(john);
        		players.add(john);
        		
        		Player robert = new Player();
        		robert.setPlayer_id(2);
        		robert.setPlayer_name("Robert G");
        		robert.setPhone_number("555-555-5555");
        		
        		playerRepository.save(robert);
        		players.add(robert);
        		
        		Player lamar = new Player();
        		lamar.setPlayer_id(3);
        		lamar.setPlayer_name("Lamar");
        		lamar.setPhone_number("789-987-8790");
        		
        		playerRepository.save(lamar);
        		players.add(lamar);
        		
        		Player tony = new Player();
        		tony.setPlayer_id(4);
        		tony.setPlayer_name("Tony");
        		tony.setPhone_number("789-789-7897");
        		
        		playerRepository.save(tony);
        		players.add(tony);
        		
        		Player santosh = new Player();
        		santosh.setPlayer_id(5);
        		santosh.setPlayer_name("Santosh");
        		santosh.setPhone_number("456-654-4560");
        		
        		playerRepository.save(santosh);
        		players.add(santosh);
        		
        		Player vinod = new Player();
        		vinod.setPlayer_id(6);
        		vinod.setPlayer_name("vinodinod");
        		vinod.setPhone_number("123-321-1230");
        		
        		playerRepository.save(vinod);
        		players.add(vinod);
        		
        		Player kathy = new Player();
        		kathy.setPlayer_id(7);
        		kathy.setPlayer_name("Kathy");
        		kathy.setPhone_number("777-777-7777");
        		
        		playerRepository.save(kathy);
        		players.add(kathy);
        		
        		Player ola = new Player();
        		ola.setPlayer_id(8);
        		ola.setPlayer_name("Ola");
        		ola.setPhone_number("555-555-5757");
        		
        		playerRepository.save(ola);
        		players.add(ola);
        		////////////////////////////////////////////////////////
        		
        		int stat_id = 1;
        		for (Game thisGame : games) {
        			for (Player player : players) {
        				Stat stat = new Stat();
        				stat.setStat_id(stat_id);
        				stat_id++;
        				
        				stat.setGame(thisGame);
        				stat.setPlayer(player);
        				stat.setTeam((thisGame.getSeason().getSeason_number() +
        						thisGame.getGame_number() + stat_id)%2 + 1);
        				stat.setSog((int) (Math.random()*Math.random()*25));
        				stat.setGoals((int) (Math.random()*Math.random()*10));
        				stat.setSaves((int) (Math.random()*Math.random()*25));
        				
        				statRepository.save(stat);
        			}
        		}
        		
        	}
        }

}
	
}