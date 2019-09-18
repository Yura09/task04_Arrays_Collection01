package com.epam.collections.binaryTree;

public class BinaryTree<K, V> {

    private Tie root;

    public static class Tie<K, V> implements Comparable {
        K key;
        V value;
        Tie left;
        Tie right;
        Tie parent;

        Tie(K key, V value, Tie parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }


        public int compareTo(Object o) {
            return this.key.toString().compareTo(o.toString());
        }
    }

    private Tie find(Tie t, K key) {
        if (t == null || t.key == key)
            return t;
        if (key.toString().compareTo(t.key.toString()) < 0)
            return find(t.left, key);
        else
            return find(t.right, key);
    }

    public Tie find(K key) {
        return find(root, key);
    }

    private Tie put(Tie t, Tie p, K key, V value) {
        if (t == null) {
            t = new Tie(key, value, p);
        } else {
            if (key.toString().compareTo(t.key.toString()) > 0)
                t.left = put(t.left, t, key, value);
            else if (key.toString().compareTo(t.key.toString()) > 0)
                t = put(t, t, key, value);
            else
                t.right = put(t.right, t, key, value);
        }
        return t;
    }

    public void put(K key, V value) {
        root = put(root, null, key, value);
    }

    private void replace(Tie a, Tie b) {
        if (a.parent == null)
            root = b;
        else if (a == a.parent.left)
            a.parent.left = b;
        else
            a.parent.right = b;
        if (b != null)
            b.parent = a.parent;
    }

    private void delete(Tie t, K key) {
        if (t == null)
            return;
        if (key.toString().compareTo(t.key.toString()) < 0)
            delete(t.left, key);
        else if (key.toString().compareTo(t.key.toString()) > 0)
            delete(t.right, key);
        else if (t.left != null && t.right != null) {
            Tie m = t.right;
            while (m.left != null)
                m = m.left;
            t.key = m.key;
            t.value = m.value;
            replace(m, m.right);
        } else if (t.left != null) {
            replace(t, t.left);
        } else if (t.right != null) {
            replace(t, t.right);
        } else {
            replace(t, null);
        }
    }

    public void delete(K key) {
        delete(root, key);
    }

    private void showThisMap(Tie t) {
        if (t != null) {
            showThisMap(t.left);
            System.out.println(t.key + "      ||       " + t.value + " ");
            showThisMap(t.right);
        }
    }

    public void showThisMap() {
        showThisMap(root);
    }
}
