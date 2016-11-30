package stats.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stats.domain.Season;
import stats.repositories.SeasonRepository;

@Service
public class SeasonServiceImpl implements SeasonService {
	
	@Autowired
	private SeasonRepository seasonRepository;

	@Override
	public ArrayList<Season> listAllSeasons() {
		return seasonRepository.findAllSeasonsDesc();//findAll();
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
