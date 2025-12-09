package M2_Act6;

//3. Create two concrete classes "Car" and "Truck". It must implement "Refuelable"and extend "Vehicle".
public class Truck extends Vehicle implements Refuelable {

 public Truck(String brand, int numberOfWheels) {
     super(brand, numberOfWheels);
 }

 @Override
 public void startEngine() {
     System.out.println("Truck engine started.......");
 }

 @Override
 public void refuel() {
     System.out.println("Refueling truck with diesel.");
 }
}

