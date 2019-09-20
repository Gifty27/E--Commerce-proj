package gfy.dao;

import java.util.List;
import gfy.model.Cart;

public interface Cartdao {
	public boolean addtocart(Cart cart);
	public boolean deletecart(Cart cart);
	public boolean updatecart(Cart cart);
	public Cart getCart(int cartId);
	public List<Cart> listCartitems();

}
