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
public class ELFHash {

    public static int ELFHash(String str) {
        int hash = 0;
        long x = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash << 4) + str.charAt(i);
            if ((x = hash & 0xF0000000L) != 0) {
                hash ^= (x >> 24);
            }
            hash &= ~x;
            hash = Math.abs(hash % str.length());
        }
        return hash;
    }

}
