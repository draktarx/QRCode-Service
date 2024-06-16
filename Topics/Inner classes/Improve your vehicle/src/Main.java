class Vehicle {

    private String name;

    // create constructor
    public Vehicle(String name) {
        this.name = name;
    }

    class Engine {

        // add field horsePower
        int horsePower;

        // create constructor
        public Engine(int horsePower) {
            this.horsePower = horsePower;
        }

        void start() {
            System.out.println("RRRrrrrrrr....");
        }

        void printHorsePower() {
            System.out.println("Vehicle " +
                               Vehicle.this.name +
                               " has " +
                               this.horsePower +
                               " horsepower.");
        }

    }

}

class EnjoyVehicle {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle("Dixi");
        Vehicle.Engine engine = vehicle.new Engine(20);
        engine.printHorsePower();
    }

}
