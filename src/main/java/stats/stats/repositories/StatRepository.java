package stats.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import stats.domain.Stat;

@Repository
public interface StatRepository extends JpaRepository <Stat, Integer>{

	@Query("SELECT s FROM Stat s WHERE s.game.game_id = ?#{[0]}")
	public ArrayList<Stat> findAllByGameId(Integer game_id);
	
	@Query("SELECT s FROM Stat s WHERE s.player.player_id = ?#{[0]} ORDER BY"
			+ " s.game.date DESC")
	public ArrayList<Stat> findAllByPlayerId(Integer player_id);
	
}
