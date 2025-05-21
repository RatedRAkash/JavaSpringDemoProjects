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

    void printLinkedList() {
        System.out.println("Linked List:");
        if (root != null) {
            ListNode current = root;
            while (current != null) {
                System.out.println(current.val);
                current = current.next;
            }
        }
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
    }
}