import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_21943_연산 최대로
 *
 * 1.
 *
 * @author semin.kim
 */

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int numberCount; // 양의 정수의 개수
    static int plusCount, multiplyCount; // 더하기, 곱하기 연산자의 개수
    static int[] numbers, selectedNumbers;
    static char[] operators;
    static boolean[] isSelected, isSelectedOp;

    static int maxResult; // 연산의 결과 중 최댓값

    /**
     * 숫자 순열
     * @param currentIdx
     */
    public static void permutationNumbers(int currentIdx){
        if(currentIdx == numberCount){
            permutationOperators(0,0);
        }
        else {
            for(int idx = 0; idx < numberCount; idx++){
                if(isSelected[idx]) continue;
                isSelected[idx] = true;
                selectedNumbers[currentIdx] = numbers[idx];
                permutationNumbers(currentIdx + 1);
                isSelected[idx] = false;
            }
        }
    }

    public static void permutationOperators(int a, int currentIdx) {
        if(currentIdx == plusCount){
            int[] sum = new int[multiplyCount + 1]; // 연산과정의 부분 합을 저장할 1차원 배열

            int idx = 0;

            for(int selectedOpIdx = 0; selectedOpIdx < numberCount - 1; selectedOpIdx++){
                // 첫번째 연산자가 '+'인 경우...
                if(selectedOpIdx == 0 && isSelectedOp[selectedOpIdx]){
                    sum[idx] = selectedNumbers[selectedOpIdx] + selectedNumbers[selectedOpIdx + 1];
                }
                // 이전 연산자와 현재 연산자가 모두 '+'인 경우...
                else if(isSelectedOp[selectedOpIdx] && isSelectedOp[selectedOpIdx - 1]){
                    sum[idx] += selectedNumbers[selectedOpIdx + 1];
                }
                // '*' 연산자인 경우.. 이전 값에서 더하는 것이 아니라 새로운 sum을 만들어야한다.
                else if(!isSelectedOp[selectedOpIdx]){
                    idx++;
                    sum[idx] += selectedNumbers[selectedOpIdx + 1];
                }
                // 현재 연산자가 '+'이지만, 이전 연산자는 '*'인 경우...
                else if(isSelectedOp[selectedOpIdx] && !isSelectedOp[selectedOpIdx - 1]){
                    sum[idx] += selectedNumbers[selectedOpIdx + 1];
                }
            }

            if(!isSelectedOp[0]) sum[0] = selectedNumbers[0];
            int result = 1;
            for(int tempSum : sum) result *= tempSum;
            maxResult = Math.max(maxResult, result);
        }
        else {
            for(int idx = a; idx < numberCount - 1; idx++){
                if(isSelectedOp[idx]) continue;
                isSelectedOp[idx] = true;
                permutationOperators(idx, currentIdx + 1);
                isSelectedOp[idx] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        numberCount = Integer.parseInt(br.readLine().trim());
        numbers = new int[numberCount];
        selectedNumbers = new int[numberCount];
        isSelected = new boolean[numberCount];

        st = new StringTokenizer(br.readLine().trim());
        for(int idx = 0; idx < numberCount; idx++){
            numbers[idx] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine().trim());
        plusCount = Integer.parseInt(st.nextToken());
        multiplyCount = Integer.parseInt(st.nextToken());

        operators = new char[numberCount - 1];
        isSelectedOp = new boolean[numberCount - 1];

        for(int idx = 0; idx < plusCount; idx++){
            operators[idx] = '+';
        }
        for(int idx = plusCount; idx < numberCount - 1; idx++){
            operators[idx] = '*';
        }

        permutationNumbers(0);
        System.out.println(maxResult);
    }
}
