package Day4;

public class text1 {
    public static void main(String[] args) {
        String s1="Hello world xiaolin";
        String res="";
        //从长度-1开始
        int l=s1.length()-1;
        for(;l>=0;l--){
            res+=s1.charAt(l);
        }
        System.out.println(res);
    }
}
