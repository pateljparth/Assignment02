package com.company;

public class Main {

    public static void main(String[] args) {
        int[] p = {2,3,5,6,8,1,32,65};
        MergeSort(p);

	    }
    public static void MergeSort(int [] p){
        int center = p.length/2;
        // Second half is sorted here
        for (int m =center; m< p.length-1; m++) {
            for (int n = center; n < p.length - 1; n++) {
                if (p[n + 1] < p[n]) {
                    int num = p[n];
                    p[n] = p[n + 1];
                    p[n + 1] = num;
                }
            }
        }
        // First half is sorted here
        for (int m =0; m< center -1; m++) {
            for (int n = 0; n < center - 1; n++) {
                if (p[n + 1] < p[n]) {
                    int num = p[n];
                    p[n] = p[n + 1];
                    p[n + 1] = num;
                }
            }
        }

        // Merge Sort comparing first half and second half
        System.out.println("\n");
        for (int n = 0; n < center-1; n++){
            for(int m = center; m<p.length; m++){
                if (p[m]<p[n]){
                    int num = p[m];
                    for(int z = m; z > n-1; z--){
                        if(z-1!=-1)

                        {
                            p[z] = p[z-1];
                        }

                    }
                    p[n] = num;
                    n++;
                }
            }
        }

        for (int h =0; h < p.length; h++){
            System.out.print(p[h]+" ");
        }
    }
}
