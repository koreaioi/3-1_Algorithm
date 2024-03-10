


// 정렬을 마친 배열을 병합하는 알고리즘
public class mergeArray {
    public static void merge(int[] a, int[] b, int[] c) {
        int aLen = a.length;
        int bLen = b.length;
        int pa,pb,index;
        pa = pb = index = 0;

        while(pa < aLen && pb < bLen){ //pa, pb 하나라도 배열 a의 크기에 달하면 종료 (배열은 a.len -1까지니까)
            c[index++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];
        }
        // 둘 중 남아있는 배열 채워넣기
        while (pa < aLen) c[index++] = a[pa++];
        while (pb < bLen) c[index++] = b[pb++];
    }
    public static void main(String[] args) {
        int[] a = {2,4,6,8,11,13};
        int[] b = {1, 2, 3, 4, 9, 16, 21};
        int[] c = new int[a.length + b.length];

        System.out.println("두 배열을 병합");
        merge(a, b, c);

        for (int x : c) {
            System.out.print(x + " ");
        }
    }
}
