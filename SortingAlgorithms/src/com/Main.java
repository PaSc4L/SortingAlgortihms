package com;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = {64,25,12,22,11};
	    System.out.println(getMaximum(arr));
    }

    public static Integer getMinimum(Integer[] list){
        Integer minimum = list[0];
        for (Integer element:list) {
            if(element<minimum){
                minimum=element;
            }
        }
        return minimum;
    }

    public static Integer getMaximum(Integer[] list){
        Integer maximum = list[0];
        for (Integer element:list) {
            if(element>maximum){
                maximum=element;
            }
        }
        return maximum;
    }

    public static Integer[] selectionSort(Integer[] list){
        Integer currentMinimum = list[0];
        Integer swap;
        for(int i=0; i<list.length; i++){
            for(int j=1; j<list.length; i++){
                if(list[i]<currentMinimum){
                    currentMinimum=list[i];
                }
            }
            swap = list[i];
            list[i] = currentMinimum;


        }
        return list;
    }
    public static Integer[] bubbleSort(Integer[] list){
        return list;
    }
    public static Integer[] insertionSort(Integer[] list){
        return list;
    }
    public static Integer[] mergeSort(Integer[] list){
        return list;
    }public static Integer[] quickSort(Integer[] list){
        return list;
    }
}
