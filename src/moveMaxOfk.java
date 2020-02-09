import java.util.ArrayDeque;
import java.util.ArrayList;

public class moveMaxOfk {
    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        System.out.println("num = " + maxInWindows(num,3));
    }
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(num == null || size <= 0) return list;
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        int start;
        for(int i=0; i<num.length; ++i){
            start = i - size + 1;//i表示的头结点，start 表示尾节点
            if(queue.isEmpty()){
                queue.add(i);
            }
            else if(start > queue.peekFirst()){
                queue.pollFirst();
            }
            System.out.println(queue.peekLast());
            while((!queue.isEmpty()) && num[queue.peekLast()] <= num[i]){
                queue.pollLast();
            }
            queue.add(i);
            System.out.println(queue.peekFirst());
            if(start >= 0){
                list.add(num[queue.peekFirst()]);
            }
        }
        return list;
    }
}
