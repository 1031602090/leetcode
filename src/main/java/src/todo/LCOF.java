package todo;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LCOF {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LCOF().getLeastNumbers(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, 9)));
        new LCOF().adjust(new int[]{1, 3, 2, 66, 5}, 2);
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> integers = new PriorityQueue<>();

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            adjust(arr, i);
            ans[i] = arr[i];
        }
        return ans;
    }

    public void adjust(int[] arr, int start) {
        int j = (arr.length - start) / 2 - 1;
        while (j >= 0) {
            if (arr[j * 2 + 1 + start] < arr[j + start]) {
                arr[j * 2 + 1 + start] ^= arr[j + start];
                arr[j + start] ^= arr[j * 2 + 1 + start];
                arr[j * 2 + 1 + start] ^= arr[j + start];
            }
            if (j * 2 + 2 + start < arr.length && arr[j * 2 + 2 + start] < arr[j+ start]) {
                arr[j * 2 + 2 + start] ^= arr[j + start];
                arr[j + start] ^= arr[j * 2 + 2 + start];
                arr[j * 2 + 2 + start] ^= arr[j + start];
            }
            j--;
        }
    }
}
