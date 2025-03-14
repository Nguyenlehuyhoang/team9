
package Sprin3;

import javax.swing.*;
import java.awt.event.*;

public class TimSoNhoNhat extends JFrame {
    private final JTextField inputField;
    private final JButton findButton;
    private final JTextArea resultArea;

    public TimSoNhoNhat() {
        setTitle("Tìm Số Nhỏ Nhất");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel label = new JLabel("Nhập các số cách nhau bằng dấu phẩy:");
        label.setBounds(20, 20, 300, 20);
        add(label);

        inputField = new JTextField();
        inputField.setBounds(20, 50, 250, 30);
        add(inputField);

        findButton = new JButton("Tìm Min");
        findButton.setBounds(280, 50, 100, 30);
        add(findButton);

        resultArea = new JTextArea();
        resultArea.setBounds(20, 100, 360, 100);
        resultArea.setEditable(false);
        add(resultArea);

        findButton.addActionListener((ActionEvent e) -> {
            findMin();
        });
    }

    private void findMin() {
        String input = inputField.getText();
        String[] numbers = input.split(",");
        try {
            int min = Integer.MAX_VALUE;
            for (String num : numbers) {
                int value = Integer.parseInt(num.trim());
                if (value < min) {
                    min = value;
                }
            }
            resultArea.setText("Số nhỏ nhất là: " + min);
        } catch (NumberFormatException ex) {
            resultArea.setText("Lỗi: Vui lòng nhập số hợp lệ!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TimSoNhoNhat app = new TimSoNhoNhat();
            app.setVisible(true);
        });
    }
}
