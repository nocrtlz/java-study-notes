package Day07app;

public class Books {
    private String name;
    private int id;
    private BookStatus status;
    Books(String name, int id, BookStatus status){
        if(id<0) {
            throw new IllegalArgumentException("Book id cannot be negative");
        }

    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
   public BookStatus getStatus(){
        return status;
   }
   public void setStatus(BookStatus status){
        this.status = status;
   }

    @Override
    public String toString(){
        return "Books [name=" + name + ", id=" + id +"status"+status+"]";
    }
}
