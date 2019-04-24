package Datastructures;

public class DoublyLLOperation {

	static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        if(head == null) {
           return null;
       }
       
       head.prev = head.next;
       head.next = null;
           
       while(head.prev != null) {
           head = head.prev;
           DoublyLinkedListNode tmp = head.next;
           head.next = head.prev;
           head.prev = tmp;
       }
           
       
       return head;

  

   }
	
}
