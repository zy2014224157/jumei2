package model;

public class Cart {
    private int cartid;
    private int userid;
    private int quantity;
    private int meizhuangid;
    private int orderid;
    public int getMeizhuangid() {
		return meizhuangid;
	}
	public void setMeizhuangid(int meizhuangid) {
		this.meizhuangid = meizhuangid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	private Goods goods;

	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getmeizhuangid() {
		return meizhuangid;
	}
	public void setmeizhuangid(int meizhuangid) {
		this.meizhuangid = meizhuangid;
	}
    
    
    
}
