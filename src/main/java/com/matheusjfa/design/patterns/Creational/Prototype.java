package com.matheusjfa.design.patterns.Creational;


/**
 * The Prototype Pattern creates new objects by copying an existing object, known as the prototype.
 * In this case, the Prototype Pattern is used to create a clone of a button.
 * The Button class is the Concrete Prototype, and the clone method is the Prototype Method.
 * The main method is used to create a clone of a button.
 *
 * Output:
 * Button: Button{text='Click me', color='blue', width=100, height=50}
 * Cloned Button: Button{text='Click me', color='blue', width=100, height=50}
 * Equality: false
 * */
public class Prototype {
    public static void main(String[] args) {
        Button button = new Button("Click me", "blue", 100, 50);
        Button clonedButton = button.duplicate();

        System.out.println("Button: " + button);
        System.out.println("Cloned Button: " + clonedButton);

        System.out.println("Button: " + button.hashCode());
        System.out.println("Cloned Button: " + clonedButton.hashCode());

        System.out.println("Equality: " + button.equals(clonedButton));
    }
}

interface ButtonPrototype<T> {
    T duplicate();
}

class Button implements ButtonPrototype<Button> {
    private final String text;
    private final String color;
    private final int width;
    private final int height;

    public Button(
        final String text,
        final String color,
        final int width,
        final int height
    ) {
        this.text = text;
        this.color = color;
        this.width = width;
        this.height = height;
    }

    @Override
    public Button duplicate() {
        return new Button(
                this.text,
                this.color,
                this.width,
                this.height
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Button button = (Button) obj;
        return this.width == button.width &&
                this.height == button.height &&
                this.text.equals(button.text) &&
                this.color.equals(button.color);
    }

    @Override
    public String toString() {
        return "Button: Text='" + this.text + "', Color='" + this.color + "', Width=" + this.width + ", Height=" + this.height;
    }
}

