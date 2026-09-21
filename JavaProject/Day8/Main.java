package Day8;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1,"s1"));
        list.add(new Student(2,"s2"));
        list.add(new Student(3,"s3"));
        list.add(new Student(4,"s4"));
        list.add(new Student(5,"s5"));
        //for-each循环打印
        for(Student s:list){
            System.out.println(s);
        }
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"student1");
        map.put(2,"student2");
        map.put(3,"student3");
        map.put(4,"student4");
        map.put(5,"student5");
        //输入
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学号:");
        int id=sc.nextInt();
        String name=map.get(id);
        //打印
        if(map.containsKey(id)){
            System.out.println("查到学生:"+name);
        }
        else{
            System.out.println("没有查到该学生");
        }
    }
}
