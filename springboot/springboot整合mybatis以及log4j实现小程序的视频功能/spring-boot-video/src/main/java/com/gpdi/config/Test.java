package com.gpdi.config;


import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> list1 = Arrays.asList(1, 2);
        list.forEach((a) -> {
            System.out.print(a + "  ");
        });
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        List<Integer> list2 = new ArrayList();
//        list2.add(1);
//        int arr2[] = {1, 2};
//        for (int i = 0; i < list2.size(); i++) {
//            for (int j = 0; j < list.size(); j++) {
//                if (list2.get(i) == list.get(j)) {
//                    list.remove(list2.get(i));//把大循环里面的数值移除
//                }
//            }
//        }
//        list.forEach((a) -> {
//            System.out.print(a+"  ");
//        });
    }
}
