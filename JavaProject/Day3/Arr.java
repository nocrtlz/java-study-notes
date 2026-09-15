package Day3;
import java.util.Scanner;
public class Arr {
    public static void main(String[] args) {
        int[] arr = {10, 11, 15, 19, 198, 25};
        int index=-1;
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                index=i;
                System.out.println(index);
                break;
            }
        }
        sc.close();
    }
}
