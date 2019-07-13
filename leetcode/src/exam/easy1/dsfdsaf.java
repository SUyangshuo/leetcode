package exam.easy1;

import java.util.Scanner;

public class dsfdsaf {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("asdsadasd");
		String str=sc.nextLine();
		removerepeatedchar(str);
	}
	public static void removerepeatedchar(String s) {
        if (s == null)
            return;
        StringBuilder sb = new StringBuilder();
        int i = 0, len = s.length();
        while (i < len) {
            char c = s.charAt(i);
            sb.append(c);
            i++;
            while (i < len && s.charAt(i) == c) {
                i++;
            }
        }
       
        for(int g= sb.length();g>=0;g--){
        	System.out.print(sb.charAt(g));
        }
        
    }
}
