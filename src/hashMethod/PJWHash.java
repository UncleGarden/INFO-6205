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
public class PJWHash {

    public static int PJWHash(String str) {

        int BitsInUnsignedInt = (int) (4 * 8);
        int ThreeQuarters = (int) ((BitsInUnsignedInt * 3) / 4);
        int OneEighth = (int) (BitsInUnsignedInt / 8);
        int HighBits = (int) (0xFFFFFFFF) << (BitsInUnsignedInt - OneEighth);
        int hash = 0;
        int test = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash << OneEighth) + str.charAt(i);
            if ((test = hash & HighBits) != 0) {
                hash = ((hash ^ (test >> ThreeQuarters)) & (~HighBits));
            }
            hash = Math.abs(hash % str.length());
        }
        return hash;
    }
}
