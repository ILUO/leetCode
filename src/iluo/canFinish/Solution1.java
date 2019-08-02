package iluo.canFinish;


import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] adjTable = new ArrayList[numCourses];
        int[] entryDegrees = new int[numCourses];
        for(int i = 0;i < prerequisites.length;i++){
            if(adjTable[prerequisites[i][1]] == null) adjTable[prerequisites[i][1]] = new ArrayList();
            adjTable[prerequisites[i][1]].add(prerequisites[i][0]);
            entryDegrees[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0;i < entryDegrees.length;i++){
            if(entryDegrees[i] == 0) queue.add(i);
        }
        while(!queue.isEmpty()){
            int head = queue.poll();
            result.add(head);
            ArrayList<Integer> arrayList = adjTable[head];
            for(int i = 0;arrayList != null && i < arrayList.size();i++){
                entryDegrees[arrayList.get(i)]--;
                if(entryDegrees[arrayList.get(i)] == 0) queue.add(arrayList.get(i));
            }
        }
        if(result.size() == numCourses) return true;
        else return false;
    }
    public static void main(String[] args){
        Solution1 solution = new Solution1();
        int[][] pre = {{0,2},{1,2},{2,0}};
        boolean result = solution.canFinish(3,pre);
        System.out.println(result);
    }
}
