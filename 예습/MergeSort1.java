import java.util.*;

public class MergeSort1 {
    private static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);

    }

    private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, tmp, start ,mid);
            mergeSort(arr, tmp, mid+1,end);
            merge(arr, tmp, start, mid, end);
        }
    }

    private static void merge(int[] arr,int[] tmp,int start,int mid,int end) {
        //임시 저장 배열에 필요한 만큼 복사
        for (int i = start; i <= end; i++) tmp[i] = arr[i];
        int part1 = start;
        int part2 = mid + 1;
        int index = start;
/*
        while (part1 < mid+1 && part2 <= end) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            }else{
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }*/

        while (part1 < mid + 1 && part2 <= end) {
            arr[index++] = (tmp[part1] <= tmp[part2]) ? tmp[part1++] : tmp[part2++];
        }

        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }

    }

    public static void main(String[] args) {
        int[] a = {1, 3, 12, 6, 4, 11, 8, 7, 3, 2, 6, 5};

        mergeSort(a);

        for (int x : a) {
            System.out.print(x + " ");
        }

    }
}
