import javax.swing.*;

public class Window extends JFrame {
    public Window() {
        JPanel jPanel = new JPanel();
        this.add(jPanel);
        this.setSize(800, 600);
        this.setTitle("Window");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
