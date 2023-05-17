/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

/**
 *
 * @author Admin
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.Instant;

public class TimeDisplayExample extends JFrame {
    private JLabel timeLabel;
    private Timer timer;
    private Instant startTime;

    public TimeDisplayExample() {
       

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 24)); // Đặt font cho label
        timeLabel.setHorizontalAlignment(JLabel.CENTER); // Căn giữa chữ trong label

        getContentPane().add(timeLabel);

        

        startTime = Instant.now(); // Lưu thời điểm bắt đầu

        // Thiết lập timer để cập nhật thời gian mỗi giây
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateElapsedTime(); // Cập nhật thời gian trôi qua
            }
        });
        timer.start(); // Khởi động timer
    }

    private void updateElapsedTime() {
        Instant currentTime = Instant.now(); // Lấy thời điểm hiện tại
        Duration duration = Duration.between(startTime, currentTime); // Tính thời gian trôi qua

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds); // Định dạng thời gian

        timeLabel.setText(timeString); // Đặt thời gian vào label
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TimeDisplayExample();
            }
        });
    }
}
