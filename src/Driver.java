import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Driver {
    private String name;
    public Driver(String location) throws FileNotFoundException {
        readDrivers(location);
        this.name = getName();
    }
    private void readDrivers(String userLocation)throws FileNotFoundException {

        var file = new FileReader("\\drivers.txt");
        var fileScanner = new Scanner(file);
        var hashDriver = new Hashtable<String, Integer>();

        while (fileScanner.hasNextLine()) {
            // grab current line
            String driver = fileScanner.nextLine();
            if (driver.contains(userLocation)){
                // condition based on rest location split at delimiter type comma .
                String[] driverArray = driver.split(",");
                // based on driver.txt format >>
                // - last value in arr of 3 items(name, location, load size) = load size >>
                // - convert to int before adding to hashtable.
                int driverLoadToInt = Integer.parseInt(driverArray[2]);
                hashDriver.put(driverArray[0], driverLoadToInt);
                sortDriversByLoad(hashDriver);
            }
        }
    }
    private void sortDriversByLoad(Hashtable<String, Integer> driverTable) {

        // Get the entry set of the Hashtable
        Set<Map.Entry<String, Integer>> entries = driverTable.entrySet();
        // Create a list of Map.Entry objects from the entry set
        List<Map.Entry<String, Integer>> list = new ArrayList<>(entries);
        // Sort the list of Map.Entry objects using comparator interface
        list.sort(new java.util.Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        // new Hashtable(sorted)
        Hashtable<String, Integer> sortedDrivers = new Hashtable<>();
        // Add the sorted Map.Entry objects to the new Hashtable
        for (Map.Entry<String, Integer> entry : list) {
            sortedDrivers.put(entry.getKey(), entry.getValue());
        }
        // call setName function
        setName(sortedDrivers);
    }
    private void setName(Hashtable<String, Integer> sortedDrivers){
        // get keySet of input HT
        Set<String> keys = sortedDrivers.keySet();
        // store the key of first element in HT(Driver with <est load) as driver name
        name = keys.iterator().next();
    }
    public String getName(){
        return name;
    }
}

