import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InSoChan extends JFrame {
    private JTextField tfSoPhanTu;
    private JTextArea taNhapMang, taKetQua;
    private JButton btnTimSoChan;

    public InSoChan() {
        setTitle("Tim so chan trong mang");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        JLabel lblSoPhanTu = new JLabel("Nhap so phan tu: ");
        tfSoPhanTu = new JTextField(10);
        JLabel lblNhapMang = new JLabel("Nhap mang (cach nhau bang dau cach): ");
        taNhapMang = new JTextArea(5, 30);
        btnTimSoChan = new JButton("Tim so chan");
        taKetQua = new JTextArea(5, 30);
        taKetQua.setEditable(false);

        add(lblSoPhanTu);
        add(tfSoPhanTu);
        add(lblNhapMang);
        add(new JScrollPane(taNhapMang));
        add(btnTimSoChan);
        add(new JScrollPane(taKetQua));

        btnTimSoChan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timSoChan();
            }
        });
    }

    private void timSoChan() {
        try {
            int n = Integer.parseInt(tfSoPhanTu.getText());
            String[] input = taNhapMang.getText().trim().split("\\s+");
            if (input.length != n) {
                taKetQua.setText("So phan tu khong khop voi mang nhap!");
                return;
            }

            double[] mang = new double[n];
            for (int i = 0; i < n; i++) {
                mang[i] = Double.parseDouble(input[i]);
            }

            StringBuilder ketQua = new StringBuilder("Cac so chan trong mang: ");
            boolean coSoChan = false;
            for (int i = 0; i < n; i++) {
                if (mang[i] % 2 == 0) {
                    ketQua.append(mang[i]).append(" ");
                    coSoChan = true;
                }
            }

            if (!coSoChan) {
                ketQua.append("Khong co so chan");
            }
            taKetQua.setText(ketQua.toString());
        } catch (Exception ex) {
            taKetQua.setText("Loi: Vui long nhap dung dinh dang!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InSoChan().setVisible(true);
            }
        });
    }
}