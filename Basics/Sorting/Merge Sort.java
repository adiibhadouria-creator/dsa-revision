MERGE SORT
→ Don't count anything
→ Just merge


COUNT INVERSIONS
→ During merge:
   if arr[i] > arr[j]
   count += mid - i + 1


REVERSE PAIRS
→ Before merge:
   if arr[i] > 2 * arr[j]
   count the pairs
→ Then do normal merge

  class Solution {
      int mergeSort(int[] arr, int low, int high) {
        if (low >= high) return 0;
        int mid = low + (high - low) / 2;
        int count = 0;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);

        // ================= DIFFERENCE =================
        // NORMAL MERGE SORT:
        // merge(arr, low, mid, high);

        // COUNT INVERSIONS:
        // count += merge(arr, low, mid, high);

        // REVERSE PAIRS:
        count += countPairs(arr, low, mid, high);
        // =================================================

        merge(arr, low, mid, high);

        return count;
    }


    // ONLY NEEDED FOR REVERSE PAIRS
    int countPairs(int[] arr, int low, int mid, int high) {
        int count = 0;
        int j = mid + 1;

        for (int i = low; i <= mid; i++) {

            while (j <= high && arr[i] > 2L * arr[j]) {
                j++;
            }

            count += j - (mid + 1);
        }

        return count;
    }


    // NORMAL MERGE
    int merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        int count = 0;

        while (i <= mid && j <= high) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } 
            else {

                // ================= DIFFERENCE =================

                // NORMAL MERGE SORT:
                temp[k++] = arr[j++];

                // COUNT INVERSIONS:
                // count += mid - i + 1;
                // temp[k++] = arr[j++];

                // =================================================
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        int k = low;
        for (int num:temp) {
            arr[k] =num;
            k++;
        }

        return count;
    }
}

