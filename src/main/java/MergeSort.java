public class MergeSort extends Sort {

    public void sort(int[] arr) {//归并排序
        if (arr == null || arr.length < 2) return;
        mergeSortProcess(arr, 0, arr.length - 1);
    }

    public void mergeSortProcess(int[] arr, int L, int R) {//归并排序，递归过程
        if (L == R) return;
        int mid = L + ((R - L) >> 1);//(L+R)/2
        mergeSortProcess(arr, L, mid);
        mergeSortProcess(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public void merge(int[] arr, int L, int mid, int R) {//归并排序，归并操作
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

}
