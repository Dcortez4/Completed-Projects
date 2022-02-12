package a1.dcortez;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Random ran = new Random();
    private static final FoodItems[] foodItems = FoodItems.values();
    private static final Tools[] tools = Tools.values();
    private static final ToolUses[] toolUses = ToolUses.values();
    private static final Booster[] boosterItems = Booster.values();
    private static final Clothes[] clothes = Clothes.values();
    private static final ClothingType [] clothingTypes = ClothingType.values();

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        // Start of the app
        System.out.print("How many items do you want: ");
        int itemCnt = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < itemCnt; i++) {
            int type = ran.nextInt(4);
            switch (type) {
                case 0 -> items.add(genFood());

                case 1 -> items.add(genTool());

                case 2 -> items.add(genBooster());

                case 3 -> items.add(genClothing());

            }
        }

        for (Item i : items) {
                System.out.println(i);
        }

    }

    public static Food genFood(){
        int foodIndex = ran.nextInt(foodItems.length);
        String foodName = foodItems[foodIndex].toString();
        float foodPrice = ran.nextFloat(10);
        int foodQty = ran.nextInt(30);
        int foodUses = ran.nextInt(6);
        float healthGain = ran.nextFloat(20);
        return new Food(foodName, foodPrice, foodQty, foodUses, healthGain);
    }

    public static Tool genTool(){
        int toolIndex = ran.nextInt(tools.length);
        String toolName = tools[toolIndex].toString();
        float toolPrice = ran.nextFloat(200);
        int toolQty = ran.nextInt(15);
        String use = toolUses[toolIndex].toString();
        return new Tool(toolName, toolPrice, toolQty, use);
    }

    public static Boosters genBooster(){
        int boostersIndex = ran.nextInt(boosterItems.length);
        String boosterName = boosterItems[boostersIndex].toString();
        float boosterPrice = ran.nextFloat(1000);
        int boosterQty = ran.nextInt(20);
        int boosterUses = ran.nextInt(10);
        float bonus = ran.nextFloat(100);
        return new Boosters(boosterName, boosterPrice, boosterQty, boosterUses, bonus);
    }

    public static Clothing genClothing(){
        int clothingIndex = ran.nextInt(clothes.length);
        String clothingName = clothes[clothingIndex].toString();
        float clothingPrice = ran.nextFloat(500);
        int clothingQty = ran.nextInt(10);
        String cType = clothingTypes[clothingIndex].toString();
        return new Clothing(clothingName, clothingPrice, clothingQty, cType);
    }

}
