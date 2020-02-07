

public class strReverse {
    public static void main(String[] args) {
        System.out.println("Rever = " + ReverseSentence(" I am a student. "));
        System.out.println("LeftRotateString(\"adcefd\",3) = " + LeftRotateString("adcefd",3));
    }
    public static String ReverseSentence(String str) {
        if(str.trim().equals("") || str == null) return str;
        String[] word = str.split(" ");//单词切分
        StringBuffer s = new StringBuffer();
        for(int i=word.length; i>0; i--){
            s.append(word[i-1]);//添加单词
            if(i > 1 ) s.append(" ");//添加空格
        }
        return s.toString();
    }
    public static String LeftRotateString(String str,int n) {
        int len = str.length();
        if(len == 0) return str;
        char[] str1 = str.toCharArray();

        n %= len;
        for(int i = 0, j = n - 1; i < j; ++i, --j) {
            char c = str1[i];
            str1[i] = str1[j];
            str1[j] = c;
        }
        for(int i = n, j = len - 1; i < j; ++i, --j) {
            char c = str1[i];
            str1[i] = str1[j];
            str1[j] = c;
        }
        for(int i = 0, j = len - 1; i < j; ++i, --j) {
            char c = str1[i];
            str1[i] = str1[j];
            str1[j] = c;
        }
        return String.valueOf(str1);
    }
    public static void swap(char m,char n){
        char t = m;
        m = n;
        n = t;
    }
}
