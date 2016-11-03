package stats.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stats.domain.Game;
import stats.repositories.GameRepository;

@Service
public class GameServiceImpl implements GameService{
	private GameRepository gameRepository;
	
	@Autowired
	public void setGameRepository(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	
	@Override
	public Iterable<Game> listAllGames() {
		return gameRepository.findAll();
	}

//	@Override
//	public Game getGameById(GameId gameId) {
//		return gameRepository.findOne(gameId);
//	}

	@Override
	public Game saveGame(Game game) {
		return gameRepository.save(game);
	}

	@Override
	public void deleteGame(Game game) {
		gameRepository.delete(game);
	}

	@Override
	public Iterable<Game> listBySeason(Integer season_number) {  
		// Needs to be done
	//	gameRepository.findAll().equals(obj)
	//	return gameRepository.;
		return null;
	}



//    @Autowired
//    public void setProductRepository(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    @Override
//    public Iterable<Product> listAllProducts() {
//        return productRepository.findAll();
//    }
//
//    @Override
//    public Product getProductById(Integer id) {
//        return productRepository.findOne(id);
//    }
//
//    @Override
//    public Product saveProduct(Product product) {
//        return productRepository.save(product);
//    }

//    I wrote the following code
//	@Override
//	public void deleteProduct(Integer id) {
//		productRepository.delete(productRepository.findOne(id));
//		
//	}
}