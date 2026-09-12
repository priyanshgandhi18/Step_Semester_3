public class RotateArray {
    public static int[] rotateArray(int[] nums, int k) {
        k = k % nums.length;
        int[] newArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArray[(i + k) % nums.length] = nums[i];
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] res = rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        System.out.print("[");
        for (int i = 0; i < res.length; i++) System.out.print(res[i] + (i == res.length - 1 ? "" : ", "));
        System.out.println("]");
    }
}