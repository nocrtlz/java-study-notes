package Day07app;
import java.util.List;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        /*书本服务
         *数字1 存入书本
         *数字2 删除书本
         *数字3 查找书本
         *数字4 列出书本
        */
        BookService service = new BookService();
        Scanner sc = new Scanner(System.in);
        int opCount=0;
        while(true){
            System.out.println("===== 图书管理系统 =====");
            System.out.println("1. 添加   2. 删除   3. 查询   4. 列表   5. 退出");
            System.out.print("请输入操作编号：");

            try {
                int choice = Integer.parseInt(sc.nextLine());   //强制把字符串转换成数字
                switch (choice) {
                    case 1 -> {
                        System.out.print("书籍id：");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("书名：");
                        String name = sc.nextLine();
                        Result<Void> r = service.addBook(new Books(name, id, BookStatus.IN_STOCK));
                        System.out.println(r.isSuccess() ? "添加成功" : "【失败】" + r.getMessage());
                    }
                    case 2 -> {
                        System.out.print("要删除的书籍id：");
                        int id = Integer.parseInt(sc.nextLine());
                        Result<Books> r = service.deleteBook(id);
                        System.out.println(r.isSuccess() ? "已删除：" + r.getData() : "【失败】" + r.getMessage());
                    }
                    case 3 -> {
                        System.out.print("要查询的书籍id：");
                        int id = Integer.parseInt(sc.nextLine());
                        Result<Books> r = service.findBook(id);
                        System.out.println(r.isSuccess() ? "查到：" + r.getData() : "【失败】" + r.getMessage());
                    }
                    case 4 -> {
                        Result<List<Books>> r = service.listBooks();
                        List<Books> all = r.getData();
                        if (all.isEmpty()) System.out.println("书库是空的");
                        else all.forEach(System.out::println);
                    }
                    case 5 -> {
                        System.out.println("本次共操作 " + opCount + " 次，再见！");
                        return;
                    }
                    default -> System.out.println("无效编号，请重新输入");
                }
                opCount++;
            } catch (NumberFormatException e) {
                System.out.println("【输入错误】请输入数字");
            } catch (BusinessException e) {
                System.out.println("【业务错误】" + e.getMessage());
            }
        }
    }
}
