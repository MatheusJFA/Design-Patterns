package com.matheusjfa.design.patterns.Creational;

/**
 * The Abstract Factory Pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes.
 * In this case, the Abstract Factory Pattern is used to create furniture based on the style (Modern, Victorian, Gamer, Simple).
 * The AbstractFurnitureCreator interface is the Abstract Factory, and the ModernFurnitureCreator, VictorianFurnitureCreator, GamerFurnitureCreator, and SimpleFurnitureCreator classes are the Concrete Factories.
 * The Chair, Sofa, and Table interfaces are the Abstract Products, and the ModernChair, ModernSofa, ModernTable, VictorianChair, VictorianSofa, VictorianTable, GamerChair, GamerSofa, GamerTable, SimpleChair, SimpleSofa, and SimpleTable classes are the Concrete Products.
 * The FurnitureFactory class is the Factory, and the getFurnitureCreator method is the Factory Method.
 * The main method is used to create furniture based on the style.
 *
 * Output:
 * Sitting on a modern chair
 * Lying on a modern sofa
 * Putting on a modern table
 * Sitting on a victorian chair
 * Lying on a victorian sofa
 * Putting on a victorian table
 * Sitting on a gamer chair
 * Lying on a gamer sofa
 * Putting on a gamer table
 * Sitting on a simple chair
 * Lying on a simple sofa
 * Putting on a simple table
 */
public class AbstractFactory {
    public static void main(String[] args) {
        AbstractFurnitureCreator modernFurnitureCreator = FurnitureFactory.getFurnitureCreator("modern");
        AbstractFurnitureCreator victorianFurnitureCreator = FurnitureFactory.getFurnitureCreator("victorian");
        AbstractFurnitureCreator gamerFurnitureCreator = FurnitureFactory.getFurnitureCreator("gamer");
        AbstractFurnitureCreator simpleFurnitureCreator = FurnitureFactory.getFurnitureCreator("simple");

        Chair modernChair = modernFurnitureCreator.createChair();
        Sofa modernSofa = modernFurnitureCreator.createSofa();
        Table modernTable = modernFurnitureCreator.createTable();

        Chair victorianChair = victorianFurnitureCreator.createChair();
        Sofa victorianSofa = victorianFurnitureCreator.createSofa();
        Table victorianTable = victorianFurnitureCreator.createTable();

        Chair gamerChair = gamerFurnitureCreator.createChair();
        Sofa gamerSofa = gamerFurnitureCreator.createSofa();
        Table gamerTable = gamerFurnitureCreator.createTable();

        Chair simpleChair = simpleFurnitureCreator.createChair();
        Sofa simpleSofa = simpleFurnitureCreator.createSofa();
        Table simpleTable = simpleFurnitureCreator.createTable();

        modernChair.sitOn();
        modernSofa.lieOn();
        modernTable.putOn();

        victorianChair.sitOn();
        victorianSofa.lieOn();
        victorianTable.putOn();

        gamerChair.sitOn();
        gamerSofa.lieOn();
        gamerTable.putOn();

        simpleChair.sitOn();
        simpleSofa.lieOn();
        simpleTable.putOn();
    }
}

/** Factory */
class FurnitureFactory {
    public static AbstractFurnitureCreator getFurnitureCreator(String type) {
        return switch (type) {
            case "modern" -> new ModernFurnitureCreator();
            case "simple" -> new SimpleFurnitureCreator();
            case "victorian" -> new VictorianFurnitureCreator();
            case "gamer" -> new GamerFurnitureCreator();
            default -> throw new IllegalArgumentException("Invalid furniture type: " + type);
        };
    }
}

/** Abstract Factory */
interface AbstractFurnitureCreator {
    Chair createChair();
    Sofa createSofa();
    Table createTable();
}

/** Concrete Factories */
class ModernFurnitureCreator implements AbstractFurnitureCreator {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }

    @Override
    public Table createTable() {
        return new ModernTable();
    }
}

class VictorianFurnitureCreator implements AbstractFurnitureCreator {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }

    @Override
    public Table createTable() {
        return new VictorianTable();
    }
}

class GamerFurnitureCreator implements AbstractFurnitureCreator {
    @Override
    public Chair createChair() {
        return new GamerChair();
    }

    @Override
    public Sofa createSofa() {
        return new GamerSofa();
    }

    @Override
    public Table createTable() {
        return new GamerTable();
    }
}

class SimpleFurnitureCreator implements AbstractFurnitureCreator {
    @Override
    public Chair createChair() {
        return new SimpleChair();
    }

    @Override
    public Sofa createSofa() {
        return new SimpleSofa();
    }

    @Override
    public Table createTable() {
        return new SimpleTable();
    }
}

/** Abstract Product */
interface Chair {
    void sitOn();
}

/** Concrete Product */
class ModernChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a modern chair");
    }
}

class VictorianChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a victorian chair");
    }
}

class GamerChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a gamer chair");
    }
}

class SimpleChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a simple chair");
    }
}

/** Abstract Product */
interface Sofa {
    void lieOn();
}

/** Concrete Product */
class ModernSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Lying on a modern sofa");
    }
}

class VictorianSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Lying on a victorian sofa");
    }
}

class GamerSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Lying on a gamer sofa");
    }
}

class SimpleSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Lying on a simple sofa");
    }
}

/** Abstract Product */
interface Table {
    void putOn();
}

/** Concrete Product */
class ModernTable implements Table {
    @Override
    public void putOn() {
        System.out.println("Putting on a modern table");
    }
}

class VictorianTable implements Table {
    @Override
    public void putOn() {
        System.out.println("Putting on a victorian table");
    }
}

class GamerTable implements Table {
    @Override
    public void putOn() {
        System.out.println("Putting on a gamer table");
    }
}

class SimpleTable implements Table {
    @Override
    public void putOn() {
        System.out.println("Putting on a simple table");
    }
}
