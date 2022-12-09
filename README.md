# Binomial_Expansion-3kyu
# 09.12.2022
# [cылка на задание](https://www.codewars.com/kata/540d0fdd3b6532e5c3000b5b/train/java)
# Код:
```java

import java.util.Random;


 class Polinom
    {
        protected double[] A;

        //////////////////////////////////////////////////////////// конструкторы начало
        public Polinom(double[] AA)
        {
            A = AA;

        }
        public Polinom(double a0, double a1, double a2)
        {
            double[] AA = new double[3];
            AA[0] = a0;
            AA[1] = a1;
            AA[2] = a2;
            A = AA;

        }
        public Polinom(double a0, double a1)
        {
            double[] AA = new double[2];
            AA[0] = a0;
            AA[1] = a1;
            A = AA;

        }
        public Polinom(double a0)
        {
            double[] AA = new double[1];
            AA[0] = a0;

            A = AA;

        }


        public Polinom()
        {

        }
        //////////////////////////////////////////////////////////// конструкторы конец

        private static void reverse(double[] A) {
            double[] temp = new double[A.length];

            for (int i = 0; i < A.length; i++) {
                temp[A.length - 1 - i] = A[i];
            }

            for (int i = 0; i < A.length; i++) {
                A[i] = temp[i];
            }
        }
        //////////////////////////////////////////////////////////// поля начало


        ////////////////////////////// статические начало
        static public Polinom Random(int deg)// сулчайный полином определенной степени
        {
            Math.random();
            Random r = new Random();
            double[] A = new double[deg + 1];

            A[deg] = 1;
            for (int i = 0; i < deg; i++)
            {
                A[i] = r.nextInt(0,10);
            }

            reverse(A);

            Polinom R = new Polinom(A);
            return R;
        }
        static public Polinom Random1(int DegMin, int DegMax )// сулчайный полином случайной степени степени по умолч от 0 до 5
        {
            Math.random();
            Random r = new Random();
            int deg = r.nextInt(DegMin, DegMax);
            double[] A = new double[deg + 1];

            A[deg] = 1;
            for (int i = 0; i < deg; i++)
            {
                A[i] =  r.nextInt(0, 9);
            }
            reverse(A);
            Polinom R = new Polinom(A);
            return R;
        }



        ////////////////////////////// статические  конец
        ////////////////////////////// гетеры и сетеры(нету в джава)
    /*public int deg
    {

        get { return DegM(); }

    }*/

        ////////////////////////////// гетеры и сетеры


        public double element(int i)
        {

            return A[i + A.length - Deg() - 1];

        }
        public double element1(int i)
        {

            return A[i + A.length - Deg() - 1];

        }

        public int Deg()
        {
            int d = A.length - 1;

            while (d > 0 && A[A.length - 1 - d] == 0)
            {
                d--;
            }

            return d;
        }


        //////////////////////////////////////////////////////////// поля конец


        //////////////////////////////////////////////////////////// печать полиномов начало


        private void Print2()//
        {

            int n = A.length;// строки
            //if (s != "") { Console.WriteLine(s); }
            for (int i = 0; i < n; i++)
            {

                if (A[i] == 0) { continue; }
                if (i == n - 1) {  System.out.println(A[i]); continue; }// конец

                if (A[i] == 1) {  System.out.println("x^"+ (n - i - 1)+"+"); continue; }
                System.out.println(A[i]+"*x ^"+(n - i - 1) +"+"); //<sup>как здесь</sup>


            }
            System.out.println();


        }
        private void Print1()//
        {

            int n = A.length;// строки
            //if (s != "") { Console.WriteLine(s); }
            for (int i = 0; i < n; i++)
            {

                if (A[i] == 0) { continue; }
                if (i == n - 1) { System.out.println("{Math.Round(A[i], ro)}"); continue; }// конец

                if (A[i] == 1) { System.out.println("x ^{n - i - 1} + "); continue; }
                System.out.println("{Math.Round(A[i], ro)}*x ^{n - i - 1} + "); //<sup>как здесь</sup>

            }
            System.out.println();

        }

        public void Print()//
        {
            int n = A.length;// строки
            int d = Deg();
            for (int i = n - d - 1; i < n; i++)
            {

                if (A[i] == 0) { continue; }


                if (i == n - d - 1 && A[i] != 1 && A[i] != -1) { System.out.print(A[i]+"x ^"+(n - i - 1)); continue; }
                if (i == n - d - 1 && A[i] == 1) { System.out.print("x ^"+( n - i - 1)); continue; }
                if (i == n - d - 1 && A[i] == -1) { System.out.print(" - x^"+( n - i - 1)); continue; }


                if (A[i] == 1) { System.out.print("x ^"+(n - i - 1)); continue; }
                if (A[i] == -1) { System.out.print("-x ^"+(n - i - 1)); continue; }

                if (i == n - 1 && A[i] > 0) { System.out.print(" + "+Math.abs(A[i])); continue; }// конец
                if (i == n - 1 && A[i] < 0) { System.out.print(" - "+Math.abs(A[i])); continue; }// конец

                if (A[i] > 0) { System.out.print(" + "+Math.abs(A[i])+"*x ^"+(n - i - 1)); }
                if (A[i] < 0) { System.out.print(" - "+Math.abs(A[i])+"*x ^"+(n - i - 1)); }

            }

            System.out.println();
        }


        public String Print6(String x)
        {

            int n = A.length;// строки
            int start = 0;
            int d=0;

            String s = "";


            long[] AI=new long[n];
            for(int l=0;l<n;l++)
            {
                AI[l] = (long) A[l];
            }

            for (int i = 0; i < n; i++) //find start
            {
                if (i == n-1) { s += AI[i];
                    return s;  }// конец

                if (AI[i] == 0)
                {
                    continue;
                }
                if (AI[i]!=0)
                {
                    start = i;
                    break;// выход из поиска
                }
            }



            for (int i = start; i<n; i++)
            {
                d=n-i-1;
                if (i == start)
                {
                    // if (i == 0) { s += $"{Math.Abs(A[i]).ToString()}"; continue; }// конец


                    if(d==1)
                    {
                        if (AI[start] > 0)
                        {
                            //if (P.Element1(i) == 0) { continue; }// возможно у нулевого многочлена
                            ////// if (i == 0) { s += $"{Math.Abs(P.Element1(0)).ToString()}"; continue; }// конец

                            if (AI[start] == 1) { s += x; continue; }
                            s += Math.abs(AI[i])+x; continue;

                        }

                        if (AI[start] < 0)
                        {

                            // if (i == 0) { s += $"- {Math.Abs(P.Element1(0)).ToString()}"; continue; }// конец

                            if (AI[start] == -1) { s += "-"; continue; }
                            s += "-"+Math.abs(AI[start])+x; continue;
                        }
                    }
                    if(d!=1)
                    {
                        if (AI[start] > 0)
                        {
                            //if (P.Element1(i) == 0) { continue; }// возможно у нулевого многочлена
                            ////// if (i == 0) { s += $"{Math.Abs(P.Element1(0)).ToString()}"; continue; }// конец

                            if (AI[start] == 1) { s += x+"^"+d; continue; }
                            s += Math.abs(AI[i])+x+"^"+d; continue;

                        }

                        if (AI[start] < 0)
                        {

                            // if (i == 0) { s += $"- {Math.Abs(P.Element1(0)).ToString()}"; continue; }// конец

                            if (AI[start] == -1) { s += "-"+x+"^"+d; continue; }
                            s += "-"+Math.abs(AI[start])+x+"^"+d; continue;
                        }
                    }


                }



                if (AI[i] >= 1)
                {
                    if (AI[i] == 0) { continue; }
                    if (i == n-1) { s += "+"+Math.abs(AI[i]); continue; }// конец


                    if(d==1)
                    {
                        if (AI[i] == 1) { s += "+"+x; continue; }
                        s += "+"+Math.abs(AI[i])+x; continue;

                    }
                    if(d!=1)
                    {
                        if (AI[i] == 1) { s += "+"+x +"^"+d; continue; }
                        s += "+"+Math.abs(AI[i])+x+"^"+d; continue;

                    }

                }

                if (AI[i] < 0)
                {


                    if (i == n-1) { s += "-"+Math.abs(AI[i]); continue; }// конец

                    if(d==1)
                    {
                        if (AI[i] == -1) { s += "-"+x; continue; }
                        s += "-"+Math.abs(AI[i])+x; continue;
                    }
                    if(d!=1)
                    {
                        if (AI[i] == -1) { s += "-"+x+"^"+d; continue; }
                        s += "-"+Math.abs(AI[i])+x+"^"+d; continue;
                    }
                }

            }
            return s;
        }     // рабочий из проекта кальк пере


        public void Print5()
        {

            char x='x';
            int n = A.length;// строки
            int start = 0;
            int d=0;

            String s = "";


            for (int i = 0; i < n; i++) //find start
            {
                if (i == n-1) { s += A[i];
                    System.out.println(s); return;  }// конец

                if (A[i] == 0)
                {
                    continue;
                }
                if (A[i]!=0)
                {
                    start = i;
                    break;// выход из поиска
                }
            }



            for (int i = start; i<n; i++)
            {
                d=n-i-1;
                if (i == start)
                {
                    // if (i == 0) { s += $"{Math.Abs(A[i]).ToString()}"; continue; }// конец


                    if (A[start] > 0)
                    {
                        //if (P.Element1(i) == 0) { continue; }// возможно у нулевого многочлена
                        ////// if (i == 0) { s += $"{Math.Abs(P.Element1(0)).ToString()}"; continue; }// конец

                        if (A[start] == 1) { s += "x ^"+d; continue; }
                        s += Math.abs(A[i])+"*x ^"+d; continue;

                    }

                    if (A[start] < 0)
                    {

                        // if (i == 0) { s += $"- {Math.Abs(P.Element1(0)).ToString()}"; continue; }// конец

                        if (A[start] == -1) { s += "- x ^"+d; continue; }
                        s += "- "+Math.abs(A[start])+"*x ^"+d; continue;
                    }

                }



                if (A[i] >= 0)
                {
                    if (A[i] == 0) { continue; }
                    if (i == n-1) { s += " + "+Math.abs(A[i]); continue; }// конец

                    if (A[i] == 1) { s += " + x ^"+d; continue; }
                    s += " + "+Math.abs(A[i])+"*x ^"+d; continue;

                }

                if (A[i] < 0)
                {

                    if (i == n-1) { s += " - "+Math.abs(A[i]); continue; }// конец

                    if (A[i] == -1) { s += " - x ^"+d; continue; }
                    s += " - "+Math.abs(A[i])+"*x ^"+d; continue;
                }

            }
            System.out.println(s);
        }     // рабочий из проекта кальк пере


        public String toString()
        {
            return "0";
        }



        //////////////////////////////////////////////////////////// печать полинома конец

        //////////////////////////////////////////////////////////// операторы начало

        public static Polinom Sum(Polinom A, Polinom B)// сумма Полиномов
        {
            /*
                            int n = A.Deg();
                           int m = B.Deg();
                        int max = Math.Max(n, m);


                        double[] C = new double[max+1];

                            for (int i = 0; i <= max; i++)
                             {
                            if (n < m && i>n )
                               {
                                C[i] = B.element(i) ;
                            }
                            if (n > m && i > m)
                            {
                                C[i] = A.element(i);
                            }
                            if(n> m&& i <= n)
                            {
                                C[i] = A.element(i) + B.element(i-(n-m));
                            }
                            if (n < m&&i<=m)
                            {
                                C[i] = A.element(i-(m-n)) + B.element(i);
                            }
                            if (n == m )
                            {
                                C[i] = A.element(i ) + B.element(i);
                            }

                        }

                            Polinom CC = new Polinom(C);

                            return CC;*/
            int n = A.Deg();
            int m = B.Deg();
            int max = Math.max(n, m);


            double[] C = new double[max + 1];
            for (int k = 0; k <= max; k++)
            {
                C[k] = A.Element1(k) + B.Element1(k);

            }

            reverse(C);
            Polinom CC = new Polinom(C);

            return CC;

        }
        public static Polinom Sum(Polinom A, double d)// сумма Полиномов со скаляром
        {


            int n = A.Deg();

            double[] C = new double[n + 1];
            for (int k = 1; k <= n; k++)
            {
                C[k] = A.Element1(k);

            }
            C[0] = A.Element1(0) + d;

            reverse(C);
            Polinom CC = new Polinom(C);

            return CC;




        }
        public static Polinom Sum(double d, Polinom A)// сумма Полиномов со скаляром
        {



            int n = A.Deg();

            double[] C = new double[n + 1];
            for (int k = 1; k <= n; k++)
            {
                C[k] = A.Element1(k);

            }
            C[0] = d + A.Element1(0);

            reverse(C);
            Polinom CC = new Polinom(C);

            return CC;




        }
        public static Polinom Sub(Polinom A, Polinom B)// разность Поиномов
        {

            int n = A.Deg();
            int m = B.Deg();
            int max = Math.max(n, m);


            double[] C = new double[max + 1];
            for (int k = 0; k <= max; k++)
            {
                C[k] = A.Element1(k) - B.Element1(k);

            }

            reverse(C);
            Polinom CC = new Polinom(C);

            return CC;

        }
        public static Polinom Sub(Polinom A, double d)//
        {



            int n = A.Deg();

            double[] C = new double[n + 1];
            for (int k = 1; k <= n; k++)
            {
                C[k] = A.Element1(k);

            }
            C[0] = A.Element1(0) - d;

            reverse(C);
            Polinom CC = new Polinom(C);

            return CC;



        }
        public static Polinom Sub(double d, Polinom A)//
        {




            int n = A.Deg();

            double[] C = new double[n + 1];
            for (int k = 1; k <= n; k++)
            {
                C[k] = A.Element1(k);

            }
            C[0] = d - A.Element1(0);

            reverse(C);
            Polinom CC = new Polinom(C);

            return CC;



        }
        public static Polinom Prod(Polinom A, Polinom B)// умножение полиномов
        {

            int n = A.Deg();
            int m = B.Deg();
            int max = Math.max(n, m);


            double[] C = new double[n + m + 1];
            for (int k = 0; k <= n + m; k++)
            {
                for (int i = 0; i <= k; i++)
                {
                    C[k] += A.Element1(i) * B.Element1(k - i);
                }


            }

            reverse(C);
            Polinom CC = new Polinom(C);

            return CC;




        }
        public static Polinom Prod(Polinom A, double d)// умножение полиномов на скаляр
        {


            int n = A.Deg();

            double[] C = new double[n + 1];
            for (int k = 0; k <= n; k++)
            {
                C[k] = A.Element1(k) * d;

            }

            reverse(C);
            Polinom CC = new Polinom(C);

            return CC;




        }
        public static Polinom Prod(double d, Polinom A)// умножение полиномов на скаляр
        {


            int n = A.Deg();

            double[] C = new double[n + 1];
            for (int k = 0; k <= n; k++)
            {
                C[k] = d * A.Element1(k);

            }

            reverse(C);
            Polinom CC = new Polinom(C);

            return CC;




        }
        public static Polinom Div(Polinom A, double d)// деление полиномов на скаляр
        {


            int n = A.Deg();

            double[] C = new double[n + 1];
            for (int k = 0; k <= n; k++)
            {
                C[k] = A.Element1(k) / d;

            }

            reverse(C);
            Polinom CC = new Polinom(C);

            return CC;




        }
        public static Polinom[] Div(Polinom A, Polinom B)// умножение полиномов на скаляр
        {
            Polinom[] Res = new Polinom[2];

            Res = A.DelOst(A, B);

            return Res;
        }
    /*public static Polinom Pow(Polinom A, int n)// возведение полинома в степень(В С# работало)
    {
        return A.Pow(A, n);
    }*/
        //////////////////////////////////////////////////////////// операторы конец

        //////////////////////////////////////////////////////////// вспомогательные функции и костыли начало
        public double value(Polinom P, double x) // значение полинома в точке
        {
            int d = P.Deg();
            double y = 0;
            for (int i = 0; i <= d; i++)
            {

                y += P.Element1(i)* Math.pow(x, i);
            }
            return y;
        }
        public Polinom Dif(Polinom P) // производная
        {

            int n = P.Deg();
            if (n == 0) { Polinom D0 = new Polinom(0); return D0; }
            double[] B = new double[n];
            for (int i = 0; i <= n - 1; i++)
            {
                B[i] = (i + 1) * P.Element1(i + 1);

            }
            reverse(B);
            Polinom D = new Polinom(B);
            return D;
        }
        public static Polinom pow(Polinom P, int d) // полином в степени
        {
            Polinom R = new Polinom(1);
            if (d == 0) { return R; }

            return Prod(P,pow(P, d - 1));
        }
        public Polinom[] DelOst(Polinom P, Polinom Q)// деление с остатком
        {
            int d = P.Deg() - Q.Deg();

            P.Print5();
            Q.Print5();

            Polinom PP = P;
            Polinom QQ = Q;

            int n = 0;
            int m = 0;
            double h = 1;

            Polinom X = new Polinom(1, 0);
            Polinom D = new Polinom(0);
            Polinom[] Res = new Polinom[2];


            if (d < 0)
            {
                Res[0] = new Polinom(0);
                Res[1] = Q;
                return Res;
            }
            Polinom Temp = P;

            double[] A = new double[d];
            while (P.Deg() - Q.Deg() >= 0)
            {

                n = P.Deg();
                m = Q.Deg();
                h = P.Element1(n) / Q.Element1(m);


                P = Sub(P,Prod(Prod(Q, pow(X, n - m)),h));
                D=Sum(D,Prod(pow(X,n-m),h));

                //P = P - Q * (X ^ (n - m)) * h C#
                // D += (X ^ (n - m)) * h;   C#
                System.out.println();
                System.out.print("множитель "); pow(X, n - m).Print5();
                System.out.print("P: "); P.Print5();
                System.out.print("D: "); D.Print5();

                if(P.Deg()== 0&&P.Element1(0)==0 && Q.Deg() == 0) { break; }// искючительнаяя ситуация когда цикл бесконечный для многоч нул степени

            }
            Res[0] = D;
            Res[1] = P;

            Polinom Prov = new Polinom(0);
            Prov = Sum(Prod(QQ, D), P);
            //Console.Write("проверка "); Prov.Print2();
            return Res;
        }
        public int DegM()//  старшая степень полинома
        {
            int d = A.length - 1;

            while (d > 0 && A[A.length - 1 - d] == 0)
            {
                d--;
            }

            return d;

        }
        public double Element1(int k) // коэфф при степени к
        {
            int d = Deg();
            int n = A.length;
            if (k > d || k < 0) { return 0; }
            return A[n - 1 - k];

        }
        public double Next(int k)  // следующий ненул коэфф после коэфф при степени к
        {
            int d = Deg();
            if (k > d ) { return Element1(d); }
            while (Element1(k)==0)
            {
                k--;
            }
            return Element1(k);
        }

        //////////////////////////////////////////////////////////// вспомогательные функции и костыли конец
    }


public class KataSolution {

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
}

```
# понравивщееся решение:(автор McMissa)
``` java
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class KataSolution {

	public static int nOverK(int n, int k) {
		if (n < k)
			return 0;
		if (k == 0 || k == n)
			return 1;
		return nOverK(n - 1, k - 1) + nOverK(n - 1, k);
	}

	public static String expand(String expr) {

		Matcher m = Pattern.compile("(\\-?\\d*)([a-z])([+-])(\\-?\\d+)\\D+(\\d+)").matcher(expr);
		m.find();
		int p = Integer.parseInt(m.group(5));
		String[] str = new String[p + 1];
		int a = m.group(1).length() == 0 ? 1 : m.group(1).equals("-") ? -1 : Integer.parseInt(m.group(1));
		int b = (m.group(3).equals("-") ? -1 : 1) * Integer.parseInt(m.group(4));
		for (int i = 0; i <= p; i++) {
			long f = (long) (nOverK(p, i) * Math.pow(a, p - i) * (i == 0 ? 1 : Math.pow(b, i)));
			if (f != 0) {
				str[i] = p - i == 0 ? f + ""
						: (f == 1 ? "" : f == -1 ? "-" : f) + m.group(2) + (p - i != 1 ? "^" + (p - i) : "");
			}
		}
		return Arrays.stream(str).filter(s -> s != null).collect(Collectors.joining("+")).replaceAll("\\+\\-", "\\-");
	}
}
