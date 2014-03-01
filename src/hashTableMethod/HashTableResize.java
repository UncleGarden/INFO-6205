/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashTableMethod;

/**
 *
 * @author Jiateng
 */
public class HashTableResize {

    String[] table = new String[1];
    int step = 0;
    int searchStep = 0;
    int count = 0;
    float factor = (float) 0.1;
    int x;

    public HashTableResize() {
    }

    public void insert(String[] s) {

        for (int i = 0; i < s.length; i++) {

            if (s[i] == null) {
                continue;
            }

            char[] c = s[i].toCharArray();
            //System.out.println((int) c[0]);

            switch ((int) c[0] % 9) {
                case 1:
                    x = APHash(s[i]);
                case 2:
                    x = BKDRHash(s[i]);
                case 3:
                    x = DEKHash(s[i]);
                case 4:
                    x = DJBHash(s[i]);
                case 5:
                    x = ELFHash(s[i]);
                case 6:
                    x = JSHash(s[i]);
                case 7:
                    x = PJWHash(s[i]);
                case 8:
                    x = RSHash(s[i]);
                case 9:
                    x = SDBMHash(s[i]);
            }

            insertAux(x, 0, s[i]);
        }
        System.out.println("Count:" + count);
    }

    public void insertAux(int x, int step, String str) {

        //check load factor
        if ((float) (count / table.length) >= factor) {
            resize(2 * table.length);
        }

        int position = x + step;

        if (table[position % table.length] != null) {
            insertAux(x, ++step, str);
        } else {
            table[position % table.length] = str;
            count++;
        }
    }

    public void resize(int capacity) {

        String[] copy = new String[capacity];

        String[] temp = new String[table.length];
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                temp[i] = table[i];
            }
            //temp = table;
        }
        table = copy;
        insert(temp);
    }

    public void search(String s) {

        char[] c = s.toCharArray();

        switch ((int) c[0] % 9) {
            case 1:
                x = APHash(s);
            case 2:
                x = BKDRHash(s);
            case 3:
                x = DEKHash(s);
            case 4:
                x = DJBHash(s);
            case 5:
                x = ELFHash(s);
            case 6:
                x = JSHash(s);
            case 7:
                x = PJWHash(s);
            case 8:
                x = RSHash(s);
            case 9:
                x = SDBMHash(s);
        }

        searchAux(x, 0, s);
    }

    public String searchAux(int x, int searchStep, String s) {

        int position = x + searchStep;

        int index = x;

        if (index == (position + 1) % table.length) {
            return null;
        }

        if (table[position % table.length] == s) {
            System.out.println("Find key: " + x + " value: " + s);
        } else {
            searchAux(x, ++searchStep, s);
        }
        return null;
    }

    public int RSHash(String str) {

        int a = 378551;
        int b = 63689;
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = hash * a + str.charAt(i);
            hash = Math.abs(hash % table.length);
            a = a * b;
        }
        return hash;
    }

    public int APHash(String str) {
        int hash = 0xAAAAAAAA;
        for (int i = 0; i < str.length(); i++) {
            if ((i & 1) == 0) {
                hash ^= ((hash << 7) ^ str.charAt(i) * (hash >> 3));
            } else {
                hash ^= (~((hash << 11) + str.charAt(i) ^ (hash >> 5)));
            }
            hash = Math.abs(hash % table.length);
        }
        return hash;
    }

    public int BKDRHash(String str) {
        int seed = 131; // 31 131 1313 13131 131313 etc..  
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash * seed) + str.charAt(i);
            hash = Math.abs(hash % table.length);
        }
        return hash;
    }

    public int DEKHash(String str) {
        int hash = str.length();
        for (int i = 0; i < str.length(); i++) {
            hash = ((hash << 5) ^ (hash >> 27)) ^ str.charAt(i);
            hash = Math.abs(hash % table.length);
        }
        return hash;
    }

    public int DJBHash(String str) {
        int hash = 5381;
        for (int i = 0; i < str.length(); i++) {
            hash = ((hash << 5) + hash) + str.charAt(i);
            hash = Math.abs(hash % table.length);
        }
        return hash;
    }

    public int ELFHash(String str) {
        int hash = 0;
        long x = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash << 4) + str.charAt(i);
            if ((x = hash & 0xF0000000L) != 0) {
                hash ^= (x >> 24);
            }
            hash &= ~x;
            hash = Math.abs(hash % table.length);
        }
        return hash;
    }

    public int JSHash(String str) {

        int hash = 1315423911;

        for (int i = 0; i < str.length(); i++) {
            hash ^= ((hash << 5) + str.charAt(i) + (hash >> 2));
            hash = Math.abs(hash % table.length);
        }
        return hash;
    }

    public int PJWHash(String str) {

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
            hash = Math.abs(hash % table.length);
        }
        return hash;
    }

    public int SDBMHash(String str) {
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash;
            hash = Math.abs(hash % table.length);
        }
        return hash;
    }
}
