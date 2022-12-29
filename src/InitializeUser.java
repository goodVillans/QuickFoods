import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class InitializeUser {
    private static final Scanner sc = new Scanner(System.in);

    //  Method Initializes creation of relevant class based on user input.
    public static Customer customerInit() {

        System.out.print("enter your name: ");
        String name = sc.nextLine();
        System.out.print("enter your city: ");
        String city = sc.nextLine();
        System.out.print("enter your home address: ");
        String address = sc.nextLine();
        System.out.print("enter your email: ");
        String email = sc.nextLine();
        System.out.print("enter your cell number: ");
        String contactNumber = sc.nextLine();

        var customer = new Customer(name, city, address, email, contactNumber);
        System.out.println(customer);
        return customer;
    }

    public static Restaurant restaurantInit(){

        System.out.print("enter your Est. name: ");
        String name = sc.nextLine();
        System.out.print("City: ");
        String city = sc.nextLine();
        System.out.print("Street address: ");
        String address = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Contact Number: ");
        String contactNumber = sc.nextLine();

        ArrayList<Object> restaurants =  new ArrayList<>();
        // create restaurant object
        var restaurant = new Restaurant(name, city, address, email, contactNumber);
        // add object to array list of restaurants
        restaurants.add(restaurant);
        return restaurant;
    }
}
