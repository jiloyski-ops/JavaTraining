package M2_Act6;

//3. Create two concrete classes "Car" and "Truck". It must implement "Refuelable"and extend "Vehicle".
public class Car extends Vehicle implements Refuelable {

 public Car(String brand, int numberOfWheels) {
     super(brand, numberOfWheels);
 }

 @Override
 public void startEngine() {
     System.out.println("Car engine started.......");
 }

 @Override
 public void refuel() {
     System.out.println("Refueling car with gasoline.");
 }
}

