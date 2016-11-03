package stats.repositories;

import org.springframework.data.repository.CrudRepository;

import stats.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
