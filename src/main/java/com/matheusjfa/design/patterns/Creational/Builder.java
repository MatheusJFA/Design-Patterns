package com.matheusjfa.design.patterns.Creational;

/**
 * The Builder Pattern separates the construction of a complex object from its representation so that the same construction process can create different representations.
 * In this case, the Builder Pattern is used to create a computer based on the type (Laptop, Desktop, Server).
 * The Computer class is the Product, and the LaptopBuilder, DesktopBuilder, and ServerBuilder classes are the Concrete Builders.
 * The ComputerBuilder class is the Builder, and the buildComputer method is the Builder Method.
 * The Director class is the Director, and the constructGamerComputer, constructBusinessComputer, constructEnterpriseComputer, and constructLowCostComputer methods are the Director Methods.
 * The main method is used to create a computer based on the type.
 *
 * Output:
 * Desktop: 32GB RAM, 4TB SSD, 27-inch screen
 * Laptop: 16GB RAM, 1TB SSD, 15-inch screen
 * Server: 64GB RAM, 8TB SSD, 32-inch screen
 */
public class Builder {
    public static void main(String[] args) {
        Director director = new Director();
        ComputerBuilder desktopBuilder = new DesktopBuilder();
        ComputerBuilder laptopBuilder = new LaptopBuilder();
        ComputerBuilder serverBuilder = new ServerBuilder();

        Computer desktop = director.constructGamerComputer(desktopBuilder);
        desktop.show();

        Computer enterpriseDesktop = director.constructEnterpriseComputer(desktopBuilder);
        enterpriseDesktop.show();

        Computer laptop = director.constructBusinessComputer(laptopBuilder);
        laptop.show();

        Computer lowCostLaptop = director.constructLowCostComputer(laptopBuilder);
        lowCostLaptop.show();

        Computer server = director.constructEnterpriseComputer(serverBuilder);
        server.show();
    }
}

interface ComputerBuilder {
    void reset();
    void setRam(String ram);
    void setSSD(String ssd);
    void setScreen(String screen);
    void setOS(String os);
    Computer getProduct();
}

/** Concrete Builders */
class Computer {
    protected String ram;
    protected String ssd;
    protected String screen;
    protected String os;

    public Computer() {
        this.ram = "";
        this.ssd = "";
        this.screen = "";
        this.os = "";
    }

    public void show() {
        System.out.println(this.ram + " RAM, " + this.ssd + " SSD, " + this.screen + " screen, " + this.os + " OS");
    }
}

/**
 * PS: I know that all the methods in the builder class share the same implementation, but I'm doing this to show that you can/may have different implementations/validations for each method.
 * Ex: If it was a motorcycle, the setTires method could have a validation to check if the number of tires is 2, and the setEngine method could have a validation to check if the engine is a 4-stroke engine.
 *
 * PS²: As you see, the ComputerBuilder interface set the contract for the Concrete Builders, and the Computer class is the Product BUT it's also important to know that you can have methods of your own in each builder which shouldn't be declared in the interface.
 * Ex²: The class DesktopBuilder can have a setGraphicsCard method, and the class LaptopBuilder can have a setTouchScreen method BUT the director class can't call these methods because they are not declared in the ComputerBuilder interface, so you may have to cast the builder to the specific type to call these methods.
 * */
class DesktopBuilder implements ComputerBuilder {
    private Computer computer;

    @Override
    public void reset() {
        this.computer = new Computer();
    }

    @Override
    public void setRam(String ram) {
        this.computer.ram = ram;
    }

    @Override
    public void setSSD(String ssd) {
        this.computer.ssd = ssd;
    }

    @Override
    public void setScreen(String screen) {
        this.computer.screen = screen;
    }

    @Override
    public void setOS(String os) {
        this.computer.os = os;
    }

    @Override
    public Computer getProduct() {
        return this.computer;
    }
}

class LaptopBuilder implements ComputerBuilder {
    private Computer computer;

    @Override
    public void reset() {
        this.computer = new Computer();
    }

    @Override
    public void setRam(String ram) {
        this.computer.ram = ram;
    }

    @Override
    public void setSSD(String ssd) {
        this.computer.ssd = ssd;
    }

    @Override
    public void setScreen(String screen) {
        this.computer.screen = screen;
    }

    @Override
    public void setOS(String os) {
        this.computer.os = os;
    }

    @Override
    public Computer getProduct() {
        return this.computer;
    }
}

class ServerBuilder implements ComputerBuilder {
    private Computer computer;

    @Override
    public void reset() {
        this.computer = new Computer();
    }

    @Override
    public void setRam(String ram) {
        this.computer.ram = ram;
    }

    @Override
    public void setSSD(String ssd) {
        this.computer.ssd = ssd;
    }

    @Override
    public void setScreen(String screen) {
        this.computer.screen = screen;
    }

    @Override
    public void setOS(String os) {
        this.computer.os = os;
    }

    @Override
    public Computer getProduct() {
        return this.computer;
    }
}

/**
 * Director (This is optional in the Builder Pattern, but I like to make it, so I can have pre-built items, with certain configurations)
 */
class Director {
    public Computer constructGamerComputer(ComputerBuilder builder) {
        builder.reset();
        builder.setRam("32GB");
        builder.setSSD("4TB");
        builder.setScreen("27-inch");
        builder.setOS("Windows 11");
        ComputerDetails(builder);
        return builder.getProduct();
    }

    public Computer constructBusinessComputer(ComputerBuilder builder) {
        builder.reset();
        builder.setRam("16GB");
        builder.setSSD("1TB");
        builder.setScreen("15-inch");
        builder.setOS("Linux Ubuntu");
        ComputerDetails(builder);
        return builder.getProduct();
    }

    public Computer constructEnterpriseComputer(ComputerBuilder builder) {
        builder.reset();
        builder.setRam("64GB");
        builder.setSSD("8TB");
        builder.setScreen("32-inch");
        builder.setOS("Windows Server 2022");
        ComputerDetails(builder);
        return builder.getProduct();
    }

    public Computer constructLowCostComputer(ComputerBuilder builder) {
        builder.reset();
        builder.setRam("8GB");
        builder.setSSD("512GB");
        builder.setScreen("13-inch");
        builder.setOS("Windows 10");
        ComputerDetails(builder);
        return builder.getProduct();
    }

    private void ComputerDetails(ComputerBuilder builder) {
        String name = builder.getClass().getSimpleName().replace("Builder", "");
        System.out.println("The " + name + " computer has:");
    }
}