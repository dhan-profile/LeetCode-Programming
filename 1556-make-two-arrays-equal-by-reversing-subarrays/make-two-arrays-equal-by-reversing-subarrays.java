// class Solution {
//     public boolean canBeEqual(int[] target, int[] arr) {
//         if (target.length != arr.length) {
//             return false;
//         } else {
//             Arrays.sort(target);
//             Arrays.sort(arr);
//         }
//         return Arrays.equals(target, arr);
//     }
// }

class Solution {
   public boolean canBeEqual(int[] target, int[] arr) {
    if (target.length != arr.length) {
        return false;
    }

    int[] map = new int[1001]; // assuming elements are within the range [0, 1000]

    for (int i = 0; i < target.length; i++) {
        map[target[i]]++;
        map[arr[i]]--;
    }

    for (int count : map) {
        if (count != 0) {
            return false;
        }
    }

    return true;
}

}