package Day4;

public class Main {
    public static void main(String[] args){
        User u1=new User(1,"张三");
        User u2=new User(1,"李四");
        if(u1.equals(u2))
            System.out.println("该用户相同");
        else
            System.out.println("0");
        System.out.println(u1.hashCode());
        System.out.println(u2.hashCode());
    }
}
