import java.util.NoSuchElementException;

/**
 * 
 * A very basic list class.  Elements can only be added at the beginning at
 * the beginning of the list, and can only be removed according to their
 * index.
 * @Author Nathan Sprague
 * @version April 12, 2010
 *
 */
public class List<T>
{

	private Node<T> first;
	private int size;

	
	/**
	 * Create an empty list.
	 */
	public List() {
		first = null;
		size = 0;
	}

	/**
	 * Adds a new element AT THE BEGINNING of the list. 
	 * @param element - The element to add
	 */
	public void addElement(T element) 
	{
		Node add = new Node(element);
		add.setNext(first);
		first = add;
		//System.out.println(this.toString());

		size ++;
		//YOU NEED TO ADD CODE HERE!
	}
	public void insertBack(T element){
		if(first == null){
			first = new Node<T>(element);
		}else{
			Node newNode = new Node(element);
			Node current = first;
			while(current.getNext() != null){
				current = current.getNext();
			}
			current.setNext(newNode);
		}
		size++;
	}

	public T getElement(int index)  throws NoSuchElementException
	{
		if(index > size() || index < 0 || first.getNext().getNext() == null)
		{
			throw new NoSuchElementException();

		}
		Node curr = first;
		Node nextNode = first.getNext().getNext();
		if(index == 0)
		{
			curr = first;
			//first.setNext(first.getNext());

		}
		else {
			int counter = 0;

			while (counter <= index - 1 && nextNode != null) {

				curr = curr.getNext();
				nextNode = curr.getNext();
				counter++;
			}
		}
		T element = (T)curr.getElement();
		System.out.println( element);
		return element;
	}
	/**
	 * Removes and returns the element at the specified index. Throws
	 * a noSuchElementException if the index is out of bounds.
	 *  
	 * @param index - position of the element to remove
	 * @return the element that was removed
	 * @throws NoSuchElementException
	 */
	public T removeElement(int index) throws NoSuchElementException
	{
		//Node target = first.getNext();

		if(index > size() || index < 0 || first.getNext().getNext() == null)
		{
			throw new NoSuchElementException();

		}
		Node curr = first;
		Node nextNode = first.getNext().getNext();
		if(index == 0)
		{
			nextNode = first;
			first = first.getNext();
			//first.setNext(first.getNext());

		}
		else {
			int counter = 0;

			while (counter != index -1 && nextNode != null) {

				curr = curr.getNext();
				nextNode = curr.getNext();
				counter++;
			}
			Node temp = curr;
			curr.setNext(temp.getPrevious());

			curr.setNext(temp.getNext());
			temp = null;


			//T element = (T) temp.getElement();
			T element1 = (T) curr.getElement();
			T element2 = (T) nextNode.getElement();
			System.out.println( counter +"  " + index + "   " + "" + element1 + "" + element2);

			//current.setNext(null);
		}

		T element = (T)nextNode.getElement();
		if(element == null)
		{
			element = (T)curr.getElement();
		}
		System.out.println( element);
		size--;
		return element;
		//YOU NEED TO ADD CODE HERE!
	}
	
	/**
	 * Returns the number of elements in the list.
	 */
	public int size() {
		return size;
	}

	public String toString()
	{
		Node test;
		test = first;
		String toReturn = "The elements of this list are: ";
		while(test != null)
		{
				toReturn += test.getElement();
				test = test.getNext();
		}
		return toReturn;
	}
	public T peekfirst()
	{
		T element = first.getElement();
		return element;
	}
	
}
