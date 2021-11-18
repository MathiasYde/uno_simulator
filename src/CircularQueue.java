import java.util.ArrayList;
import java.util.Iterator;
 
class CircularQueue<T> implements Iterable<T> {
	private int size;
	private ArrayList<T> queue = new ArrayList<T>();
	private int index = 0;
	private int direction = 1;

	CircularQueue(int size) {
		this.size = size;
	}

	public void enqueue(T object) {
		if (queue.size() >= size) {
			return;
		}

		queue.add(object);
	}

	public T peek() {
		if (index < 0 || index >= queue.size()) { return null; }
		return queue.get(index);
	}

	public T pop() {
		T object = queue.get(index);
		advance();
		return object;
	}

	public void reverse() {
		direction *= -1;
	}

	// Return the element next to current one
	public T next() {
		return queue.get(safe_index_bounds(index + 1));
	}

	public void advance() {
		index += direction;
		index = safe_index_bounds(index);
	}

	public int safe_index_bounds(int i) {
		if (i < 0) { i = queue.size(); }
		if (i >= queue.size()) { i = 0; }
		return i;
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> iter = new Iterator<T>() {
			private int currentIndex = 0;

			@Override
			public boolean hasNext() {
				if (currentIndex >= queue.size()) { return false; }
				if (queue.get(currentIndex) == null) { return false; }

				return true;
			}

			@Override
			public T next() {
				return queue.get(currentIndex++);
			}

			@Override
			public void remove() { throw new UnsupportedOperationException(); }
		};
		return iter;
	}
}