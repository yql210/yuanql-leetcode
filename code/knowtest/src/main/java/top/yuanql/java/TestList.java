package top.yuanql.java;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.java
 * @BelongsClassName: TestList
 * @Author: yuanql
 * @CreateTime: 2023-08-05  15:22
 * @Description:
 * @Version: 1.0
 */


public class TestList {

    public static void main(String[] args) {


//        Object[] EMPTY1 = {};
//        Object[] EMPTY2 = {};
//        Object[] EMPTY3 = {};
//
//        System.out.println(EMPTY1);
//        System.out.println(EMPTY2);
//        System.out.println(EMPTY3);
//
//        List list1 = new ArrayList<>();
//        List list2 = new ArrayList<>();
//
//
//
//        System.out.println(list1);
//        System.out.println(list2);
//        System.out.println(System.identityHashCode(list1));
//        System.out.println(System.identityHashCode(list2));
//        System.out.println(list1 == list2);
//
//        System.out.println("----------------------------------------");

        List list = new LinkedList<>();



        AbstractList<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;

        list1 = list3;
        list2 = list3;

        List<String> list4 = new ArrayList<>();
    }


}
