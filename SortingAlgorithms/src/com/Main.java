package com;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = {64, 25, 12, 22, 11};   //random array to sort
        //System.out.println(getMinimum(arr));
        //System.out.println(getMaximum(arr));

        //arr=selectionSort(arr);
        //arr = bubbleSort(arr);
        arr = insertionSort(arr);
        for (Integer element : arr) {
            System.out.println(element);
        }
    }

    /**
     * getMinimum function
     * @param list
     * @return minimum value of an array
     */
    public static Integer getMinimum(Integer[] list){
        Integer minimum = list[0];  //first element will be the minimum automatically
        for (Integer element:list) {    //going trough the array with a foreach
            if(element<minimum){    //checking if current element is below minimum
                minimum=element;    //current element set as minimum if it's lower
            }
        }
        return minimum; //return minimum
    }

    /**
     * getMaximum function
     * @param list
     * @return maximum value of an array
     */
    public static Integer getMaximum(Integer[] list){
        Integer maximum = list[0];  //first element will be the maximum automatically
        for (Integer element:list) {    //going trough the array with a foreach
            if(element>maximum){    //checking if current element is above maximum
                maximum=element;    //current element set as maximum if it's higher
            }
        }
        return maximum; //return maximum
    }

    /**
     * Selection sort
     * @param list
     * @return sorted list
     */
    public static Integer[] selectionSort(Integer[] list){
        Integer swap;   //temporary integer for storing a value to be swapped
        for(int i=0; i<list.length; i++){   //going trough the whole list
            Integer currentMinimumIndex = i;    //storing the arrays first number's index

            for(int j=i;j<list.length; j++){    //going trough the whole list
                if(list[j]<list[currentMinimumIndex]){  //check if current value is lower than the current lowest
                    currentMinimumIndex=j;  //changin if true
                }
            }
            swap = list[i]; //stroring current item to swap
            list[i] = list[currentMinimumIndex];    //setting the current's item's value to the minimum value we found
            list[currentMinimumIndex] = swap;   //setting the higher  value to the index which had the lowest number
        }
        return list;    //return sorted list
    }

    /**
     * Bubble sort
     * @param list
     * @return sorted array
     */
    public static Integer[] bubbleSort(Integer[] list){
        Integer swap;   //temporary integer for storing a value to be swapped
        for (int i =0; i<list.length; i++){
            for (int j=1; j<list.length-i; j++){    //going trough the list from 1st index to avoid out of bounds sexception
                if(list[j]<list[j-1]){  //checking if the list's previous element is higher than the current
                    swap=list[j-1]; //storing previous item to swap
                    list[j-1] = list[j];    //giving the current item's value to the previous itme
                    list[j] = swap; //giving the stored value to the current item
                }
            }
        }

        return list;
    }

    /**
     * Inseton sort
     * @param list
     * @return Sorted array
     */
    public static Integer[] insertionSort(Integer[] list){
        Integer swap;
        Integer j=1;    //starting with the first index to avoid out of bounds
        while(j<list.length){   //using while loop so that I can increment or decrement the j variable any time it needed
            if(list[j]<list[j-1]){  //change the values if the current is lower than the previous
                swap = list[j];
                list[j] = list[j-1];
                list[j-1] = swap;
                if(j-1!=0){ //checking if the previous is not the first (to avoid out of bounds sexception)
                    j --;   //decrement j, to check if the switched value with the previous value(s)
                }else j++;  //increment j if the switch hapenned with the first element of the array
            }else j++;  //increase if swapping happened
        }
        return list;
    }

    public static Integer[] mergeSort(Integer[] list){
        return list;
    }

    public static Integer[] quickSort(Integer[] list){
        return list;
    }
}
