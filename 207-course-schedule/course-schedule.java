class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        int indegree[] = new int[numCourses];

        for(int g[]:prerequisites){
            int u = g[0];
            int v = g[1];
            graph.get(v).add(u);
            indegree[u]++;
        }

        Queue<Integer>q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer>ans = new ArrayList<>();

        while(!q.isEmpty()){
            int x = q.remove();
            ans.add(x);
            for(int v:graph.get(x)){
                indegree[v]--;
                if(indegree[v]==0){
                    q.add(v);
                }
            }
        }
        return ans.size() == numCourses;
    }
}