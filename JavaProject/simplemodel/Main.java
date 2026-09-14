package simplemodel;

public class Main {
    public static void main(String[] args) {
    Phone p1=new Phone();
    Book b1=new Book();
    b1.setauthor("马冬梅");
    p1.setbrand("菠萝牌");
    b1.setprice(20);
    p1.setprice(200);
    b1.showInfo();
    p1.showInfo();
    }
}
