import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private static List<List<Integer>> graph;

    private static boolean[] visited;

    private static int startVertex;

    private static int maxVertex;
    private static int graphNum;

    private static int[] incomingEdges;

    private void initGraph(int[][] edges) {
        maxVertex = 0;

        for (int[] edge : edges) {
            maxVertex = Math.max(maxVertex, Math.max(edge[0], edge[1]));
        }

        visited = new boolean[maxVertex + 1];
        incomingEdges = new int[maxVertex + 1];
        graph = new ArrayList<>(maxVertex + 1);

        for (int i = 0; i <= maxVertex; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);// 단방향 그래프
            incomingEdges[edges[i][1]]++;
        }
    }

    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        // 그래프 초기화
        initGraph(edges);

        // 시작 정점 찾기 + 전체 그래프 갯수 찾기
        startVertex = findCreatedVertex();
        graphNum = graph.get(startVertex).size();
        answer[0] = startVertex;
        // 시작 정점 연결 끊기.
        removeEdgesFromCreatedVertex(startVertex);

        // 막대 그래프 갯수 찾기.
        // 들어오는 간선이 없거나, 나가는 간선이 없는 vertex의 갯수이다.
        answer[2] = countBarGraphs();

        // 8자모양 그래프 갯수 찾기.
        // 둘어오는 간선 2개, 나가는 간선2개인 vertex의 갯수이다.
        answer[3] = countEightShape();
        answer[1] = graphNum - (answer[2] + answer[3]);

        System.out.println(countIncomingEdges(maxVertex - 1));
        return answer;
    }

    private int countBarGraphs() {
        int count = 0;
        for (int i = 1; i < graph.size(); i++) {
            if (i == startVertex) {
                continue;
            }
            if (graph.get(i).isEmpty()) {// 나가는게 없다.
                count++;
                visited[i] = true;
            }
        }
        return count;
    }

    private int countEightShape() {
        int count = 0;
        for (int i = 1; i < graph.size(); i++) {
            if (!visited[i]) {
                if (graph.get(i).size() == 2 && countIncomingEdges(i) == 2) {
                    System.out.println(i);
                    count++;
                }
            }
        }
        return count;
    }

    private int findCreatedVertex() {
        // 들어오는 거의 갯수가 없고, 나가는 것만 2개 이상인 점.
        int createdVertex = -1;
        for (int i = 1; i < graph.size(); i++) {
            if (graph.get(i).size() >= 2 && countIncomingEdges(i) == 0) {
                createdVertex = i;
                break;
            }
        }
        visited[createdVertex] = true;
        return createdVertex;
    }

    private int countIncomingEdges(int vertex) {
        return incomingEdges[vertex];
    }

    private void removeEdgesFromCreatedVertex(int vertex) {
        for (int end : graph.get(vertex)) {
            incomingEdges[end]--;
        }
        graph.set(vertex, new LinkedList<>());
    }
}
// fail.
// 요구사항 : answer = [ a,b,c,d ]; 를 만들어라.
// 주어지는 정보 : 간선의 갯수 = edges 배열의 크기.
// edges의 크기 = a
// a = N개의 그래프 + 원래 있던 간선들의 갯수.
// 원래 있던 간선들의 갯수 : (2n.+2)*b + (막대라면 n..-1)*c + (8자라면 2n...+2)*d

//

// ----도넛인 경우의 수----
// 같은 숫자가 반복된다면 도넛 +1 =>[1,1]
// 서로 참조하고 있다면 도넛 +1 =>[1,2] [2,1]
//

// ----막대인 경우의 수----
// ----8자 모양인 경우의 수----