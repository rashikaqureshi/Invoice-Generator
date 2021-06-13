package com.example.InvoiceGenerator;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemService {


    public void processInputs(List<String> input, Map<String, Integer> quantityMap) {
        for (String s : input) {
            if (s.contains("Open")) {
                String[] s1 = s.split(" ");
                quantityMap.put("open Seats", Integer.parseInt(s1[0]));
            } else if (s.contains("Cabin")) {
                String[] s1 = s.split(" ");
                quantityMap.put("Cabin Seats", Integer.parseInt(s1[0]));
            } else if (s.contains("Conference")) {
                String[] s1 = s.split(" ");
                quantityMap.put("Conference Room", Integer.parseInt(s1[0]));
            } else if (s.contains("Meals")) {
                String[] s1 = s.split(" ");
                quantityMap.put("Meals", Integer.parseInt(s1[0]));
            }
        }
    }
}
