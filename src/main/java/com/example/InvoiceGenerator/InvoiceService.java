package com.example.InvoiceGenerator;

import java.util.Map;


public class InvoiceService {

    int freeHours = 0;
    double totalGst = 0;
    int conferenceRoomCost = 200;
    int totalAmount = 0;

    public void generateInvoice(Map<String, Integer> quantityMap) {
        for (Map.Entry<String, Integer> entry : quantityMap.entrySet()) {
            if (entry.getKey().equalsIgnoreCase("Open Seats")) {
                System.out.println(entry.getValue() + " " + "Open Seats" + ": " + calculateAmount(Seating.OPEN, entry.getValue()));
            }
            if (entry.getKey().equalsIgnoreCase("Cabin Seats")) {
                System.out.println(entry.getValue() + " " + "Cabin Seats" + ": " + calculateAmount(Seating.CABIN, entry.getValue()));
            }
            if (entry.getKey().equalsIgnoreCase("Conference Room")) {
                System.out.println(entry.getValue() + " " + " hours of Conference Room usage" + ": " + calculateConferenceRoomAmount(entry.getValue()));
            }
            if (entry.getKey().equalsIgnoreCase("Meals")) {
                System.out.println(entry.getValue() + " " + "Meals" + ": " + calculateMealAmount(Meals.MEAL, entry.getValue()));
            }
        }

        System.out.println("Total : " + totalAmount);
        System.out.println("Total GST: " + totalGst);


    }


    public double calculateAmount(Seating seating, int quantity) {
        freeHours += seating.getFreeHours() * quantity;
        int amount = seating.getFare(seating, quantity);
        double gst = seating.getGst(seating, amount);
        totalGst += gst;
        double finalAmount = amount + gst;
        totalAmount += finalAmount;
        return finalAmount;

    }

    public int calculateConferenceRoomAmount(int hours) {
        if (freeHours > hours) return 0;
        else {
            int cost = (hours - freeHours) * conferenceRoomCost;
            totalAmount += cost;
            return cost;
        }
    }

    public double calculateMealAmount(Meals meal, int quantity) {
        int amount = meal.getFare(meal, quantity);
        double gst = meal.getGst(meal, amount);
        totalGst += gst;
        double finalAmount = amount + gst;
        totalAmount += finalAmount;
        return finalAmount;

    }
}
