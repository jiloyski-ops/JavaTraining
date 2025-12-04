package Car;

public class Car {
    private String brand;
    private String model;

    // No-argument constructor
    public Car() {
        this.brand = "-";
        this.model = "-";
    }

    // Parameterized constructor
    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    // ===== Getters =====
    public String getBrand() { return brand; }
    public String getModel() { return model; }

    // ===== Setters =====
    public void setBrand(String brand) { this.brand = brand; }
    public void setModel(String model) { this.model = model; }

    // print car information
    public void displayInfo() {
        System.out.println("Brand: " + brand + "\nModel: " + model);
    }

    // create two cars and use getters/setters
    public static void main(String[] args) {
        // 1) NO-ARG constructor, then assign values via setters
        Car car1 = new Car();
        car1.setBrand("Toyota");
        car1.setModel("Vios");
     // getters
        System.out.println("Car 1 Brand: " + car1.getBrand() + "\n=================");
        car1.displayInfo();

        // 2) PARAMETERIZED constructor
        Car car2 = new Car("Honda", "Civic");
        car2.displayInfo();

        // setters
        car2.setModel("City");
        System.out.println("=================" + "\nChange Car 2 Model: " + car2.getModel() + "\n=================");
        car2.displayInfo();
    }
}
