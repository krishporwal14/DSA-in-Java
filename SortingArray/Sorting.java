package sortingArray;

public class Sorting extends MyLongArray1 {
    public Sorting(int size) {
        super(size);
    }
    /**
     * This method sorts the array with the help of bubble sort. In bubble sort, zeroeth position element is compared to all elements till n - 1 and if zeroeth position element is smaller than any compared element then we swap them and shift to right position. The number of comparisons in first iteration is n - 1 and number of swaps maybe betwwen 0 to n - 1.
     */
    public void bubbleSort() {
        int in, out;
        long temp;
        for(out = a.length - 1; out > 1; out--) {
            for(in = 0; in < out; in++) {
                if(a[in] > a[in + 1]) {
                    temp = a[in];
                    a[in] = a[in + 1];
                    a[in + 1] = temp;
                }
            }
        }
        System.out.println("Array is sorted.");
    }
    /**
     * This method sorts the array with the help of selection sort. In selection sort, we first find the smallest element in the array and swap it with the zeroeth position element and shift right by one position. The number of swaps required is o(n) but, the number of comparisons isthe same as buble sort which is o(n^2).
     */
    public void selectionSort() {
        int in, out, minIndex;
        long temp;
        for(out = 0; out < a.length; out++) {
            minIndex = out;
            for(in = out + 1; in < a.length; in++) {
                if(a[in] < a[minIndex]) {
                    minIndex = in;
                }
            }
            temp = a[out];
            a[out] = a[minIndex];
            a[minIndex] = temp;
        }
        System.out.println("Array is sorted.");
    }
    /**
     * This method uses insertion sort to sort the array elements. In insertion sort, a marked item is chosen and elements left to the marked item are considered partially sorted and the elements right of the marked element are considered unsorted. Then we find a place for marked element in the partially sorted subarray and remove the marked element from its place. Then we shift the elements greater than marked element in the sub array to the right and insert the marked element.
     */
    public void insertionSort() {
        int in, out;
        long temp;
        for(out = 1; out < a.length; out++) {
            temp = a[out];
            in = out;
            while(in > 0 && a[in - 1] >= temp) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = temp;
        }
        System.out.println("Array is sorted.");
    }
}
