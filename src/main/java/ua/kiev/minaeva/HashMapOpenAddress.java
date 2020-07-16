package ua.kiev.minaeva;

import java.util.Arrays;

/*
Hash Map с открытой адресацией, для ключей типа int и значений типа long.
Реализуйте операции put, get, size (remove не требуется, поддержка стандартного интерфейса Map не требуется).
Продемонстрируйте работоспособность реализации с помощью соответствующих тестов.
 */
public class HashMapOpenAddress {

    int free = Integer.MIN_VALUE;
    int size;
    int[] keys;
    long[] values;

    HashMapOpenAddress(int size) {
        this.size = Math.max(size, 3 * size / 2) + 1;
        keys = new int[this.size];
        values = new long[this.size];
        Arrays.fill(keys, free);
    }

    void put(int x, long y) {
        for (int i = index(hash(x)); ; i++) {
            if (i == size) {
                i = 0;
            }
            if (keys[i] == x) {
                values[i] = y;
                return;
            }
            if (keys[i] == free) {
                keys[i] = x;
            }
        }
    }

    long get(int x) {
        for (int i = index(hash(x)); ; i++) {
            if (i == size) {
                i = 0;
            }
            if (keys[i] == free) {
                throw new RuntimeException("Key " + x + " is absent");
            }
            if (keys[i] == x) {
                return values[i];
            }
        }
    }

    int hash(int x) {
        int hash = (x >> 15) ^ x;
        return hash;
    }

    int index(int hash) {
        return Math.abs(hash) % size;
    }
}


