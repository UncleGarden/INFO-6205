/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashMethod;

/**
 *
 * @author Jiateng
 */
public class JSHash {

    public static int JSHash(String str) {

        int hash = 1315423911;

        for (int i = 0; i < str.length(); i++) {
            hash ^= ((hash << 5) + str.charAt(i) + (hash >> 2));
            hash = Math.abs(hash % str.length());
        }
        return hash;
    }
}
