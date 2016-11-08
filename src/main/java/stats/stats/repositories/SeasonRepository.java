package stats.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stats.domain.Season;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Integer>{
										// database object	// parameter
//	@Query("SELECT s FROM Season s WHERE s.season_number = :season_number AND s.season_name = :season_name")
//	public Season findSeasonByKey(@Param("season_number") Integer season_number, @Param("season_name") String season_name);
	
	// Query through Spring
	
//	@Query("SELECT s FROM Season s WHERE s.season_number = :season_number")
//	public Season findSeasonByNumber(@Param("season_number") Integer season_number);
}
