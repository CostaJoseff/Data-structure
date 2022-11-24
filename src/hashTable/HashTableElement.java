package hashTable;

public class HashTableElement<T> {

	public final int ID;
	private T value;
	
	public HashTableElement(int ID, T value) {
		this.ID = ID;
		this.value = value;
	}
	
	public T getValue() {
		return this.value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
}
