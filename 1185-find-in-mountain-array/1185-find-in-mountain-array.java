/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakElement = peakElement(mountainArr);
        if (target == mountainArr.get(peakElement)) {
            return peakElement;
        }
        int index = orderAgnosticBS(mountainArr, target, 0, peakElement);
        if (index != -1) {
            return index;
        }
        return orderAgnosticBS(mountainArr, target, peakElement + 1, mountainArr.length() - 1);
    }

    int peakElement(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    int orderAgnosticBS(MountainArray mountainArr, int target, int start, int end) {
        boolean isAsc = mountainArr.get(start) < mountainArr.get(end);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == mountainArr.get(mid)) {
                return mid;
            }
            if (isAsc) {
                if (target < mountainArr.get(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > mountainArr.get(mid)) {
                    end = mid - 1;
                } else {
                     start = mid + 1;
                }
            }
        }
        return -1;
    }
}