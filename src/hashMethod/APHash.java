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
public class APHash {

    public static int APHash(String str) {
        int hash = 0xAAAAAAAA;
        for (int i = 0; i < str.length(); i++) {
            if ((i & 1) == 0) {
                hash ^= ((hash << 7) ^ str.charAt(i) * (hash >> 3));
            } else {
                hash ^= (~((hash << 11) + str.charAt(i) ^ (hash >> 5)));
            }
            hash = Math.abs(hash % str.length());
        }
        return hash;
    }
}
