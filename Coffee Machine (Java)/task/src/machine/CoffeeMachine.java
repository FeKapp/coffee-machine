package machine;


import java.util.Scanner;

public class CoffeeMachine {

    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;

    public CoffeeMachine(int water, int milk, int coffeeBeans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
    }
    public int getWater() {
        return water;
    }
    public int getMilk() {
        return milk;
    }
    public int getCoffeeBeans() {
        return coffeeBeans;
    }
    public int getCups() {
        return cups;
    }
    public int getMoney() {
        return money;
    }

    public void setWater(int water) {
        this.water = water;
    }
    public void setMilk(int milk) {
        this.milk = milk;
    }
    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }
    public void setCups(int cups) {
        this.cups = cups;
    }
    public void setMoney(int money){
        this.money = money;
    }

    public boolean checkResources(int waterDifference, int milkDifference, int coffeeBeansDifference, int cupsDifference) {
        if (waterDifference < 0) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (milkDifference < 0) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (coffeeBeansDifference < 0) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (cupsDifference < 0) {
            System.out.println("Sorry, not enough cups!");
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
    }

    public void printState() {
        System.out.printf("\nThe coffee machine has:\n%d ml of water\n%d ml of milk\n%d g of coffee beans\n%d disposable cups\n$%d of money\n%n", water, milk, coffeeBeans, cups, money);
    }

    public void brewCoffee(int action) {
        switch (action) {
            case 1 -> {
                if (checkResources(water - 250, milk, coffeeBeans - 16, cups - 1)) {
                    water -= 250;
                    coffeeBeans -= 16;
                    money += 4;
                    cups -= 1;
                }
            }
            case 2 -> {
                if (checkResources(water - 350, milk - 75, coffeeBeans - 20, cups - 1)) {
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    money += 7;
                    cups -= 1;
                }
            }
            case 3 -> {
                if(checkResources(water - 200, milk - 100, coffeeBeans - 12, cups - 1)) {
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    money += 6;
                    cups -= 1;
                }
            }
        }
    }

    public void fillCoffeeMachine(int waterAdd, int milkAdd, int coffeeBeansAdd, int cupsAdd) {
        water += waterAdd;
        milk += milkAdd;
        coffeeBeans += coffeeBeansAdd;
        cups += cupsAdd;
    }

    public void takeMoney() {
        System.out.printf("I gave you $%d%n", money);
        money = 0;
    }

    public static void main(String[] args) {



        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);

        Scanner keyboard = new Scanner(System.in);

        boolean stillRunning = true;

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");

            String action = keyboard.nextLine();

            switch (action) {
                case "remaining" -> {
                    coffeeMachine.printState();
                }
                case "exit" -> {
                    stillRunning = false;
                }
                case "buy" -> {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String coffeeType = keyboard.nextLine();
                    if (coffeeType.equals("back")) {
                        break;
                    } else {
                    coffeeMachine.brewCoffee(Integer.parseInt(coffeeType));
                    }
                }
                case "fill" -> {
                    System.out.println("Write how many ml of water do you want to add:");
                    int waterAdd = keyboard.nextInt();
                    System.out.println("Write how many ml of milk do you want to add:");
                    int milkAdd = keyboard.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    int coffeeBeansAdd = keyboard.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    int cupsAdd = keyboard.nextInt();

                    coffeeMachine.fillCoffeeMachine(waterAdd, milkAdd, coffeeBeansAdd, cupsAdd);
                }
                case "take" -> {
                    coffeeMachine.takeMoney();
                }
            }
        } while (stillRunning);
    }




}



