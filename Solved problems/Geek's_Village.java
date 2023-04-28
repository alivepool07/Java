/*
Geek's village is represented by a 2-D matrix of characters of size n*m, where

H - Represents a house
W - Represents a well
. - Represents an open ground
N - Prohibited area(Not allowed to enter this area)

Every house in the village needs to take water from a well, as the family members are so busy with their work, so every family wants to take the 
water from a well in minimum time, which is possible only if they have to cover as less distance as possible. Your task is to determine the minimum distance 
that a person in the house should travel to take out the water and carry it back to the house.

A person is allowed to move only in four directions left, right, up, and down. That means if he/she is the cell (i,j), then the possible cells he/she can reach 
in one move are (i,j-1),(i,j+1),(i-1,j),(i+1,j), and the person is not allowed to move out of the grid.

Note: For all the cells containing 'N', 'W' and '.' our answer should be 0, and for all the houses where there is no possibility of taking water our answer 
should be -1.
*/

//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Gfg {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int m=Integer.parseInt(s[1]);
            char c[][]=new char[n][m];
            for(int i=0;i<n;i++){
                s=in.readLine().trim().split(" ");
                for(int j=0;j<m;j++){
                    c[i][j]=s[j].charAt(0);
                }
            }
            Solution ob=new Solution();
            int ans[][]=ob.chefAndWells(n, m, c);

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    out.print(ans[i][j]+" ");
                }
                out.println();
            }
        }
        out.close();
    }
}
// } Driver Code Ends






//User function Template for Java
class Solution
{
    public int [][] noWells(int n,int m, char c[][],int ans[][])
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(c[i][j]=='H') 
                {
                    ans[i][j]=-1;//since no well present so, -1
                }
                else if(c[i][j]=='N')
                {
                    ans[i][j]=0; // it is restricted area, so 0
                }
                else if(c[i][j]=='.')
                {
                    ans[i][j]=0; // it's an open area, so 0
                }
            }
        }
        return ans;
    }
    public int[][] chefAndWells(int n,int m,char c[][])
    {
        int ans[][]= new int[n][m];
        //fill answer array with max integer value;
        //Arrays.fill(ans,Integer.MAX_VALUE);
        
        Queue<Pos>q= new LinkedList<>();
        boolean visited[][]= new boolean[n][m];//records for visited index
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(c[i][j]=='W')
                {
                    q.add(new Pos(i,j));//Adding position of the wells into queue
                    visited[i][j]=true;
                }
                else
                {
                    //Initializing parts , other than 'Wells' as Maximum 
                    ans[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        if(q.size()==0)//if no wells is present
        {
            return noWells(n,m,c,ans);
        }
        
        //Four directions to search for home
        // Direction->     up,right,down,left
        int dr[]= new int[]{-1,0,1,0};
        int dc[]= new int[]{0,1,0,-1};
        
        //Initializing dstance as 0, because distance from well - well is 0
        int distance=0;//distance from well
        
        while(q.size()>0)
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                Pos p= q.poll();
                int row=p.i;
                int col=p.j;
                if(c[row][col]=='W'||c[row][col]=='.')
                {
                    ans[row][col]=0;
                }
                else if(c[row][col]=='H')
                {
                    ans[row][col]=Math.min(ans[row][col],distance*2);
                }
                for(int j=0;j<4;j++)
                {
                    int nr=row+dr[j];
                    int nc=col+dc[j];
                    if(nr<0||nr>=n||nc<0||nc>=m)//invalid co-ordinates
                    {
                        continue;
                    }
                    else if(visited[nr][nc]==false && (c[nr][nc]=='H'|| c[nr][nc]=='.')) //encountered a home
                    {
                        q.add(new Pos(nr,nc));
                        visited[nr][nc]=true;
                    }
                }
            }
            distance++;
        }
        
        //Even after the while loop terminates, there will be some places not visited
        //if the place contains 'N' & 'H' we'll mark it 0 and -1 respectively
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(visited[i][j]==false && c[i][j]=='N')
                {
                    ans[i][j]=0; //N represents restricted area
                    visited[i][j]=true;
                }
                if(visited[i][j]==false && c[i][j]=='H')
                {
                    ans[i][j]=-1; //This Home is unreachable
                    visited[i][j]=true;
                }
                if(visited[i][j]==false && c[i][j]=='.')
                {
                    ans[i][j]=0; //This ground is unreachable
                    visited[i][j]=true;
                }
            }
        }
        
        return ans;
    }
    class Pos{
        int i;
        int j;
        Pos(int i,int j)
        {
            this.i=i;
            this.j=j;
        }
    }
}
