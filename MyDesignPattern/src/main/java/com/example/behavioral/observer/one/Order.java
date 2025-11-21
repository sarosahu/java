package com.example.behavioral.observer.one;

import java.util.ArrayList;
import java.util.List;

// Concrete subject (observable)
public class Order {
    private String id;
    private double itemCost;
    private int count;
    private List<OrderObserver> observers = new ArrayList<>();
    private double discount;
    private double shippingCost;

    public Order(String id) {
        this.id = id;
    }

    public void attach(OrderObserver observer) {
        this.observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        this.observers.remove(observer);
    }

    public double getTotal() {
        return this.itemCost - this.discount + this.shippingCost;
    }

    public void addItem(double price) {
        this.itemCost += price;
        ++count;
        observers.forEach(o -> o.updated(this));
    }

    public int getCount() {
        return this.count;
    }

    public double getItemCost() {
        return this.itemCost;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", itemCost=" + itemCost +
                ", count=" + count +
                ", observers=" + observers +
                ", discount=" + discount +
                ", shippingCost=" + shippingCost +
                '}';
    }
}
