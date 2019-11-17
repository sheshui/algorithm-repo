import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.Arrays;

public class Sort {


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];

    }

    public static void bubbleSort(int[] arr) {//冒泡排序
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void selectSort(int[] arr) {//选择排序
        if (arr == null || arr.length < 2) return;
        for (int begin = 0; begin < arr.length - 1; begin++) {
            int minIndex = begin;
            for (int i = begin + 1; i < arr.length; i++) {
                minIndex = arr[i] < arr[minIndex] ? i : minIndex;
            }
            swap(arr, begin, minIndex);
        }
    }

    public static void insertSort(int[] arr) {//插入排序
        if (arr == null || arr.length < 2) return;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void mergeSort(int[] arr) {//归并排序
        if (arr == null || arr.length < 2) return;
        mergeSortProcess(arr, 0, arr.length - 1);
    }

    public static void mergeSortProcess(int[] arr, int L, int R) {//归并排序，递归过程
        if (L == R) return;
        int mid = L + ((R - L) >> 1);//(L+R)/2
        mergeSortProcess(arr, L, mid);
        mergeSortProcess(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {//归并排序，归并操作
        int[] temp = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) temp[i++] = arr[p1++];
        while (p2 <= R) temp[i++] = arr[p2++];
        for (i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
    }

    public static void rightMathod(int[] arr) {
        Arrays.sort(arr);
    }

    public static int[] generrateRandomArray(int size, int value) {
//        Math.random()->double[0,1)
//        (size+1)*Math.random()->double[0,size+1)
//        (int)((size+1)*Math.random())->int[0,size]

        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value + 1) * Math.random() - (int) (value * Math.random()));
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) return null;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) return true;
        else if ((arr2 != null && arr1 == null) || (arr1 != null && arr2 == null)) return false;
        else if (arr1.length != arr2.length) return false;
        else {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) return false;
            }
            return true;
        }

    }

    public static String printArray(int[] arr) {
        StringBuilder s=new StringBuilder("");
        if (arr == null) System.out.println("null");
        else {
            for (int value : arr) {
                s.append(value+" ");
            }
        }
        return s.toString();
    }

    public static void logarithmic() {
        int testTime = 500000;
        int size = 10;
        int value = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generrateRandomArray(size, value);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
//            bubbleSort(arr1);
//            selectSort(arr1);
//            insertSort(arr1);
            mergeSort(arr1);
            rightMathod(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                System.out.println(printArray(arr3));
                System.out.println(printArray(arr1));
                System.out.println(printArray(arr2));
                break;
            }
        }
        System.out.println(succeed ? "nice" : "wrong");
    }

    public static void main(String[] args) {
        logarithmic();
//        int[] arr = {-19,2,-15,37,-78,7};
//        int[] a=copyArray(arr);
//        rightMathod(a);
//        selectSort(arr);
//
//        System.out.println(printArray(arr));
//        System.out.println(isEqual(arr,a) ? "nice" : "wrong");
    }

}
