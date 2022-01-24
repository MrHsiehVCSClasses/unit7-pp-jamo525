package u7pp;

import java.util.List;
import java.util.ArrayList;

/*
Class runs basic sorts: selection and insertion, for arrays and array lists
*/
public class Sorts {

  /*
  @param array of integers
  @return array of integers in ascending order
  */
  public static int[] selectionSort(int[] x)
  {
    int[] sortMe = new int[x.length];
    for (int i = 0; i < sortMe.length; i++)
    {
      sortMe[i] = x[i];
    }
    for (int i = 0; i < x.length; i++)
    {
      int minIndex = i;
      for (int j = i + 1; j < sortMe.length; j++)
      {
        if (sortMe[j] < sortMe[minIndex])
          minIndex = j;
      }
      int temp = sortMe[i];
      sortMe[i] = sortMe[minIndex];
      sortMe[minIndex] = temp;
    }
    return sortMe;
  }
  /*
  @param array of integers
  @return array of integers in ascending order
  */
  public static int[] insertionSort(int[] x)
  {
    int[] sortMe = new int[x.length];
    for (int i = 0; i < sortMe.length; i++)
    {
      sortMe[i] = x[i];
    }
    for (int i = 1; i < sortMe.length; i ++)
    {
      int temp = sortMe[i];
      int possIndex = i;
      while (possIndex > 0 && temp < sortMe[possIndex - 1])
      {
        sortMe[possIndex] = sortMe[possIndex - 1];
        possIndex --;
      }
      sortMe[possIndex] = temp;
    }
    return sortMe;
  }
  /*
  @param array list of integers
  @return array list of integers in descending order
  */
  public static List<Integer> selectionSort(List<Integer> x)
  {
    ArrayList<Integer> sortMe = new ArrayList<Integer>();
    for (int value : x)
    {
      sortMe.add(value);
    }
    for (int i = 0; i < x.size(); i++)
    {
      int maxIndex = i;
      for (int j = i + 1; j < x.size(); j++)
      {
        if (sortMe.get(j) > sortMe.get(maxIndex))
          maxIndex = j;
      }
      int temp = sortMe.get(i);
      sortMe.set(i, sortMe.get(maxIndex));
      sortMe.set(maxIndex,temp);
    }
    return sortMe;
  }
  /*
  @param array list of integers
  @return array list of integers in descending order
  */
  public static List<Integer> insertionSort(List<Integer> x)
  {
    ArrayList<Integer> sortMe = new ArrayList<Integer>();
    for (int value : x)
    {
      sortMe.add(value);
    }
    for (int i = 1; i < sortMe.size(); i ++)
    {
      int temp = sortMe.get(i);
      int possIndex = i;
      while (possIndex > 0 && temp > sortMe.get(possIndex - 1))
      {
        sortMe.set(possIndex, sortMe.get(possIndex - 1));
        possIndex --;
      }
      sortMe.set(possIndex, temp);
    }
    return sortMe;
  }

  /*
  @param array of integers
  prints each item in the array
  */
  public static void printArray(int[] x)
  {
    for (int value : x)
    {
      System.out.print(value + " ");
    }
    System.out.println();
  }
  /*
  @param array list of integers
  prints each item in the array
  */
  public static void printArray (List<Integer> x)
  {
    for (Integer value : x)
    {
      System.out.print(value + " ");
    }
    System.out.println();
  }
}
