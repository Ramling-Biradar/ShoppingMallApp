package com.project.entities;

import jakarta.persistence.*;

@Entity
public class Mall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mallName;
    private String location;
    private String categories;

    @OneToOne(mappedBy = "mall", cascade = CascadeType.ALL)
    private MallAdmin mallAdmin;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public MallAdmin getMallAdmin() {
        return mallAdmin;
    }

    public void setMallAdmin(MallAdmin mallAdmin) {
        this.mallAdmin = mallAdmin;
        mallAdmin.setMall(this);
    }

	@Override
	public String toString() {
		return "Mall [id=" + id + ", mallName=" + mallName + ", location=" + location + ", categories=" + categories
				+ ", mallAdmin=" + mallAdmin + ", getId()=" + getId() + ", getMallName()=" + getMallName()
				+ ", getLocation()=" + getLocation() + ", getCategories()=" + getCategories() + ", getMallAdmin()="
				+ getMallAdmin() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
    
    
}

