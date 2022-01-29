import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 3, 1};
        System.out.println(solution(arr));
    }

    public static int solution(int[] l) {
        List<Integer> initList = new ArrayList<>();
        List<Integer> resList = new ArrayList<>();

        Queue<Integer> rem0queue = new LinkedList<>();
        Queue<Integer> rem1queue = new LinkedList<>();
        Queue<Integer> rem2queue = new LinkedList<>();

        StringBuilder sbResult = new StringBuilder();
        int result = 0, sum = 0, rem;

        for (int x : l) {
            if (x < 0) return result;
            initList.add(x);
        }

        Collections.sort(initList);
        System.out.println(initList);

        for (int y : initList) {
            sum += y;
            if ((y % 3) == 0) rem0queue.add(y);
            else if ((y % 3) == 1) rem1queue.add(y);
            else rem2queue.add(y);
        }

        if (sum == 0) return result;
        rem = sum % 3;


        switch (rem) {
            case 0:
                resList.addAll(rem0queue);
                resList.addAll(rem1queue);
                resList.addAll(rem2queue);
                resList.sort(Collections.reverseOrder());

                for (int x : resList) sbResult.append(x);
                result = Integer.parseInt(sbResult.toString());
                break;

            case 1:
                if (!rem1queue.isEmpty()) rem1queue.remove();
                else {
                    if (!rem2queue.isEmpty()) rem2queue.remove();
                    if (!rem2queue.isEmpty()) rem2queue.remove();
                }
                resList.addAll(rem1queue);
                resList.addAll(rem2queue);
                resList.addAll(rem0queue);
                if (resList.isEmpty()) return result;
                resList.sort(Collections.reverseOrder());

                for (int x : resList) sbResult.append(x);
                //System.out.println(resList);
                result = Integer.parseInt(sbResult.toString());
                break;

            case 2:
                if (!rem2queue.isEmpty()) rem2queue.remove();
                else {
                    if (!rem1queue.isEmpty()) rem1queue.remove();
                    if (!rem1queue.isEmpty()) rem1queue.remove();
                }
                resList.addAll(rem2queue);
                resList.addAll(rem1queue);
                resList.addAll(rem0queue);
                if (resList.isEmpty()) return result;
                resList.sort(Collections.reverseOrder());

                for (int x : resList) sbResult.append(x);
                if (resList.isEmpty()) return result;
                result = Integer.parseInt(sbResult.toString());
                break;
        }


        //System.out.println("Sum of digits " + sum + "\n" + "Rem num " + rem + "\n" + "Result num " + sbResult);

        return result;
    }
}
