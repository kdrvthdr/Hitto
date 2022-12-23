package by.it.group151004.sakovsky.lesson04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Рассчитать число инверсий одномерного массива.
Сложность алгоритма должна быть не хуже, чем O(n log n)

Первая строка содержит число 1<=n<=10000,
вторая - массив A[1…n], содержащий натуральные числа, не превосходящие 10E9.
Необходимо посчитать число пар индексов 1<=i<j<n, для которых A[i]>A[j].

    (Такая пара элементов называется инверсией массива.
    Количество инверсий в массиве является в некотором смысле
    его мерой неупорядоченности: например, в упорядоченном по неубыванию
    массиве инверсий нет вообще, а в массиве, упорядоченном по убыванию,
    инверсию образуют каждые (т.е. любые) два элемента.
    )

Sample Input:
5
2 3 9 2 9
Sample Output:
2

Головоломка (т.е. не обязательно).
Попробуйте обеспечить скорость лучше, чем O(n log n) за счет многопоточности.
Докажите рост производительности замерами времени.
Большой тестовый массив можно прочитать свой или сгенерировать его программно.
*/


public class C_GetInversions {
    private int invertCount = 0;
    int[] MergeSort(int[] a){
        if(a.length<=1){
            return a;
        }else {
            int mid=a.length>>1;
            int[] leftArr = new int[mid];
            int[] rightArr = new int[a.length - mid];
            int[] result = new int[a.length];
            for (int i = 0; i < mid; i++) {
                leftArr[i] = a[i];
            }
            int j = 0;
            for (int i = mid; i < a.length; i++) {
                rightArr[j] = a[i];
                j++;
            }
            leftArr = MergeSort(leftArr);
            rightArr = MergeSort(rightArr);
            result = merge(leftArr, rightArr);
            return result;
        }
    }
    int[] merge(int[] lArr, int[] rArr){
        int[] result= new int[lArr.length+rArr.length];
        int n=0, m=0, k=0;
        while(n<lArr.length && m<rArr.length){
            if(lArr[n]<=rArr[m]){
                result[k]=lArr[n];
                n++;
            }else{
                result[k]=rArr[m];
                invertCount +=lArr.length-n;
                m++;
            }
            k++;
        }
        while(n<lArr.length){
            result[k]=lArr[n];
            k++;
            n++;
        }
        while(m<rArr.length){
            result[k]=rArr[m];
            k++;
            m++;
        }
        return result;
    }

    int calc(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!
        //размер массива
        int n = scanner.nextInt();
        //сам массив
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int result = 0;
        //!!!!!!!!!!!!!!!!!!!!!!!!     тут ваше решение   !!!!!!!!!!!!!!!!!!!!!!!!
        MergeSort(a);
        result=invertCount;
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group151004/sakovsky/lesson04/dataC.txt");
        C_GetInversions instance = new C_GetInversions();
        //long startTime = System.currentTimeMillis();
        int result = instance.calc(stream);
        //long finishTime = System.currentTimeMillis();
        System.out.print(result);
    }
}
