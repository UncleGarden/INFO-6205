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
public class BKDRHash {

    public static int BKDRHash(String str) {
        int seed = 131; // 31 131 1313 13131 131313 etc..  
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash * seed) + str.charAt(i);
            hash = Math.abs(hash % str.length());
        }
        return hash;
    }

}
