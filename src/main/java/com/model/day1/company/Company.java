package com.model.day1.company;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Company {
    private String name; // nazwa firmy
    private String cityHeadquarters; // siedziba firmy
    private int employees; // ilość pracowników
    private List<Purchase> purchaseList; // lista zakupów wykonanych przez firmę (co firma kupiła)

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", cityHeadquarters='" + cityHeadquarters + '\'' +
                ", employees=" + employees +
                ", purchaseList=" + purchaseList +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityHeadquarters() {
        return cityHeadquarters;
    }

    public void setCityHeadquarters(String cityHeadquarters) {
        this.cityHeadquarters = cityHeadquarters;
    }

    public int getEmployees() {
        return employees;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }
}

