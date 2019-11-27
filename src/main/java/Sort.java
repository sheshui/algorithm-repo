import java.util.Arrays;


public abstract class Sort implements CommonInterface{


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];

    }

    public static void rightMathod(int[] arr) {
        Arrays.sort(arr);
    }

    public int[] generrateRandomArray(int size, int value) {
//        Math.random()->double[0,1)
//        (size+1)*Math.random()->double[0,size+1)
//        (int)((size+1)*Math.random())->int[0,size]

        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value + 1) * Math.random() - (int) (value * Math.random()));
        }
        return arr;
    }

    public int[] copyArray(int[] arr) {
        if (arr == null) return null;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) return true;
        else if (arr2 == null || arr1 == null) return false;
        else if (arr1.length != arr2.length) return false;
        else {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) return false;
            }
            return true;
        }

    }

    public String printArray(int[] arr) {
        StringBuilder s=new StringBuilder("");
        if (arr == null) System.out.println("null");
        else {
            for (int value : arr) {
                s.append(value).append(" ");
            }
        }
        return s.toString();
    }

    public void logarithmic() {
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
//            mergeSort(arr1);
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



}
