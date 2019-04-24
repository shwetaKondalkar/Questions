package Datastructures;

public class linkedListOperations {



	static void reversePrint(SinglyLinkedListNode head) {

		if (head == null) {
			return;
		}
		reversePrint(head.next);
		System.out.println(head.data);
	}

	static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {

		SinglyLinkedListNode prev = null;
		SinglyLinkedListNode cur = head;
		SinglyLinkedListNode next = head.next;
		while (next != null) {
			cur.next = prev;
			prev = cur;
			cur = next;
			next = next.next;
		}
		// If here, then cur is at the last node (tail).
		cur.next = prev;
		return cur; // the new head.
	}

	static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

		while (head1 != null && head2 != null) {
			if (head1.data != head2.data) {
				return false;
			}
			head1 = head1.next;
			head2 = head2.next;

		}

		return (head1 == null && head2 == null);
	}



	static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {


		if (head1 == null && head2 == null) {
			return null;
		} else if (head1 == null) {
			return head2;
		} else if (head2 == null) {
			return head1;
		}
		SinglyLinkedListNode merge, ptr;
		if (head1.data < head2.data) {
			merge = head1;
			merge.next = mergeLists(head1.next, head2);
		} else {
			merge = head2;
			merge.next = mergeLists(head1, head2.next);
		}

		return merge;
	}


	static int getNode(SinglyLinkedListNode head, int positionFromTail) {

		SinglyLinkedListNode cur = head;
		SinglyLinkedListNode result = head;
		int idx = 0;
		while (cur.next != null) {
			cur = cur.next;
			if (idx >= positionFromTail) {
				result = result.next;
			}
			idx++;
		}
		return result.data;
	}


	static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
		SinglyLinkedListNode mainCur = head;
		while (mainCur != null) {
			SinglyLinkedListNode checkCur = mainCur.next;
			while (checkCur != null && checkCur.data == mainCur.data) {
				checkCur = checkCur.next;
			}
			mainCur.next = checkCur;
			mainCur = mainCur.next;
		}
		return head;
	}

	static boolean hasCycle(SinglyLinkedListNode head) {
		SinglyLinkedListNode slow = head;
		SinglyLinkedListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}
		}

		return false;

	}


}
