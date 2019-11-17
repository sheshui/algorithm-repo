public class SortTest {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];

    }

    private static void partition(int[] arr, int l, int r, int p) {
        if (arr==null||arr.length<2)return;
        int less = l - 1;
        int more = r + 1;
        while (l < more) {
            if (arr[l] < p) {
                l++;
                less++;
            } else if (arr[l] > p) swap(arr, --more, l);//l下标不变，判断more边界区的数符合哪个条件。
            else l++;
        }

    }

    public static int mergeSort(int[] arr) {//归并排序
        if (arr == null || arr.length < 2) return 0;
        return mergeSortProcess(arr, 0, arr.length - 1);
    }

    private static int mergeSortProcess(int[] arr, int L, int R) {//归并排序，递归过程
        if (L == R) return 0;
        int mid = L + ((R - L) >> 1);//(L+R)/2防止溢出
        return mergeSortProcess(arr, L, mid) +
                mergeSortProcess(arr, mid + 1, R) +
                merge(arr, L, mid, R);
    }

    private static int merge(int[] arr, int L, int mid, int R) {//归并排序，归并操作
        int[] temp = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        int sum = 0;
        while (p1 <= mid && p2 <= R) {
            sum += arr[p1] < arr[p2] ? arr[p1] * (R - p2 + 1) : 0;
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) temp[i++] = arr[p1++];
        while (p2 <= R) temp[i++] = arr[p2++];
        for (i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
        return sum;
    }

    public static int rightMathod(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                sum += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return sum;
    }

    public static int[] generrateRandomArray(int size, int value) {
//        Math.random()->double[0,1)
//        (size+1)*Math.random()->double[0,size+1)
//        (int)((size+1)*Math.random())->int[0,size]

        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value + 1) * Math.random() - (int) (value * Math.random()));//[1-value,value]
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
        StringBuilder s = new StringBuilder("");
        if (arr == null) System.out.println("null");
        else {
            for (int value : arr) {
                s.append(value + " ");
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
//            mergeSort(arr1);
//            rightMathod(arr2);
            if (mergeSort(arr1) != rightMathod(arr2)) {
                succeed = false;
                System.out.println("merge:" + mergeSort(arr1));
                System.out.println("right:" + rightMathod(arr2));
                System.out.println("array:" + printArray(arr3));
                break;
            }
        }
        System.out.println(succeed ? "nice" : "wrong");
    }

    public static void main(String[] args) {
//        logarithmic();
        int[] a=generrateRandomArray(10,10);
        System.out.println(printArray(a));
        partition(a,0,a.length-1,a[0]);
        System.out.println(printArray(a));
//        int[] arr1={2,3,4,1,5};
//
//        int[] arr2 = copyArray(arr1);
//        int[] arr3 = copyArray(arr1);
//        int a=mergeSort(arr1);
//        int b=rightMathod(arr2);
//        if (a!=b) {
////            succeed = false;
//            System.out.println("merge:"+a);
//            System.out.println("right:"+b);
//            System.out.println("array:"+printArray(arr3));
////            break;
//        }
//        System.out.println(mergeSort(arr1)!=rightMathod(arr2) ? "nice" : "wrong");
        System.out.println();
    }
}
