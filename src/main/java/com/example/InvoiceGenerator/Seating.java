package com.example.InvoiceGenerator;


public enum Seating {

    OPEN(5000, 5, .18)
    ,CABIN(10000, 10, .18);

    private final int seatFare;
    private final int freeHours;
    private final double gst;

    Seating(int seatFare, int freeHours, double gst) {

        this.seatFare = seatFare;
        this.freeHours = freeHours;
        this.gst = gst;
    }

    public int getFreeHours()
    {
        return freeHours;
    }

    public int getFare(Seating seating,int quantity)
    {
        int amountWithoutGst = seating.seatFare*quantity;
         return amountWithoutGst;
    }

    public double getGst(Seating seating,int amount)
    {
       return (seating.gst) * amount;
    }
}
