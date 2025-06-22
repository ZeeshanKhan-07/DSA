public class FindInInfiniteArray {
    static int infinite(int arr[], int target) {
        int start = 0;
        int end = 1;

        while(end < arr.length && target > arr[end]){
            int temp = end + 1; //it will be the new start
            end = end + (end - start + 1) * 2; //just double the size of the end 
            start = temp;
        }
        //make sure it doesnt exceed the length of array
        if(end >= arr.length) {
            end = arr.length - 1;
        }
        //just do normal binary search in the chunk
        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int arr[], int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else{
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 7;
        //the array is sorted just apply binary search
        //make a small chunk and then increase the size of chunk 
        System.out.println(infinite(arr, target));
    }
}
