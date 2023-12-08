package slidingwindow;

import java.util.Arrays;

public class CountOccurrences {

    public static void main(String[] args) {
        System.out.println(new CountOccurrences().search("for", "forxxorfxdofr"));
    }

    int search(String pat, String txt) {

        int patlength = pat.length();//3
        int txtlength = txt.length();//13

        int patArray[] = new int[26];
        int txtArray[] = new int[26];


        for(int i=0;i<patlength;i++)
        {
            patArray[pat.charAt(i)-'a']++;
            txtArray[txt.charAt(i)-'a']++;
        }

        int count = 0;//1

        if(Arrays.equals(patArray,txtArray)) count++;


        for(int i=patlength;i<txtlength;i++)
        {
            txtArray[txt.charAt(i)-'a']++;
            txtArray[txt.charAt(i-patlength)-'a']--;

            if(Arrays.equals(patArray,txtArray)) count++;
        }


        return count;
    }
}
