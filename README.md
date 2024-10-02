# MyHashSet

## Overview

`MyHashSet` is a custom implementation of a hash set that utilizes separate chaining to handle collisions. This implementation stores integer data and provides various functionalities, including adding elements, checking for their existence, calculating the load factor, and resizing the underlying bucket array.

## Features

- **Add Elements**: Adds an integer to the hash set if it is not already present.
- **Check Existence**: Determines if a specific integer exists in the hash set.
- **Display Contents**: Shows the contents of the hash set, grouped by buckets.
- **Load Factor Calculation**: Computes the load factor, representing the ratio of elements to buckets.
- **Dynamic Resizing**: Resizes the hash set to a new bucket size and rehashes all existing elements.

## Class Structure

### `MyHashSet`

#### Member Variables

- `ArrayList<Integer>[] buckets`: An array of `ArrayList` objects, where each bucket stores integers.
- `int numElements`: The current number of elements in the hash set.

#### Methods

- `MyHashSet()`: Constructor that initializes the hash set with 4 buckets.
- `void add(int item)`: Adds an integer to the hash set.
- `void show()`: Displays the contents of the hash set, grouped by bucket.
- `boolean hasItem(int targetItem)`: Checks if an integer is present in the hash set.
- `double loadFactor()`: Returns the load factor of the hash set.
- `void resize(int newSize)`: Resizes the bucket array and rehashes existing elements.

## Output
- Bucket 0: [10, 100]
- Bucket 1: [22, 61]
- Bucket 2: [49, 84]
- Bucket 3: [37, 53, 72, 95]
- Has 37? true
- Has 99? false
- Load Factor before resizing: 2.5
- Bucket 0: [100, 10]
- Bucket 1: [22, 61]
- Bucket 2: [49, 84]
- Bucket 3: [37, 53, 72, 95]
- Bucket 4: []
- Bucket 5: []
- Bucket 6: []
- Bucket 7: []
- Load Factor after resizing: 1.25

## Author

[nav7FSC on GitHub](https://github.com/nav7FSC)