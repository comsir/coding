package JobFinding;

//约瑟夫环问题 直接构造循环链表解答
public class LastRemaining_Solution {
    public static void main(String[] args) {
        LastRemaining_Solution demo = new LastRemaining_Solution();
        System.out.println(demo.LastRemaining_Solution(3,4));

    }
    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    public int LastRemaining_Solution(int n, int m) {
        if(n==1)return 1;

        Node head = new Node(0);
        head.next = null;
        Node curr = head;
        for(int i=0;i<n;i++) {
            Node node = new Node(i);
            curr.next = node;
            curr = curr.next;
        }
        curr.next = head.next;
        curr = curr.next; //从0开始
        while(curr.next !=curr) {
            int tmp = m;
            while(tmp>2) {
                curr = curr.next;
                tmp--;
            }
            curr.next = curr.next.next;
            curr = curr.next;
        }
        return curr.val;
    }
}
