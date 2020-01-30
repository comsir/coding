package JobFinding;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> map;
    int capacity,count;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }

    public void deleteNode(Node node) {
        //双向链表删除节点不需要前置节点
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(Node node) {
        //添加节点 需要维护两套指针
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public int get(int key) {
        if(map.get(key)!=null) {
            Node node = map.get(key);
            int result = node.value;
            //被调用后 删掉 重新放到最前面
            //用这种方法来实现 LRU最近最少使用
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return -1;
    }
    public void put(int key, int value) {
        if(map.get(key)!=null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }else {
            Node node = new Node(key, value);
            map.put(key, node);
            if(count < capacity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.pre.key); //移除最久没用的
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }
}
