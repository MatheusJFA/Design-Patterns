package com.matheusjfa.design.patterns.Creational;

/**
 * The Singleton Pattern ensures that a class has only one instance and provides a global point of access to it.
 * In this case, the Singleton Pattern is used to create a single instance of the Singleton class.
 * The Database class is the Singleton class, and the instance method is the Singleton Method.
 * The main method is used to create a single instance of the Singleton class.
 *
 * Output:
 * Equality: true
 * */
public class Singleton {
    public static void main(String[] args) {
        var database = Database.getInstance();
        var anotherDatabaseAccess = Database.getInstance();

        System.out.println("Equality: " + database.equals(anotherDatabaseAccess));

        System.out.println(database);
        System.out.println(anotherDatabaseAccess);
    }
}

class Database {
    private static Database instance;

    private Database() {
        // Prevent instantiation via reflection
    }

    public static Database getInstance() {
        if (instance == null) instance = new Database();
        return instance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Verify if the objects have the same reference
        if (obj == null || getClass() != obj.getClass()) return false; // Verify if the objects are from the same class

        final Database database = (Database) obj; // Cast the object to the class type
        return this.hashCode() == database.hashCode(); // Verify if the objects have the same hash code
    }

    @Override
    public String toString() {
        return "Database instance: " + instance.hashCode();
    }
}
