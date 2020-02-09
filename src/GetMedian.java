import java.util.Comparator;
import java.util.PriorityQueue;

public class GetMedian {
    //    最小堆
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //    最大堆
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    static int count = 0;//记录偶数个还是奇数个

    public static void Insert(Integer num) {
        if (count % 2 == 0) {
            maxHeap.offer(num);
            int max = maxHeap.poll();
            minHeap.offer(max);
        } else {
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);

        }
        count++;
    }

    public static Double GetMedia() {
        if (count % 2 != 0) {
            return new Double(minHeap.peek());
        } else {
            return new Double(maxHeap.peek() + minHeap.peek()) / 2;
        }
    }

    public static void main(String[] args) {
        int[] num = {5, 2, 3, 4, 1, 6, 7, 0, 8};

        for (int i = 0; i < num.length; i++) {
            Insert(num[i]);
            System.out.println("this.GetMedia() = " + GetMedia());
        }
    }
}

