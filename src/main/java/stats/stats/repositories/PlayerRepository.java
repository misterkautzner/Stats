package stats.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import stats.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

	@Query("SELECT player_name FROM Player")
	public ArrayList<String> findAllPlayerNames();
}
