package Day4;
import java.util.Objects;
public class User {
    int id;
    String name;

    public User(int id, String name){
        this.id=id;
        this.name=name;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj){return true;}
        if(obj==null||getClass()!=obj.getClass()) return false;
        User u=(User)obj;
        return id==u.id&&Objects.equals(name,u.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id,name);
    }

}
