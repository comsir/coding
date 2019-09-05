package test;

public class myHashMap<K,V> {

    private Entry[] table;
    private static Integer CAPACITY = 8;
    private int size = 0;
    public myHashMap() {
        this.table = new Entry[CAPACITY];
    }

    public int size(){
        return size;
    }
    public Object get(Object key) {
        int hashcode = key.hashCode();
        int index = hashcode%8;
        for(Entry<K, V> entry = table[index];entry!=null;entry = entry.next) {
            if(entry.k.equals(key)) {

                return entry.v;
            }
        }
        return null;
    }
    //泛型对Object的运用
    public Object put( K key, V value) {
        //当一个entry进来之后 要放到数组里 第一步 就是找下标志 用hashcode
        int hashcode = key.hashCode();
        int index = hashcode%8;

        //如果产生了hash冲突 就需要放到链表中 头插法
        //链表的头节点就是数组位置

        //遍历链表
        for(Entry<K, V> entry = table[index];entry!=null;entry = entry.next) {
            if(entry.k.equals(key)) {
                V oldvalue = entry.v;
                entry.v = value;
                return oldvalue;
            }
        }

        addNode(key, value, index);

        return null;
    }

    private void addNode(K key, V value, int index) {
        Entry entry = new Entry(key, value, table[index]);
        //这个下移的过程不好理解
        table[index] = entry;
        size++;
    }

    class Entry<K, V> {
        private K k;
        private V v;
        private Entry<K, V> next;

        public Entry(K k, V v, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        public K getK() {
            return k;
        }

        public V getV() {
            return v;
        }

        public Entry<K, V> getNext() {
            return next;
        }
    }

    public static void main(String[] args) {
        myHashMap<String, String> map = new myHashMap<String, String>();
        map.put("1", "song");
        System.out.println(map.get("1"));

    }
}
