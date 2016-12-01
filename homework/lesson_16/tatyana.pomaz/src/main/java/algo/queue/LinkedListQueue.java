package algo.queue;

public class LinkedListQueue<T> implements Queue<T> {
  private LinkList<T> linkList;
  
  public LinkedListQueue() {
	linkList = new LinkList<>();  
  }
  
  public void enqueue(T item) {
	linkList.addLast(item);
  }

  public T dequeue() {
    T temp = linkList.getFirst();
    linkList.deleteFirst();
    return temp;	
  }
  
	
  private class LinkList<T> {
	private Node<T> first;
    private Node<T>	last;
		
    private class Node<T> {
      T value;
      Node<T> next;
	  Node<T> previous;

      private Node(T value) {
        this.value = value;
      }
    }
	
	public void addLast(T item) {
      Node<T> newNode = new Node<>(item);
	  if (isEmpty()) {
	    first = newNode;
	  } else {
		last.next = newNode; 
		newNode.previous = last; 		
	  }
	  last = newNode;
	}
	
	public T getFirst() {
	  return first.value;
	}
	
	public void deleteFirst() {
	  first = first.next;	
	}
	
	private boolean isEmpty() {
	  return first == null;
	}
  }
}