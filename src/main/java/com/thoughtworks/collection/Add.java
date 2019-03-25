package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int temp;
        if (rightBorder < leftBorder) {
            temp = rightBorder;
            rightBorder = leftBorder;
            leftBorder = temp;
        }
        int result;
        if (leftBorder % 2 == 0) {
            result = leftBorder;
        } else {
            result = leftBorder + 1;
        }
        for (int i = result + 2; i <= rightBorder; i = i + 2) {
            result += i;
        }
        return result;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int temp;
        if (rightBorder < leftBorder) {
            temp = rightBorder;
            rightBorder = leftBorder;
            leftBorder = temp;
        }
        int result;
        if (leftBorder % 2 != 0) {
            result = leftBorder;
        } else {
            result = leftBorder + 1;
        }
        for (int i = result + 2; i <= rightBorder; i = i + 2) {
            result += i;
        }
        return result;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        int result = 0;
        for (int num : arrayList) {
            result += num;
        }
        return result * 3 + 2 * arrayList.size();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        int value;
        for (int i = 0; i < arrayList.size(); i++) {
            value = arrayList.get(i);
            if (value % 2 != 0) {
                arrayList.set(i, value * 3 + 2);
            }
        }
        return arrayList;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        int result = 0;
        int value;
        for (int i = 0; i < arrayList.size(); i++) {
            value = arrayList.get(i);
            if (value % 2 != 0) {
                result += value * 3 + 5;
            }
        }
        return result;
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i % 2 == 0) {
                list.add(arrayList.get(i));
            }
        }
        int size = list.size();
        if (size % 2 == 0) {
            return (list.get(size / 2 - 1) + list.get(size / 2)) / 2;
        } else {
            return list.get((size + 1) / 2 - 1);
        }
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream().filter(item -> item % 2 == 0).mapToInt(Integer::intValue).sum() / arrayList.stream().filter(item -> item % 2 == 0).mapToInt(Integer::intValue).count();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(item -> item % 2 == 0).mapToInt(Integer::intValue).anyMatch(num -> num == specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(item -> item % 2 == 0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> listEven = arrayList.stream().filter(item -> item % 2 == 0).sorted().collect(Collectors.toList());
        List<Integer> listOdd = arrayList.stream().filter(item -> item % 2 != 0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return Stream.concat(listEven.stream(), listOdd.stream()).collect(Collectors.toList());
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        int a, b;
        a = arrayList.get(0);
        List<Integer> result = new ArrayList<>();
        int i;
        for (i = 1; i < arrayList.size(); i++) {
            b = arrayList.get(i);
            result.add((a + b) * 3);
            a = b;
        }
        return result;
    }
}
