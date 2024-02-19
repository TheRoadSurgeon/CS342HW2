import java.util.Iterator;

public class LinkedListDictionary<K ,V> implements Dictionary<K,V>{

    private Node front;
    private Node back;
    private int size;

    private class Node{
        K key;
        V value;
        Node next;
        Node(K newKey, V newValue){
            super();
            key = newKey;
            value = newValue;
        }
    }

    private class LinkedListIterator implements Iterator<K> {
        Node cursor;
        private LinkedListIterator() {
            cursor = front;
        }
        @Override
        public boolean hasNext() {
            return cursor != null;
        }
        @Override
        public K next() {
            K toRet = cursor.key;
            cursor = cursor.next;
            return toRet;
        }
    }

    @Override
    public void insert(K key, V value) {
        Node toAdd = new Node(key,value);
        if(front == null){
            front = toAdd;
            back = toAdd;
            size = 1;
        } else {
            back.next = toAdd;
            back = back.next;
            size++;
        }
    }

    @Override
    public V find(K key) {
        Node cursor = front;
        while(cursor != null){
            if (cursor.key.equals(key)){
                return cursor.value;
            }
            cursor = cursor.next;
        }
        return null;
    }

    @Override
    public boolean delete(K key) {

        if(front == null){
            return false;
        }

        if(front.key.equals(key)){
            if(front.next == null){
                front = null;
                back = null;
            }
            else{
                front = front.next;
            }
            size--;
            return true;
        }


        Node cursor = front;
        while(cursor.next != null){
            if (cursor.next.key.equals(key)){
                cursor.next = cursor.next.next;
                if(cursor.next == null){
                    back = cursor;
                }
                size--;
                return true;
            }

            cursor = cursor.next;
        }


        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<K> iterator() {
        return new LinkedListIterator();
    }
}
