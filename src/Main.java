import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        final String filename="src/ex1_1.txt";
        File file = new File(filename);

        int x[] = new int[100];

        try {
            Scanner fileInput = new Scanner(file);
            int i = 0;
            while(fileInput.hasNextInt())
                x[i++] = fileInput.nextInt();
            x = Arrays.copyOf(x, i);

        } catch (FileNotFoundException e) {
            System.out.println("Exception : " + e.getMessage());
        }

        System.out.println(Arrays.toString(x));
        System.out.println("the # of 9 = " + count9(x));
        System.out.println("the values with 9 = " + Arrays.toString(filterDigit(x, 9)));
//        int[] arrayOf9s = filter9(x);
//        for (int i=0; i<arrayOf9s.length; i++ ){
//            System.out.println(arrayOf9s[i]);
//        }
    }

    public static int count9(int x[]) {
        int count = 0;
        for (int i=0; i<x.length; i++){
                int temp = x[i];
                while(temp != 0){
                    if(temp%10 == 9){
                        count ++;
                        break;
                    }else{
                        temp /= 10;
                    }
                }
            }
        return count;
    }

    public static int[] filterDigit(int x[], int digit){

        int count = 0;
        int[] y = new int[x.length];
        for (int i=0; i<x.length; i++){
            int temp = x[i];
            while(temp > 0){
                if(temp%10 == digit){
                    y[count] = x[i];
                    count ++;
                    break;
                }else{
                    temp = temp/10;
                }
            }
        }

        y = Arrays.copyOf(y, count);
        return y;
    }

}
