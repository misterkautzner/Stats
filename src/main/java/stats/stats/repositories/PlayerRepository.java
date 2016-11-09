package stats.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stats.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

}
