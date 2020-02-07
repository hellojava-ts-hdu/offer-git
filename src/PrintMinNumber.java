import java.util.Arrays;
import java.util.Comparator;
import java.util.SplittableRandom;

public class PrintMinNumber {
    public static void main(String[] args) {
        int a[] = {3,32,321};
        System.out.println("printMinNumber = " + printMinNumber(a));
    }

    private static String printMinNumber(int[] a) {
        if(a == null || a.length <= 0) {
            return "";
        }

        int len = a.length;
        String []str = new String[len];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(a[i]);//把数字转换为字符串,解决大数问题
        }
        Arrays.sort(str, new Comparator<String>() {//重写排序方法
            @Override
            public int compare(String o1, String o2) {
                String c1 = o1 + o2;
                String c2 = o2 + o1;
                return c1.compareTo(c2);
            }
        });
        for (int i = 0; i < len; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
