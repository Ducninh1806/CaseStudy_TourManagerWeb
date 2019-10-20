package com.ducninh.model;

import javax.persistence.*;

@Entity
@Table(name = "tour")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameTour;
    private int isDate;
    private Long price;
    @Lob
    private String route;

    @Lob
    private String tourPriceIncluded;

    @Lob
    private String tourPriceIsNotIncluded;

    @Lob
    private String children;

    public Tour() {
    }

    public Tour(String nameTour, int isDate, Long price, String route, String tourPriceIncluded, String tourPriceIsNotIncluded, String children) {
        this.nameTour = nameTour;
        this.isDate = isDate;
        this.price = price;
        this.route = route;
        this.tourPriceIncluded = tourPriceIncluded;
        this.tourPriceIsNotIncluded = tourPriceIsNotIncluded;
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTour() {
        return nameTour;
    }

    public void setNameTour(String nameTour) {
        this.nameTour = nameTour;
    }

    public int getIsDate() {
        return isDate;
    }

    public void setIsDate(int isDate) {
        this.isDate = isDate;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getTourPriceIncluded() {
        return tourPriceIncluded;
    }

    public void setTourPriceIncluded(String tourPriceIncluded) {
        this.tourPriceIncluded = tourPriceIncluded;
    }

    public String getTourPriceIsNotIncluded() {
        return tourPriceIsNotIncluded;
    }

    public void setTourPriceIsNotIncluded(String tourPriceIsNotIncluded) {
        this.tourPriceIsNotIncluded = tourPriceIsNotIncluded;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }
}
