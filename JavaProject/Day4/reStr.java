package Day4;

public class reStr {
    public static void main(String[] args) {
        String str1=" Hello Java World ";
        System.out.println(str1);
        String str2=str1.trim();
        System.out.println(str2);
        String str3=str2.toLowerCase();
        System.out.println(str3);
        //截取java子串
        //获取java字符开始下标
        int index=str3.indexOf("java");
        //substring截取目标;
        if(index!=-1){
        String r=str3.substring(index,index+4);
        System.out.println(r);
        }
        //判断开头字符
        if(str3.startsWith("Hello")) System.out.println("Hello开头");
        //用s[]接受split()分开空格前后字符然后打印
        String s[]=str3.split(" ");
        for(String i:s){
            System.out.println(i+"-");
        }
    }
}
