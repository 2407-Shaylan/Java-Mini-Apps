import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeMap;

public class Application {

    private HashMap<String,Item> stock;
    private TreeMap<Double, Integer> change;
    private HashMap<Integer, String> menu;
    private double userMoney;


    public void loadChange(Double money, Integer amount) {
        if (change.get(money) != null) {
            int old_value = change.get(money);
            change.put(money, old_value + amount);
        }
        else
            change.put(money, amount);
    }
    public void loadItems(String name,  Double price, Integer amount) {

        if (stock.get(name) != null) {
            Item current = stock.get(name);
            current.setQuantity(current.getQuantity() + amount);
        }
        else {
            Item current = new Item(name, price, amount);
            stock.put(name, current);
        }
    }
    public Application() {
        stock = new HashMap<String, Item>();
        change = new TreeMap<Double, Integer>();
        menu = new HashMap<Integer, String>();

        userMoney = 0;
    }

    public double getMachineTotal() {
        double total = 0;
        for (Double val : change.keySet())
            total = total + (val * change.get(val));
        return total;
    }


    public static void main(String[] args) {


        Application Vending_Machine = new Application();

        Vending_Machine.menu.put(new Integer(1), "Snickers");
        Vending_Machine.menu.put(new Integer(2), "KitKat");
        Vending_Machine.menu.put(new Integer(3), "Coke Zero");
        Vending_Machine.menu.put(new Integer(4), "Sprite");
        Vending_Machine.menu.put(new Integer(5),"Skittles");
        Vending_Machine.menu.put(new Integer(6),"M&M Chocolate");
        Vending_Machine.menu.put(new Integer(7),"Muffin");

        Vending_Machine.loadChange(new Double(0.01), new Integer(100));
        Vending_Machine.loadChange(new Double(0.02), new Integer(100));
        Vending_Machine.loadChange(new Double(0.05), new Integer(100));
        Vending_Machine.loadChange(new Double(0.1), new Integer(100));
        Vending_Machine.loadChange(new Double(0.2), new Integer(100));
        Vending_Machine.loadChange(new Double(0.5), new Integer(100));
        Vending_Machine.loadChange(new Double(1.0), new Integer(100));
        Vending_Machine.loadChange(new Double(2.0), new Integer(100));

        Vending_Machine.loadItems("Snickers", 2.0,  3);
        Vending_Machine.loadItems("KitKat", 3.20, 7);
        Vending_Machine.loadItems("Skittles", 1.75, 5);
        Vending_Machine.loadItems("Muffin", 4.0, 15);
        Vending_Machine.loadItems("M&M Chocolate", 1.5, 5);
        Vending_Machine.loadItems("Sprite", 2.15, 12);
        Vending_Machine.loadItems("Coke Zero", 1.75, 30);


        Vending_Machine.runMachine();

    }
    public void buyItem(Integer sel, double money) {

        Item current = this.stock.get(this.menu.get(sel));
        double expected = current.getPrice();
        if (money > expected) {
            if (expected - money < this.getMachineTotal()) {
                this.dispenseItem(current);
                this.makeChange(money - expected);
                this.userMoney = (double) (money - expected);
            }
            else
                System.out.println("Sorry ! Not enough change. Aborting operation");
        }
        else
            System.out.println("Sorry, Insufficient funds ! Please insert  "+(expected - money)+" to buy this item");


    }

    public void dispenseItem(Item newItem) {
        newItem.setQuantity(newItem.getQuantity()-1);
        System.out.println("Please take your "+newItem.getName()+" from the dispenser");
    }

    public void runMachine() {

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Snack Bar!");
        System.out.println("_________________________");

        for (Integer number : this.menu.keySet())
        {
            String name = this.menu.get(number);
            if(this.stock.get(name) != null)
                System.out.println("Press "+ (int) number+" for "+ name + " price "+ "$" + this.stock.get(name).getPrice());
        }
        System.out.println("_________________________________________________________________________________________");
        System.out.println("Please enter your cash followed by # to start your selection: ");
        boolean exit = false;
        while (true)
        {
            while (input.hasNext()) {

                if (input.hasNextDouble())
                    this.userMoney = this.userMoney + input.nextDouble();
                else if (input.next().equals("#"))
                    break;
            }
            while (!exit) {

                System.out.println("Amount credited: "+ "$"+ this.userMoney);

                System.out.println("Please enter a selection, or press ($) to add credit or (exit) to quit: ");

                if(input.hasNextInt()) {
                    int selection = input.nextInt();
                    if (this.menu.containsKey(selection))
                        buyItem(selection, this.userMoney);
                    else
                        System.out.println("Enter a valid menu item");
                }
                else {

                    String command = input.next();
                    if (command.equals("$")) {

                        System.out.println("Please enter your cash followed by # to add credit");
                        while (input.hasNext()) {
                            if (input.hasNextDouble())
                                this.userMoney = this.userMoney + input.nextDouble();
                            else if (input.next().equals("#"))
                                break;
                        }
                    }
                    else if (command.equals("exit")) {

                        System.out.println("Goodbye! Enjoy your snacks");
                        System.exit(0);
                    }
                }
            }

        }
    }

    public void makeChange(Double needed)
    {
        System.out.println("Change needed :"+ "$" + needed);
        double temp = needed;
        for (Double value : this.change.descendingMap().keySet()) {

        }
    }
}