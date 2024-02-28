package QueueStack;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*한가롭게 방학에 놀고 있던 도현이는 갑자기 재밌는 자료구조를 생각해냈다. 그 자료구조의 이름은 queuestack이다.

queuestack의 구조는 다음과 같다. 
$1$번, 
$2$번, ... , 
$N$번의 자료구조(queue 혹은 stack)가 나열되어있으며, 각각의 자료구조에는 한 개의 원소가 들어있다.

queuestack의 작동은 다음과 같다.

 
$x_0$을 입력받는다.
 
$x_0$을 
$1$번 자료구조에 삽입한 뒤 
$1$번 자료구조에서 원소를 pop한다. 그때 pop된 원소를 
$x_1$이라 한다.
 
$x_1$을 
$2$번 자료구조에 삽입한 뒤 
$2$번 자료구조에서 원소를 pop한다. 그때 pop된 원소를 
$x_2$이라 한다.
...
 
$x_{N-1}$을 
$N$번 자료구조에 삽입한 뒤 
$N$번 자료구조에서 원소를 pop한다. 그때 pop된 원소를 
$x_N$이라 한다.
 
$x_N$을 리턴한다.
도현이는 길이 
$M$의 수열 
$C$를 가져와서 수열의 원소를 앞에서부터 차례대로 queuestack에 삽입할 것이다. 이전에 삽입한 결과는 남아 있다. (예제 
$1$ 참고)

queuestack에 넣을 원소들이 주어졌을 때, 해당 원소를 넣은 리턴값을 출력하는 프로그램을 작성해보자.
*/


public class QueueStack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 자료구조 개수

        int[] typeArr = new int[N]; // 자료구조 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        

        //각각 자료구조의 개수만큼 어떠한 자료구조를 가지는지 입력받기(큐 or 스택)
        for(int i = 0; i < N; i++){
            // 일단 자료구조형태값만 받는다.
            typeArr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        //각각의 자료구조가 가지는 값 입력받기(하나의 원소밖에 가지지 못함)
        for(int i = 0; i < N; i++){
            //스택은 들어가자마자 나오기 때문에 자료형이 큐인 것만 저장한다.
            int num = Integer.parseInt(st.nextToken());
            if(typeArr[i] == 0){
                deque.addLast(num);
            }
        }

        int M = Integer.parseInt(br.readLine()); // 삽입할 수열의 길이

        st = new StringTokenizer(br.readLine());
        br.close();
        // 수열을 삽입한다.
        while(M --> 0){
            int moveValue = Integer.parseInt(st.nextToken());
            // 만약 큐만 없고 스택으로 이루어졌다고 해도 바로 빼기 때문에 (pollLast()) 문제가 되지 않는다.
            // => 첫번째에 넣고 마지막을 뺀다. (큐의 자료구조를 가진 큰 큐로 가정해서 풀면 되는 문제)
            deque.addFirst(moveValue);
            sb.append(deque.pollLast()).append(" ");
        }

        System.out.println(sb); 
    }
}