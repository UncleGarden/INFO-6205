/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generateArray;

import static generateArray.GenerateArray.generateArray;
import java.io.IOException;

/**
 *
 * @author Jiateng
 */
public class ArraySize {

    /**
     * array size 100
     *
     * @return @throws IOException
     */
    public static final String[] arraySize100() throws IOException {
        return generateArray(100);
    }

    /**
     * array size 1000
     *
     * @return
     * @throws IOException
     */
    public static final String[] arraySize1000() throws IOException {
        return generateArray(1000);
    }

    /**
     * array size 2000
     *
     * @return
     * @throws IOException
     */
    public static final String[] arraySize2000() throws IOException {
        return generateArray(2000);
    }

    /**
     * array size 5000
     *
     * @return
     * @throws IOException
     */
    public static final String[] arraySize5000() throws IOException {
        return generateArray(5000);
    }

    /**
     * array size 10000
     *
     * @return
     * @throws IOException
     */
    public static final String[] arraySize10000() throws IOException {
        return generateArray(10000);
    }
}
