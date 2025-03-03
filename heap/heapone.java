class maxHeap {
    int maxSize;
    int curr;
    int heap[];

    maxHeap(int n) {
        maxSize = n;
        curr = -1;
        heap = new int[n];
    }

    void insert(int val) {
        if (curr >= maxSize-1) {
            return;
        }
        curr++;
        heap[curr] = val;
        int i = curr;
        while (i > 0 && heap[i] > heap[(i - 1) / 2]) {
            int t = heap[i];
            heap[i] = heap[(i - 1) / 2];
            heap[(i - 1) / 2] = t;
            i = (i - 1) / 2;
        }
    }

    void delete() {
        if (curr == -1) {
            return;
        }
        int t = heap[0];
        heap[0] = heap[curr];
        heap[curr] = t;
        curr--;
        heapify(0);
    }

    void heapify(int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int max = i;
        if (l <= curr && heap[max] < heap[l]) {
            max = l;
        }
        if (r <= curr && heap[max] < heap[r]) {
            max = r;
        }
        if (i != max) {
            int t = heap[max];
            heap[max] = heap[i];
            heap[i] = t;
            heapify(max);
        }
    }

    void printSortedHeap() {
        while (curr >= 0) {
            System.out.print(heap[0] + " ");
            delete();  // Remove the root (max element) and heapify the heap again.
        }
        System.out.println();
    }


    void printHeap() {
        for (int i = 0; i <= curr; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getCurr() {
        return curr;
    }

    public void setCurr(int curr) {
        this.curr = curr;
    }

    public int[] getHeap() {
        return heap;
    }

    public void setHeap(int[] heap) {
        this.heap = heap;
    }
}

public class heapone {
    public static void main(String[] args) {
        maxHeap heap = new maxHeap(10);

        heap.insert(15);
        heap.insert(10);
        heap.insert(30);
        heap.insert(20);
        heap.insert(40);


        // System.out.println("Sorted output after extracting elements:");
        // heap.printSortedHeap();

        System.out.println("Heap after insertion:");
        heap.printHeap();

        heap.delete();
        System.out.println("Heap after deletion:");
        heap.printHeap();

        heap.insert(50);
        System.out.println("Heap after inserting 50:");
        heap.printHeap();

        heap.delete();
        System.out.println("Heap after another deletion:");
        heap.printHeap();
    }
}
