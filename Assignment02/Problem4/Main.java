package com.company;

public class Main {

    public static void main(String[] args) {
        int[] w = {12,33,65,451,19,7};
        Problem04Solving(w,w.length);
    }

    public  static void Problem04Solving(int[] a, int Array) {
        int[] x = new int[Array];
        x = a.clone();
        int y = 0;
            //The Maxima Array

        while(y < x.length && y+1< x.length){
            if(x[y]<x[y+1]){
                int temp = x[y];
                x[y] = x[y + 1];
                x[y + 1] = temp;
                y += 2;
            } else {
                y++;
            }
        }

        System.out.print("The Maxima is: ");
        System.out.println("\n");

        for (y=0; y<x.length; y++){
            System.out.print(x[y]+" ");
                    }
        System.out.println("\n");
        // The Minima Array

        int o = 0;

        while (o < Array && o+1 < Array) {
            if (a[o] > a[o + 1]) {
                int temp = a[o];
                a[o] = a[o + 1];
                a[o + 1] = temp;
                o += 2;
            } else {
                o++;
            }
        }

        System.out.println("The Minima is: ");

        for (o = 0; o<Array; o++){
            System.out.print(a[o]+ " ");
        }
        System.out.println("\n");
    }
}
