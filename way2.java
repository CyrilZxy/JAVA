public class way2 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(binarySearch(arr, 6));
    }
    public static int binarySearch(int[] arr, int toFind) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (toFind < arr[mid]) {
                // 去左侧区间找
                right = mid - 1;
            } else if (toFind > arr[mid]) {
                // 去右侧区间找
                left = mid + 1;
            } else {
                // 相等, 说明找到了
                return mid;
            }
        }
        // 循环结束, 说明没找到
        return -1;
    }
// 执行结果
//5
}

