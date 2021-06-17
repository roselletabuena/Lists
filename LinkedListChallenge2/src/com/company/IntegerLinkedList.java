package com.company;

public class IntegerLinkedList {

    private IntegerNode head;
    private int size;

    public void addToFront(Integer value) {
        IntegerNode node = new IntegerNode(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public void addToEnd(Integer value) {

        IntegerNode node = new IntegerNode(value);
        IntegerNode current = head;
        int size = getSize();
        while (size > 0) {
            if(size == 1) {
                current.setNext(node);
            }
            size--;
        }
        size++;
    }

    public IntegerNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        IntegerNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public void insertSorted(Integer value) {

//        IntegerNode current = head;
//        IntegerNode newNode = new IntegerNode(value);
//
//        if(current == null) {
//            newNode.setNext(head);
//            head = newNode;
//            size++;
//            return;
//        }
//
//        if(current.getValue() > value) {
//            addToFront(value);
//        } else {
//            IntegerNode curr = head;
//            while (curr != null && curr.getValue() < value) {
//                if(curr.getNext() == null) break;
//                curr = curr.getNext();
//            }
//
//            newNode.setNext(curr.getNext());
//            curr.setNext(newNode);
//        }

        if(head == null || head.getValue() >= value) {
            addToFront(value);
            return;
        }

        // find the insertion point
        IntegerNode current = head.getNext();
        IntegerNode previous = head;

        while (current != null && current.getValue() < value) {
            previous = current;
            current = current.getNext();
        }

        IntegerNode newNode = new IntegerNode(value);
        newNode.setNext(current);
        previous.setNext(newNode);

        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        IntegerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
