package Day3;

public interface Run {
    abstract void run() ;
    default void show(){
        System.out.println("展示接口");
    };
}
