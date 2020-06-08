import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Нажмите 1, чтобы ввести ряд самостоятельно или 2, чтобы использовать тесты: ");
        int num = in.nextInt();
        if (num == 2) Test();
        else if (num == 1) {
            System.out.print("Введите размерность ряда: ");
            num = in.nextInt();
            int[] mas = new int[num];
            System.out.println("Введите ряд через Enter");
            for (int i = 0; i < num; i++)
                mas[i] = in.nextInt();
            System.out.println(Solution(mas));
        }
        else System.out.println("Ошибка!");
    }

    static void Test(){
        Random rand = new Random();
        System.out.print("Ряд:");
        int [] mas = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        for (int i = 0; i < mas.length; i++)
            System.out.print(mas[i]);
        System.out.println();
        System.out.println(Solution(mas));
        mas = new int[]{5, 1, 5, 1, 5, 1, 5, 1, 5, 1, 5, 1, 5, 1, 5, 1, 5};
        System.out.print("Ряд: ");
        for (int i = 0; i < mas.length; i++)
            System.out.print(mas[i]);
        System.out.println();
        System.out.println(Solution(mas));
        for (int i = 0; i < 7; i++){
            System.out.print("Ряд: ");
            for (int j = 0; j < mas.length; j++){
                mas[j] = rand.nextInt(8) + 1;
                System.out.print(mas[j]);
            }
            System.out.println();
            System.out.println(Solution(mas));
        }
    }

    static String Solution(int [] mas){
        int min = 0;
        int max = 0;
        for (int i = 0; i < mas.length; i++) {
            if (i == 0){
                if (mas[0] > mas[1]) max++;
                else if (mas[0] < mas[1]) min++;
            }else if (i == mas.length - 1){
                if (mas[mas.length - 1] > mas[1]) max++;
                else if (mas[mas.length - 1] < mas[1]) min++;
            }else if ((mas[i] > mas[i - 1]) && (mas[i] > mas[i + 1])) max++;
            else if ((mas[i] < mas[i - 1]) && (mas[i] < mas[i + 1])) min++;
        }
        return "Количество локальных минимумов: " + min + "\n" + "Количество локальных максимумов: " + max;
    }
}
