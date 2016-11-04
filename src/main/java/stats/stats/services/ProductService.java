package stats.services;

import stats.domain.Product;

public interface ProductService {
	Iterable<Product> listAllProducts();
	
	Product getProductById(Integer id);
	
	Product saveProduct(Product product);
	
	void deleteProductById(Integer id);
}
