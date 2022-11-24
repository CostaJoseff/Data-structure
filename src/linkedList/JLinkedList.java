package linkedList;

public class JLinkedList<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public boolean isEmpty() {
		return (this.size == 0);
	}
	
	public int size() {
		return this.size;
	}
	
	public T head() {
		if (isEmpty()) {
			return null;
		}
		return this.head.value;
	}
	
	public T tail() {
		if (isEmpty()) {
			return null;
		}
		return this.tail.value;
	}
	
	public T putLast(T value) {
		if (value == null) {
			throw new IllegalArgumentException("value cannot be null.");
		}
		Node<T> newNode = new Node<T>(value);
		if (isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.next = newNode;
			newNode.previous = this.tail;
			this.tail = newNode;
		}
		this.size++;
		return value;
	}
	
	public T removeLast() {
		if (isEmpty()) {
			throw new RuntimeException("The list is already empty.");
		}
		T element = this.tail.value;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.tail = this.tail.previous;
			this.tail.next = null;
		}
		this.size--;
		return element;
	}
	
	public T putFirst(T value) {
		if (value == null) {
			return null;
		}
		Node<T> newNode = new Node(value);
		newNode.next = this.head;
		this.head.previous = newNode;
		this.head = newNode;
		this.size++;
		return value;
	}
	
	public T putOnIndex(int index, T value) {
		if (value == null) {
			throw new NullPointerException("value cannot be null.");
		}
		if (index > this.size + 1|| index < 0) {
			return null;
		}
		if (index == 0) {
			return putFirst(value);
		}
		if (index == this.size) {
			return putLast(value);
		}
		
		Node<T> newNode = new Node(value);
		Node<T> element = this.head;
		int loopIndex = 0;
		do {
			if (loopIndex == index) {
				newNode.next = element;
				newNode.previous = element.previous;
				element.previous = newNode;
				newNode.previous.next = newNode;
				this.size++;
				return newNode.value;
			}
			element = element.next;
			loopIndex++;
		} while (true);
	}
	
	/*public T removeOnIndex(int index) {
		// TODO
	}
	
	public T putInFrontOf(T value) {
		// TODO
	}
	
	public T putBehindOf(T value) {
		// TODO
	}
	
	public T removeValue(T value) {
		// TODO
	}
	
	public int removeAllInFrontOf(T value) {
		// TODO
	}
	
	public int removeAllBehindOf(T value) {
		// TODO
	}
	
	public int removeAllInFrontOfIndex(int index) {
		// TODO
	}*/
	
	public void removeAllBehindOfIndex(int index) {
		if (index > this.size || index < 0) {
			throw new IndexOutOfBoundsException("The index is out of range.");
		}
		if (index == this.size) {
			clear();
			return;
		}
		Node<T> element = this.head;
		int loopIndex = 0;
		do {
			if (index == loopIndex) {
				element.previous = null;
				size -= loopIndex;
				this.head = element;
				return;
			}
			element = element.next;
			loopIndex++;
		} while (element != null);
	}
	
	public void clear() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public boolean contains(T value) {
		if (value == null) {
			return false;
		}
		Node<T> element = this.head;
		do {
			if (element.value.equals(value)) {
				return true;
			}
			element = element.next;
		} while (element != null);
		return false;
	}

	public int indexOf(T value) {
		if (value == null) {
			return -1;
		}
		Node<T> element = this.head;
		int index = 0;
		do {
			if (element.value.equals(value)) {
				return index;
			}
			element = element.next;
			index++;
		} while (element != null);
		return -1;
	}
	
	public T elementAt(int index) {
		if (index > this.size || index < 0) {
			return null;
		}
		Node<T> element = this.head;
		int loopIndex = 0;
		do {
			if (index == loopIndex) {
				return element.value;
			}
			element = element.next;
			loopIndex++;
		} while (element != null);
		return null;
	}
	
	@Override
	public String toString() {
		if (this.size == 0) {
			return "";
		}
		String str = "";
		Node<T> element = this.head;
		do {
			str += "[" + element.value + "]";
			element = element.next;
		} while (element != null);
		return str;
	}
	
}
