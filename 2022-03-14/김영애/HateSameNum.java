package week1;

import java.util.ArrayList;
import java.util.Arrays;

public class HateSameNum {
	public static int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<Integer>(); // ArrayList ����

        int num = -1; // ó�� �� ����� ���ѻ��׿� �������� ���� -1�� ����
        for(int i=0; i<arr.length; i++){
            if(arr[i] != num){
                list.add(arr[i]); // ArrayList�� �ߺ����� �ʴ� �� ���
                num = arr[i];
            } // �ߺ����� �ʴ� ���� ArrayList�� ���� �ʰ� �Ѿ
        }

        int[] answer = new int[list.size()]; // list�� ���� ũ�⸸ŭ�� ũ��� �迭����
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] eg1 = {1,1,3,3,0,1,1};
        int[] eg2 = {4,4,4,3,3};
        System.out.println(Arrays.toString(solution(eg1)));
        System.out.println(Arrays.toString(solution(eg2)));
    }
}
