import java.util.Scanner;

public class copy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int countCopy = Integer.parseInt(str[0]);
        int speedFirst = Integer.parseInt(str[1]);
        int speedSecond = Integer.parseInt(str[2]);
        int result = 0;
        if (speedSecond > speedFirst){
            result+=speedSecond;
            countCopy-=1;
        }else{
            result+=speedFirst;
            countCopy-=1;
        }
        int a = countCopy / (speedSecond + speedFirst);
        result += a;
        if (speedSecond > speedFirst){
            result+=speedFirst;
        }else{
            result+=speedSecond;
        }
        System.out.println(result);
    }
}
