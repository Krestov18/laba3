import java.util.Scanner;
import java.util.Random;

public class RSA {
    public static void main(String[] args) {

        long m ;
        int p;
        int q;
        int n;
        int fi;
        int e;
        int d;
        long c;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введите число для шифрования: ");
        m = scanner.nextLong();

        p = 0;
        long aaa;
        long bb = 1;
        long bbb = 0;
        while(bbb != 2){
            p = random.nextInt(300);
            bbb = 0;
            bb = 1;
            while ((bbb <= 2) & (bb <= p)){
                aaa = p % bb;
                bb += 1;
                if (aaa == 0){
                    bbb += 1;
                }
            }
        }
        System.out.println("p = " + p);

        q = 0;
        bbb = 0;
        while((bbb != 2)){
            q = random.nextInt(300);
            bbb = 0;
            bb = 1;
            while ((bbb <= 2) & (bb <= q)){
                aaa = q % bb;
                bb += 1;
                if (aaa == 0){
                    bbb += 1;
                }
            }
        }
        System.out.println("q = " + q);

        // Модуь произведения (p) и (q)
        n = p * q;

        // Вычисляем функцию Эйлера
        fi = (p-1)*(q-1);

        Random rand = new Random();
        e = rand.nextInt(100);
        long a = fi;
        long b;
        long r = 0;
        long y;
        while((a != 1) | (e == 1)){
            e = rand.nextInt(100);
            a = fi;
            b = e;
            while((b != 0) & (b<fi)) {
                r = a % b;
                a = b;
                b = r;
            }
            y = fi % e;
            if (y == 0){
                a = 0;
            }
        }
        System.out.println("Число (е) равно: "+ e);

        // Вычислим (d) по формуле (d*e)%F=1
        d = 0;
        while ((((d * e) % fi) != 1) | (d == e)) { //| (d == e)
            d += 1;
        }

        System.out.println("Открытый ключ {" + e + ", " + n + "} ");
        System.out.println("Закрытый ключ {" + d + ", " + n + "} ");

        c = pow(m, e, n);
        System.out.println("Зашифровано = " + c);

        m = pow(c, d, n);
        System.out.println("Расшифрованно = " + m);
    }

    public static long pow(long m, int e, long mod) {
        long x = m;
        for (int i = 0; i < e - 1; i++) {
            x = (x * m) % mod;
        }
        return x;
    }
}