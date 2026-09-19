package Day07app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
public class BookService{
    //全局书本数量
    private List<Books> bookList=new ArrayList<>();
    private HashMap<Integer,Books> bookMap=new  HashMap<>();

    public Result<Void> addBook(Books book){
        if(bookMap.containsKey(book.getId())){
            return Result.fail("ID:"+book.getId()+"已存在");
        }
        bookList.add(book);
        bookMap.put(book.getId(),book);
        return Result.ok(null);
    }
    public Result<Books> deleteBook(int id){
        Books book=bookMap.get(id);
        if(book==null) return Result.fail("找不到id："+book.getId()+"的书");
        bookList.remove(book);
        bookMap.remove(id);
        return Result.ok(null);
    }
    public Result<Void> updateBook(Books book){

        return Result.ok(null);
    }
    public Result<Books> findBook(int id){
        Books book=bookMap.get(id);
        return book==null?Result.fail("查无此书"):Result.ok(book);
    }
    public Result<List<Books>> listBooks(){
        return Result.ok(bookList);
    }
}
