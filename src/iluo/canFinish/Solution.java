package iluo.canFinish;

import java.util.ArrayList;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses < 0) return false;
        ArrayList[] arrayLists = new ArrayList[numCourses];
        for(int i = 0;i < prerequisites.length;i++){
            if(arrayLists[prerequisites[i][1]] == null) arrayLists[prerequisites[i][1]] = new ArrayList();
            arrayLists[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        int[] visited = new int[numCourses];
        for(int i = 0;i < numCourses;i++){
            if(dfsCore(i,arrayLists,visited)) return false;
        }
        return true;
    }

    private boolean dfsCore(int i,ArrayList[] arrayLists,int[] visited){
        if(visited[i] == 2) return false;
        if(visited[i] == 1) return true;
        visited[i] = 1;
        ArrayList<Integer> arrayList = arrayLists[i];
        for(int j = 0;arrayList != null && j < arrayList.size();j++){
            if(dfsCore(arrayList.get(j),arrayLists,visited)) return true;
        }
        visited[i] = 2;
        return false;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] pre = {{0,2},{1,2},{2,0}};
        boolean result = solution.canFinish(3,pre);
        System.out.println(result);
    }


}


