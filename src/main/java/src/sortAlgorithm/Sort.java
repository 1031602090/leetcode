package sortAlgorithm;

import java.util.Random;

public class Sort {
    public static void main(String[] args) {
        int[] array = new int[100 * 6000];
        Random random = new Random();
        for (int i = 0; i < 100 * 6000; i++) {
            array[i] = random.nextInt();
        }

        long start = System.currentTimeMillis();
        fastSort(array, 0, array.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start));

        start = System.currentTimeMillis();
        mergeSort(array, 0, array.length - 1);
        end = System.currentTimeMillis();
        System.out.println("time:" + (end - start));

        start = System.currentTimeMillis();
        bubbleSort(array);
        end = System.currentTimeMillis();
        System.out.println("time:" + (end - start));

//        System.out.println(Arrays.toString(array));
        check(array);
    }

    private static void check(int[] array) {
        boolean f = true;
        boolean f2 = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                f = false;
                break;
            }
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                f2 = false;
                break;
            }
        }
        System.out.println(f | f2);
    }

    private static void mergeSort(int[] array, int s, int e) {
        if (s >= e) return;
        int mid = (s + e) / 2;
        mergeSort(array, s, mid);
        mergeSort(array, mid + 1, e);
        int[] t = new int[e - s + 1];
        int index = 0, l = s, r = mid + 1;
        while (l <= mid && r <= e) {
            if (array[l] < array[r]) {
                t[index++] = array[l++];
            } else {
                t[index++] = array[r++];
            }
        }
        while (l <= mid) {
            t[index++] = array[l++];
        }
        while (r <= e) {
            t[index++] = array[r++];
        }
        System.arraycopy(t, 0, array, s, e - s + 1);
    }

    private static void fastSort(int[] array, int s, int end) {
        if (s < end) {
            int t = array[s];
            int l = s;
            int r = end;
            while (l < r) {
                while (l < r && array[r] >= t) r--;
                array[l] = array[r];
                while (l < r && array[l] <= t) l++;
                array[r] = array[l];
            }
            array[l] = t;
            fastSort(array, s, l - 1);
            fastSort(array, l + 1, end);
        }

    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean f = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] < array[j]) {
                    int t = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = t;
                    f = false;
                }
            }
            if (f) return;
        }
    }

}
