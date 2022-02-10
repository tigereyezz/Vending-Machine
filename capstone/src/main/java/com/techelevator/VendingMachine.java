package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        System.out.println(vm.createItems());
    }
static
    Map<String, Item> inventoryMap = new HashMap<>();
    Scanner scan = new Scanner(System.in);

    public String createItems() {

        try (Scanner inputFile = new Scanner(new File("vendingmachine.csv"))) {
            
            while (inputFile.hasNextLine()) {
                String line = inputFile.nextLine();
                String[] characteristics = line.split("|");
                String slot = characteristics[0];
                String name = characteristics[1];
                BigDecimal price = new BigDecimal(characteristics[2]);
                String item = characteristics[3];



                if (item.equals("Chip")) {
                    Chip chip = new Chip(name, price, slot);
                    inventoryMap.put(slot, chip);

                } else if
                (item.equals("Drink")) {
                    Drink drink = new Drink(name, price, slot);
                    inventoryMap.put(slot, drink);

                } else if
                (item.equals("Candy")) {
                    Candy candy = new Candy(name, price, slot);
                    inventoryMap.put(slot, candy);

                } else if (item.equals("Gum")) {
                    Gum gum = new Gum(name, price, slot);
                    inventoryMap.put(slot, gum);
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }

    }
}

