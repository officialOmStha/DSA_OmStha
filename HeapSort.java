public class HeapSort {

    // Heapify a subtree rooted at index i
    static void heapify(int[] arr, int n, int i) {
        int largest = i;          // Initialize largest as root
        int left = 2 * i + 1;     // left child
        int right = 2 * i + 2;    // right child

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        // Swap and heapify the affected subtree
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    // Main function to perform heap sort
    static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Utility function to print array
    static void printArray(int[] arr) {
        for (int value : arr)
            System.out.print(value + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {99, 41, 23, 26, 56, 7};

        System.out.println("Original array:");
        printArray(arr);

        heapSort(arr);

        System.out.println("Sorted array using Heap Sort:");
        printArray(arr);
    }
}
