package simplemodel;

public class Book extends Goods{
    private String author="无";
    public String getauthor(){
        return author;
    }
    public void setauthor(String author){
        this.author=author;
    }
    @Override
    public void showInfo(){
        System.out.println("id="+getid()+" name="+getname()+" price="+getprice()+" author="+author);
    }
}
