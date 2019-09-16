package exam.NiuKe.wuba;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class diyi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string=in.nextLine();
        Set<String> set=new HashSet<>();
        for(String temp:string.split(",")){
            set.add(temp);
        }
        System.out.println(set.size());
    }
}
