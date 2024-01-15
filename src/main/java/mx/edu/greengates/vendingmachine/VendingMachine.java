package mx.edu.greengates.vendingmachine;

public class VendingMachine {

    private Item[][] itemGrid;
    private double[] currency = {0.5, 1.00, 2.00, 5.00, 10.00, 20.00,
            20.00, 50.0, 100.0, 200.00, 500.00, 1000.00};

    private int[] billsAndCoins;

    private final int BILLS = 6;
    private final int BILLS_AND_COINS_SIZE = 12;

    public VendingMachine() {

        itemGrid = new Item[5][4];
        billsAndCoins = new int[BILLS_AND_COINS_SIZE];

        billsAndCoins[0] = 20;  // 0.50
        billsAndCoins[1] = 50;  // 1.00
        billsAndCoins[2] = 20;  // 2.00
        billsAndCoins[3] = 0;  // 5.00
        billsAndCoins[4] = 10;  // 10.00
        billsAndCoins[5] = 1;   // 20.00
        billsAndCoins[6] = 15;  // 20.00 bill
        billsAndCoins[7] = 15;  // 50.00 bill
        billsAndCoins[8] = 4;   // 100.00 bill
        billsAndCoins[9] = 0;   // 200.00 bill
        billsAndCoins[10] = 0;  // 500.00 bill
        billsAndCoins[11] = 0;  // 1000.00 bill
    }

    public double inputItem(String code) {
        // 1. Get coordinates for the selected item
        int[] coordinates = getCoordinates(code);
        // 2. Verify that there is something on that slot
        if(itemGrid[coordinates[0]][coordinates[1]] != null){
            Item item = itemGrid[coordinates[0]][coordinates[1]];
            // 3. Verify that there is enough quantity
            if(item.getQuantity() > 0){
                // 4. Return the price of the item
                return item.getPrice();
            }
        }
        return 0.0;
    }

    public double inputMoney(double money) {
        return 0.0;
    }

    private double calculateTotalMoney(int[] billsAndCoins) {
        double totalMoneyInMachine = 0.0;

        for(int counter = 0; counter < BILLS_AND_COINS_SIZE; counter++){
            // totalMoneyInMachine += billsAndCoins[counter] * currency[counter];
            totalMoneyInMachine =  totalMoneyInMachine + billsAndCoins[counter] * currency[counter];
        }

        return totalMoneyInMachine;
    }

    public int[] calculateChange(double amount, double price) {
        double change = 0.0;
        int[] changeCurrency = new int[BILLS_AND_COINS_SIZE];
        // 1. Verify that the amount is greater than the price
        if(amount >= price){

            change = amount - price;
        } else {
            System.out.println("Not enough money");
            return changeCurrency; // Error returnin an invalid value
        }
        // 2. Do we have enough change?
        if(calculateTotalMoney(this.billsAndCoins) > change) {
           double changeInCurrency = 0.0;

           int index = BILLS_AND_COINS_SIZE - 1;
           while (change > (changeInCurrency)){
               if(currency[index]<= change){
                   if(billsAndCoins[index] > 0){
                       billsAndCoins[index]--;
                       changeCurrency[index]++;
                       changeInCurrency += currency[index];
                       change -= currency[index];
                   }
               }
                index--;
           }
        } else {
            System.out.println("Not enough change");
            return changeCurrency; // Error returnin an invalid value
        }

        return changeCurrency;
    }

    public void dispenseItem(String code) {
    }

    public void insertItem(Item item, String code) {
        int[] coordinates = getCoordinates(code);
        itemGrid[coordinates[0]][coordinates[1]] = item;
    }

    public void removeItem(String code) {
    }

    public void updateItem(String code, Item item) {
    }

    public void printItems() {
        for (int i = 0; i < itemGrid.length; i++) {
            for (int j = 0; j < itemGrid[i].length; j++) {
                if (itemGrid[i][j] != null) {
                    System.out.println(itemGrid[i][j]);
                }
            }
        }
    }

    public void printItem(String code) {
    }

    private int[] getCoordinates(String code) {
        char letter = code.charAt(0);
        int number = Integer.parseInt(code.substring(1));

        int[] coordinates = new int[2];
        switch (letter) {
            case 'A':
                coordinates[0] = 0;
                break;
            case 'B':
                coordinates[0] = 1;
                break;
            case 'C':
                coordinates[0] = 2;
                break;
            case 'D':
                coordinates[0] = 3;
                break;
            case 'E':
                coordinates[0] = 4;
                break;
        }
        coordinates[1] = number - 1;

        return coordinates;
    }

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        Item chocolate = new Item(1, "Chocolate", 10.0, 10);
        Item soda = new Item(2, "Soda", 15.0, 10);
        Item chips = new Item(3, "Chips", 12.0, 10);
        Item gum = new Item(4, "Gum", 5.0, 10);
        Item water = new Item(5, "Water", 8.0, 10);

        vendingMachine.insertItem(chocolate, "A1");
        vendingMachine.insertItem(soda, "A2");
        vendingMachine.insertItem(chips, "A3");
        vendingMachine.insertItem(gum, "A4");
        vendingMachine.insertItem(water, "B1" );

        vendingMachine.printItems();

        String selectedCode = "A2";
        double price = vendingMachine.inputItem(selectedCode);
        System.out.println("Price: " + price);
        double money = 20.00;
        int[] changeCurrency = vendingMachine.calculateChange(money, price);
        for(int counter = 0; counter < vendingMachine.BILLS_AND_COINS_SIZE; counter++){
            System.out.println(vendingMachine.currency[counter] + " " + changeCurrency[counter]);
        }
        double change = vendingMachine.calculateTotalMoney(changeCurrency);
        System.out.println("Change: " + change);
        vendingMachine.inputMoney(10.0);
        vendingMachine.dispenseItem("A1");
    }
}
