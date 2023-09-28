package algorithm;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = {64, 25, 12, 111, 22, 11};   //random array to sort
        //System.out.println("The minimum value is: " + getMinimum(arr));
        //System.out.println("The maximum value is: " +getMaximum(arr));

        //arr=selectionSort(arr);
        //arr = bubbleSort(arr);
        //arr = insertionSort(arr);
        //arr = mergeSort(arr);
        arr = quickSort(arr);
        System.out.println(Arrays.toString(arr));
        //for (Integer element : arr) {
        //   System.out.println(element);
        //}
    }

    /**
     * getMinimum function
     * @param list
     * @return minimum value of an array
     */
    public static Integer getMinimum(Integer[] list){
        //TODO: min max with while
        Integer minimum = list[0];  //first element will be the minimum automatically
        for (int i =1; i<list.length; i++) {    //going trough the array with a foreach
            if(list[i]<minimum){    //checking if current element is below minimum
                minimum=list[i];    //current element set as minimum if it's lower
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
        for (int i =1; i<list.length; i++) {    //going trough the array with a foreach
            if(list[i]>maximum){    //checking if current element is above maximum
                maximum=list[i];    //current element set as maximum if it's higher
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

    /**
     * Merge Sort
     * @param list
     * @return sorted list
     */
    public static Integer[] mergeSort(Integer[] list){
        Integer[] firstArray = Arrays.copyOfRange(list, 0, list.length/2);  //firstArray: first half of the list array
        Integer[] secondArray = Arrays.copyOfRange(list, list.length/2, list.length);   //second half of the list array

        if((firstArray.length > 1)){    //checking if the array can be divided more (it contains more than one element)
            firstArray = mergeSort(firstArray); //calling merge sort if it can be divided even more (recursive call)
        }if((secondArray.length > 1)){  //checking if the array can be divided more (it contains more than one element)
            secondArray = mergeSort(secondArray);   //calling merge sort if it can be divided even more (recursive call)
        }

        Integer sizeCounter = 0;    //this will count what place we will put pur sorted value in the list
        for(int i = 0; i<firstArray.length; i++){   //going trough the first array
            for(int j = 0; j<secondArray.length; j++){  //going troug the second array
                if(secondArray[j] != null){ //checking if the secondArrays value is null: this means that all values from the second array are sorted

                    if(firstArray[i]<=secondArray[j] && j+1==secondArray.length){ //checnking if the first array's element is lower than the second array's element and if it is the second array's last element
                        list[sizeCounter] = firstArray[i];  //putting the lower element to the sorted array
                        list[sizeCounter+1] = secondArray[j];   //putting tha last element from the second array to the sorted array
                        sizeCounter++;  //incrementing the sizeCounter
                        break;  //breaking since the first arrays element is sorted

                    }else if(firstArray[i]<=secondArray[j]){    //checking if the first array's element is lower
                        list[sizeCounter] = firstArray[i];  //putting it in the sorted array
                        sizeCounter++;  //element sorted: incrementing sizeCounter
                        break;  //breaking since we put an element in place

                    }else if(j+1==secondArray.length){  //checking if second arrays number is the last element in the array (meaning that it is the lowest element so both the first and second arrays elemnts needs to be sorted
                        list[sizeCounter] = secondArray[j]; //setting the second arrays element to the sorted list
                        list[sizeCounter+1] = firstArray[i];    //setting the first array's element to the sorted list
                        secondArray[j] = null;  //setting already sorted number value to zero, so it won't be sorted again
                        sizeCounter += 2;   //incrementig sizeCounter by 2 since 2 element is sorted
                        //we not break here because we can still compare the next element from the current array with-

                    }else{  //else: the second array's value is lower so it must be placed in the sorted array
                        list[sizeCounter] = secondArray[j];
                        secondArray[j] = null;
                        sizeCounter++;
                    }
                }else if(j+1==secondArray.length) { //if the second array is full with null values
                    list[sizeCounter] = firstArray[i];
                    sizeCounter++;
                }
            }
        }
        return list;
    }

    public static Integer[] quickSort(Integer[] array){
        int privot = array[array.length-1];
        int i = 0;
        Integer[] sorted = new Integer[array.length];
        if(array.length>1) {

            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] <= privot) {
                    int swap = array[j];
                    array[j] = array[i];
                    array[i] = swap;
                    i++;
                }
            }
            int swapPrivot = array[i];
            array[i] = array[array.length - 1];
            array[array.length - 1] = swapPrivot;

            Integer[] lowerNumbers = Arrays.copyOfRange(array, 0, i);
            if (lowerNumbers.length != 0) {
                lowerNumbers = quickSort(lowerNumbers);
            }
            Integer[] higherNumbers = Arrays.copyOfRange(array, i+1, array.length);
            if (higherNumbers.length != 0) {
                higherNumbers = quickSort(higherNumbers);
            }
            int j = 0;
            for(int k = 0; k<lowerNumbers.length; k++){
                sorted[j] = lowerNumbers[k];
                j++;
            }

            sorted[i] = privot;
            j++;
            for(int k = 0; k<higherNumbers.length; k++){
                sorted[j] = higherNumbers[k];
                j++;
            }
        }else{
            sorted[i] = privot;
        }

        return sorted;
    }

}
