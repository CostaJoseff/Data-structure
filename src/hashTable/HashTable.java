package hashTable;

public class HashTable<T> {
	
	private final int DEFAULT_SIZE = 11;
	private final double DEFAULT_LOAD_LIMIT = 0.75;
	
	private HashTableElement<T>[] elements;
	private int size;
	private double loadLimit;
	
	public HashTable(int firstSize, int loadLimit) {
		if (loadLimit > 100 || loadLimit < 1 || firstSize <= 0) {
			throw new IllegalArgumentException();
		}
		if (!isPrime(firstSize)) {
			this.elements = new HashTableElement[findNextPrime(firstSize)];
		} else {
			this.elements = new HashTableElement[firstSize];
		}
		
		this.size = 0;
		this.loadLimit = this.loadLimit/100;
	}
	
	private int hash(T key) {
		if (key.get)
	}
	
	private int findNextPrime(int value) {
		if (value % 2 == 0) {
			value++;
		}
		while(!isPrime(value)) {
			value += 2;
		}
		return value;
	}
	
	private boolean isPrime(int value) {
		for (int i = 2; i < value; i++) {
			if (value % i > 1) {
				return false;
			}
		}
		return true;
	}
}
