package Day5;

/*
 * 自定义业务异常
 * 继承 RuntimeException，表示非受检异常
 * 调用者不强制 try-catch，但业务上可以主动捕获处理
 */
public class BusinessException extends RuntimeException{
   /*业务错误码*/
    private final int code;
    public BusinessException(int code,String message){
        super(message);
        this.code=code;
    }
    public BusinessException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
