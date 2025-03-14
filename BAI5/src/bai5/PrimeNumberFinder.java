
package bai5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PrimeNumberFinder {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tìm Số Nguyên Tố");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Nhập các số, cách nhau bởi dấu phẩy:");
        JTextField inputField = new JTextField(20);
        JButton findButton = new JButton("Tìm SNT");
        JTextArea resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                String[] numbers = input.split(",");
                ArrayList<Integer> primes = new ArrayList<>();
                
                for (String num : numbers) {
                    try {
                        int value = Integer.parseInt(num.trim());
                        if (isPrime(value)) {
                            primes.add(value);
                        }
                    } catch (NumberFormatException ex) {
                        resultArea.setText("Vui lòng nhập đúng định dạng số!");
                        return;
                    }
                }
                resultArea.setText("Số nguyên tố: " + primes.toString());
            }
        });

        frame.add(label);
        frame.add(inputField);
        frame.add(findButton);
        frame.add(new JScrollPane(resultArea));

        frame.setVisible(true);
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

