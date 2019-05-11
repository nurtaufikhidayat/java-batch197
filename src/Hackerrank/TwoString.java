package Hackerrank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class TwoString {
	
    static String twoStrings(String s1, String s2) {
        HashSet<Character> map = new HashSet<Character>();
        char[] str = s1.toCharArray();
    for(int i=0; i<s1.length();i++){
        map.add(str[i]);
    }
    for(char element: s2.toCharArray()){
        if(map.contains(element)){
            return "YES";
        }
    }
    return "NO";


    }

    private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws IOException{
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();

	}

}
