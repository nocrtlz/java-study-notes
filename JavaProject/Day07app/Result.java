package Day07app;

public class Result<T> {
    private boolean success;
    private String message;
    private T data;
    public Result(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
    public static <T> Result<T> ok(T data){
        return new Result<>(true,"已完成",data);
    }
    public static <T> Result<T> fail(String message){
        return new Result<>(false,message,null);
    }
    public boolean isSuccess() {return success;}
    public String getMessage() {return message;}
    public T getData() {return data;}
}
