
import java.util.Random;
import java.util.Scanner;// библ для ввода с клавиатуры

public class Main {


    public static String expand(String s) {
        int n=s.length();
        String[]S=new String[n];
        {
            for (int i=0;i<n;i++)
            {
                S[i]=Character.toString(s.charAt(i));
            }
        }


        int sign=1;
        int sign2=1;
        int a;
        int b;
        int nn;
        String x;

        int caret=1;

        if(S[1].equals("-"))
        {
            caret++;
           sign=-1;
        }
        if(S[1].equals("+"))
        {
            caret++;
            sign=-1;
        }

        int[]AA=new int[2];
        AA=Rasp_num(S,caret,0);
        a=AA[0];
        caret=AA[1];
        x=S[caret];
        caret++;
        if(S[caret].equals("-"))
        {
            caret++;
            sign2=-1;
        }

        if(S[caret].equals("+"))
        {
            caret++;
        }
        if(S[caret].equals(")"))
        {
            caret--;
        }

        int[]BB=new int[2];
        BB=Rasp_num(S,caret,1);
        b=BB[0];
        caret=BB[1];
        caret=caret+2;

        int[]NN=new int[2];
        NN=Rasp_num(S,caret,2);
        nn=NN[0];
        caret=NN[1];

        a=a*sign;
        b=b*sign2;
        Polinom P=new Polinom(a,b);
        Polinom Q=Polinom.pow(P,nn);


        String Res=Q.Print6(x);

        System.out.println(s);
        System.out.println(Res);


        return Res;
    }
    public  static int[] Rasp_num(String[] S,int caret,int ab)
    {
        int n=S.length;
        int[] Res=new  int[2];
        String Ress="";
        int i=caret;

        String sss=S[i];
        boolean Stop=true;
        while (Stop) {
            if (S[i].equals("0") ||
                    S[i].equals("1") ||
                    S[i].equals("2") ||
                    S[i].equals("3") ||
                    S[i].equals("4") ||
                    S[i].equals("5") ||
                    S[i].equals("6") ||
                    S[i].equals("7") ||
                    S[i].equals("8") ||
                    S[i].equals("9")
            ) {
                Ress += S[i];
                i++;
                if(i==n)
                {
                    Stop=false;
                }
            }
            else {
                Stop=false;
            }
        }

        if(Ress==""){
                if(ab==0)
                {
                    Res[0]=1;
                    Res[1]=caret;
                    return Res;
                }
            if(ab==1)
            {
                Res[0]=0;
                Res[1]=caret;
                return Res;
            }

        }
        Res[0] =Integer.parseInt(Ress);
        Res[1]=i;
        return Res;
    }

    private static Scanner inn = new Scanner(System.in);// метод для ввода с клавиатуры

    public static <string> void main(String[] args) {


        double[]A={1,2,1};
        double[]B={1,1};

        Polinom P=new Polinom(A);
        Polinom Q=new Polinom(B);



        String s="(-12c+1)^15";


        System.out.println( expand(s));


    }
}
