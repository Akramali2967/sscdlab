/*
20
7 0 
0 3 
1 2
2 1
0 2
3 7
0 0
4 1
2 0
3 1
3
*/
import java.util.*;
class frame 
  { 
    int pagenumber=-1;
    int lastaccesstime=-1;
    void replaceframe(int pagenumber, int lastaccesstime)
        {
        this.pagenumber=pagenumber;
        this.lastaccesstime=lastaccesstime;
        }
    void refreshframe(int lastaccesstime)
        {
        this.lastaccesstime=lastaccesstime;
        }
    }   
    public class LRU
        {
          public static frame cache[];
          public static int nF;
          public static void main(String[] args)
           {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the no of page requests");
            int nR=sc.nextInt();
            int pnumbers[]=new int[nR];
            System.out.println("Enter the page requests");
            for(int i=0;i<nR;i++)
                {
                  pnumbers[i]=sc.nextInt();
                }
            System.out.println("Enter the no of frames");
            nF=sc.nextInt();
            cache=new frame[nF];
            for(int i=0;i<nF;i++)
                {
                 cache[i]=new frame();
                }
            int hit=0,fault=0;
            for(int i=0;i<nR;i++)
                {
                  int index=findpagenumber(pnumbers[i]);
                  if(index!=-1)
                    {
                      hit++;
                      cache[index].refreshframe(i);
                    }
                 else
                    {
                     fault=fault+1;
                     int temp=getlruindex();
                     cache[temp].replaceframe(pnumbers[i],i);
                    }
                 cacheprint();
                }
            System.out.println("hit= "+hit);
            System.out.println("fault= "+fault);
            sc.close();
            }
    public static int findpagenumber(int pn)
        {
        for(int i=0;i<nF;i++)
            {
              if(pn==cache[i].pagenumber)
                    {
                    return i;
                    }
            }
        return -1;
        }

        public static int getlruindex()
            {
            int min=cache[0].lastaccesstime;
            int index=0;
            for(int i=0;i<nF;i++)
                {
                if(cache[i].lastaccesstime<min)
                    {
                       min=cache[i].lastaccesstime;
                        index=i;
                    }
                }
            return index;
            }

public static void cacheprint()
        {
            for(int i=0;i<nF;i++)
                {
                    System.out.print(cache[i].pagenumber+" ");
                }
            System.out.println();
        }
    }
