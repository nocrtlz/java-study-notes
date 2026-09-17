package Day5;

public class ExceptionDemo1 {
    public static void main(String[] args) {
        int[] a=new int[3];
        try{
            int b=a[4];
        } catch(ArrayIndexOutOfBoundsException e){//catch子类在前
            System.out.println("数组越界");
        } catch(IndexOutOfBoundsException e){
            System.out.println("索引越界");
        }finally{
            System.out.println("finally");
        }
        System.out.println("已完成代码执行");
    }
}
