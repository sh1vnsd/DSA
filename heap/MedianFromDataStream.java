class MedianFinder {
    PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (leftMaxHeap.isEmpty() || num < leftMaxHeap.peek()) {
            leftMaxHeap.offer(num);
        } else {
            rightMinHeap.offer(num);
        }

        // always maintain leftMaxHeap size one greater than rightMinHeap
        // or else both sizes equal

        // Size difference is greater than 1
        if (leftMaxHeap.size() - rightMinHeap.size() > 1) {
            rightMinHeap.offer(leftMaxHeap.peek());
            leftMaxHeap.poll();
        }
        // should never be possible
        else if (leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.offer(rightMinHeap.peek());
            rightMinHeap.poll();
        }
    }

    public double findMedian() {
        // even number of elements
        if (leftMaxHeap.size() == rightMinHeap.size()) {
            double mean = (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
            return mean;
        }
        // odd number of elements
        else {
            return leftMaxHeap.peek();
        }
    }
}
