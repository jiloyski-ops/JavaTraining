package M2_Act6;

public class MyApplication {

 // 5. In you Main Application, create a method called "destroyVehicle" that takes ONE parameter (either a car or Truck) and call their "destroy()" method.
 public static void destroyVehicle(Vehicle vehicle) {
     vehicle.destroy();
 }
 //4. In your Main Application
 public static void main(String[] args) {
     // create one Car and one truck 
     Car car = new Car("BYD", 4);
     Truck truck = new Truck("Hino", 18);

     System.out.println(car);
     System.out.println(truck);

     // call the methods they inherited / implemented.
     car.startEngine();    
     car.refuel();         

     truck.startEngine();  
     truck.refuel();       

     // Use the destroyVehicle method (Requirement #5)
     destroyVehicle(car);
     destroyVehicle(truck);
 }
}
