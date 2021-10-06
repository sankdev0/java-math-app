package com.sankdev.mathapp.linearsystem;

import java.util.Arrays;

public class ZeidelTest {

  public static void main(String[] args) {

    /*
     *        Допустим уравнение такое
     *
     *        x + y + z = 5
     *        x + 2*y + 2*z = -3
     *        x + 2*y + 3*z = 6
     *
     */
    Zeidel slae = new Zeidel();
    double[][] A = {{0.9, 2.7, -3.8, 2.4}, {2.5, 5.8, -0.5, 3.5}, {4.5, -2.1, 3.2, -1.2}};
    double[] x = slae.findSolution(A);
    for (double[] d : A) {
      System.out.println(Arrays.toString(d));
    }
    System.out.println(Arrays.toString(x));
  }

}
