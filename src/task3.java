/*
Реализовать алгоритм пирамидальной сортировки (HeapSort).
https://habr.c om/ru/company/otus/blog/460087/
 */

import java.util.Arrays;
import java.util.Random;

public class task3 {
    public static void main(String[] args) {
        Random random = new Random();
        int length = 21;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println("Сгенерированный массив:\n" + Arrays.toString(arr));
        task3 ob = new task3();
        ob.sort(arr);
        System.out.println("Сортированнный массив: \n" + Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i=n-1; i>=0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && arr[l] > arr[largest]) largest = l;
        if (r < n && arr[r] > arr[largest]) largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}

