class Solution {
    public int[] sortArray(int[] arr) {
        int start = 0, end = arr.length-1;
        divide(arr, start, end);
        return arr;
    }

        private static void divide(int[] arr, int start, int end) {
        if(start < end){
            int mid = start + (end - start) / 2;
            divide(arr, start, mid);
            divide(arr, mid+1, end);
            conquer(arr, start, mid, end);
        }
    }

    private static void conquer(int[] arr, int start, int mid, int end) {
        int merge[] = new int[end - start + 1];
        int left = start;
        int right = mid+1;
        int x = 0;

        while(left <= mid && right <= end){
            if(arr[left] <= arr[right]){
                merge[x++] = arr[left++];
            } else {
                merge[x++] = arr[right++];
            }
        }

        while(left <= mid){
            merge[x++] = arr[left++];
        }

        while(right <= end){
            merge[x++] = arr[right++];
        }

        for(int i=start, j=0; i<=end; i++, j++){
            arr[i] = merge[j];
        }
    }
}