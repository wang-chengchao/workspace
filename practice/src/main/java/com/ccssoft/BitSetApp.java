package com.ccssoft;

import java.util.BitSet;

/**
 * BitSet Case {@link java.util.BitSet}
 *
 * @author: kermit
 * @date: 2020/7/31/22:10
 */
public class BitSetApp {

  public static void main(String[] args) {

    int[] a1 = {1, 2, 3, 4, 5, 6, 11, 14, 15, 17};
    int[] a2 = {1, 2, 3, 4, 5, 18, 19, 20, 0, 11};

    BitSet b1 = new BitSet(a1.length);
    BitSet b2 = new BitSet(a2.length);
    for (int i : a1) {
      b1.set(i);
    }
    for (int i : a2) {
      b2.set(i);
    }
    b1.and(b2);
    System.out.println("=====两个数组重复的元素有=======>" + b1.cardinality() + "个");
    System.out.println("============重复的元素分别是=========");
    for (int i = 0; i < a1.length; i++) {
      if (b1.get(a1[i])) {
        System.out.println(a1[i] + "\t");
      }
    }
  }
}
