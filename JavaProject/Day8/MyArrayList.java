package Day8;
import java.util.ArrayList;
import java.util.List;
public class MyArrayList {
    //手写简易ArrayList
    Object[] arr;
    int size;
    //初始化
    public MyArrayList(){
        arr=new Object[10];
        size=0;
    }
    //增加
    public void add(Object o){
        if(size==arr.length){
            grow();
        }
        arr[size]=o;
        size++;
    }
    //扩容
    public void grow(){
        Object[] newArr=new Object[arr.length*2];
        //复制,size和arr.length一样
        System.arraycopy(arr,0,newArr,0,arr.length);
        arr=newArr;
    }
    //获取
    public Object get(int i){
        //简单判断，抛出异常
        if(i<0||i>size){
           throw new IndexOutOfBoundsException("数组下标越界");
        }
        return arr[i];
    }
    public int size(){
        return size;
    };

    public static  void main(String[] args) {
        MyArrayList list=new MyArrayList();
        list.add("你好");
        list.add("我好");
        list.add("大家好");
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
