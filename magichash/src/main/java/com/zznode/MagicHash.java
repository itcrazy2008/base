package com.zznode;

//神奇的数据0x61c88647
public class MagicHash {

    private static final int HASH_INCREMENT = 0x61c88647;

    public static void main(String[] args) {
        magic(16);
        System.out.println("");
        magic(32);
    }

    public static void magic(int size){
        for (int i=0;i<size;i++){
            int nextHashCode = i * HASH_INCREMENT + HASH_INCREMENT;
            nextHashCode = nextHashCode & (size-1);
            System.out.print("\t" + nextHashCode);
        }
    }
}
