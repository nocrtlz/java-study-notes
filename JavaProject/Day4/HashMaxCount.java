package Day4;

import java.util.HashMap;

public class HashMaxCount {
    public static void main(String[] args) {
        String s1="Hello world xiaoli wwwqtyu";
        HashMap<Character,Integer> map=new HashMap();
        //for遍历字符串
        for(int i=0;i<s1.length();i++){
            char c=s1.charAt(i);
            //if判断是否出现
            if(map.containsKey(c)){
                int count=map.get(c);//取出旧次数
                map.put(c,count+1);   //更新次数
            }
            else{
                map.put(c,1);//未出现，创建并设置为1次
            }
        }
        // 遍历输出统计结果
        System.out.println("各字符出现次数：");
        for (HashMap.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("字符 '" + entry.getKey() + "' 出现 " + entry.getValue() + " 次");
        }
    }
}
