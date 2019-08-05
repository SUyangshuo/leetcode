package exam.NiuKe.WangYi;

import java.util.Scanner;

public class 路灯问题 {
        //从前往后遍历，遇到.就前进3个（+2)
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                int n = scanner.nextInt();
                while (n-- > 0) {
                    int len = scanner.nextInt();
                    String line = scanner.next();
                    int count = 0;
//                在需要防止路灯位置的右边放置路灯
                    for (int i = 0; i < len; i++) {
                        if (line.charAt(i) == 'X') {
                            continue;
                        }
                        count++;
                        i += 2;
                    }
                    System.out.println(count);
                }
            }
        }

}
