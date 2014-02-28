/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import static generateArray.ArraySize.arraySize100;
import hashTableMethod.HashTableNew;
import hashTableMethod.HashTableResize;
import java.io.IOException;

/**
 *
 * @author Jiateng
 */
public class Main {

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        String[] a = arraySize100();
        //String[] a = arraySize1000();
        //String[] a = arraySize2000();
        //String[] a = arraySize5000();
        //String[] a = arraySize10000();

        HashTableResize htr = new HashTableResize();
        htr.insert(a);

        //HashTableNew htn = new HashTableNew();
        //htn.insert(a);
    }
}
