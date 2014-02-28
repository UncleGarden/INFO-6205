/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashTableMethod;

import hashMethod.APHash;
import hashMethod.BKDRHash;
import hashMethod.DEKHash;
import hashMethod.DJBHash;
import hashMethod.ELFHash;
import hashMethod.JSHash;
import hashMethod.PJWHash;
import hashMethod.RSHash;
import hashMethod.SDBMHash;

/**
 *
 * @author Jiateng
 */
public class HashTableResize {

    String[] table = new String[1];
    int step = 0;
    int count = 0;
    float factor = (float) 0.5;
    int x;

    public HashTableResize() {
    }

    public void insert(String[] s) {

        for (int i = 0; i < s.length; i++) {
            char[] c = s[i].toCharArray();
            //System.out.println((int) c[0]);

            switch ((int) c[0] % 9) {
                case 1:
                    x = APHash.APHash(s[i]);
                case 2:
                    x = BKDRHash.BKDRHash(s[i]);
                case 3:
                    x = DEKHash.DEKHash(s[i]);
                case 4:
                    x = DJBHash.DJBHash(s[i]);
                case 5:
                    x = ELFHash.ELFHash(s[i]);
                case 6:
                    x = JSHash.JSHash(s[i]);
                case 7:
                    x = PJWHash.PJWHash(s[i]);
                case 8:
                    x = RSHash.RSHash(s[i]);
                case 9:
                    x = SDBMHash.SDBMHash(s[i]);
            }

            System.out.println(x);
            insertAux(x, 0, s[i]);
        }
        System.out.println("Count:" + count);

        //worst case
//        for (int i = 0; i < s.length; i++) {
//            int x = RSHash.RSHash(s[0]);
//            System.out.println(x);
//            insertAux(x, 0, s[i]);
//        }
//        System.out.println("Count:" + count);
    }

    public void insertAux(int x, int step, String str) {

        //check load factor
        if ((float) (count / table.length) >= factor) {
            resize(2 * table.length);
        }

        int position = x + step;

        if (table[position % table.length] != null) {
            insertAux(x, ++step, str);
        } else {
            table[position % table.length] = str;
            count++;
        }
    }

    public void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < capacity / 2; i++) {
            copy[i] = table[i];
            table = copy;
        }
    }
}
