package Day3;

public class Dog extends Animal implements Run{
    @Override
    void eat() {
        System.out.println("Dog eat");
    }
    public void run(){
        System.out.println("Dog run");
    }
}
