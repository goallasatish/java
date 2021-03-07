package com.java.util.sample;

class DoublyLinkedList<T> {

	class Node<T> {
		T item;
		Node<T> previous;
		Node<T> next;

		public Node(T item) {
			this.item = item;
		}
	}

	Node<T> head, tail = null;

	public void addNodeFirst(T item) {
		
		Node<T> nodeFirst = new Node<T>(item);

		if (head == null) {
			head = tail = nodeFirst;
			head.previous = null;
			tail.next = null;
		} else {

			head.previous = nodeFirst;
			nodeFirst.next = head;
			nodeFirst.previous = null;
			head = nodeFirst;
		}
	}

	public void addNodeLast(T item) {
		
		Node<T> nodeLast = new Node<T>(item);
		if (head == null) {
			head = tail = nodeLast;
			head.previous = null;
			tail.next = null;
		} else {
			tail.next = nodeLast;
			nodeLast.previous = tail;
			tail = nodeLast;
			tail.next = null;
		}
	}

	public int countNodes() {
		
		int counter = 0;
		Node<T> current = head;

		while (current != null) {
			counter++;
			current = current.next;
		}
		return counter;
	}

	public void addNodeAtIndex(T item, int index) {
		
		int count = countNodes();
		if (item == null) {
			return;
		}
		if (index == 0) {
			addNodeFirst(item);
			return;
		}
		Node<T> node = new Node<T>(item);
		
		if (head == null) {
			head = node;
			tail = node;
		} else if (index == 0) {
			node.next = head;
			head.previous = node;
			head = node;
		} else if (index == count) {
			node.previous = tail;
			tail.next = node;
			tail = node;
		} else {
			Node<T> nodeRef = head;
			for (int i = 1; i < index; i++) {
				nodeRef = nodeRef.next;
			}

			node.next = nodeRef.next;
			nodeRef.next = node;
			node.previous = nodeRef;
			node.next.previous = node;
		}
		count++;
	}

	void deleteNodeFromList(Node<T> del) {

		if (head == null || del == null) {
			return;
		}
		if (head == del) {
			head = del.next;
		}
		if (del.next != null) {
			del.next.previous = del.previous;
		}
		if (del.previous != null) {
			del.previous.next = del.next;
		}
		return;
	}

	public void deleteNodeAtIndex(int n) {
		
		if (head == null || n <= 0) {
			return;
		}
		Node<T> current = head;
		for (int i = 1; current != null && i < n; i++) {
			current = current.next;
		}
		if (current == null) {
			return;
		}
		deleteNodeFromList(current);
	}

	public void printNode() {
		Node<T> curr = head;
		if (head == null) {
			System.out.println("Node not available in list");
			return;
		}
		while (curr != null) {

			System.out.print(curr.item + " ");
			curr = curr.next;
		}
		System.out.println();
	}
}

public class Double {

	public static void main(String[] args) {
		DoublyLinkedList dlList = new DoublyLinkedList();
		dlList.addNodeFirst(1);
		dlList.printNode();
		dlList.addNodeFirst("satish");
		dlList.printNode();
		dlList.addNodeLast(2.5);
		dlList.printNode();
		dlList.addNodeAtIndex("goalla", 1);
		dlList.printNode();
		System.out.println("After First Node Delete");
		dlList.deleteNodeFromList(dlList.head);
		dlList.printNode();
		System.out.println("After Last Node Delete");
		dlList.deleteNodeFromList(dlList.tail);
		dlList.printNode();
		System.out.println("After index Node Delete");
		dlList.deleteNodeAtIndex(2);
		dlList.printNode();
	}
}
