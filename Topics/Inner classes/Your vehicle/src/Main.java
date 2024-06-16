class EnjoyVehicle {

    public static void startVehicle() {
        // start your vehicle
        Vehicle v = new Vehicle();
        Vehicle.Engine engine = v.new Engine();
        engine.start();
    }
}
