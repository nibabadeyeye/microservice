package com.whs.test;

public class Test {
    public int add(int a,int b)
    {
       return a+b;
    }


    public static void main(String[] args) {
//        String aa="11*33*44";
//        String bb=aa.substring(aa.lastIndexOf("*"));
//        String cc=bb.substring(1,bb.length());
//        System.out.println(cc);
//        for(int i=1;i<10;i++)
//        {
//            for(int j=2;i<10;j++)
//            {
//                if(i%j==0)
//                {
//                    break;
//                }else {
//
//                    }
//            }
//       //     System.out.println(i);
//        }
        for(int i=0;i<10;i++)
        {
            if(i==8)
            {
                continue;
            }else
                {
                    System.out.println(i);
                }
        }
    }
}
