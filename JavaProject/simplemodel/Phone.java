package simplemodel;

public class Phone extends Goods{
    private String brand;
    public String getbrand(){
        return brand;
    }
    public void setbrand(String brand){
        this.brand=brand;
    }
    @Override
    public void showInfo(){
        System.out.println("id="+ getid() +" name="+getname()+ " price="+getprice()+" brand="+brand);
    }
}
