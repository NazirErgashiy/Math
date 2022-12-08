package mathFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * class Commons contains other functions
 */
public class Commons {
    /**
     * Returns 2 minimal integer in array
     *
     * @param arr input array with 2 and more elements in
     * @return arr with 2 elements which contains 2 minimal integers
     */
    public int[] findTwoMinElements(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("В массиве должно быть минимум 2 элемента!");
        }
        Arrays.sort(arr);
        return new int[]{arr[0], arr[1]};
    }

    /**
     * Returns 2 minimal integer in array (no using Arrays.sort)
     *
     * @param arr input array with 2 and more elements in
     * @return arr with 2 elements which contains 2 minimal integers
     */
    public int[] findTwoMinElementsCustom(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("В массиве должно быть минимум 2 элемента!");
        }

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minId = i;

            for (int x = i + 1; x < arr.length; x++) {
                if (arr[x] < min) {
                    min = arr[x];
                    minId = x;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[minId] = temp;
        }

        return new int[]{arr[0], arr[1]};
    }

    /**
     * Node class which realizes LinkedList
     */
    public static class Node {
        Integer value;
        Node next;

        public Node(Integer value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(Integer value) {
            this.value = value;
        }
    }

    /**
     * Return reversed Node
     *
     * @param node
     * @return
     */
    public static Node reverseLinkedList(Node node) {
        if (node == null) {
            return node;
        }
        Node previousNode = null;
        Node currentNode = node;
        Node nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    /**
     * Check brackets correctness
     * @param str input string
     * @return boolean if brackets order is correct returns true
     * example{
     * str = "({<>})"
     * return boolean = true
     * }
     */
    public boolean checkBracketsCorrectness(String str) {
        char[] strInChars = str.toCharArray();
        char[] symbolBracketsOpen = new char[]{'{', '<', '['};
        char[] symbolBracketsClose = new char[]{'}', '>', ']'};
        int[] counter = new int[symbolBracketsOpen.length];
        int lastOpenedId = 0;
        int lastClosedId = 0;


        for (int i = 0; i < strInChars.length; i++) {
            //start: Если есть закрытая скобка но не имеется открытая то возвращаем -> false
            for (int k = 0; k < symbolBracketsClose.length; k++) {
                if (strInChars[i] == symbolBracketsClose[k] && counter[k] == 0) {
                    return false;
                }
            }
            //end: Если есть закрытая скобка но не имеется открытая то возвращаем -> false


            for (int j = 0; j < symbolBracketsOpen.length; j++) {
                if (strInChars[i] == symbolBracketsOpen[j]) {
                    counter[j]++;
                    lastOpenedId = j;
                    break;//Нашли то что нужно поэтому выходим из цикла
                }
                if (strInChars[i] == symbolBracketsClose[j]) {
                    counter[j]--;
                    lastClosedId = j;
                    if (strInChars[i - 1] == symbolBracketsOpen[lastOpenedId]) {
                        if (lastClosedId != lastOpenedId) {
                            return false;
                        }
                    }
                    break;//Нашли то что нужно поэтому выходим из цикла
                }
            }
        }

        Set<Integer> distinct = Arrays.stream(counter).boxed().collect(Collectors.toSet());
        boolean allEqual = distinct.size() == 1;

        return allEqual;
    }

    /**
     * Finds maximum number of users which watched stream
     * @param t_in user started watching stream
     * @param t_out user leaved stream
     * @return integer peak of stream watchers
     */
    public int maximumNumberOfUsers(int[] t_in, int[] t_out) {
        if (t_in.length != t_out.length) {
            throw new IllegalArgumentException("Длина массивов должна быть одинаковой!");
        }

        int[] sortedOut = t_out;
        Arrays.sort(sortedOut);
        int watchedStream = 0;
        int max = 0;
        for (int i = 0; i < sortedOut[sortedOut.length - 1]; i++) {
            for (int k = 0; k < t_in.length; k++) {
                if (t_in[k] == i) {
                    watchedStream += 1;
                }
                if (t_out[k] == i) {
                    watchedStream--;
                }
            }
            if (max < watchedStream) {
                max = watchedStream;
            }
        }

        return max;
    }

    /**
     * Compares Lists
     * @param first
     * @param second
     * @return boolean if second List contains same character as first returns true (also number of same characters is counting)
     */
    public boolean isContainsSameCharacters(List<Character> first, List<Character> second) {
        List<Character> s = new ArrayList<>(second.size());
        s.addAll(second);

        for (int i = 0; i < first.size(); i++) {
            if (s.contains(first.get(i))) {
                s.remove(first.get(i));
            } else {
                return false;
            }
        }
        return true;
    }
}