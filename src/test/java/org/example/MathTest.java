package org.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class MathTest {

    private Math math;
    private Commons commons;

    @Before
    public void setUp() throws Exception {
        math = new Math();
        commons=new Commons();
    }

    @Test
    public void factorial() {
        assertThat(math.factorial(1), is(1L));
        assertThat(math.factorial(2), is(2L));
        assertThat(math.factorial(3), is(6L));
        assertThat(math.factorial(5), is(120L));
    }

    @Test
    public void factorialForWrongArgument() {
        try {
            math.factorial(-2);
            fail("Должно вылететь исключение");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Ожидается положительный параметр!"));
        }
    }

    @Test
    public void fibonacci() {
        assertThat(math.fibonacci(1), is(1L));
        assertThat(math.fibonacci(2), is(1L));
        assertThat(math.fibonacci(3), is(2L));
        assertThat(math.fibonacci(4), is(3L));
        assertThat(math.fibonacci(5), is(5L));
        assertThat(math.fibonacci(6), is(8L));
        assertThat(math.fibonacci(7), is(13L));
        assertThat(math.fibonacci(8), is(21L));
        assertThat(math.fibonacci(9), is(34L));
        assertThat(math.fibonacci(10), is(55L));
    }

    @Test
    public void fibonacciForWrongArgument() {
        try {
            math.fibonacci(-2);
            fail("Должно вылететь исключение");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Ожидается положительный параметр!"));
        }
    }

    @Test
    public void findTwoMinElements() {
        int[] test = {60, 5, -16, 789, 0, 3879, -37, -5};
        int[] result = {-37, -16};
        assertThat(commons.findTwoMinElements(test), is(result));
    }

    @Test
    public void findTwoMinElementsForWrongArgument1() {
        try {
            int[] n = {};
            commons.findTwoMinElements(n);
            fail("Ошибка");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("В массиве должно быть минимум 2 элемента!"));
        }
    }

    @Test
    public void findTwoMinElementsForWrongArgument2() {
        try {
            int[] n = {50};
            commons.findTwoMinElements(n);
            fail("Ошибка");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("В массиве должно быть минимум 2 элемента!"));
        }
    }

    @Test
    public void findTwoMinElementsCustom() {
        int[] test = {60, 5, -16, 789, 0, 3879, -37, -5};
        int[] result = {-37, -16};
        assertThat(commons.findTwoMinElementsCustom(test), is(result));
    }

    @Test
    public void findTwoMinElementsCustomForWrongArgument1() {
        try {
            int[] n = {};
            commons.findTwoMinElementsCustom(n);
            fail("Ошибка");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("В массиве должно быть минимум 2 элемента!"));
        }
    }

    @Test
    public void findTwoMinElementsCustomForWrongArgument2() {
        try {
            int[] n = {50};
            commons.findTwoMinElementsCustom(n);
            fail("Ошибка");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("В массиве должно быть минимум 2 элемента!"));
        }
    }

    @Test
    public void isPalindrome() {
        assertThat(math.isPalindrome(""), is(true));
        assertThat(math.isPalindrome("Nazir"), is(false));
        assertThat(math.isPalindrome("Alla"), is(true));
        assertThat(math.isPalindrome("alla"), is(true));
    }

    @Test
    public void isPalindromeForWrongArgument() {
        try {
            math.isPalindrome(null);
            fail("Ошибка");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Недопустим пустой параметр!"));
        }
    }

    @Test
    public void isTriangle() {
        assertThat(math.isTriangle(3, 3, 3), is(true));
        assertThat(math.isTriangle(3, 2, 4), is(true));
        assertThat(math.isTriangle(0, 1, 1), is(false));
        assertThat(math.isTriangle(-5, 9, 8), is(false));
        assertThat(math.isTriangle(5, -9, 8), is(false));
        assertThat(math.isTriangle(5, 9, -8), is(false));
    }

    @Test
    public void powerOfTwo() {
        int[] test = {-5, -3, 0, 1, 2, 4};
        int[] result = {0, 1, 4, 9, 16, 25};
        assertThat(math.powerOfTwo(test), is(result));
    }

    @Test
    public void powerOfTwoStream() {
        int[] test = {-5, -3, 0, 1, 2, 4};
        int[] result = {0, 1, 4, 9, 16, 25};
        assertThat(math.powerOfTwoStream(test), is(result));
    }


    @Test
    public void reverseLinkedListOneItem() {
        var node1 = new Commons.Node(5);

        Commons.Node result = Commons.reverseLinkedList(node1);

        assertThat(result.value, is(5));
        assertThat(result.next, nullValue());
    }

    @Test
    public void reverseLinkedListTwoItems() {
        var node1 = new Commons.Node(5);
        var node2 = new Commons.Node(10,node1);

        Commons.Node result = Commons.reverseLinkedList(node2);

        assertThat(result.value, is(5));
        assertThat(result.next.value, is(10));
        assertThat(result.next.next, nullValue());
    }

    @Test
    public void reverseLinkedListThreeItems() {
        var node1 = new Commons.Node(5);
        var node2 = new Commons.Node(10,node1);
        var node3 = new Commons.Node(15,node2);

        Commons.Node result = Commons.reverseLinkedList(node3);

        assertThat(result.value, is(5));
        assertThat(result.next.value, is(10));
        assertThat(result.next.next.value, is(15));
        assertThat(result.next.next.next, nullValue());
    }

    @Test
    public void correctBrackets() {
        assertThat(commons.checkBracketsCorrectness("{"), is(false));
        assertThat(commons.checkBracketsCorrectness("]"), is(false));
        assertThat(commons.checkBracketsCorrectness("<>"), is(true));
        assertThat(commons.checkBracketsCorrectness("<{}[<>]>"), is(true));
        assertThat(commons.checkBracketsCorrectness("{}[]"), is(true));
        assertThat(commons.checkBracketsCorrectness("}{"), is(false));
        assertThat(commons.checkBracketsCorrectness("{[<>]}{<>}"), is(true));
        assertThat(commons.checkBracketsCorrectness("{[<>]}{<}>"), is(false));
    }

    @Test
    public void maximumNumberOfUsers1() {
        int[] t_in = {8, 12, 0, 50};
        int[] t_out = {20, 16, 6, 70};
        assertThat(commons.maximumNumberOfUsers(t_in, t_out), is(2));
    }

    @Test
    public void maximumNumberOfUsers2() {
        int[] t_in = {0, 10, 21, 30};
        int[] t_out = {6, 20, 25, 70};
        assertThat(commons.maximumNumberOfUsers(t_in, t_out), is(1));
    }

    @Test
    public void maximumNumberOfUsers3() {
        int[] t_in = {0, 5, 9, 30};
        int[] t_out = {20, 10, 25, 70};
        assertThat(commons.maximumNumberOfUsers(t_in, t_out), is(3));
    }

    @Test
    public void isContainsSameCharacters1() {
        var first = List.of('a', 'b', 'c', 'd');
        var second = List.of('c', 'a', 'e', 'd', 'g', 'b');
        assertThat(commons.isContainsSameCharacters(first, second), is(true));
    }

    @Test
    public void isContainsSameCharacters2() {
        var first = List.of('a', 'd', 'a', 'b', 'c', 'd');
        var second = List.of('c', 'd', 'a', 'e', 'd', 'g', 'b');
        assertThat(commons.isContainsSameCharacters(first, second), is(false));
    }
}