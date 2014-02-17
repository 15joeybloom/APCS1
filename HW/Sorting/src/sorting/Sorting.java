package sorting;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 Contains utility methods for sorting Lists using the natural ordering
 of the elements.
 <p/>
 @author Joey Bloom
 */
public class Sorting
{
    public static void main(String[] args)
    {
        Random gen = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++)
        {
            list.add(gen.nextInt(5000));
        }
        System.out.println(list);
        bogoSort(list);
        System.out.println(list);

    }

    /**
     Sorts a List using the MergeSort algorithm.
     <p/>
     @param list List of Comparable Objects
     */
    public static <T extends Comparable<T>> void mergeSort(List<T> list)
    {
        if(list.size() < 2)
        {
            return;
        }
        int end = list.size();
        int middle = end / 2;
        int start = 0;

        List<T> list1 = new ArrayList<>();
        for(T el : list.subList(start, middle))
        {
            list1.add(el);
        }
        List<T> list2 = new ArrayList<>();
        for(T el : list.subList(middle, end))
        {
            list2.add(el);
        }
        mergeSort(list1);
        mergeSort(list2);

        list.clear();
        Iterator<T> oneI = list1.iterator();
        Iterator<T> twoI = list2.iterator();
        T one = oneI.next();
        T two = twoI.next();
        loop:
        while(true)
        {
            if(one.compareTo(two) < 0)
            {
                list.add(one);
                if(!oneI.hasNext())
                {
                    list.add(two);
                    while(twoI.hasNext())
                    {
                        list.add(twoI.next());
                    }
                    break loop;
                }
                one = oneI.next();
            }
            else
            {
                list.add(two);
                if(!twoI.hasNext())
                {
                    list.add(one);
                    while(oneI.hasNext())
                    {
                        list.add(oneI.next());
                    }
                    break loop;
                }
                two = twoI.next();
            }
        }
    }

    /**
     Sorts a List using the QuickSort algorithm.
     <p/>
     @param list List of Comparable Objects
     */
    public static <T extends Comparable<T>> void quickSort(List<T> list)
    {
        if(list.size() < 2)
        {
            return;
        }
        T pivot = list.get(0);
        int i = 0;
        int j = list.size() - 1;

        partition:
        while(i <= j)
        {
            while(list.get(i).compareTo(pivot) < 0)
            {
                i++;
                if(i > j)
                {
                    break partition;
                }
            }
            while(list.get(j).compareTo(pivot) > 0)
            {
                j--;
                if(i > j)
                {
                    break partition;
                }
            }
            swap(list, i, j);
            i++;
            j--;
        }

        List<T> list1 = new ArrayList<>();
        for(T el : list.subList(0, i))
        {
            list1.add(el);
        }
        List<T> list2 = new ArrayList<>();
        for(T el : list.subList(i, list.size()))
        {
            list2.add(el);
        }
        quickSort(list1);
        quickSort(list2);
        list.clear();
        list.addAll(list1);
        list.addAll(list2);
    }

    /**
     Sorts a List using the bubblesort algorithm
     <p/>
     @param list List of Comparable objects to sort
     */
    public static <T extends Comparable<T>> void bubbleSort(List<T> list)
    {
        if(list.size() < 2)
        {
            return;
        }
        for(int i = list.size() - 1; i > 0; i--)
        {
            for(int j = 0; j < i; j++)
            {
                if(list.get(j).compareTo(list.get(j + 1)) > 0)
                {
                    swap(list, j, j + 1);
                }
            }
        }
    }

    /**
     Sorts a List using the insertionsort algorithm
     <p/>
     @param list List of Comparable objects to sort
     */
    public static <T extends Comparable<T>> void insertionSort(List<T> list)
    {
        if(list.size() < 2)
        {
            return;
        }
        for(int i = 1; i < list.size(); i++)
        {
            T t = list.get(i);
            for(int j = i - 1; j >= 0; j--)
            {
                if(t.compareTo(list.get(j)) < 0)
                {
                    swap(list, j, j + 1);
                }
                else
                {
                    break;
                }
            }
        }
    }

    /**
     Sorts a List using the selectionsort algorithm
     <p/>
     @param list List of Comparable objects to sort
     */
    public static <T extends Comparable<T>> void selectionSort(List<T> list)
    {
        if(list.size() < 2)
        {
            return;
        }
        for(int i = 0; i < list.size() - 1; i++)
        {
            T min = list.get(i);
            int minI = i;
            for(int j = i + 1; j < list.size(); j++)
            {
                T temp = list.get(j);
                if(temp.compareTo(min) < 0)
                {
                    min = temp;
                    minI = j;
                }
            }
            swap(list, i, minI);
        }
    }

    /**
     Sorts a List using the bogosort algorithm
     Note: do not use this. It is a joke.
     <p/>
     @param list List of Comparable objects to sort
     */
    public static <T extends Comparable<T>> void bogoSort(List<T> list)
    {
        sort:
        while(true)
        {
            Random gen = new Random();
            List<T> temp = new ArrayList<>();
            for(int i = list.size(); i > 0; i--)
            {
                temp.add(list.remove(gen.nextInt(i)));
            }
            list.addAll(temp);
            for(int i = 0; i < list.size() - 1; i++)
            {
                if(list.get(i).compareTo(list.get(i + 1)) > 0)
                {
                    continue sort;
                }
            }
            break;
        }

    }

    /**
     Swaps two elements
     <p/>
     @param list list in which the elements are to be swapped
     @param one  index of first element
     @param two  index of second element
     */
    private static <T> void swap(List<T> list, int one, int two)
    {
        list.set(one, list.set(two, list.get(one)));
    }
}
