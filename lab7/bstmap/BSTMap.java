package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left, right;
        private int size;

        public Node(K key, V val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node x, K key) {
        if (x == null || key == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        }
        else { return x.val; }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) { return 0; }
        else { return x.size; }
    }

    @Override
    public boolean containsKey(K key) {
        return containsKey(root, key);
    }

    private boolean containsKey(Node x, K key) {
        if (x == null || key == null) { return false; }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) { return containsKey(x.left, key); }
        else if (cmp > 0) { return containsKey(x.right, key); }
        else { return true; }
    }

    @Override
    public void put(K key, V val) {
        if (key == null) { throw new IllegalArgumentException("calls put() with a null key"); }
        root = put(root, key, val);
    }

    private Node put(Node x, K key, V val) {
        if (x == null) { return new Node(key, val, 1); }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) { x.right = put(x.right, key, val); }
        else if (cmp < 0) { x.left = put(x.left, key, val); }
        else { x.val = val; }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    @Override
    public V remove(K key) {
        if (!containsKey(key)) {
            return null;
        }
        V removeVal = get(key);
        root = remove(root, key);
        return removeVal;
    }

    private Node remove(Node x, K key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = remove(x.right, key);
        } else if (cmp < 0) {
            x.left = remove(x.left, key);
        } else {
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            Node temp = x;
            x = min(temp.right);
            x.right = removeMin(temp.right);
            x.left = temp.left;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }

    private Node removeMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = removeMin(x.left);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    @Override
    public V remove(K key, V value) {
        V removeVal = get(key);
        if (removeVal != value) {
            return null;
        }
        root = remove(root, key);
        return value;
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}

