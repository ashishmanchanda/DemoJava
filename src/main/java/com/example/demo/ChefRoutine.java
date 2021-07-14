package com.example.demo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ChefRoutine {
    public static void main (String s[])
    {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t=0;
        try{
            t=Integer.parseInt(br.readLine());
            while(t>0)
            {
                String in=br.readLine();
                int len=in.length();
                int max=0;
                int newMax;
                String ans="yes";
                switch(in.charAt(0))
                {
                    case 'C': max=0;
                        break;
                    case 'E':max=1;
                        break;
                    case 'S':max=2;
                }
                newMax=max;
                for(int i=1;i<len;i++)
                {
                    switch(in.charAt(i))
                    {
                        case 'C': newMax=0;
                            break;
                        case 'E':newMax=1;
                            break;
                        case 'S':newMax=2;
                    }
                    if(newMax<max)
                    {
                        ans="no";
                        break;
                    }else{
                        max= newMax;
                    }
                }
                System.out.println(ans);
                t--;
            }

        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}

