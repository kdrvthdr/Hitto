package by.it.group151002.naftolsky.lesson07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
Задача на программирование: расстояние Левенштейна
    https://ru.wikipedia.org/wiki/Расстояние_Левенштейна
    http://planetcalc.ru/1721/

Дано:
    Две данных непустые строки длины не более 100, содержащие строчные буквы латинского алфавита.

Необходимо:
    Решить задачу МЕТОДАМИ ДИНАМИЧЕСКОГО ПРОГРАММИРОВАНИЯ
    Итерационно вычислить алгоритм преобразования двух данных непустых строк
    Вывести через запятую редакционное предписание в формате:
     операция("+" вставка, "-" удаление, "~" замена, "#" копирование)
     символ замены или вставки

    Sample Input 1:
    ab
    ab
    Sample Output 1:
    #,#,

    Sample Input 2:
    short
    ports
    Sample Output 2:
    -s,~p,#,#,#,+s,

    Sample Input 3:
    distance
    editing
    Sample Output 2:
    +e,#,#,-s,#,~i,#,-c,~g,


    P.S. В литературе обычно действия редакционных предписаний обозначаются так:
    - D (англ. delete) — удалить,
    + I (англ. insert) — вставить,
    ~ R (replace) — заменить,
    # M (match) — совпадение.
*/


public class C_EditDist {
    public static int min(int... numbers) {
        return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
    }

    String getDistanceEdinting(String one, String two) {
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        int[][] matrix = new int[one.length() + 1][two.length() + 1];

        for (int i = 0; i <= two.length(); i++){
            matrix[0][i] = i;
        }
        for (int i = 0; i <= one.length(); i++){
            matrix[i][0] = i;
        }

        int tempNumber;
        for (int i = 1; i <= one.length(); i++) {
            for (int j = 1; j <= two.length(); j++) {
                if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    tempNumber = 0;
                } else {
                    tempNumber = 1;
                }

                int replaceLength = matrix[i - 1][j - 1] + tempNumber;
                int insertLength = matrix[i][j - 1] + 1;
                int deleteLength = matrix[i - 1][j] + 1;

                matrix[i][j] = min(insertLength, deleteLength, replaceLength);
            }
        }

        String line = "";

        int i = one.length();
        int j = two.length();


        while (i > 0 || j > 0){
            if (i > 0 && j >0 && one.charAt(i - 1) == two.charAt(j - 1)) {
                tempNumber = 0;
            } else {
                tempNumber = 1;
            }
            if (i > 0 && j >0 && (matrix[i - 1][j - 1] + tempNumber) == matrix[i][j]){
                if(one.charAt(i - 1) == two.charAt(j - 1)){
                    line = line + "#,";
                }else {
                    line = line + "~" + two.charAt(j - 1) + ",";
                }
                i--;
                j--;
            } else if (j > 0 && matrix[i][j] == matrix[i][j - 1] + 1) {
                line = line + "+" + two.charAt(j - 1) + ",";
                j--;
            } else if ( i > 0 && matrix[i][j] == matrix[i - 1][j] + 1) {
                line = line + "-" + one.charAt(i - 1) + ",";
                i--;
            }
        }

        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return line;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group151002/naftolsky/lesson07/dataABC.txt");
        C_EditDist instance = new C_EditDist();
        Scanner scanner = new Scanner(stream);
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
    }

}