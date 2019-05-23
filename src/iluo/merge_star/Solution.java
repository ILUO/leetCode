package iluo.merge_star;

import java.util.ArrayList;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return intervals;
        sort(intervals,0,intervals.length-1);
        ArrayList<int[]> res = new ArrayList();
        res.add(intervals[0]);
        for(int i = 1;i < intervals.length;i++){
            int end = res.get(res.size()-1)[1];
            if(end >= intervals[i][0]){
                if(end < intervals[i][1]){
                    int[] temp = res.get(res.size()-1);
                    temp[1] = intervals[i][1];
                    res.set(res.size()-1,temp);
                }
            }else {
                res.add(intervals[i]);
            }
        }
        int[][] result = new int[res.size()][2];
        for(int i = 0;i < res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }

    private void sort(int[][] intervals,int start,int end){
        if(start >= end) return;
        int partion = partition(intervals,start,end);
        int[] temp = intervals[start];
        intervals[start] = intervals[partion];
        intervals[partion] = temp;
        sort(intervals,start,partion-1);
        sort(intervals,partion+1,end);
    }
    private int partition(int[][] intervals,int start,int end){
        int i = start;
        int j = end+1;
        int compare = intervals[i][0];
        while (true){
            while (intervals[++i][0] <= compare) if(i == end) break;
            while (intervals[--j][0] >= compare) if(j == start) break;
            if(i >= j) break;
            int[] temp = intervals[i];
            intervals[i] = intervals[j];
            intervals[j] = temp;
        }
        return j;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] a= {{2,3},{1,4}};
        solution.merge(a);
    }
}
