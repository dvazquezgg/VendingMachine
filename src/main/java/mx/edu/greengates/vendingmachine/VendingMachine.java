package mx.edu.greengates.vendingmachine;

public class VendingMachine {

    private Item[][] itemGrid;

    public VendingMachine() {
        itemGrid = new Item[5][4];
    }

    public double inputItem(String code) {
        return 0.0;
    }

    public double inputMoney(double money) {
        return 0.0;
    }

    public double calculateChange(double amount, double price) {
        return 0.0;
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

        vendingMachine.inputItem("A1");
        vendingMachine.inputMoney(10.0);
        vendingMachine.dispenseItem("A1");
    }
}
