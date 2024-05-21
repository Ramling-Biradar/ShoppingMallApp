package com.project.entities;
import jakarta.persistence.*;
@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shopId;

    private String shopCategory;

    @ManyToOne
    @JoinColumn(name = "shopEmployeeID")
    private Employee shopEmployeeID;

    private String shopName;

    private String customers; // Assuming this is a simple string

    private String shopStatus;

    @ManyToOne
    @JoinColumn(name = "shopOwner")
    private ShopOwner shopOwner;

    private String leaseStatus;

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getShopCategory() {
		return shopCategory;
	}

	public void setShopCategory(String shopCategory) {
		this.shopCategory = shopCategory;
	}

	public Employee getShopEmployeeID() {
		return shopEmployeeID;
	}

	public void setShopEmployeeID(Employee shopEmployeeID) {
		this.shopEmployeeID = shopEmployeeID;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getCustomers() {
		return customers;
	}

	public void setCustomers(String customers) {
		this.customers = customers;
	}

	public String getShopStatus() {
		return shopStatus;
	}

	public void setShopStatus(String shopStatus) {
		this.shopStatus = shopStatus;
	}

	public ShopOwner getShopOwner() {
		return shopOwner;
	}

	public void setShopOwner(ShopOwner shopOwner) {
		this.shopOwner = shopOwner;
	}

	public String getLeaseStatus() {
		return leaseStatus;
	}

	public void setLeaseStatus(String leaseStatus) {
		this.leaseStatus = leaseStatus;
	}

	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", shopCategory=" + shopCategory + ", shopEmployeeID=" + shopEmployeeID
				+ ", shopName=" + shopName + ", customers=" + customers + ", shopStatus=" + shopStatus + ", shopOwner="
				+ shopOwner + ", leaseStatus=" + leaseStatus + ", getShopId()=" + getShopId() + ", getShopCategory()="
				+ getShopCategory() + ", getShopEmployeeID()=" + getShopEmployeeID() + ", getShopName()="
				+ getShopName() + ", getCustomers()=" + getCustomers() + ", getShopStatus()=" + getShopStatus()
				+ ", getShopOwner()=" + getShopOwner() + ", getLeaseStatus()=" + getLeaseStatus() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

   
}
