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
public class RSHash {

    public static int RSHash(String str) {

        int a = 378551;
        int b = 63689;
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = hash * a + str.charAt(i);
            hash = Math.abs(hash % str.length());
            a = a * b;
        }
        return hash;
    }

}
