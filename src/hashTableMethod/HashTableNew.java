/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashTableMethod;

import hashMethod.RSHash;

/**
 *
 * @author Jiateng
 */
public class HashTableNew {

    String[] table = new String[1];
    int step = 0;
    int count = 0;
    float factor = (float) 0.5;

    public HashTableNew() {
    }

    public void insert(String[] s) {

        for (int i = 0; i < s.length; i++) {
            int x = RSHash.RSHash(s[i]);
            System.out.println(x);
            insertAux(x, 0, s[i]);
        }
    }

    public void insertAux(int x, int step, String str) {

        //check load factor
        if ((float) (count / table.length) >= factor) {
            //String[] table = new String[1000];
        }

        int position = x + step;

        if (table[position % table.length] != null) {
            insertAux(x, ++step, str);
        } else {
            table[position % table.length] = str;
            count++;
        }
    }
}
