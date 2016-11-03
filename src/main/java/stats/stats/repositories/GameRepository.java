package stats.repositories;

import org.springframework.data.repository.CrudRepository;

import stats.domain.Game;

public interface GameRepository extends CrudRepository<Game, Integer>{
	
//	public findOne(Integer season_number, Integer game_number) {
//		
//	}

}
