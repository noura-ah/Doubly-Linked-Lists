package com.codingdojo.dll;

public class DLL {
    public Node head;
    public Node tail;
    
    public DLL() {
        this.head = null;
        this.tail = null;
    }
    
    // the push method will add a new node to the end of the list
    public void push(Node newNode) {
    	// if there is no head in the list, aka, an empty list, we set the newNode to be the head and tail of the list
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        
        // first find the lastNode in the list
        // then, set the lastNode's next to be the newNode;
        // then, we have to set the previous of the lastNode to the lastNode that we found previously.
        // finally, set the list's tail to be the node that we have added
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode;
    }
    
    public void printValuesForward() {
        // find the first node, aka head.
        Node current = this.head;
        
        // while the current node exists...
        while(current != null) {
            // print it's value
            System.out.println(current.value);
            // and move on to it's next node.
            current = current.next;
        }
    }
    public void printValuesBackward() {
    	Node current = this.tail;
        
        // while the current node exists...
        while(current != null) {
            // print it's value
            System.out.println(current.value);
            // and move on to it's next node.
            current = current.previous;
        }
    	
    }
    public Node pop() {
    	Node current = this.tail;
    	this.tail = this.tail.previous;
    	this.tail.next = null;
    	return current;
    	
    }
    
    public boolean contains(Integer value) {
    	Node current = this.head;
    	while(current != null ) {
    		if (current.value == value) {
    			return true;
    		}
    		current = current.next;
    	}
    	return false;
    }
    
    public int size() {
    	int count = 0;
    	Node current = this.head;
    	while(current != null ) {
    		count++;
    		current = current.next;
    	}
    	return count;
    }
    
    public void insertAt(Node newNode, int index) {
    	Node current = this.head;
    	if (index==0) {
    		this.head = newNode;
    		current.previous = newNode;
    	    this.head.next = current;
    	}
    	else if (index == size()) {
    		push(newNode);
    	}
    	else if (index > size()) {
    		System.out.println("index out of list range");
    	}
    	else {
		    for(int i=0 ;i < index ; i++) {
		        current = current.next;
		    	}
		    Node prev =current.previous;
		    prev.next =newNode;
		    newNode.previous = prev;
	
		    current.previous = newNode;
		    newNode.next = current;
    	}
    }
    public void removeAt(int index) {
    	Node current = this.head;
    	if (index==0) {
    		Node newHead = this.head.next;
    		newHead.previous = null;
    		this.head = newHead;
    	}
    	else if (index >= size()) {
    		System.out.println("index out of list range");
    	}
    	else if (index == size()-1) {
    		pop();
    	}
    	else {
		    for(int i=0 ;i < index; i++) {
		            	current = current.next;
		    	}
		    Node prev =current.previous;
		    prev.next =current.next;
		    current.next.previous = prev;
		    
    	}
    }
}
