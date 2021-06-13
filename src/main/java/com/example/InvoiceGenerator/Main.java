package com.example.InvoiceGenerator;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        invoiceService();
    }

    private static void invoiceService() {

        System.out.println();
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Lines in input");
        int n = sc.nextInt();
        List<String> input = captureInput(n);

//        List<String> input = new ArrayList<>();
//        input.add("2 Open Seats");
//        input.add("3 Cabin Seats");
//        input.add("35 hours of Conference Room usage");
//        input.add("5 Meals");

//        List<String> input = new ArrayList<>();
//        input.add("1 Cabin Seat");
//        input.add("50 hours of Conference Room usage");
//        input.add("10 Meals");

//        List<String> input = new ArrayList<>();
//        input.add("2 Open Seats");
//        input.add("30 Meals");


        ItemService itemService = new ItemService();
        Map<String, Integer> quantityMap = new HashMap<>();
        itemService.processInputs(input,quantityMap);
        InvoiceService invoiceService = new InvoiceService();
        invoiceService.generateInvoice(quantityMap);

    }

    private static List<String> captureInput(int n) {
        Scanner sc1 = new Scanner(System.in);
        List<String> inputLines = new ArrayList();
        for(int i=0; i<n; i++) {
            inputLines.add(sc1.nextLine());
        }
        return inputLines;
    }
}
