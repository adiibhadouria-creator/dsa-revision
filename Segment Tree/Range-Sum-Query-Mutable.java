/*
 * Range Sum Query - Mutable
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Segment Tree
 * Time complexity: O(logN)
 * Space complexity: O(4n)
 * Solved: 2026-10-16
 * URL: https://leetcode.com/problems/range-sum-query-mutable/submissions/2173662196/?utm_source=chatgpt.com
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class NumArray {
    
    int[] seg;
    int n;
    public NumArray(int[] nums) {
        //here we have to build segment tree
        n = nums.length;
        seg = new int[4*n];
        build(0,0,n-1,nums);
    }
    
    public void update(int index, int val) {
        updateTree(0,0,n-1,index,val);
    }
    
    public int sumRange(int left, int right) {
        return query(0,0,n-1,left,right);
    }
    private void build(int idx,int low,int high,int[] nums){
        if(low==high){
            seg[idx] = nums[low];
            return;
        }
        int mid = low +(high-low)/2;
        build(2*idx+1,low,mid,nums);
        build(2*idx+2,mid+1,high,nums);
        seg[idx] = seg[2*idx+1] + seg[2*idx+2];
    }
    private int query(int idx , int low ,int high,int l,int r){
        //completely lies
        if(l<=low && high<=r) return seg[idx];
        if(low>r || high<l) return 0;
        int mid = low+(high-low)/2;
        int left = query(2*idx+1,low,mid,l,r);
        int right = query(2*idx+2,mid+1,high,l,r);
        return left + right;
    }
    private void updateTree(int idx,int low,int high,int i,int value){
        if(low==high){
            seg[idx]= value;
            return;
        }
        //if it completely lies
        int mid  = low+(high-low)/2;
        if(i<=mid){
            updateTree(2*idx+1,low,mid,i,value);
        }
        else{
            updateTree(2*idx+2,mid+1,high,i,value);
        }
        seg[idx] = seg[2*idx+1] + seg[2*idx+2];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
