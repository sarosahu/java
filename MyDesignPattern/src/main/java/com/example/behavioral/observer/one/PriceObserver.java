package com.example.behavioral.observer.one;

public class PriceObserver implements OrderObserver {
    @Override
    public void updated(Order order) {
        double total = order.getItemCost();
        if (total >= 500) {
            // Discount
            order.setDiscount(20);
        } else if (total >= 200) {
            // Discount
            order.setDiscount(10);
        }
    }
}
