
import java.io.File;
import java.util.Scanner;

/**
 * Created by Soroush on 4/7/2017.
 */
public class Person {
    public String word = "";
    public static void main(String[] args) throws InterruptedException {
        Scanner i=new Scanner(System.in);
        while(true) {

            System.out.println("Enter your word:");
            String Myword=i.nextLine();
            if (Myword.equalsIgnoreCase("end"))
                System.exit(0);
            Bots bot1 = new Bots(1, "1.txt");
            Bots bot2 = new Bots(2, "2.txt");
            Bots bot3 = new Bots(3, "3.txt");
            Bots bot4 = new Bots(4, "4.txt");
            Bots bot5 = new Bots(5, "5.txt");
            bot1.setWord(Myword);
            bot2.setWord(Myword);
            bot3.setWord(Myword);
            bot4.setWord(Myword);
            bot5.setWord(Myword);
            Thread a1=new Thread(bot1);
            Thread a2=new Thread(bot2);
            Thread a3=new Thread(bot3);
            Thread a4=new Thread(bot4);
            Thread a5=new Thread(bot5);
            a1.start();
            a2.start();
            a3.start();
            a4.start();
            a5.start();
            Thread.sleep(3000);

        }

    }
}
