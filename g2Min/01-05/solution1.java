package example13;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Clock extends JFrame {
    Container contentPane;

    Clock() {
        setTitle("Analgo Clock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = getContentPane();

        MyPanel panel = new MyPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        setSize(600, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Clock();
    }

    // 선을 그릴 수 있는 패널을 구현한다.
    // 이 패널에 Mouse 리스너를 구현한다.
    class MyPanel extends JPanel implements Runnable {
        int ox, oy, r;
        Calendar cal;

        public MyPanel() {
            ox = oy = 300;
            r = 200;
            Thread t = new Thread(this);
            t.start();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            cal = Calendar.getInstance();
            int sec = cal.get(Calendar.SECOND); // 초 구현
            int min = cal.get(Calendar.MINUTE); // 분 구현
            int hour = cal.get(Calendar.HOUR); // 분 구현
            int millis = cal.get(Calendar.MILLISECOND);

            // 시계 테두리
            g.setColor(Color.BLUE);
            g.drawOval(100, 100, 400, 400);
            g.setColor(Color.RED);
            for (int i = 0; i <= 360; i += 6) { // 시계 테두리
                int x1 = (int) (r * Math.sin(3.1415 * i / 180) + ox);
                int y1 = (int) (r * Math.cos(3.1415 * i / 180) + oy);
                int x2 = (int) ((r - 5) * Math.sin(3.1415 * i / 180) + ox);
                int y2 = (int) ((r - 5) * Math.cos(3.1415 * i / 180) + oy);

                if (i % 30 == 0) { // 큰 눈금 표시
                    int j = 1;
                    x2 = (int) ((r - 20) * Math.sin(3.1415 * i / 180) + ox);
                    y2 = (int) ((r - 20) * Math.cos(3.1415 * i / 180) + oy);
                }
                g.drawLine(x1, y1, x2, y2);

            }

            if (sec == 60) {
                sec = 0;
                min++;
            }
            if (min == 60) {
                min = 0;
                hour++;
            }
            if (min == 60 && hour == 12) {
                hour = 0;
            }

            sec = sec * 6 - 90;
            int xSecond = (int) (r * Math.cos(3.1415 * sec / 180) + ox);
            int ySecond = (int) (r * Math.sin(3.1415 * sec / 180) + oy);
            g.setColor(Color.RED);
            g.drawLine(ox, oy, xSecond, ySecond);

            min = cal.get(Calendar.MINUTE)*6 + sec/60 - 90;
            int xMinute = (int) (150 * Math.cos(3.1415 * min / 180) + ox);
            int yMinute = (int) (150 * Math.sin(3.1415 * min / 180) + oy);
            g.setColor(Color.BLUE);
            g.drawLine(ox, oy, xMinute, yMinute);

            hour = hour * 30 + cal.get(Calendar.MINUTE) /2 - 90 ;
            int xHour = (int) (100 * Math.cos(3.1415 * hour / 180) + ox);
            int yHour = (int) (100 * Math.sin(3.1415 * hour / 180) + oy);
            g.setColor(Color.BLACK);
            g.drawLine(ox, oy, xHour, yHour);

        }

        public void run() {
            try {
                while (true) {
                    Thread.sleep(1000);
                    repaint();
                }
            } catch (Exception e) {
            }
        }

    }
}
