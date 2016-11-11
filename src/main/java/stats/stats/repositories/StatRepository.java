package stats.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import stats.domain.Stat;

@Repository
public interface StatRepository extends JpaRepository <Stat, Integer>{

	@Query("SELECT s FROM Stat s WHERE s.game_id = ?#{[0]}")
	public Iterable<Stat> findAllByGameId(Integer game_id);
}
