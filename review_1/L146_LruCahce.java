package review_1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jelly
 * @version 1.0.0
 * @ClassName L146_LruCahce.java
 * @Description TODO
 * @createTime 2020年07月19日 18:06:00
 */
public class L146_LruCahce {

    /**
     * map用来作为索引定位节点
     * 双链表用来保存节点，并借助固定大小cap，来保持Cache大小，使用双链表达到删除指定节点的效果
     * cap保持Cache大小
     */
    private Map<Integer,Node> map;
    private DoubleList list;
    private int capacity;

    /**
     * 初始化
     */
    public L146_LruCahce(int cap) {
        this.map = new HashMap<>();
        this.list = new DoubleList();
        this.capacity = cap;
    }

    /**
     * 向Cache添加
     * 如果key已存在，则删除掉原key对应的node，并重新添加node，这样既可以更新value值，同时也可以将新的KV放在最前面
     * 如果key不存在，则先判断Cache中node的数量是否已达到容量，达到容量则淘汰last节点，然后重新添加node
     */
    public void put(int key, int value) {
        Node x = new Node(key, value);
        if (map.containsKey(key)) {
            list.remove(map.get(key));
            list.addFirst(x);
            map.put(key, x);
            return;
        }
        if (list.getSize() >= capacity) {
            Node lastNode = list.removeLast();
            map.remove(lastNode.key);
        }
        list.addFirst(x);
        map.put(key, x);
    }

    /**
     * 从Cache中获取
     * 如果key存在于Map中，则去除其对应的value，同时重新插入KV达到更新此KV至第一位，然后返回value
     * 如果key不存在与Map中，则返回-1
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key).value;
            put(key, value);
            return value;
        }
        return -1;
    }

    class Node {
        private int key, value;
        private Node pre, next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleList {
        private Node head, tail;
        private int size;
        public DoubleList() {
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        public int getSize() {
            return size;
        }

        /**
         * 双向链表中插入一个节点的模板
         * 1. 被插入节点的头指针：x.pre
         * 2. 被插入节点的尾指针：x.next
         * 3. 原插入位置的头指针：head.next.pre
         * 4. 原插入位置的尾指针：head.next
         * 5. 链表长度+1
         */
        public void addFirst(Node x) {
            x.pre = head;
            x.next = head.next;
            head.next.pre = x;
            head.next = x;
            size++;
        }

        /**
         * 双向链表中删除指定节点模板
         * 1. 被删除节点的尾结点的头结点，指向被展出节点的头结点
         * 2. 被删除节点的头结点的尾结点，指向被删除节点的尾结点
         * 3. 链表长度-1
         */
        public void remove(Node x) {
            x.next.pre = x.pre;
            x.pre.next = x.next;
            size--;
        }

        /**
         * 双链表删除尾结点模板
         * 1. 判断双链表是否为空（头节点的尾指针指向尾结点）
         * 2. 获取尾结点tail.pre
         * 3. 借助remove删除指定节点
         */
        public Node removeLast() {
            if (head.next == tail) {
                return null;
            }
            Node lastNode = tail.pre;
            remove(lastNode);
            return lastNode;
        }
    }
}
