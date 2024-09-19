package com.matheusjfa.design.patterns.Creational;

import java.util.Scanner;

/**
 * The Factory Method Pattern defines an interface for creating an object, but lets subclasses decide which class to instantiate.
 * In this case, the Factory Method Pattern is used to create a delivery system based on the environment (Rails, Land, Sea, Air).
 * The Logistics class is the Creator, and the RoadLogistics, SeaLogistics, and AirLogistics classes are the Concrete Creators.
 * The Transport class is the Product, and the Car, Truck, Boat, Ship, Helicopter, Airplane, Train, and BulletTrain classes are the Concrete Products.
 * The Delivery class is the Client, and the DeliveryService interface is the Product interface.
 * The PRIORITY, ENVIRONMENT and DISTANCE enums are used to define the priority, environment and distance of the delivery.
 * The planDelivery method is used to plan the delivery based on the user input.
 *
 * Output:
 * Enter the product name: Pizza
 * Enter the delivery location:  New York
 * Enter the environment (RAILS, LAND, SEA, AIR): LAND
 * Enter the priority (LOW, MEDIUM, HIGH, EMERGENCY): HIGH
 * Enter the distance (LOCAL, SHORT, MEDIUM, LONG):  LOCAL
 * >>> Delivering Pizza by car to New York
 */

public class FactoryMethod {
    public static void main(String[] args) {
        Delivery delivery = new Delivery();
        delivery.planDelivery();
    }
}

abstract class Transport implements DeliveryService {
    protected String product;
    protected String location;

    public Transport(String product, String location) {
        this.product = product;
        this.location = location;
    }
}

interface DeliveryService {
    void deliver(String product, String location);
}

// Concrete Products

// Land
class Truck extends Transport {
    public Truck(String product, String location) {
        super(product, location);
    }

    @Override
    public void deliver(String product, String location) {
        System.out.println("Delivering " + product + " by truck to " + location);
    }
}

class Car extends Transport {
    public Car(String product, String location) {
        super(product, location);
    }

    @Override
    public void deliver(String product, String location) {
        System.out.println("Delivering " + product + " by car to " + location);
    }
}

// Sea
class Ship extends Transport {
    public Ship(String product, String location) {
        super(product, location);
    }

    @Override
    public void deliver(String product, String location) {
        System.out.println("Delivering " + product + " by ship to " + location);
    }
}

class Boat extends Transport {
    public Boat(String product, String location) {
        super(product, location);
    }

    @Override
    public void deliver(String product, String location) {
        System.out.println("Delivering " + product + " by boat to " + location);
    }
}

// Air
class Airplane extends Transport {
    public Airplane(String product, String location) {
        super(product, location);
    }

    @Override
    public void deliver(String product, String location) {
        System.out.println("Delivering " + product + " by airplane to " + location);
    }
}

class Helicopter extends Transport {
    public Helicopter(String product, String location) {
        super(product, location);
    }

    @Override
    public void deliver(String product, String location) {
        System.out.println("Delivering " + product + " by helicopter to " + location);
    }
}

// Rails
class Train extends Transport {
    public Train(String product, String location) {
        super(product, location);
    }

    @Override
    public void deliver(String product, String location) {
        System.out.println("Delivering " + product + " by train to " + location);
    }
}

class BulletTrain extends Transport {
    public BulletTrain(String product, String location) {
        super(product, location);
    }

    @Override
    public void deliver(String product, String location) {
        System.out.println("Delivering " + product + " by bullet train to " + location);
    }
}

/** Creator */
abstract class Logistics {
    protected final PRIORITY priority;
    protected final DISTANCE distance;
    protected final String product;
    protected final String location;

    public Logistics(PRIORITY priority, DISTANCE distance, String product, String location) {
        this.priority = priority;
        this.distance = distance;
        this.product = product;
        this.location = location;
    }

    public void planDelivery(String product, String location) {
        Transport transport = createTransport();
        transport.deliver(product, location);
    }

    protected abstract Transport createTransport();
}

/** Concrete Creators */
class RoadLogistics extends Logistics {
    public RoadLogistics(PRIORITY priority, DISTANCE distance, String product, String location) {
        super(priority, distance, product, location);
    }

