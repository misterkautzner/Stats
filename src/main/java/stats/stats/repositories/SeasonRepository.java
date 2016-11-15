package stats.repositories;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import stats.domain.Season;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Integer>{
	
	@Query("SELECT s FROM Season s ORDER BY s.season_number DESC")
	public ArrayList<Season> findAllSeasonsDesc();
	
										// database object	// parameter
//	@Query("SELECT s FROM Season s WHERE s.season_number = :season_number AND s.season_name = :season_name")
//	public Season findSeasonByKey(@Param("season_number") Integer season_number, @Param("season_name") String season_name);
	
	
	
//	@Query("SELECT s FROM Season s WHERE s.season_number = :season_number")
//	public Season findSeasonByNumber(@Param("season_number") Integer season_number);
}
