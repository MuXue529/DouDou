package cn.tx.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DishApp {

    //提前准备一些菜品，展示给用户，同时用户可以点菜
    //定义集合，表示所有的菜品
    static List<Dish> dishList = new ArrayList<>();
    static List<Dish> personDish = new ArrayList<>();

    public static void initDish(){
        dishList.add(new Dish(1,"香辣肉丝",29.0));
        dishList.add(new Dish(2,"炖王八",59.0));
        dishList.add(new Dish(3,"家常凉菜",59.0));
        dishList.add(new Dish(4,"地三鲜",24.0));
        dishList.add(new Dish(5,"油焖大虾",55.0));
    }

    public static void showMenu(){
        System.out.println("----主菜单----");
        System.out.println("菜单\t\t\t1");
        System.out.println("已点菜品\t\t2");
        System.out.println("买单\t\t\t3");
        System.out.println("----根据编号选择服务----");
    }

    private static void showDishMenu() {//展示菜单
        System.out.println("----请您点菜----");
        //遍历集合
        for (int i = 0; i < dishList.size(); i++) {
            Dish dish = dishList.get(i);
            System.out.println(dish.id+"\t"+dish.name+"\t"+dish.price);
        }
        System.out.println("----输入序号点菜，按0返回上一级----");
    }

    private static void showPersonDishMenu() {//展示已点菜品
        System.out.println("您已点：");
        for (Dish dish : personDish) {
            System.out.println(dish.id+"\t"+dish.name+"\t"+dish.price);
        }
    }

    private static void buy() {//结账
        System.out.println("----请稍等，正在结算----");
        double total = 0f;
        for (Dish dish : personDish) {
            total  += dish.price;
        }
        System.out.println("亲，您本次共消费了:"+total+" 元");
    }

    public static void main(String[] args) {
        //先初始化菜品
        initDish();
        Scanner s = new Scanner(System.in);

        //写死循环
        while (true){
            showMenu();
            int num = s.nextInt();
            switch (num){
                case 1:
                    while (true){
                        showDishMenu();
                        int id = s.nextInt();
                        if (id == 0){
                            break;
                        }
                        Dish dish = dishList.get(id-1);
                        System.out.println("亲，您点了"+dish.name+" 菜");
                        personDish.add(dish);
                    }
                case 2:
                    showPersonDishMenu();
                    break;
                case 3:
                    buy();
                    return;


            }
        }


    }




}
