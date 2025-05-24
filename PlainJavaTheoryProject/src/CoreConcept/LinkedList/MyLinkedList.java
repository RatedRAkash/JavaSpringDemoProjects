package CoreConcept.LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MyLinkedList {
    ListNode root;

    MyLinkedList(int val) {
        root = new ListNode(val);
    }

    void addNode(int val) {
        if (root != null) {
            ListNode current = root;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(val);
        }
    }

    ListNode deleteNode(int valueToBeDeleted){
        ListNode dummy = new ListNode();
        dummy.next = root;

        ListNode current = root;
        ListNode prev = dummy;

        while(current!=null){
            if(current.val == valueToBeDeleted){
                prev.next = current.next;
                break;
            }

            // we can Do this or, "prev = current"
//            prev = prev.next;
            prev = current;
            current = current.next;
        }

        return dummy.next;
    }

    ListNode reverseLinkedList(ListNode root) {
        ListNode current = root;
        ListNode prev = null;

        while(current!=null){
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        // as "current" is pointing to "null"... that means, "prev" is Pointing to the Last Node, so we return that
        return prev;
    }


    void printLinkedList() {
        System.out.print("Linked List:   ");
        if (root != null) {
            ListNode current = root;
            while (current != null) {
                System.out.print(current.val);
                current = current.next;

                // for Last Element we are Not Printing the "->"
                if(current!=null){
                    System.out.print("->");
                }
            }
        }

        System.out.println();
    }
}

class Main{
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(2);
        list.addNode(1);
        list.addNode(55);
        list.addNode(58);
        list.addNode(6);
        list.addNode(51);
        list.printLinkedList();

        list.root = list.deleteNode(58);
        list.printLinkedList();

        list.root = list.reverseLinkedList(list.root);
        list.printLinkedList();
    }
}