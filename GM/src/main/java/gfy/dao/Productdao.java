package gfy.dao;

import java.util.List;

import gfy.model.Product;

public interface Productdao {
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public Product getProduct(int productId);
	public List<Product> listProducts();
	

}
