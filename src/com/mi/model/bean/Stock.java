package com.mi.model.bean;

public class Stock {
	
	
	private int stockId;
	private int productId;
	private int totalStock;
	private int allocatableStock;
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getTotalStock() {
		return totalStock;
	}
	public void setTotalStock(int totalStock) {
		this.totalStock = totalStock;
	}
	public int getAllocatableStock() {
		return allocatableStock;
	}
	public void setAllocatableStock(int allocatableStock) {
		this.allocatableStock = allocatableStock;
	}


	
}
