/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generateArray;

import java.io.IOException;
import java.util.UUID;

/**
 *
 * @author Jiateng
 */
public class GenerateArray {

    /**
     * generate the array
     *
     * @param capacity
     * @return
     * @throws IOException
     */
    public static String[] generateArray(int capacity) throws IOException {
        String[] array = new String[capacity];
        int i;

        for (i = 0; i < capacity; i++) {
            UUID id = UUID.randomUUID();
            array[i] = id.toString();
            //System.out.println(array[i]);
        }

        return array;

    }
}
