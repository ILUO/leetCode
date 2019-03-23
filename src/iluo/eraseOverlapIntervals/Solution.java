package iluo.eraseOverlapIntervals;

import iluo.util.Interval;

/**
 * Created by Yang Xing Luo on 2019/3/23.
 */
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        int length = intervals.length;
        if(length == 0) return 0;
        quickSort(intervals,0,length - 1);
        int result = 1;
        int end = intervals[0].end;
        for(int i = 1; i < length;i++){
            if(intervals[i].start >= end){
                result++;
                end = intervals[i].end;
            }
        }
        return length - result;
    }

    private void quickSort(Interval[] intervals,int low,int high){
        if(low >= high) return;
        int i = low;
        int j = high + 1;
        int comp = intervals[i].end;
        while(true){
            while(intervals[++i].end <= comp) if(i == high) break;
            while(intervals[--j].end >= comp) if(j == low) break;
            if(i >= j){
                break;
            }
            Interval temp = intervals[i];
            intervals[i] = intervals[j];
            intervals[j] = temp;
        }
        Interval temp = intervals[j];
        intervals[j] = intervals[low];
        intervals[low] = temp;
        quickSort(intervals,low,j);
        quickSort(intervals,j+1,high);
    }
}
