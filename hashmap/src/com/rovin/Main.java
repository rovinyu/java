package com.rovin;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Map map = new HashMap();
        map.put("a", "aaa");
        map.put("b", "bbb");
        map.put("c", "ccc");
        map.put("d", "ddd");

        Iterator it = map.keySet().iterator();

        while (it.hasNext()) {
            Object key = it.next();
            System.out.println("key is: "+ key + " map.get(key) is: " + map.get(key));
        }

        Hashtable tab = new Hashtable();
        tab.put("a", "aaa");
        tab.put("b", "bbb");
        tab.put("c", "ccc");
        tab.put("d", "ddd");

        /*
        it = tab.keySet().iterator();
        while (it.hasNext()) {
            Object key = it.next();
            System.out.println("key is " + key + " tab.get(key) is: " + tab.get(key));
        }
        */
        for(Object key: tab.keySet()) {
            System.out.println("key is " + key + " tab.get(key) is: " + tab.get(key));
        }


        TreeMap tree = new TreeMap();
        tree.put("a", "aaa");
        tree.put("b", "bbb");
        tree.put("c", "ccc");
        tree.put("d", "ddd");

        it = tree.keySet().iterator();
        while (it.hasNext()) {
            Object key = it.next();
            System.out.println("key is: " + key + " tree.get(key) is: " + tree.get(key));
        }
    }
}
