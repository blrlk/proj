package todoList;

import java.util.ArrayList;
import java.util.Scanner;


public class todoList {
    public static void main(String[] args) {
        todo task = new todo();
        ArrayList<todo> arr;
        taskManage tm = new taskManage();

        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("select function");
            System.out.println("1. Add task / 2. Read task / 3. check / 4. Read all task / 5. Delete task ");


            System.out.println("== Add task ==");
            arr = tm.addTask();


        }

    }

}
