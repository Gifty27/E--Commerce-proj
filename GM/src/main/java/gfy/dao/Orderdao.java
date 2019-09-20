package gfy.dao;

import gfy.model.Orderdetail;

public interface Orderdao {

	public boolean paymentProcess(Orderdetail orderdetail);
	public boolean updateCartItemStatus(String username,int orderId);

}
