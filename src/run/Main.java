/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import static generateArray.ArraySize.arraySize100;
import static generateArray.ArraySize.arraySize1000;
import static generateArray.ArraySize.arraySize2000;
import hashTableMethod.HashTableNew;
import hashTableMethod.HashTableResize;
import java.io.IOException;
import java.util.UUID;

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

        //for worst case
        String id = UUID.randomUUID().toString();

        String[] a = arraySize2000();
        //String[] a = arraySize1000();
        //String[] a = arraySize2000();

        long Start1 = System.nanoTime();
        HashTableResize htr = new HashTableResize();
        htr.insert(a);
        long End1 = System.nanoTime();
        System.out.println("Total Insert Time:" + (End1 - Start1));

        long SearchStart1 = System.nanoTime();
        htr.search(id);
        long SearchEnd1 = System.nanoTime();
        System.out.println("Total Search Time:" + (SearchEnd1 - SearchStart1));

        long Start2 = System.nanoTime();
        HashTableNew htn = new HashTableNew();
        htn.insert(a);
        long End2 = System.nanoTime();
        System.out.println("Total Insert Time:" + (End2 - Start2));

        long SearchStart2 = System.nanoTime();
        htr.search(id);
        long SearchEnd2 = System.nanoTime();
        System.out.println("Total Search Time:" + (SearchEnd2 - SearchStart2));
    }
}
