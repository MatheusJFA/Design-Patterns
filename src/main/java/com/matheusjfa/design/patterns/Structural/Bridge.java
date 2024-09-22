package com.matheusjfa.design.patterns.Structural;

/**
 * The Bridge Pattern decouples an abstraction from its implementation so that the two can vary independently.
 * In this example we have a remote control that can turn on and off a device.
 * The remote control has a reference to the device interface.
 * The device interface has a turnOn and turnOff method.
 * The TV and Radio classes implement the device interface.
 *
 * The same RemoteControl can turn on and off a TV and a Radio.
 * The RemoteControl has a reference to the Device interface, and the Device interface has a reference to the TV and Radio classes.
 * If we want to add a new device, we can create a new class that implements the Device interface and the RemoteControl will be able to turn it on and off.
 *
 * Output:
 * TV is on
 * TV is off
 * --------------------
 * Radio is on
 * Radio is off
 * */
public class Bridge {
    public static void main(String[] args) {
        Device tv = new TV();
        RemoteControl remoteControl = new RemoteControl(tv);
        remoteControl.turnOn();
        remoteControl.turnOff();
        System.out.println("--------------------");
        Device radio = new Radio();
        remoteControl = new RemoteControl(radio);
        remoteControl.turnOn();
        remoteControl.turnOff();
    }
}


interface Device {
    void turnOn();
    void turnOff();
}

class TV implements Device {
    @Override
    public void turnOn() {
        System.out.println("TV is on");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is off");
    }
}

class Radio implements Device {
    @Override
    public void turnOn() {
        System.out.println("Radio is on");
    }

    @Override
    public void turnOff() {
        System.out.println("Radio is off");
    }
}

class RemoteControl {
    private final Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void turnOn() {
        device.turnOn();
    }

    public void turnOff() {
        device.turnOff();
    }
}