package Day6;

public class GetNumber {
    //泛型类
    public static class  Result <T> implements GenericStack<Result<T>>{
        private T t;
        public void add(T t) {
            this.t = t;
        }
        public T getT() {
            return t;
        }
        //泛型方法
        public static <K,V> void Pair(K k,V v) {


        }
        @Override
        public void CiFang(Result<T> o) {
            System.out.printf(""+o.getT());
        }
    }
    //接口
    interface GenericStack<T>{
        public void CiFang(T t);
    }
    public static void main(String[] args) {
        Result<Integer> intResult=new Result<>();
        Result<String> stringResult=new Result<>();

        intResult.add(12);
        stringResult.add("12345");

        System.out.println(intResult.getT());
        System.out.println(stringResult.getT());
    }
}
