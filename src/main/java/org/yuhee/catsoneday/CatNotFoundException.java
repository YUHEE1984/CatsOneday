package org.yuhee.catsoneday;

public class CatNotFoundException extends Exception {
    // Defined by inheriting from Java's standard exception class *Exception*
    // forcing the calling method to always handle or throw the exception

    public CatNotFoundException (Long catId) {

        super("No cat found for ID " + catId);
        // Call parent class (Exception) constructor, where we pass a message (cat 'catId' not found)

    } // Create a message to deliver to users when an exception is thrown
}
