package top.auntie.leetcode;

public class Code2 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        addSingleNumber(l1, l2, result);
        return result;
    }

    private void addSingleNumber(ListNode l1, ListNode l2, ListNode result) {
        boolean isCarry = addNum(l1, l2, result);
        while (isCarry) {
            isCarry = addNum(getNext(result), new ListNode(1), getNext(result));
        }
        if (l1.next == null && l2.next == null) {
            return;
        } else {
            getNext(l1);
            getNext(l2);
        }
        addSingleNumber(l1.next, l2.next, getNext(result));
    }

    private ListNode getNext(ListNode result) {
        if (result.next == null) {
            result.next = new ListNode(0);
        }
        return result.next;
    }

    private boolean addNum(ListNode i1, ListNode i2, ListNode result) {
        i1 = i1 == null ? new ListNode(0) : i1;
        i2 = i2 == null ? new ListNode(0) : i2;
        int sum = i1.val + i2.val;
        result.val += sum % 10;
        doCarry(result);
        return sum / 10 > 0;
    }

    private void doCarry(ListNode result) {
        if (result.val >= 10) {
            getNext(result).val += 1;
            result.val = result.val % 10;
        }
    }

}
