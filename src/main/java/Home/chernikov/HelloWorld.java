package Home.chernikov;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by admin on 1/30/2018.
 */
public class HelloWorld {//On ge PassGen
    static final int PAWORD_DOWN = 8;
    static final int PAWORD_UP = 20;
    static final String SYMBOL_GROUP = "!@#$%^&*";
    static final String NUMBER_GROUP = "1234567890";
    static final String LETTERS_GROUP = "POIUYTREWQASDFGHJKLMNBVCXZqwertyuiopasdfghjklzxcvbnm";
    static final int GROUP_COUNT = 3;
    private final Random random;
    static final int SYMBOL_GROUP_ID = 0;
    static final int NUMBER_GROUP_ID = 1;
    static final int LETTERS_GROUP_ID = 2;

    public HelloWorld() {//kostructor class'a
        random = new Random();
    }

    private char getRandomChar(String alphabet) {
        int index = random.nextInt(alphabet.length());
        return alphabet.charAt(index);
    }

    public String generation(int dlina) {
        if (dlina > PAWORD_UP || dlina < PAWORD_DOWN) {
            return null;
        }

        StringBuilder password = new StringBuilder();
        boolean exist = true;
        int count = 1;
        while (password.length() < dlina) {
            char nextChar;
            switch (random.nextInt(GROUP_COUNT)) {
                case SYMBOL_GROUP_ID:
                    if (exist) {
                        nextChar = getRandomChar(SYMBOL_GROUP);
                        password.append(nextChar);
                        exist = false;
                    }
                    break;
                case NUMBER_GROUP_ID:
                    if (count <= 3) {
                        nextChar = getRandomChar(NUMBER_GROUP);
                        if (password.length() == 0 || password.charAt(password.length() - 1) != nextChar) {
                            password.append(nextChar);
                            count++;
                        }
                    }
                    break;
                case LETTERS_GROUP_ID:
                    nextChar = getRandomChar(LETTERS_GROUP);
                    if (password.length() == 0 || password.charAt(password.length() - 1) != nextChar) {
                        password.append(nextChar);
                    }
                    break;
            }

        }
        System.out.printf("%nYour password is: ");
        return password.toString();
    }


    public int getVvod() {
        System.out.printf("Vvedite dliny parol9 ot 8 do 20 symvolov %n");
        Scanner console = new Scanner(System.in);
        int passLen = 0;
        while (true) {

            int pl = console.nextInt();
            if (pl > PAWORD_UP || pl < PAWORD_DOWN) {
                System.out.printf("Vvedite dliny parol9 ot 8 do 20 symvolov %n");
                passLen = pl;
            } else {
                passLen = pl;
                return passLen;
               // break;
            }
        }

    }
}
            //int r=rand.nextInt(10);

       /* int[][] m = new int[10][10];//obj9vlenie masiva
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++)
                m[i][j] = i + j;
        }
       /* for (int i=0; i<m.length;i++) {
            for(int j=0; j<m[i].length; j++)
                System.out.print(m[i][j]+" ");
        }*/
        /*for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }

        String str1 = "some String";
        String str2 = "some String";

        System.out.println(str1.equals(str2));
        int[] h = new int[100];
        StringBuilder sb = new StringBuilder();
        for (int mm : h) {
            sb.append(mm)
                    .append(',');
        }
        System.out.println(sb.toString());

        Pattern pattern = Pattern.compile("[A-z]{2}");
        Scanner line = new Scanner(System.in);
        pattern.matcher(line).matches();

*/



