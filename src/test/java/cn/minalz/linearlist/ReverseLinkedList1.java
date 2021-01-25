package cn.minalz.linearlist;

public class ReverseLinkedList1 {
    public ListNode reverseList(ListNode head) {
      if (head == null) {
         return null;
      }
        // 1 -> 2 -> 3 -> 4 -> 5
        //prev = 1
        // current = 2;
      ListNode prev = head;
      ListNode current = head.next;
        // 1  2 -> 3 -> 4 -> 5
        // prev = 1
        // current = 2;
      prev.next = null;
      while (current != null) {
          // First time
          /*
          next = 3
          1  <- 2  3 -> 4 -> 5
          prev = 2
          current = 3
          */
          // Second time
          /*
          next = 4
          1  <- 2 <- 3  4 -> 5
          prev = 3
          current = 4
          */
          // third time
          /*
          next = 5
          1  <- 2 <- 3 <- 4 5
          prev = 4
          current = 5
          */
          // fourth time
          /*
          next = null
          1  <- 2 <- 3 <- 4 <-5
          prev = 5
          current = null
          */
          ListNode next = current.next;
          current.next = prev;
          prev = current;
          current = next;
      }
        //exit
        //return prev = 5
      return prev;
    }
}