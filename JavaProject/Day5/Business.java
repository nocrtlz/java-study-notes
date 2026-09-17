package Day5;

public class Business {
    public static void main(String[] args) {
        BankService bankService = new BankService();

        try{
            bankService.withdraw(1000,200);
        }catch(BusinessException e){
            System.out.println("捕获错误code"+e.getCode()+" 捕获Message："+e.getMessage());
        }
        try{
            bankService.withdraw(1000,-1);
        }catch(BusinessException e){
            System.out.println("捕获错误code"+e.getCode()+" 捕获Message："+e.getMessage());
        }
    }

}
class BankService{
    public void withdraw(double balance,double amount){
        if(amount<=0){
            throw new BusinessException(1001,"取款金额必须大于0");
        }
        if(amount>balance){
            throw new BusinessException(1002,"余额不足");
        }
        System.out.println("取款成功:"+amount);
    }
}