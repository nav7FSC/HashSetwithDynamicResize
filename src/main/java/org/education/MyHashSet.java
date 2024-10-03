package org.education;
import java.util.ArrayList;

/**
 * The MyHashSet class implements a hash set using separate chaining.
 * It stores integers in buckets (ArrayLists) and supports adding,
 * checking for existence, displaying, calculating load factor, and resizing.
 */
public class MyHashSet {
    private ArrayList<Integer>[] buckets; // Array of ArrayLists to store integers
    private int numElements; // Number of elements currently in the hash set

    /**
     * Default constructor that initializes the hash set with 4 buckets and sets the number of elements to zero.
     */
    public MyHashSet() {
        // Initializing 4 buckets
        buckets = new ArrayList[4];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        numElements = 0;
    }

    /**
     * Adds the given integer to the hash set if it is not already present.
     *
     * @param item The integer to be added to the hash set.
     */
    public void add(int item) {
        // Check if the item is already in the set
        if (!hasItem(item)) {
            int bucketIndex = item % buckets.length;
            buckets[bucketIndex].add(item);
            numElements++;
        }
    }

    /**
     * Displays the contents of the hash set, grouped by bucket.
     * Each bucket and its contents are printed to the console.
     */
    public void show() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.println("Bucket " + i + ": " + buckets[i]);
        }
    }

    /**
     * Checks if a given item exists in the hash set.
     *
     * @param targetItem The integer to be searched for.
     * @return true if the item exists in the hash set, false otherwise.
     */
    public boolean hasItem(int targetItem) {
        int bucketIndex = targetItem % buckets.length;
        return buckets[bucketIndex].contains(targetItem);
    }

    /**
     * Calculates and returns the current load factor of the hash set.
     * The load factor is defined as the number of elements divided by the number of buckets.
     *
     * @return The load factor of the hash set.
     */
    public double loadFactor() {
        return (double) numElements / buckets.length;
    }

    /**
     * Resizes the hash set to use a new number of buckets. It rehashes all existing elements
     * into the newly allocated bucket array.
     *
     * @param newSize The new number of buckets for the hash set.
     */
    public void resize(int newSize) {
        // Create a new bucket array with the new size
        ArrayList<Integer>[] newBuckets = new ArrayList[newSize];
        for (int i = 0; i < newSize; i++) {
            newBuckets[i] = new ArrayList<>();
        }

        // Rehash all items from the old buckets into the new buckets
        for (ArrayList<Integer> bucket : buckets) {
            for (int item : bucket) {
                int newBucketIndex = item % newSize;
                newBuckets[newBucketIndex].add(item);
            }
        }

        // Update the bucket array reference to the new one
        buckets = newBuckets;
        System.out.println("Resized to " + newSize + " buckets.");
    }

    /**
     * Main method to test the MyHashSet class. It adds 10 different integers to the hash set,
     * displays the contents, and performs resizing while displaying load factors before and after resizing.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();

        // Adding 10 numbers to the hash set
        int[] numbers = {10, 22, 31, 4, 5, 19, 27, 12, 17, 6};
        for (int number : numbers) {
            hashSet.add(number);
        }

        // Show all the data in the hash set
        System.out.println("HashSet contents:");
        hashSet.show();

        // Display load factor before resizing
        System.out.println("Load factor before resizing: " + hashSet.loadFactor());

        // Added dashed line
        System.out.println("----------------------------------");

        // Resize to 8 buckets
        hashSet.resize(8);

        // Show all the data after resizing
        System.out.println("HashSet contents after resizing:");
        hashSet.show();

        // Display load factor after resizing
        System.out.println("Load factor after resizing: " + hashSet.loadFactor());
    }
}