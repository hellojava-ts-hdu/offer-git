public class sortDataDigits {
    public static void main(String[] args) {
        int[] array = {5,4,3,3,3,3,1,2};
        int k = 3;
        System.out.println("biSerach(array,k) = " + GetNumberOfk(array,k));
    }

    private static int GetNumberOfk(int[] array, int k) {
        if(array == null || array.length <= 0) return 0;
        return Math.abs(biSerach(array,k+0.5) - biSerach(array,k-0.5));
    }

    private static int biSerach(int[] array, double v) {
        int start = 0, end = array.length-1;
        while (start <= end){
            int mid = (end + start) >> 1;
            if(array[0]<array[array.length-1]) {
                if (array[mid] < v) {
                    start = mid + 1;
                } else if (array[mid] > v) {
                    end = mid - 1;
                }
            }else if(array[0]>array[array.length-1]){
                if (array[mid] > v) {
                    start = mid + 1;
                } else if (array[mid] < v) {
                    end = mid - 1;
                }
            }
        }
        return start;
    }
}
