package algorithm.sort;

/**
 * 二分查找
 *
 * @author qidi
 * @date 2018/12/18 上午10:32
 */
public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int result = -1;
        //空
        if (null == arr || arr.length < 1) {
            return result;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            //右移除以2
            int middle = high + low >>> 1;
            if (target == arr[middle]) {
                return middle;
            } else if (target > arr[middle]) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int target1 = 4;
        int[] arr1 = {1, 4, 8, 12, 16};
        System.out.println(binarySearch(arr1, target1));
        arr1 = null;
        System.out.println(binarySearch(arr1, target1));
        arr1 = new int[4];
        System.out.println(binarySearch(arr1, target1));

        int[] arrX = {4};
        System.out.println(binarySearch(arrX, target1));

        int target2 = Integer.MAX_VALUE - 2;
        int[] arr2 = {Integer.MAX_VALUE - 3, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
        System.out.println(binarySearch(arr2, target2));


    }
}
