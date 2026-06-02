class Solution {
    public double findMedianSortedArrays(int[] n1, int[] n2) {

        if (n1.length > n2.length) {
            int[] t = n2;
            n2 = n1;
            n1 = t;
        }

        int len1 = n1.length, len2 = n2.length;
        int half = (len1 + len2 + 1) / 2;
        int l = 0, r = len1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int mid2 = half - mid;

            int l1 = mid > 0 ? n1[mid - 1] : Integer.MIN_VALUE;
            int r1 = mid < len1 ? n1[mid] : Integer.MAX_VALUE;
            int l2 = mid2 > 0 ? n2[mid2 - 1] : Integer.MIN_VALUE;
            int r2 = mid2 < len2 ? n2[mid2] : Integer.MAX_VALUE;

            if (Math.max(l1,l2) <= Math.min(r1,r2)) {
                if ((len1 + len2) % 2 != 0) {
                    return Math.max(l1, l2);
                }
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else if (l1 > r2) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }
}
