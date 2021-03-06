import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DualPriorityQueue{
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];

		PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        for (String op : operations) {
            StringTokenizer st = new StringTokenizer(op);
            String judge = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            //빈 큐에 데이터를 삭제 요청 경우 연산 무시
            if (pq.size() < 1 && judge.equals("D"))
                continue;

            //삽입 시 최소 힙, 최대 힙에 value 넣기
            if (judge.equals("I")) {
                pq.offer(value);
                maxPq.offer(value);
                continue;
            }

            //나머지 경우는 D이면서 value값이 1인지 -1인지 이므로
            //0보다 작은 경우 최소 힙에서 poll후 최대힙에서 해당 원소 삭제
            if(value < 0) {
                int min = pq.poll();
                maxPq.remove(min);
                continue;
            }

            //최대 힙에서 poll후 최소힙에서 해당 원소 삭제
            int max = maxPq.poll();
            pq.remove(max);
        }
		
        if(pq.size() > 0 ) {
            answer[0] = maxPq.poll();
            answer[1] = pq.poll();
        }
        return answer;
    }


	public static void main(String[] args) {


		String[] arr1 = {"I 16","D 1"};
		String[] arr2 = {"I 7","I 5","I -5","D -1"};


		System.out.println(Arrays.toString(solution(arr1)));
		System.out.println(Arrays.toString(solution(arr2)));
	}
}