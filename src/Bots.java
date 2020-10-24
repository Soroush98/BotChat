import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Soroush on 4/7/2017.
 */
public class Bots implements Runnable{
    private String file;
    private int num;
    private String word;
    private int wait=0;
    private int delay=0;
    Bots(int num,String file)
    {
      this.file=file;
      this.num=num;
    }
    public void setWord(String word)
    {
        this.word=word;
    }
    public  String  find()
    {
        int random=(int )(Math.random()*500);
        try {
            Thread.sleep(random);
            delay=random;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String k=" ";
        try {
            int d=0;
            Scanner i=new Scanner (Paths.get(file));
            while (i.hasNext())
            {
                String t=i.next();
                if (t.equals(word))
                {
                    d++;
                    i.nextLine();
                }

            }

            i.close();
            if (d!=0) {
                Random rand = new Random();
                int r = rand.nextInt(d) + 1;
                // System.out.println(r);
                Scanner refile = new Scanner(Paths.get(file));
                int j=0;
                String t="";
                while(j!=r) {
                    t=refile.nextLine();
                    if (t.contains(word)) {
                        j++;
                    }

                }
                k=t;
                refile.close();
            }
            else
                k="Nothing to say";
        } catch (IOException e) {

        }
        return k;
    }
    @Override
    public void run() {
        synchronized (word) {
            if (wait > 3) {
                word.notifyAll();
                wait = 0;
            }
            System.out.println("Robot number "+this.num+" replayed " +find()+" with delay "+delay);

                try {
                    if (wait==0)
                    {
                        wait++;
                        word.wait();

                    }
                    else if (wait==4) {
                        wait=0;
                        word.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

