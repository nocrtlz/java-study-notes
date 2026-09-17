package Day5;

public class Demo3 {
    public static void main(String[] args) {
        Controller controller = new Controller();
        try {
            controller.handle();
        } catch (BusinessException e) {
            System.out.println("最外层捕获：" + e.getMessage());
            System.out.println("错误码：" + e.getCode());
            System.out.println("\n异常链：");
            Throwable cause = e.getCause();
            while (cause != null) {
                System.out.println(cause.getClass().getSimpleName() + " -> " + cause.getMessage());
                cause = cause.getCause();
            }
        }
    }
}
class Controller {
    private final Service service = new Service();
    public void handle() {
        try {
            service.process();
        } catch (BusinessException e) {
            // 包装异常，并把原异常作为 cause 传进去
            throw new BusinessException(3001, "Controller 处理失败", e);
        }
    }
}
class Service {
    private final Repository repository = new Repository();
    public void process() {
        try {
            repository.query();
        } catch (Exception e) {
            // 把底层异常包装成业务异常，保留 cause
            throw new BusinessException(2001, "Service 查询失败", e);
        }
    }
}
class Repository {
    public void query() throws Exception {
        // 模拟底层异常
        throw new Exception("底层数据库连接失败");
    }
}
