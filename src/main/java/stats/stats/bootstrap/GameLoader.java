//package stats.bootstrap;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//import stats.domain.Game;
//import stats.repositories.GameRepository;
//
//@Component
//public class GameLoader implements ApplicationListener<ContextRefreshedEvent> {
//
//	@Autowired
//	private GameRepository gameRepository;
//
//	private Logger log = Logger.getLogger(GameLoader.class);
//
//	
////	public void setGameRepository(GameRepository gameRepository) {
////		this.gameRepository = gameRepository;
////	}
//
//	@Override
//	public void onApplicationEvent(ContextRefreshedEvent event) {
//		Game game1 = new Game();
//		game1.setGameId(101);
//		//game1.setSeason_number(1);
//		game1.setGame_number(1);
//		game1.setSpecial_name("First Game");
//		// Format date
//		String date = "2015-01-05";
//		game1.setDate(makeDate(date));
//
//		gameRepository.save(game1);
//
//		//log.info("Saved Game - season: " + game1.getSeason_number() + ", game: " + game1.getGame_number());
//		
//		Game game2 = new Game();
//		game2.setGameId(102);
//		//game2.setSeason_number(1);
//		game2.setGame_number(2);
//		//game2.setSpecialName("");
//		// Format date
//		String date2 = "2015-01-12";
//		game2.setDate(makeDate(date2));
//
//		gameRepository.save(game2);
//
//		//log.info("Saved Game - season: " + game2.getSeason_number() + ", game: " + game2.getGame_number());
//	}
//
//	// Format the date
//	public java.sql.Date makeDate(String date) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		java.util.Date regDate = null;
//		try {
//			regDate = sdf.parse(date);
//		} catch (ParseException e) {
//			e.printStackTrace();
//			System.out.println("There's a problem with the date");
//		}
//		java.sql.Date sqlDate = new java.sql.Date(regDate.getTime());
//		return sqlDate;
//	}
//}
//
//
