package com.codingdojo.dll;
public class DLLTest {
    public static void main(String[] args) {
        DLL dll = new DLL();
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(50);
        Node n4 = new Node(60);
        Node n5 = new Node(80);
        Node n6 = new Node(100);
        
        dll.push(n1);
        dll.push(n2);
        dll.push(n3);
        dll.push(n4);
        dll.push(n5);
        dll.push(n6);
        
        dll.printValuesForward();
        dll.printValuesBackward();
        
        System.out.println(dll.pop().value+" was removed ");
        dll.printValuesForward();
        
        System.out.println(dll.contains(50));
        System.out.println(dll.contains(100));
        System.out.println(dll.size());
        
        Node n7 = new Node(150);
        dll.insertAt(n7, 0);
        dll.printValuesForward();
        
        Node n8 = new Node(33);
        dll.insertAt(n8, 5);
        dll.printValuesForward();
        
        dll.removeAt(2);
        dll.printValuesForward();

    }
}
