/*
 * Java 版本的 O(n log n) 时间复杂度示例与讨论
 */
import java.util.*;

public class Onlogn {

    // Quick Sort) - O(n log n)
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Arrays.sort() (Dual-Pivot QuickSort) - O(n log n)
    public static void arraySortExample(int[] arr) {
        Arrays.sort(arr);
    }

    // PriorityQueue - O(n log n)
    public static void priorityQueueExample(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : arr) {
            pq.offer(num); // O(log n)
        }
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " "); // O(log n)
        }
    }

    // 运行测试
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};

        // 测试快排
        quickSort(arr, 0, arr.length - 1);
        System.out.println("QuickSort结果: " + Arrays.toString(arr));

        // 测试Arrays.sort()
        int[] arr2 = {3, 7, 2, 9, 4};
        arraySortExample(arr2);
        System.out.println("Arrays.sort()结果: " + Arrays.toString(arr2));

        // 测试PriorityQueue
        int[] arr3 = {7, 1, 5, 9, 3};
        System.out.print("PriorityQueue结果: ");
        priorityQueueExample(arr3);
    }
}

/*
 * 📝 
 * 1. QuickSort): Average Complexity O(n log n) Worst case: O(n²)
 * 2. Arrays.sort():  Dual-Pivot Average: O(n log n)
 * 3. PriorityQueue: 插入 n 个元素，每次插入 O(log n)，n 次插入 O(n log n)
 *
 * O(n log n)  
 * - Divide and Conquer
 */