    @Override
    protected Transport createTransport() {
        var carCondition = (distance.equals(DISTANCE.LOCAL) || distance.equals(DISTANCE.SHORT)) && (priority.equals(PRIORITY.HIGH) || priority.equals(PRIORITY.EMERGENCY));
        var truckCondition = (distance.equals(DISTANCE.MEDIUM) || distance.equals(DISTANCE.LONG)) && (priority.equals(PRIORITY.LOW) || priority.equals(PRIORITY.MEDIUM));

        if (carCondition) return new Car(product, location);
        else if (truckCondition) return new Truck(product, location);
        else return null;
    }
}

class SeaLogistics extends Logistics {
    public SeaLogistics(PRIORITY priority, DISTANCE distance, String product, String location) {
        super(priority, distance, product, location);
    }

    @Override
    protected Transport createTransport() {
        var boatCondition = (distance.equals(DISTANCE.LOCAL) || distance.equals(DISTANCE.SHORT)) && (priority.equals(PRIORITY.HIGH) || priority.equals(PRIORITY.EMERGENCY));
        var shipCondition = (distance.equals(DISTANCE.MEDIUM) || distance.equals(DISTANCE.LONG)) && (priority.equals(PRIORITY.LOW) || priority.equals(PRIORITY.MEDIUM));

        if (boatCondition) return new Boat(product, location);
        else if (shipCondition) return new Ship(product, location);
        else return null;
    }
}

class AirLogistics extends Logistics {
    public AirLogistics(PRIORITY priority, DISTANCE distance, String product, String location) {
        super(priority, distance, product, location);
    }

    @Override
    protected Transport createTransport() {
        var helicopterCondition = (distance.equals(DISTANCE.LOCAL) || distance.equals(DISTANCE.SHORT) || distance.equals(DISTANCE.MEDIUM)) && (priority.equals(PRIORITY.HIGH) || priority.equals(PRIORITY.EMERGENCY));
        var airplaneCondition = (distance.equals(DISTANCE.LONG)) && (priority.equals(PRIORITY.LOW) || priority.equals(PRIORITY.MEDIUM));

        if (helicopterCondition) return new Helicopter(product, location);
        else if (airplaneCondition) return new Airplane(product, location);
        else return null;
    }
}

class RailLogistics extends Logistics {
    public RailLogistics(PRIORITY priority, DISTANCE distance, String product, String location) {
        super(priority, distance, product, location);
    }

    @Override
    protected Transport createTransport() {
        var trainCondition = (distance.equals(DISTANCE.LOCAL) || distance.equals(DISTANCE.SHORT)) && (priority.equals(PRIORITY.LOW) || priority.equals(PRIORITY.MEDIUM));
        var bulletTrainCondition = (distance.equals(DISTANCE.MEDIUM) || distance.equals(DISTANCE.LONG)) && (priority.equals(PRIORITY.HIGH) || priority.equals(PRIORITY.EMERGENCY));

        if (trainCondition) return new Train(product, location);
        else if (bulletTrainCondition) return new BulletTrain(product, location);
        else return null;
    }
}

/** Client */
class Delivery {
    final Scanner scanner = new Scanner(System.in);

    public void planDelivery() {
        Logistics logistics = null;

        System.out.println("Enter the product name: ");
        String product = scanner.nextLine();

        System.out.println("Enter the delivery location: ");
        String location = scanner.nextLine();

        System.out.println("Enter the environment (RAILS, LAND, SEA, AIR): ");
        ENVIRONMENT environment = ENVIRONMENT.valueOf(scanner.nextLine());

        System.out.println("Enter the priority (LOW, MEDIUM, HIGH, EMERGENCY): ");
        PRIORITY priority = PRIORITY.valueOf(scanner.nextLine());

        System.out.println("Enter the distance (LOCAL, SHORT, MEDIUM, LONG): ");
        DISTANCE distance = DISTANCE.valueOf(scanner.nextLine());

        switch (environment) {
            case RAILS -> logistics = new RailLogistics(priority, distance, product, location);
            case LAND -> logistics = new RoadLogistics(priority, distance, product, location);
            case SEA -> logistics = new SeaLogistics(priority, distance, product, location);
            case AIR -> logistics = new AirLogistics(priority, distance, product, location);
            default -> throw new IllegalStateException("Unexpected value: " + environment);
        }

        logistics.planDelivery(product, location);
    }
}


enum PRIORITY {
    LOW,
    MEDIUM,
    HIGH,
    EMERGENCY
}

enum DISTANCE {
    LOCAL,
    SHORT,
    MEDIUM,
    LONG
}

enum ENVIRONMENT {
    RAILS,
    LAND,
    SEA,
    AIR
}