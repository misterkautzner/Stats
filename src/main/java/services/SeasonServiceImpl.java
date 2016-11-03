package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Season;
import repositories.SeasonRepository;

@Service
public class SeasonServiceImpl implements SeasonService {
	private SeasonRepository seasonRepository;
	
	@Autowired
	public void setSeasonRepository(SeasonRepository seasonRepository) {
		this.seasonRepository = seasonRepository;
	}

	@Override
	public Iterable<Season> listAllSeasons() {
		return seasonRepository.findAll();
	}

	@Override
	public Season getSeasonByNumber(Integer season_number) {
		return seasonRepository.findOne(season_number);
	}

	@Override
	public Season saveSeason(Season season) {
		return seasonRepository.save(season);
	}

	@Override
	public void deleteSeasonByNumber(Integer season_number) {
		seasonRepository.delete(seasonRepository.findOne(season_number));
	}

}
