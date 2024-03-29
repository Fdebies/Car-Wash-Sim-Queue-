/**
 * A list node.  Contains a generic element, and a reference
 * to the next node in the list.
 *
 * @param <T>
 */
public class Node<T> {
	
	private Node<T> next;
	private T element; 
	private Node<T> previous;

	/**
	 * Creates a node. 
	 * @param element - the element that the node will contain
	 */
	public Node(T element) {
		this.next = null;
		this.element = element;
	}


	/**
	 * Returns the element contained in this node. 
	 * @return
	 */
	public T getElement() {
		return element;
	}
	public String toString()
	{return (String)element;}
	/**
	 * Returns the next node in the list. 
	 * @return
	 */
	public Node<T> getNext() {
		return next;
	}

	public Node<T> getPrevious() {return previous;}
	
	/**
	 * Sets the next node reference for this node. 
	 * @param next - The node that will follow this node.
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	
}
