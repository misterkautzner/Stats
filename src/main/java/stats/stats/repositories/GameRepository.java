package stats.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stats.domain.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer>{
	
//	public findOne(Integer season_number, Integer game_number) {
//		
//	}

}
