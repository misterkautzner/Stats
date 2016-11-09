package stats.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stats.domain.Season;
import stats.repositories.SeasonRepository;

@Service
public class SeasonServiceImpl implements SeasonService {
	
	@Autowired
	private SeasonRepository seasonRepository;
	
//	@Autowired
//	public void setSeasonRepository(SeasonRepository seasonRepository) {
//		this.seasonRepository = seasonRepository;
//	}

	@Override
	public Iterable<Season> listAllSeasons() {
		return seasonRepository.findAll();
	}

	@Override
	public Season getSeasonByNumber(Integer season_number) {
//		System.out.println("SeasonServiceImpl : getSeasonByNumber   = " + season_number);
//		Season season = seasonRepository.findOne(season_number);
//		System.out.println("SeasonServiceImpl : getSeasonByNumber   = " + season.getSeason_name());
		return seasonRepository.findOne(season_number);
	}

	@Override
	public Season saveSeason(Season season) {
		return seasonRepository.save(season);
	}
	
//	@Override
//	public Season saveSeason(Season season) {
//		Season temp = seasonRepository.findSeasonByNumber(season.getSeason_number());
//		if (temp == null) {
//			return seasonRepository.save(season);
//		}
//		else {
//			temp.setSeason_name(season.getSeason_name());
//			temp.setSeason_number(season.getSeason_number());
//			return seasonRepository.save(temp);
//		}
//	}
	
	// KEYS
//	@Override
//	public Season saveSeason(Season season) {
//		Season temp = seasonRepository.findSeasonByKey(season.getSeason_number(), season.getSeason_name());
//		// use setters to change values of temp when UPDATING
//		if (temp == null) {
//			seasonRepository.save(season);
//		}
//		else {
//			temp.setSeason_name(season.getSeason_name());
//			temp.setSeason_number(season.getSeason_number());
//			seasonRepository.save(temp);
//		}
//		return season;
//	}

	@Override
	public void deleteSeasonByNumber(Integer season_number) {
		seasonRepository.delete(seasonRepository.findOne(season_number));
	}



//	@Override
//	public Season getSeasonByNumber(Integer season_number) {
//		return seasonRepository.findSeasonByNumber(season_number);
//	}



}
