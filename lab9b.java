//10 2 3 5 4 2 5 7 3 8 7
import java.io.*;
public class FIFO {
public static void main(String[] args) throws IOException
    {
        int frames[] = new int[3];
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of inputs");
        n = Integer.parseInt(br.readLine());
        int ip[] = new int[n];
        System.out.println("Enter inputs");
        for(int i = 0;i<n;i++)
            {
              ip[i] = Integer.parseInt(br.readLine());
            }
        for(int i=0;i<3;i++) //setting frame
            {
             frames[i] = -1;
            }
        int hit = 0,fault = 0,j = 0;
        boolean check;
        for(int i = 0;i<n;i++)
            {
            check = false;
            for(int k=0;k<3;k++)
             {  
               if(ip[i] == frames[k])
                {
                  hit = hit+1;
                  check = true;
                }
            }
            if(check == false)
                {
                 frames[j] = ip[i];
                 fault = fault+1;
                 j = j+1;
                }
            if(j>=3)
            {
             j=0;
            }
            }
System.out.println("Hit : "+hit);
System.out.println("Fault: "+fault);
}
}
