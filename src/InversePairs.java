public class InversePairs {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,0};
        int[] copy = {1,2,3,4,5,6,7,0};
        System.out.println("InversePairsCore(array,copy,0,array.length-1) = " + InversePairsCore(array,copy,0,array.length-1));
//        System.out.println("InversePairs(array) = " + InversePairs(array));
    }
    public static int InversePairs(int [] array) {
        if(array == null || array.length <= 0) return 0;//对输入进行处理
        int[] copy = new int[array.length];//声明一个数组
        for(int i=0; i<array.length; ++i){//将array数组复制
            copy[i] = array[i];
        }
        int count = InversePairsCore(array,copy,0,array.length-1);
        return count;
    }
    public static int InversePairsCore(int[] array,int[] copy,int start,int end){
        if(start == end){
            copy[start] = array[start];
            return 0;
        }
        int length = (end-start)/2;//一半长度
        int left = InversePairsCore(copy,array,start,start+length);
        int right = InversePairsCore(copy,array,start+length+1,end);

        int i = start + length;//前半段最后一个坐标
        int j = end;//后半段最后一个坐标
        int indexCopy = end;
        int count = 0;
        while(i>=start && j>=start+length+1){
            if(array[i] > array[j]){//如果左边最大数大于右边最大数时可以构成逆序对
                copy[indexCopy--] = array[i--];
                count += j - start - length;
            }else{
                copy[indexCopy--] = array[j--];
            }
        }
        for(;i>=start;i--){//左边
            copy[indexCopy--] = array[i];
        }
        for(;j>=start+length+1;j--){//右边
            copy[indexCopy--] = array[j];
        }
        return left + right + count;
    }
}
