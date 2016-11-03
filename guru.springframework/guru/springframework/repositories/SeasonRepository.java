package guru.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.Season;

public interface SeasonRepository extends CrudRepository<Season, Integer>{

}
