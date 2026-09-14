package simplemodel;

public class Goods {
    private int id=0;
    private String name="空";
    private double price=0;
    public int getid(){
    return id;
    }
    public String getname(){
        return name;
    }
    public double getprice(){
        return price;
    }
    public void setid(int id){
        this.id = id;
    }
    public void setname(String name){
        this.name = name;
    }
    public void setprice(double price){
        this.price=price;
    }
    public void showInfo(){
        System.out.println("id="+id+" name="+name+ "price="+price);
    }
}
