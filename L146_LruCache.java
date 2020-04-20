import java.util.HashMap;
import java.util.Map;

/**
 * @author Jelly
 * @version 1.0.0
 * @ClassName L146_LruCache.java
 * @Description TODO
 * @createTime 2020年04月20日 22:23:00
 */
public class L146_LruCache {
    class LRUCache {

        private Map<Integer,Node> map;
        private DoubleList doubleList;
        private int cap;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            doubleList = new DoubleList();
            this.cap = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                int value = map.get(key).value;
                put(key, value);
                return value;
            }
            return -1;
        }

        public void put(int key, int value) {

            Node node = new Node(key, value);

            if (map.containsKey(key)) {
                doubleList.remove(map.get(key));
                doubleList.addFirst(node);
                map.put(key, node);
                return;
            }

            if (doubleList.getSize()>=cap) {
                Node delNode = doubleList.removeLast();
                map.remove(delNode.key);
            }

            map.put(key,node);
            doubleList.addFirst(node);
        }
    }

    class Node {
        private int key,value;
        private Node pre,next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleList{
        private Node head,tail;
        private int size;

        DoubleList() {
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.pre = head;
            int size = 0;
        }

        public void addFirst(Node x) {
            x.next = head.next;
            x.pre = head;
            head.next.pre = x;
            head.next = x;
            size++;
        }

        public void remove(Node x) {
            x.pre.next = x.next;
            x.next.pre = x.pre;
            size--;
        }

        /**
         * 去除左后一个节点，注意非尾结点
         * @return
         */
        public Node removeLast() {
            if (tail.pre == head) {
                return null;
            }
            Node last = tail.pre;
            remove(last);
            return last;
        }

        public int getSize() {
            return size;
        }
    }
}
