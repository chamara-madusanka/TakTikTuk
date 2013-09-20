/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taktiktuk;

import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author Rumesh
 */
public class Test {

    public static void main(String[] args) {
        TreeSet<Integer> t = new TreeSet<Integer>();
        t.add(5);
        t.add(10);
        t.add(10);
        System.out.println(t.size());
        Iterator ij = t.iterator();
        while(ij.hasNext()){
            int i = (Integer)ij.next();
        }
        int i = 100;
        int j = 500;


        String a = "" + i;
        for (int k =i; k <= j; k++) {
            get(k);
        }
        Math.abs(5);
        



    }

    static int[] get(int i) {
        String a = "" + i;
        int[] out = new int[a.length()];

        int len = a.length();
        int multFac = 1;
        int j = 0;
        for (int k = 0; k < len - 1; k++) {
            multFac *= 10;
        }

        for (int k = 0; k < len; k++) {
            out[k] = i;
            i = (i % multFac) * 10 + (i / multFac);

        }

        for (int k = 0; k < out.length; k++) {
            
            if (a.length() != ("" + out[k]).length()) {
                continue;
                
            } else {
                System.out.println("Match");
            }
            System.out.println(out[k]);
        }

        return out;
    }
}
