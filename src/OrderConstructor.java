import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class OrderConstructor {
    private static final Scanner orderSc = new Scanner(System.in);
    private final Hashtable<String, Integer> menu;
    private final ArrayList<Integer> orderQuantities;
    private Double total;
    public OrderConstructor(Hashtable<String, Integer> menu) {
        this.menu = placeOrder(menu);
        this.orderQuantities = getOrderQuantities();
        this.total = getTotal();
    }
//  instantiate user orders to new hashtable.
    private Hashtable<String, Integer> placeOrder(Hashtable<String, Integer>menu){

        Hashtable<String, Integer> order = new Hashtable<>();
        boolean anotherDish = true;

        while (anotherDish){
//          get Cx order from input
            System.out.println("enter the name of the dish you would like to order: ");
            String dishName = orderSc.nextLine();
//          check input against menu keys
            if(menu.containsKey(dishName)){
//              get value for relevant key
                int dishPrice = menu.get(dishName);
//              get quantity and calculate value of order
                System.out.print("How many orders of the dish would you like? \t");
                int quantity = orderSc.nextInt();
                int priceWithQuantityUpdate = dishPrice * quantity;
//              add to total after Math
                total += priceWithQuantityUpdate;
//              add to new HT for print purposes
                order.put(dishName, priceWithQuantityUpdate);
                orderQuantities.add(quantity);
//              add new item to order
                System.out.println("Place Another order? type (yes/no): ");
                String addAnother = orderSc.nextLine();
//              conditional checks if user wants to place another order(continue loop)
                if (addAnother.equalsIgnoreCase("no")) {
                    anotherDish = false;
                }
            } else {
                System.out.println("no Such dish");
                placeOrder(menu);
            }
        }
        return order;
    }
    public Hashtable<String, Integer> getMenu() {
        return menu;
    }
    public Double getTotal(){
        return total;
    }
    public ArrayList<Integer> getOrderQuantities(){
        return orderQuantities;
    }
    public static String specialInstructions(){
        System.out.println("Enter any Special Instructions you have Below:");
        String instructions = orderSc.nextLine();
        return instructions;
    }
}
