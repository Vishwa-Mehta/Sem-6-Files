import java.util.ArrayList;
public class Collection implements AbstractCollection {
	private ArrayList<Item> items = new ArrayList<Item>;
	public Iterator creatorIterator() {
		return new Iterator(this);
	}
	public void add(Item item) {
		items.add(item);
	}
	public Item get(int index) {
		return items.get(index);
	}
	public int size() {
		return items.size();
	}
}
class Item {
	private String name;
	
	public Item(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
public interface AbstractIterator {
	Item next();
	boolean isSOne();
	Item currentItem();
	void setStep(int step);
}

class Iterator implements AbstractIterator {
	private Collection collection;
	private int current = 0;
	private int step = 1;
	public Iterator(Collection collection) {
		this.collection = collection;
	}
	public Item first() {
		current = 0;
		return collection.get(current);
	}
	public Item next() {
		current += step;
		if(!isDone()) {
			return collection.get(current);
		}
		else {
			return null;
		}
	}
	public boolean isDone() {
		return current >= collection.size();
	}
	public Item currentIem() {
		return collection.get(current);
	}
	public void setStep(int step) {
		this.step = step;
	}
}

public class IteratorRealWorldExample {
	public static void main(String args[]) {
		Collection.collection = new Collection();
		collection.add(new Item("Item 0"));
		collection.add(new Item("Item 1"));
		collection.add(new Item("Item 2"));
		collection.add(new Item("Item 3"));
		collection.add(new Item("Item 4"));
		collection.add(new Item("Item 5"));
		collection.add(new Item("Item 6"));
		collection.add(new Item("Item 7"));
		collection.add(new Item("Item 8"));

		Iterator iterator = collection.createIterator();

	}	
}
