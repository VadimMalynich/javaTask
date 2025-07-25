package com.leecode.task2;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbersByCollection(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        Deque<Integer> deque1 = getNumbersInStack(l1);
        Deque<Integer> deque2 = getNumbersInStack(l2);
        int stack1Length = deque1.size();
        int stack2Length = deque2.size();
        Deque<Integer> sum;
        if (stack1Length >= stack2Length) {
            sum = sumDeque(deque1, deque2, stack1Length);
        } else {
            sum = sumDeque(deque2, deque1, stack2Length);
        }
        ListNode result = new ListNode(sum.pop());
        while (!sum.isEmpty()) {
            result = new ListNode(sum.pop(), result);
        }
        return result;
    }

    private Deque<Integer> getNumbersInStack(ListNode listNode) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(listNode.getVal());
        while (listNode.hasNext()) {
            listNode = listNode.getNext();
            deque.add(listNode.getVal());
        }
        return deque;
    }

    private Deque<Integer> sumDeque(Deque<Integer> stack1, Deque<Integer> stack2, int size) {
        int delta = 0;
        int sum;
        Deque<Integer> result = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            sum = getSumOfTwoNumbers(stack1, stack2) + delta;
            if (sum > 9) {
                sum %= 10;
                delta = 1;
            } else {
                delta = 0;
            }
            result.push(sum);
        }
        if (delta != 0) {
            result.push(delta);
        }
        return result;
    }

    private int getSumOfTwoNumbers(Deque<Integer> deque1, Deque<Integer> deque2) {
        if (deque1.isEmpty()) {
            return deque2.pollFirst();
        } else if (deque2.isEmpty()) {
            return deque1.pollFirst();
        } else {
            return deque1.pollFirst() + deque2.pollFirst();
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        String numbersFirst = new String(getNumbersLikeString(l1));
        String numbersSecond = new String(getNumbersLikeString(l2));
        BigInteger num1 = new BigInteger(numbersFirst);
        BigInteger num2 = new BigInteger(numbersSecond);
        BigInteger sum = num1.add(num2);
        String[] str = String.valueOf(sum).split("");
        ListNode result = new ListNode(Integer.parseInt(str[0]));
        for (int i = 1; i <= str.length - 1; i++) {
            result = new ListNode(Integer.parseInt(str[i]), result);
        }
        return result;
    }

    private StringBuilder getNumbersLikeString(ListNode listNode) {
        StringBuilder sb = new StringBuilder();
        sb.append(listNode.getVal());
        while (listNode.hasNext()) {
            listNode = listNode.getNext();
            sb.append(listNode.getVal());
        }
        return sb.reverse();
    }
}
