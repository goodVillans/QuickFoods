import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static final Scanner mainSc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.print("Are you a customer or a restaurant?\ntype C for Customer or R for restaurant:");
        var userType = mainSc.nextLine();

        if (userType.equalsIgnoreCase("c")){
            // create Customer Object
            var customer = InitializeUser.customerInit();

            // get Customer Attributes
            var customerName = customer.getName();
            var customerAddress = customer.getAddress();
            var customerEmail = customer.getEmail();
            var customerContact = customer.getContactNumber();
            var customerLocation = customer.getCity();
            // new HT for relevant restaurants
            var relevantRestaurants = new ArrayList<>();

            // display only restaurants in customers city
            var findRestaurantsByLocation =
                Restaurant.findRestaurantsAtLocation(customerLocation, relevantRestaurants);

            // if there are no restaurants in the customers city create an invoice with apology message.
            if (findRestaurantsByLocation.isEmpty()){
                CreateInvoice.generateInvoiceNoRestaurantsInArea(customer.getName());
            }

            var requestedRestaurant = Restaurant.findRequestedRestaurant(findRestaurantsByLocation);
            if (requestedRestaurant == null){
                System.out.println("no Restaurant with this name");
            }
            var restaurantMenu = requestedRestaurant.getMenu();
            var restaurantName = requestedRestaurant.getName();
            var restaurantContact = requestedRestaurant.getContactNumber();

            // FROM ORDER CONSTRUCTOR:
            // create a new order
            var newOrder = new OrderConstructor(restaurantMenu);
            var orderedItems = newOrder.getMenu();
            var orderTotal = newOrder.getTotal();
            var orderQuantities = newOrder.getOrderQuantities();
            var specialInstructions = OrderConstructor.specialInstructions();

            // new Driver object
            var driver = new Driver(customerLocation);
            var driverName = driver.getName();
            // create customer invoice.
            CreateInvoice.printOrderDetails
                    (
                        customerName,
                        customerLocation,
                        customerEmail,
                        customerContact,
                        customerAddress,
                        driverName,
                        restaurantName,
                        restaurantContact,
                        specialInstructions,
                        orderedItems,
                        orderQuantities,
                        orderTotal
                    );
        }else if (userType.equalsIgnoreCase("r")){
            var restaurant = InitializeUser.restaurantInit();
        }
    }
}