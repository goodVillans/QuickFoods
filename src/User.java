import java.util.Scanner;
// Abstract class for Restaurant and Customer
public abstract class User {

    private final Scanner sc = new Scanner(System.in);
    String name;
    String city;
    String address;
    String email;
    String contactNumber;

    public User(String name, String city, String address, String email, String contactNumber) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.email = email;
        this.contactNumber = contactNumber;
    }
    public String getName() {
        return name;
    }
    public String setName() {
        System.out.println("Name: ");
        name = sc.nextLine();
        return name;
    }
    public String getCity() {
        return city;
    }

    public String setCity() {
        System.out.println("City : ");
        city = sc.nextLine();
        return city;
    }
    public String getAddress() {
        return address;
    }

    public String setAddress() {
        System.out.println("Address: ");
        address = sc.nextLine();
        return address;
    }
    public String getEmail() {
        return email;
    }

    public String setEmail() {
        System.out.println("Email Address: ");
        email = sc.nextLine();
        return null;
    }
    public String getContactNumber() {
        return contactNumber;
    }

    public String setContactNumber() {
        System.out.println("Cell Number: ");
        contactNumber = sc.nextLine();
        return contactNumber;
    }
    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
