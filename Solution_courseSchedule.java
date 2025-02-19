//TC: O(V+E)
//SC: O(V+E)
//Did it run on leetcode: Yes
public class Solution_courseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegrees = new int[numCourses];
        int count = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < prerequisites.length; i++){
            int dep = prerequisites[i][0];
            int ind = prerequisites[i][1];
            indegrees[dep]++;
            if(!map.containsKey(ind))
                map.put(ind, new ArrayList<>());
            map.get(ind).add(dep);
        }

        for(int i = 0; i < indegrees.length; i++){
            if(indegrees[i] == 0){
                q.add(i);
                count++;
            }
        }

        if(count == numCourses)
            return true;
        if(q.isEmpty())
            return false;
        while(!q.isEmpty()){
            int currInd = q.poll();
            List<Integer> children = map.get(currInd);
            if(children == null)
                continue;
            for(Integer child: children){
                indegrees[child]--;
                if(indegrees[child] == 0){
                    q.add(child);
                    count++;
                }
                if(count == numCourses)
                    return true;
            }
        }
        return false;
    }

}
