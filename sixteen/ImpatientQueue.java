package chaptertwo.sixteen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * An <code>ImpatientQueue</code> object represents
 * a simple linked list of nodes.
 * @author tohrul
 * @version 0.0.1
 */
public class ImpatientQueue<T>{
	/**
	 * A <code>Node</code> class represents
	 * an element of a queue.
	 * @author tohrul
	 * @version 0.0.1
	 */
	private class Node{
		private T value;
		public Node nextElement;
		public Node prevElement;
		
		/**
		 * @return node value
		 */
		public T getValue(){
			return this.value;
		}
		
		/**
		 * @param value
		 */
		public void setValue(T value){
			this.value = value;
		}
		
		@Override
		public String toString(){
			return getValue().toString();
		}
	}
	
	/**
	 * An <code>Iterator</code> object
	 * provides an iterator to go through elements
	 * of <code>ImpatienQueue</code> object.
	 * @author tohrul
	 * @version 0.0.1
	 */
	private class QueueIterator implements Iterator<Node>{
		private int currentIndex = 0;
		/**
		 * @return next item
		 */
		@Override
		public Node next(){
			return items.get(currentIndex++);
		}
		/**
		 * @return whether there is next item
		 */
		@Override
		public boolean hasNext(){
			if(currentIndex >= items.size()){
				return false;
			} else{
				return true;
			}
		}
		/**
		 * removes an item
		 */
		@Override
		public void remove(){
			items.remove(--currentIndex);
		}
	}
	
	public Iterator<Node> iterator(){
		return new QueueIterator();
	}
	
	private List<Node> items = new ArrayList<Node>();
	
	/**
	 * Adds an item to a queue.
	 * @param value
	 */
	public void addItem(T value){
		Node item = new Node();
		
		if(this.items.isEmpty()){
			item.setValue(value);
			item.nextElement = null;
			item.prevElement = null;
			this.items.add(item);
		} else{
			Iterator<ImpatientQueue<T>.Node> itemsIterator = this.items.iterator();
			List<Node> temp = new ArrayList<Node>();
			while(itemsIterator.hasNext()){
				Node element = itemsIterator.next();
				if(element.nextElement == null){
					item.setValue(value);
					item.nextElement = element.nextElement;
					element.nextElement = item;
					item.prevElement = element;
					temp.add(item);
				}
			}
			this.items.addAll(temp);
		}
	}
	
	/**
	 * Removes an item from a queue.
	 * @param value
	 */
	public void removeItem(T value){
		if(!this.items.isEmpty()){
			Iterator<ImpatientQueue<T>.Node> itemsIterator = this.items.iterator();
			while(itemsIterator.hasNext()){
				Node element = itemsIterator.next();
				if(element.getValue().toString().equals(value.toString())){
					element.prevElement.nextElement = element.nextElement;
					element.nextElement.prevElement = element.prevElement;
					this.items.remove(element);
				}
			}
		}
	}
	
	@Override
	public String toString(){
		return this.items.toString();
	}
}
