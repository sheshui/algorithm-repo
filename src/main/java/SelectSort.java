public class SelectSort extends Sort {

    public void sort(int[] arr) {//选择排序
        if (arr == null || arr.length < 2) return;
        for (int begin = 0; begin < arr.length - 1; begin++) {
            int minIndex = begin;
            for (int i = begin + 1; i < arr.length; i++) {
                minIndex = arr[i] < arr[minIndex] ? i : minIndex;
            }
            swap(arr, begin, minIndex);
        }
    }
}
