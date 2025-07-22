package com.leecode.task2;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        String numbersFirst = new String(getNumbersLikeString(l1));
        String numbersSecond = new String(getNumbersLikeString(l2));
        BigInteger num1 =  new BigInteger(numbersFirst);
        BigInteger num2 =  new BigInteger(numbersSecond);
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
