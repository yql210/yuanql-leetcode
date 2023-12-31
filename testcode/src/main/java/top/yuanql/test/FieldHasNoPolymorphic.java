package top.yuanql.test;

import java.io.IOException;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql
 * @BelongsClassName: FieldHasNoPolymorphic
 * @Author: yuanql
 * @CreateTime: 2023-08-11  17:36
 * @Description:
 * @Version: 1.0
 */


public class FieldHasNoPolymorphic {
    static class Father{
        public int money = 1;
        public Father(){
            money = 2;
            showMeTheMoney();
        }
        public void showMeTheMoney(){
            System.out.println("I am Father, i have $" + money);
        }
    }
    static class Son extends Father{
        public int money = 3;
        public Son(){
            money = 4;
            showMeTheMoney();//第二行的结果
        }
        public void showMeTheMoney(){
            System.out.println("I am Son, i have $" + money);
        }
    }
    public static void main(String[] args) throws IOException {
        Father gay = new Son();
        System.out.println("This gay has $" + gay.money);

        int read = System.in.read();
    }

}
