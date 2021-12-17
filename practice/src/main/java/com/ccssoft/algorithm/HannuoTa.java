package com.ccssoft.algorithm;

import java.util.LinkedList;

/**
 * 哈诺塔
 */
public class HannuoTa {


    public static void main(String[] args) {
        LinkedList<Integer> A = new LinkedList<>();
        A.add(1);
        A.add(0);
        A.add(2);
        A.add(4);

        LinkedList<Integer> B = new LinkedList<>();
        LinkedList<Integer> C = new LinkedList<>();
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        System.out.println("==================================");
        hanota(A, B, C);
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
    }

    public static void hanota(LinkedList<Integer> A, LinkedList<Integer> B, LinkedList<Integer> C) {

        int n = A.size() - 1;
        process(A, C, B, n);

    }

    /**
     * [1,0,2,4]
     * @param from
     * @param to
     * @param other
     * @param n
     */
    private static void process(LinkedList<Integer> from, LinkedList<Integer> to, LinkedList<Integer> other, int n) {

        if (n == 0) {
            to.add(from.remove(from.size()-1));
        } else {
            process(from, other, to, n - 1);
            to.add(from.remove(from.size()-1));
            process(other, to, from, n - 1);

        }
    }

}
