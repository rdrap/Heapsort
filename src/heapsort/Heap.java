package heapsort;

public class Heap<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;

    public Heap(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public void sort() {
        for (int k = (N + 1) / 3; k >= 1; k--)
            sink(k);
        while (N > 1) {
            exch(1, N--);
            sink(1);
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k) {
        while (k > 1 && less((k + 1) / 3, k)) {
            exch((k + 1) / 3, k);
            k = (k + 1) / 3;
        }
    }

    private void sink(int k) {
        while (3 * k - 1 <= N) {
            int j = 3 * k - 1;
            if (j < N - 1 && less(j, j + 1)) {
                j++;
                if (j < N - 1 && less(j, j + 1))
                    j++;
            } else if(j < N - 1 && less(j, j + 2))
                j += 2;
            if (!less(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

    public void printHeap() {
        for (int i = 1; i < pq.length; i++) {
            System.out.println(pq[i]);
        }
    }
}
