// 4  8  4 9 5
import java.util.*;
public class lab7b 
    {
    public static void main(String[] args) 
    {
    int process[],bt[],wt[],tat[],i,j,n,total=0;
    int pos,temp;
    float avg_wt,avg_tat;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter no of process");
    n = sc.nextInt();
    process=new int[n];
    bt = new int[n];
    wt = new int[n];
    tat = new int[n];
    System.out.println("Enter bt");
    for(i=0;i<n;i++)
     {
        System.out.println("p["+(i+1)+"]");
        bt[i]=sc.nextInt();
        process[i]=i+1;
     }
    for(i=0;i<n;i++)
        {
          pos=i;
          for(j=i+1;j<n;j++)
            {
            if(bt[j]<bt[pos])
                {
                  pos=j;
                }
            }
        temp=bt[i]; 
        bt[i]=bt[pos];
        bt[pos]=temp;
        temp=process[i];
        process[i]=process[pos];
        process[pos]=temp;
        }
    wt[0]=0;
    for(i=0;i<n;i++)
      {
        wt[i]=0;
        for(j=0;j<i;j++)
          {
           wt[i]=wt[i]+bt[j];
            }
        total=total+wt[i];
        }
    avg_wt=(float)total/n;
    System.out.println("Process\t"+"BT\t"+"WT\t"+"TAT");
    total=0;
    for(i=0;i<n;i++)
      {
        tat[i]=wt[i]+bt[i];
        total=total+tat[i];
        System.out.println("P"+process[i]+"\t"+bt[i]+"\t"+wt[i]+"\t"+tat[i]);
       }
    avg_tat=(float)total/n;
    System.out.println("Avg Wt: \t"+avg_wt);
    System.out.println("Avg Tat: \t"+avg_tat);
    }
}
