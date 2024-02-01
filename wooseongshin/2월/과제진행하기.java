import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        ArrayList<String> result = new ArrayList<>();
        PriorityQueue<HomeWork> queue = new PriorityQueue<>(Comparator.comparingInt(HomeWork::getStart).thenComparingInt(HomeWork::getPlayTime));
        Stack<HomeWork> stack = new Stack<>();
        int length = plans.length;

        for (String[] plan : plans) {
            String[] split = plan[1].split(":");
            int playTime = Integer.parseInt(plan[2]);
            int start = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            queue.add(new HomeWork(plan[0], start, playTime));
        }

        int time = queue.peek().getStart();
        int cnt = 0;

        while (cnt < length) {
            if (!stack.isEmpty()) {
                stack.peek().decreasePlayTime();
                if (stack.peek().getPlayTime() == 0) {
                    result.add(stack.peek().getName());
                    stack.pop();
                    cnt++;
                }
            }

            if (!queue.isEmpty() && queue.peek().getStart() == time) {
                stack.add(queue.poll());
            }
            time++;
        }
        return result.toArray(new String[0]);
    }

    static class HomeWork {
        private String name;
        private int start;
        private int playTime;

        public HomeWork(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }

        public String getName() {
            return name;
        }

        public int getStart() {
            return start;
        }

        public int getPlayTime() {
            return playTime;
        }

        public void decreasePlayTime() {
            playTime--;
        }
    }
}
