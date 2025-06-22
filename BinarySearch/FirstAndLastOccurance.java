https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
import java.util.Arrays;

public class FirstAndLastOccurance {
    static int firstAndLast(int arr[], int target, boolean findStartIndex) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                // target found
                // it may possible more elements lies before it
                ans = mid;
                if (findStartIndex) { // search for the first occurance of target element
                    end = mid - 1;
                } else { // search for the last occurance of the target element
                    start = mid + 1;
                }
            }
        }
        return ans;
    }

    public static int[] searchRange(int[] nums, int target) {
        // store the indexes of first and last occurance of the answer
        int[] ans = { -1, -1 };
        // check for first occurrance
        ans[0] = firstAndLast(nums, target, true);
        if (ans[0] != -1) {
            // check for last occurrance
            ans[1] = firstAndLast(nums, target, false);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 7, 7, 7, 7, 8, 8, 10, 7 };
        System.out.println(Arrays.toString(searchRange(arr, 7)));
    }
}
