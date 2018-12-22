
/*  Linear Probing Hash Table */
public class Hashtable {
	private int currentSize, maxSize;

	public Pair[] map = null; // stores hash table elements

	// Constructor
	public Hashtable(int capacity) {
		currentSize = 0;
		maxSize = capacity;
		map = new Pair[maxSize];
		for (int i = 0; i < maxSize; i++)
			map[i] = null;
	}

	// Function to check if hash table is empty
	public boolean isEmpty() {
		return getSize() == 0;
	}

	// Function to get size of hash table
	public int getSize() {
		return currentSize;
	}

	// Function to check if hash table is full
	public boolean isFull() {
		return currentSize == maxSize;
	}

	// Function to check if hash table contains a key
	public boolean contains(String key) {
		return get(key) != null;
	}

	// Function to get hash-code/hash-value for a given key
	public int hash(String key) {
		return Math.abs(key.hashCode()) % maxSize;
	}

	// Function to get value for a given key
	public String get(String key) {
		int index = hash(key);
		int start = index;

		while (map[index] != null) {
			if (map[index].getKey() == key)
				return map[index].getValue();
			index = (index + 1) % map.length;
			if (index == start)
				return null;
		}
		return null;
	}

	// Function to insert key-value pair
	public void put(String key, String val) {
		if (isFull()) 
			rehash();
		int index = hash(key); // hash func
		while (map[index] != null)
			index = (index + 1) % map.length;
		map[index] = new Pair(key, val);
		currentSize++;
	}

	/// Function to rehash when the table is full
	public void rehash() {
		Pair[] backup = map;
		map = new Pair[2 * backup.length];
		maxSize = 2 * backup.length;
		currentSize = 0;
		for (int i = 0; i < backup.length; i++) {
			put(backup[i].getKey(), backup[i].getValue());
		}
		// Hint: 1-backup the reference to the old hash map
		// 2-create a new map twice the old size
		// 3-hash all elements from the old hash map to new hash map

	}

	// Function to print HashTable
	public void printHashTable() {
		System.out.println("\nHash Table: Key, Value ");
		for (int i = 0; i < maxSize; i++)
			if (map[i] != null)
				System.out.println(map[i].getKey() + ", " + map[i].getValue());
		System.out.println();
	}
}

class Pair {

	private String key;
	private String value;

	public Pair(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

}
