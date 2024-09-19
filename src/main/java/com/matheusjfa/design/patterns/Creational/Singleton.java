package com.matheusjfa.design.patterns.Creational;

/**
 * The Singleton Pattern ensures that a class has only one instance and provides a global point of access to it.
 * In this case, the Singleton Pattern is used to create a single instance of the Singleton class.
 * The Database class is the Singleton class, and the instance method is the Singleton Method.
 *
 * Output:
 *
 * */
public class Singleton {
    public static void main(String[] args) {
        var database = Database.getInstance();
        var anotherDatabaseAccess = Database.getInstance();

        System.out.println("Equality: " + database.equals(anotherDatabaseAccess));
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
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        final Database database = (Database) obj;
        return this.hashCode() == database.hashCode();
    }

    @Override
    public String toString() {
        return "Database instance: " + instance.hashCode();
    }
}
