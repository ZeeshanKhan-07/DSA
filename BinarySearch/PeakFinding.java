public class PeakFinding {
    static int Peak(int arr[]) {
        //Starting from 1 to avoid index out of bound situation
        int start = 1;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // you are in the ascending part of the array
                // there is no possible case like more greater element will lie before it then
                // just do
                start = mid + 1;
            } else {
                // you are in the descending part of the array
                // there is no possible case like more greater element will lie after it then
                // just do
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 9, 10, 7, 6, 4 };
        int answer = Peak(arr);
        System.out.println("The peak index is : " + answer);
    }
}
