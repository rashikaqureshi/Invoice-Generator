package com.example.InvoiceGenerator;

public enum Meals {
    MEAL(100,0.12);
    private final int cost;
    private final double gst;

    Meals(int cost, double gst) {

        this.cost = cost;
        this.gst = gst;
    }

    public int getFare(Meals meals,int quantity)
    {
        int amountWithoutGst = meals.cost*quantity;
        return amountWithoutGst;
    }

    public double getGst(Meals meals,int amount)
    {
        return (meals.gst) * amount;
    }
}
