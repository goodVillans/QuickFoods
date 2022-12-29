import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class CreateInvoice {


    public static void generateInvoiceNoRestaurantsInArea(String name)  {

        try{
            String noRestaurantCopy = "Hi" + name + ". \n" +
                "Unfortunately there are no restaurants In your city, " +
                "please check back with us in a few months and hopefully we will be able to send you some cholesterol" +
                "Stay Greasy, hot stuff";
            BufferedWriter bw = new BufferedWriter(new FileWriter("Misfortune.txt"));
            bw.write(noRestaurantCopy);
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

//  final output for customer invoice
    public static void printOrderDetails
            (String name,
             String city,
             String email,
             String contactNo,
             String customerAddress,
             String driverName,
             String restName,
             String restNumber,
             String specialInstructions,
             Hashtable<String, Integer> orders,
             ArrayList<Integer> quantities,
             Double total){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("invoice.txt"));

            var orderNo = new Random();
            int orderNumber = orderNo.nextInt(9999);

            bw.write("Order Number: " + orderNumber + "\n");
            bw.write("Customer: " + name + "\n");
            bw.write("Email: " + email + "\n");
            bw.write("Phone Number: " + contactNo + "\n");
            bw.write("Location: " + city + "\n");
            bw.write("\n");
            bw.write("You Have Ordered the Following from " + restName + "in " + city + ":");
//          iterate thorough quantities and order datasets
            for(int i = 0; i < quantities.size(); i++){
                String key = (String)orders.keySet().toArray()[i];
                int value = orders.get(key);
                bw.write(quantities.get(i) + "x" + key + " (" + value + ")");
            }
            bw.newLine();
            bw.write("Special instructions: " + specialInstructions + "\n");
            bw.write("\n");
            bw.write("Total: " + total + "\n");
            bw.write("\n");
            bw.write(driverName + "is nearest to the restaurant and will be delivering to:" +
                    customerAddress);
            bw.write("if you need to contact the restaurant, their number is: " + restNumber);
            bw.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
