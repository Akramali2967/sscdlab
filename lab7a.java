//3 24 3 3 2
import java.util.*;
public class RoundRobin
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int num,rp,quantum,bt[],rt[];
        bt=new int[10];
        rt=new int[10];
        System.out.println("ENTER NO. OF PROCESSES");
        num = sc.nextInt();
        System.out.println("ENTER BURST TIME");
        for(int i=0;i<num;i++)
        {
            System.out.println("P["+(i+1)+"]");
            bt[i]=sc.nextInt();
            rt[i]=bt[i];
        }
        System.out.println("ENTER QUANTUM");
        quantum=sc.nextInt();
        int time=0,i=0;
        rp=num;
        System.out.println("|PROCESS|TIME(0)|");
        System.out.println("");
        System.out.println("");
        while(rp>0)
            {
            if(rt[i]>quantum)
                {
                 rt[i]=rt[i]-quantum;
                 System.out.print("| P"+(i+1)+"|");
                 time = time + quantum;
                 System.out.println(time);
                }
            else if(rt[i]<=quantum && rt[i]>0)
            {
            time = time +rt[i];
            rt[i]=rt[i]-rt[i];
            System.out.print("| P"+(i+1)+"|");
            System.out.println(time);
            rp--;
            }
        i++;
        if(i==num)
            i=0;
        }
    }
}
