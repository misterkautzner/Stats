package repositories;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.data.repository.CrudRepository;

import domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
