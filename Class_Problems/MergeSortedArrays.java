public class MergeSortedArrays {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) result[k++] = arr1[i++];
            else result[k++] = arr2[j++];
        }
        while (i < arr1.length) result[k++] = arr1[i++];
        while (j < arr2.length) result[k++] = arr2[j++];
        return result;
    }

    public static void main(String[] args) {
        int[] res = mergeSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6});
        System.out.print("[");
        for (int i = 0; i < res.length; i++) System.out.print(res[i] + (i == res.length - 1 ? "" : ", "));
        System.out.println("]");
    }
}