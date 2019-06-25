package song.tree.com;

/*
* 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
* 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
*
*
* 解题思路：
* 1.复制每一个节点 分别插入到源节点后面
* 2.遍历链表：node.random = root.random.next
* 3.拆分表格
* */
public class complexLinkedList {
    public static void main(String[] args) {

    }

    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null) return null;
        //1.复制
        RandomListNode cur = pHead;
        while (cur!=null) {
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        //2.node.random = pHead.random.next
        cur = pHead;

        while (cur!= null) {
            RandomListNode tmp_node = cur.next;
            if (cur.random != null) {
                tmp_node.random = cur.random.next;
            }
            cur = tmp_node.next;
        }

        //拆分
        cur = pHead;
        RandomListNode res = pHead.next;
        RandomListNode temps = null;
        while (cur.next != null) {
            temps = cur.next;
            cur.next = temps.next;
            cur = temps;
        }
        return res;
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
