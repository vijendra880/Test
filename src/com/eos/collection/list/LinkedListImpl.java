package com.eos.collection.list;

import java.util.HashMap;
import java.util.Map;

public class LinkedListImpl<K> {

    ListNode head;

    public void addLast(K data) {
        ListNode listNode = new ListNode(data);
        if (head == null) {
            head = listNode;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = listNode;
        }
    }


    public void addFirst(K data) {
        ListNode listNode = new ListNode(data);
        listNode.next = head;
        head = listNode;
    }

    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + ",");
            temp = temp.next;
        }
        System.out.println();
    }

    public void removeDuplicate() {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            while (temp != null && temp.next != null && temp.data == temp.next.data) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    }

    public void check() {
        ListNode temp = head;
        temp.next = null;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1, t2 = l2, result = null, temp = null;
        int carry = 0;
        while (t1 != null && t2 != null) {
            int sum = (int) t1.data + (int) t2.data + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            if (result == null) {
                result = node;
            } else {
                temp.next = node;
            }
            temp = node;
            t1 = t1.next;
            t2 = t2.next;
        }
        while (t1 != null) {
            int sum = (int) t1.data + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = node;
            t1 = t1.next;
        }
        while (t2 != null) {
            int sum = (int) t2.data + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = node;
            t2 = t2.next;
        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return result;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null, temp = head;
        while (temp != null && temp.next != null) {
            ListNode temp1 = temp.next;
            int count = 1;
            while (temp1 != null && temp.data == temp1.data) {
                count++;
                temp1 = temp1.next;
            }
            if (count > 1) {
                if (prev == null) {
                    head = temp1;
                } else {
                    prev.next = temp1;
                }
            } else {
                if (prev == null) {
                    head = temp;
                }
                prev = temp;

            }
            temp = temp1;
        }
        return head;
    }
}

class ListNode<K> {

    ListNode(K data) {
        this.data = data;
    }

    K data;
    ListNode next;
    ListNode random;
}

class LinkedListDriver {

    public static void main(String args[]) {
    /*LinkedListImpl list1 = new LinkedListImpl();
    list1.addLast(2);
    list1.addLast(4);
    list1.addLast(3);
    LinkedListImpl list2 = new LinkedListImpl();
    list2.addLast(5);
    list2.addLast(6);
    list2.addLast(4);
    ListNode result =LinkedListImpl.addTwoNumbers(list1.head,list2.head);*/
        LinkedListImpl list = new LinkedListImpl();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(3);
        list.addLast(4);
        list.addLast(4);
        list.addLast(5);
        //ListNode result = list.deleteDuplicates(list.head);
        //printList(result);
    }

    private static void printList(ListNode result) {
        ListNode temp = result;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}
