package stats.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import stats.domain.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer>{
	
	@Query("SELECT g FROM Game g WHERE g.season_number = ?#{[0]}")
	public ArrayList<Game> findAllSeason(Integer season_number);
	
	@Query("SELECT g FROM Game g WHERE g.season_number = ?#{[0]} AND g.game_number = ?#{[1]}")
	public Game findOneBySeasonAndGame(Integer season_number, Integer game_number);
}
