package by.it.group151004.dubovsky.lesson04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Реализуйте сортировку слиянием для одномерного массива.
Сложность алгоритма должна быть не хуже, чем O(n log n)

Первая строка содержит число 1<=n<=10000,
вторая - массив A[1…n], содержащий натуральные числа, не превосходящие 10E9.
Необходимо отсортировать полученный массив.

Sample Input:
5
2 3 9 2 9
Sample Output:
2 2 3 9 9
*/
public class B_MergeSort {

    public int[] getMergeSort(InputStream stream) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(stream)) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                System.out.println(a[i]);
            }
            mergeSort(a, 0, n - 1);
            return a;
        }
    }

        // тут ваше решение (реализуйте сортировку слиянием)
        // https://ru.wikipedia.org/wiki/Сортировка_слиянием

        public void merge(int[] a, int p, int q, int r) {
            int n1 = q - p + 1;
            int n2 = r - q;
            int[] L = new int[n1];
            int[] R = new int[n2];
            int i, j, k;
            for (i = 0; i < n1; i++) {
                L[i] = a[p + i];
            }

            for (j = 0; j < n2; j++) {
                R[j] = a[q + 1 + j];
            }

            i = 0;
            j = 0;
            k = p;
            while (i < n1 && j < n2) {
                if (L[i] < R[j]) {
                    a[k] = L[i];
                    i++;
                } else {
                    a[k] = R[j];
                    j++;
                }
                k++;
            }
            while (i < n1) {
                a[k] = L[i];
                i++;
                k++;
            }
            while (j < n2) {
                a[k] = R[j];
                j++;
                k++;
            }
        }

        public void mergeSort(int[] a, int p, int r) {
            if (p < r) {
                int q = (p + r) / 2;
                mergeSort(a, p, q);
                mergeSort(a, q + 1, r);
                merge(a, p, q, r);
            }
        }

        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson04/dataB.txt");
        B_MergeSort instance = new B_MergeSort();
        //long startTime = System.currentTimeMillis();
        int[] result=instance.getMergeSort(stream);
        //long finishTime = System.currentTimeMillis();
        for (int index:result){
            System.out.print(index+" ");
        }
    }


}
