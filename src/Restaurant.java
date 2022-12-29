import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Restaurant extends User{

    private final static Scanner restSc = new Scanner(System.in);

    Hashtable<String, Integer> menu;

    public Restaurant(String name, String city, String address, String email, String contactNumber) {
        super(name, city, address, email, contactNumber);
        this.menu = setMenu(new Hashtable<>());
    }
//  input menu dishes and prices to hashtable to set menu
    private Hashtable<String, Integer> setMenu(Hashtable<String, Integer> menu) {

        boolean keepAdding = true;
        int itemPrice;

        while (keepAdding){

            System.out.print("Enter menu item name: ");
            String itemName = restSc.next();
            System.out.print("Enter menu items price(As double): ");
            itemPrice = restSc.nextInt();

            menu.put(itemName, itemPrice);

            System.out.println("enter 1 to add add another menu item, enter any other number to exit");
            int anotherItemRequest = restSc.nextInt();

            if (anotherItemRequest != 1) {
                keepAdding = false;
            }
        }
        return menu;
    }
    public Hashtable<String, Integer> getMenu() {
        return menu;
    }
//  find only restaurants in customers city
    public static ArrayList<Object> findRestaurantsAtLocation(String location, ArrayList<Object> objects){

        var onlyMatchingRestaurants = new ArrayList<>();

        for (Object obj: objects) {
            if (obj.toString().contains(location)){
                onlyMatchingRestaurants.add(obj);
            }
        }
        if (onlyMatchingRestaurants.isEmpty()){
            System.out.println("no matching restaurants In your City");
        }
        System.out.println(onlyMatchingRestaurants);
        return onlyMatchingRestaurants;
    }
//  get customer requested restaurant
    public static Restaurant findRequestedRestaurant(ArrayList<Object> restArr){

        System.out.print("Please enter the name of the restaurant you wish to order from: ");
        String userRequest = restSc.nextLine();

        for (Object obj: restArr) {
            if (!obj.toString().contains(userRequest)){
                System.out.println("Restaurant not found");
                findRequestedRestaurant(restArr);
            } else {
                return (Restaurant) obj;
            }
        }
        return null;
    }

}
