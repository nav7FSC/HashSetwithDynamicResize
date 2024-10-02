package org.education;
import java.util.ArrayList;

/**
 * A custom HashSet implementation that uses separate chaining to handle collisions.
 * This HashSet stores integer data.
 */
public class HashSet {

    /** An array of ArrayLists, where each ArrayList stores integers for a bucket. */
    private ArrayList<Integer>[] buckets;

    /** The number of elements currently in the hash set. */
    private int numElements;

    /**
     * Default constructor that initializes the hash set with 4 buckets
     * and sets the number of elements to 0.
     */
    @SuppressWarnings("unchecked")
    public HashSet() {
        buckets = new ArrayList[4]; // Initialize with 4 buckets
        numElements = 0;
        // Initialize each bucket with an ArrayList
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    /**
     * Adds an integer to the hash set if it is not already present.
     * The integer is added to the appropriate bucket using the mod operation.
     *
     * @param item the integer to add to the hash set
     */
    public void add(int item) {
        if (!hasItem(item)) {  // Check if item is already in the set
            int bucketIndex = item % buckets.length;  // Use mod operation to find the bucket
            buckets[bucketIndex].add(item);
            numElements++;  // Increment the number of elements
        }
    }

    /**
     * Displays the contents of the hash set grouped by bucket.
     */
    public void show() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.println("Bucket " + i + ": " + buckets[i]);
        }
    }

    /**
     * Checks if a given integer is present in the hash set.
     *
     * @param targetItem the integer to search for
     * @return true if the integer is present, false otherwise
     */
    public boolean hasItem(int targetItem) {
        int bucketIndex = targetItem % buckets.length;
        return buckets[bucketIndex].contains(targetItem);
    }

    /**
     * Calculates and returns the load factor of the hash set.
     * The load factor is the ratio of the number of elements to the number of buckets.
     *
     * @return the load factor of the hash set
     */
    public double loadFactor() {
        return (double) numElements / buckets.length;
    }

    /**
     * Resizes the bucket array to the specified new size and rehashes
     * all elements into the new bucket array.
     *
     * @param newSize the new number of buckets
     */
    @SuppressWarnings("unchecked")
    public void resize(int newSize) {
        ArrayList<Integer>[] newBuckets = new ArrayList[newSize];  // Create new buckets
        // Initialize each new bucket with an ArrayList
        for (int i = 0; i < newSize; i++) {
            newBuckets[i] = new ArrayList<>();
        }
        // Rehash and transfer data
        for (ArrayList<Integer> bucket : buckets) {
            for (int item : bucket) {
                int newBucketIndex = item % newSize;
                newBuckets[newBucketIndex].add(item);
            }
        }
        buckets = newBuckets;  // Replace old buckets with new ones
    }

    /**
     * Main method to test the functionality of the HashSet class.
     * Adds 10 numbers to the hash set, displays the contents, checks for
     * specific items, shows the load factor, and resizes the hash set.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        HashSet myHashSet = new HashSet();
        int[] numbers = {10, 22, 37, 49, 53, 61, 72, 84, 95, 100};

        for (int num : numbers) {
            myHashSet.add(num);
        }

        myHashSet.show();

        // Check if certain items exist
        System.out.println("Has 37? " + myHashSet.hasItem(37));  // true
        System.out.println("Has 99? " + myHashSet.hasItem(99));  // false

        // Display the load factor
        System.out.println("Load Factor: " + myHashSet.loadFactor());

        // Resize and show again
        myHashSet.resize(8);
        myHashSet.show();
    }
}