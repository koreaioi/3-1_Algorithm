import java.util.*;


public class MergeSort {
    static int[] tmp;

    public static void __mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            int i=0;
            int p =0;
            int j=0;
            int k = left;

            __mergeSort(a, left, mid); //왼쪽 배열 정렬
            __mergeSort(a, mid+1, right); //오른쪽 배열 정렬
            //나눠진 두 배열이 정렬 됨
            for(i = left ; i <= mid ;i++){
                tmp[p++] = a[i]; //tmp 배열에 a의 왼쪽 부분을 옮겨둔다.
            }
            // p는 center - left + 1인 상태 (전체 배열 기준) 즉, p는 a를 복사한 배열 tmp의 마지막 인덱스
            // i는 mid 까지간 상태

            //j=0, i는 mid +1, k=left
            while (j < p && i <= right) { //right는 = 포함
                a[k++] = (tmp[j] <= a[i]) ? tmp[j++] : a[i++];
            }

            while (j < p) {
                a[k++] = tmp[j++];
            }
        }
    }

    public static void mergeSort(int[] a, int n) {
        tmp = new int[n];

        __mergeSort(a, 0, n - 1);

        tmp = null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
/*        System.out.println("배열의 크기를 입력하시오");
        int n = sc.nextInt();
        int[] a = new int[n];*/
//        for (int i = 0; i < a.*/; i++) a[i] = sc.nextInt();
        int[] a = {1, 3, 12, 6, 4, 11, 8, 7, 3, 2, 6, 5};

        mergeSort(a,a.length);

        for (int x : a) {
            System.out.print(x + " ");
        }
    }

}
