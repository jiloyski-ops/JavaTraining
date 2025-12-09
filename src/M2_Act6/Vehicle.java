package M2_Act6;

//2. Create Abstract Class "Vehicle". 
public abstract class Vehicle {
 protected int numberOfWheels;
 protected String brand;

//Extending classes should have attributes "numberOfWheels" and "brand"  
 public Vehicle(String brand, int numberOfWheels) {
     this.brand = brand;
     this.numberOfWheels = numberOfWheels;
 }

 public int getNumberOfWheels() {
     return numberOfWheels;
 }

 public String getBrand() {
     return brand;
 }

// and should have an abstract method "startEngine()"
 public abstract void startEngine();

// it should have a concrete method "void destroy()"
 public void destroy() {
     System.out.println(getClass().getSimpleName() + " (" + brand + ") has been destroyed.");
 }

 @Override
 public String toString() {
    return brand + " contains " + numberOfWheels + " wheels";
 }

}

