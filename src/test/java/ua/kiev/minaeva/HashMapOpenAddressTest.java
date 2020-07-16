package ua.kiev.minaeva;

import org.junit.Test;

public class HashMapOpenAddressTest {

    @Test
    public void createHashMap() {

        HashMapOpenAddress hashMap = new HashMapOpenAddress(32);
        for (int i = -544; i > -550; i--) {
            System.out.println("i = " + i + ", hash = " + hashMap.hash(i) + ", index = " + hashMap.index(hashMap.hash(i)));
        }
        for (int i = 2; i < 83; i += 10) {
            System.out.println("i = " + i + ", hash = " + hashMap.hash(i) + ", index = " + hashMap.index(hashMap.hash(i)));
        }
    }

}
