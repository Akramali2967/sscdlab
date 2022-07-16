// 3 4
// 1 2 2 1
// 1 0 2 3
// 1 2 1 0
// 3 3 2 2
// 1 1 3 4
// 1 3 5 0
// 3 1 1 2
import java.util.*;
public class lab8
    {
        private int np,nr,need[][],allocate[][],max[][],avail[][];
        private void input()
            {
              Scanner sc=new Scanner(System.in);
              System.out.println("Enter no.of Processes and resources:");
              np=sc.nextInt();
              nr=sc.nextInt();
              need=new int [np][nr];
              allocate=new int [np][nr];
              max=new int [np][nr];
              avail=new int [1][nr];
              System.out.println("Enter allocate matrix:");
              for(int i=0;i<np;i++)
                  {
                    for(int j=0;j<nr;j++)
                        {
                          allocate[i][j]=sc.nextInt();
                        }
                    }
              System.out.println("Enter max matrix:");
              for(int i=0;i<np;i++)
                {  
                 for(int j=0;j<nr;j++)
                        {
                         max[i][j]=sc.nextInt();
                        }
                }       
              System.out.println("Enter avail matrix:");
             for(int j=0;j<nr;j++)
              {
                avail[0][j]=sc.nextInt();
              }
            sc.close();
          }
    private int[][] calcneed()  
        {
            for(int i=0;i<np;i++)
                {  
                  for(int j=0;j<nr;j++)
                  {
                    need[i][j]=max[i][j]-allocate[i][j];
                   }
                }
            return need;
        }
    private boolean check(int i)
        {
          for(int j=0;j<nr;j++)
            {
                if(avail[0][j]<need[i][j])
                {
                    return false;
                }
            }
         return true;
        }
    public void isSafe()
        {
        input();
        calcneed();
        boolean done[]=new boolean[np];
        int j=0;
        while(j<np)
            {
              boolean allocated =false;
                for(int i=0;i<np;i++)
                    {
                      if(!done[i] && check(i))
                            {
                            for(int k=0;k<nr;k++)
                                {
                                    avail[0][k]=avail[0][k]-need[i][k]+max[i][k];
                                }
                            System.out.println("Allocated Process:"+i);
                            allocated=done[i]=true;
                            j++;
                            }
                    }
                if(!allocated)
                    break;
            }
        if(j==np)
            System.out.println("Safely Allocated");
        else
            System.out.println("All processes cannot be allocated safely");
        }   
    public static void main(String[]args)
        {
            new lab8().isSafe();
        }
    }
