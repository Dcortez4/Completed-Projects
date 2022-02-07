package a1.dcortez;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random ran = new Random();
        List<Item> items = new ArrayList<>();
        FoodItems[] foodItems = FoodItems.values();
        Tools[] tools = Tools.values();
        ToolUses[] toolUses = ToolUses.values();
        Booster[] boosterItems = Booster.values();
        Clothes[] clothes = Clothes.values();
        ClothingType [] clothingTypes = ClothingType.values();


        System.out.print("How many items do you want: ");
        int itemCnt = Integer.parseInt(scan.nextLine());

        for(int i=0; i<itemCnt; i++){
            int type = ran.nextInt(4);
            switch (type) {
                case 0 -> {
                    int foodIndex = ran.nextInt(foodItems.length);
                    String foodName = foodItems[foodIndex].toString();
                    float foodPrice = ran.nextFloat(10);
                    int foodQty = ran.nextInt(30);
                    int foodUses = ran.nextInt(6);
                    float healthGain = ran.nextFloat(20);
                    Food tempFood = new Food(foodName, foodPrice, foodQty, foodUses, healthGain);
                    items.add(tempFood);
                }
                case 1 -> {
                    int toolIndex = ran.nextInt(tools.length);
                    String toolName = tools[toolIndex].toString();
                    float toolPrice = ran.nextFloat(200);
                    int toolQty = ran.nextInt(15);
                    String use = toolUses[toolIndex].toString();
                    Tool tempTool = new Tool(toolName, toolPrice, toolQty, use);
                    items.add(tempTool);
                }
                case 2 -> {
                    int boostersIndex = ran.nextInt(boosterItems.length);
                    String boosterName = boosterItems[boostersIndex].toString();
                    float boosterPrice= ran.nextFloat(1000);
                    int boosterQty = ran.nextInt(20);
                    int boosterUses = ran.nextInt(10);
                    float bonus = ran.nextFloat(100);
                    Boosters tempBooster = new Boosters(boosterName, boosterPrice, boosterQty, boosterUses, bonus);
                    items.add(tempBooster);
                }
                case 3 -> {
                    int clothingIndex = ran.nextInt(clothes.length);
                    String clothingName = clothes[clothingIndex].toString();
                    float clothingPrice = ran.nextFloat(500);
                    int clothingQty = ran.nextInt(10);
                    String cType = clothingTypes[clothingIndex].toString();
                    Clothing tempClothing = new Clothing(clothingName,clothingPrice,clothingQty, cType);
                    items.add(tempClothing);
                }
            }
        }

        for(Item i : items) {
            System.out.println(i);
        }

    }
}
