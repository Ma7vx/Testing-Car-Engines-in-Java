import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<CarEngine> engines = new ArrayList<>();
        engines.add(new CarEngine("Company 1", 120, 520, 85, 87, 5));
        engines.add(new CarEngine("Company 2", 230, 720, 97, 150, 8));
        engines.add(new CarEngine("Company 3", 340, 640, 120, 170, 1));
        engines.add(new CarEngine("Company 4", 460, 1200, 170, 180, 6));
        engines.add(new CarEngine("Company 5", 570, 1310, 140, 110, 10));

        printEngineDetails(engines);
    }
    public static void printEngineDetails(ArrayList<CarEngine> engines) {
        for (CarEngine engine : engines) {
            System.out.println("Company Name: " + engine.getCompanyName());
            System.out.println("Number of Cylinders: " + engine.getNumCylinders());
            System.out.println("Engine Displacement: " + engine.getEngineDisplacement());
            System.out.println("Horsepower: " + engine.getHorsePower());
            System.out.println("**************");
        }
    }
}