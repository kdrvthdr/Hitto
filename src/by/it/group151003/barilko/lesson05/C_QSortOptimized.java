package by.it.group151003.barilko.lesson05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Видеорегистраторы и площадь 2.
Условие то же что и в задаче А.

        По сравнению с задачей A доработайте алгоритм так, чтобы
        1) он оптимально использовал время и память:
            - за стек отвечает элиминация хвостовой рекурсии,
            - за сам массив отрезков - сортировка на месте
            - рекурсивные вызовы должны проводиться на основе 3-разбиения

        2) при поиске подходящих отрезков для точки реализуйте метод бинарного поиска
        для первого отрезка решения, а затем найдите оставшуюся часть решения
        (т.е. отрезков, подходящих для точки, может быть много)

    Sample Input:
    2 3
    0 5
    7 10
    1 6 11
    Sample Output:
    1 0 0

*/


public class C_QSortOptimized {

    //отрезок
    private class Segment  implements Comparable<Segment>{
        int start;
        int stop;

        Segment(int start, int stop){

            if(start < stop)
            {
                this.start = start;
                this.stop = stop;
            }
            else
            {
                this.start = stop;
                this.stop = start;
            }

            //тут вообще-то лучше доделать конструктор на случай если
            //концы отрезков придут в обратном порядке
        }

        Segment(Segment o)
        {
            this.start = o.start;
            this.stop = o.stop;
        }

        void swap(Segment other)
        {
            Segment temp = new Segment(this);
            this.start = other.start;
            this.stop = other.stop;
            other.start = temp.start;
            other.stop = temp.stop;
        }

        @Override
        public int compareTo(Segment o) {
            //подумайте, что должен возвращать компаратор отрезков
            
            return (this.start - o.start != 0 ? (this.start - o.start) / Math.abs(this.start - o.start) : 0);
        }
    }



    int[] getAccessory2(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        //число отрезков отсортированного массива
        int n = scanner.nextInt();
        Segment[] segments=new Segment[n];
        //число точек
        int m = scanner.nextInt();
        int[] points=new int[m];
        int[] result=new int[m];

        //читаем сами отрезки
        for (int i = 0; i < n; i++) {
            //читаем начало и конец каждого отрезка
            segments[i]=new Segment(scanner.nextInt(),scanner.nextInt());
        }
        //читаем точки
        for (int i = 0; i < m; i++) {
            points[i]=scanner.nextInt();
        }
        //тут реализуйте логику задачи с применением быстрой сортировки
        //в классе отрезка Segment реализуйте нужный для этой задачи компаратор

        QSort(segments, 0, n - 1);


       
        for(int i = 0; i < m; ++i)
        {
            int left = 0;
            int right = n;
            int Indx = left + (right - left) / 2;
            while(segments[Indx].start > points[i])
            {
                right = Indx;
                Indx = left + (right - left) / 2;
            }

            for(int j = 0; (Indx - j >= 0) || 
                            (Indx + j + 1 < n && segments[Indx + j + 1].start <= points[i]); ++j)
            {
                if(Indx - j >= 0 && segments[Indx - j].start <= points[i] && segments[Indx - j].stop >= points[i])
                    ++result[i];
                if(Indx + j + 1 < n && segments[Indx + j + 1].start <= points[i] && segments[Indx + j + 1].stop >= points[i])
                    ++result[i];
            }

        }

        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }

    public class pair<T1, T2>
    {
        public T1 first;
        public T2 second;
        public pair(T1 first, T2 second)
        {
            this.first = first;
            this.second = second;
        }
    }



    pair<Integer, Integer> partition(Segment[] arr, int low, int high)
    {

        pair<Integer, Integer> pivotIndxs = new pair<>(low, high);
        if(high - low <= 1)
        {
            if(arr[high].compareTo(arr[low]) <= 0)
                arr[low].swap(arr[high]); 
            pivotIndxs.first = low;
            pivotIndxs.second = high;
        }
        else
        {
            int Indx = low;
            Segment pivot = new Segment(arr[high]);
            while(Indx <= pivotIndxs.second)
            {
                switch(arr[Indx].compareTo(pivot))
                {
                    case -1:
                        arr[Indx++].swap(arr[(pivotIndxs.first)++]);
                        break;
                    case 0:
                        ++Indx;
                        break;
                    case 1:
                        arr[Indx].swap(arr[(pivotIndxs.second)--]);
                        break;
                }
            }  

        }
        return pivotIndxs;
    }

    
    void QSort(Segment[] arr, int low, int high)
    {
        while (low < high)
        {
            pair<Integer, Integer> pivotIndxs = partition(arr, low, high);
            if (pivotIndxs.first - low < high - pivotIndxs.second)
            {
                QSort(arr, low, pivotIndxs.first - 1);
                low = pivotIndxs.second + 1;
            }
            else
            {
                QSort(arr, pivotIndxs.second + 1, high);
                high = pivotIndxs.first - 1;
            }
        }
    }


    public static void main(String[] args) throws FileNotFoundException 
    {
        String root = System.getProperty("user.dir") + "/src/";
                                    
        InputStream stream = new FileInputStream(root + "by/it/group151003/barilko/lesson05/dataC.txt");
        C_QSortOptimized instance = new C_QSortOptimized();
        int[] result = instance.getAccessory2(stream);
        for (int index:result){
            System.out.print(index+" ");
        }
    }

}
