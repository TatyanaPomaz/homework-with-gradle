package algo.stack;

public class LinkedListStack<T> implements Stack<T>{
  private LinkList linkList;
  
  public LinkedListStack() {
	  linkList = new LinkList();
  }
  
  public void push(T item) {
    linkList.addFirst(item);
  } 
  
  public T pop() {
	T temp = linkList.getFirst(); 
	linkList.deleteFirst();
	return temp;
  }
   
  
  private class LinkList {
    private Node<T> first;
	
	private class Node<T> {
      T value;
      Node<T> next;

      private Node(T value) {
        this.value = value;
      }
    }

	public void addFirst(T item) {
      Node<T> newNode = new Node<T>(item);
      newNode.next = first;
	  first = newNode;
    }
  
    public T getFirst() {
	  return first.value; 	
	}
	
    public void deleteFirst() {
	  first = first.next;
    }
  
    public boolean isEmpty() {
	  return first == null;
	}
  }
}