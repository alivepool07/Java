//Shortest Path by Removing K walls
//GFG

/*Given a 2-D binary matrix of size n*m, where 0 represents an empty space while 1
represents a wall you cannot walk through. You are also given an integer k.
You can walk up, down, left, or right. Given that you can remove up to k walls, return
the minimum number of steps to walk from the top left corner (0, 0) to the bottom right
corner (n-1, m-1).
Note: If there is no way to walk from the top left corner to the bottom right corner,
return -1.

 */

import java.util.ArrayDeque;

public class Shortest_Path_by_Removing_K_walls {

    public static void main(String[] args) {

    }
    public static class Fours{
        int i,j;
        int dist; int obs;
        Fours(int i,int j,int dist,int obs){
            this.i=i; this.j=j; this.dist=dist; this.obs=obs;
        }
    }
    static int shortestPath(int[][] mat, int n, int m, int k) {
        // code here
        ArrayDeque<Fours> q = new ArrayDeque<>();
        q.add(new Fours(0,0,0,k));
        boolean[][][] visited = new boolean[n][m][k+1];
        visited[0][0][k]=true;
        int[] dx = {1,0,0,-1};
        int[] dy = {0,1,-1,0};
        while(!q.isEmpty()){
            Fours curr = q.poll();
            int i=curr.i, j=curr.j, dist=curr.dist, obs=curr.obs;
            if(i==n-1 && j==m-1) return dist;
            for(int dir=0; dir<4; dir++){
                int ni=i+dx[dir], nj=j+dy[dir];
                if(ni>=0 && nj>=0 && ni<n && nj<m && !visited[ni][nj][obs]){
                    if(mat[ni][nj]==0){
                        visited[ni][nj][obs]=true;
                        q.add(new Fours(ni,nj,dist+1,obs));
                    }else if(mat[ni][nj]==1 && obs>0){
                        visited[ni][nj][obs]=true;
                        q.add(new Fours(ni,nj,dist+1,obs-1));
                    }
                }
            }
        }
        return -1;
    }
}
