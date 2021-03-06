package leetCode.剑指Offer;

/**
 * 给定一个链表数组，每个链表都已经按升序排列。
 *
 * 请将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * */
public class 剑指Offer_078_合并排序链表 {


    private ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (ListNode list : lists) {
            res = mergeTwo(res, list);
        }
        return res;
    }

    private ListNode mergeTwo(ListNode a, ListNode b) {
        if (a==null||b==null){
           return a!=null?a:b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head,aPtr = a,bPtr = b;
        while(aPtr!=null&&bPtr!=null){
            if (aPtr.val<bPtr.val){
                tail.next = aPtr;
                aPtr = aPtr.next;
            }else{
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr!=null?aPtr:bPtr);
        return head.next;
    }
}
