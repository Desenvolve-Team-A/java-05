import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Calculadora {

  private JFrame frame;
  public static JLabel visor;

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Calculadora window = new Calculadora();
          window.frame.setVisible(true);
          window.frame.setLocationRelativeTo(null);
          window.frame.setResizable(false);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  public Calculadora() {
    initialize();
  }

  private void initialize() {
    frame = new JFrame();
    frame.getContentPane().setBackground(new Color(36, 40, 51));
    frame.setBounds(100, 100, 520, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new BorderLayout(0, 0));

    visor = new JLabel("0");
    visor.setForeground(new Color(255, 255, 255));
    visor.setFont(new Font("SansSerif", Font.BOLD, 48));
    visor.setHorizontalAlignment(SwingConstants.RIGHT);
    frame.getContentPane().add(visor, BorderLayout.NORTH);

    JPanel panel = new JPanel();
    panel.setBackground(new Color(36, 40, 51));
    frame.getContentPane().add(panel, BorderLayout.CENTER);
    panel.setLayout(new GridLayout(4, 4, 10, 10));

    JButton btn7 = EventoBotoes.createButton("7");
    panel.add(btn7);

    JButton btn8 = EventoBotoes.createButton("8");
    panel.add(btn8);

    JButton btn9 = EventoBotoes.createButton("9");
    panel.add(btn9);

    JButton btnMais = EventoBotoes.createOperatorButton("+");
    panel.add(btnMais);

    JButton btn4 = EventoBotoes.createButton("4");
    panel.add(btn4);

    JButton btn5 = EventoBotoes.createButton("5");
    panel.add(btn5);

    JButton btn6 = EventoBotoes.createButton("6");
    panel.add(btn6);

    JButton btnMenos = EventoBotoes.createOperatorButton("-");
    panel.add(btnMenos);

    JButton btn1 = EventoBotoes.createButton("1");
    panel.add(btn1);

    JButton btn2 = EventoBotoes.createButton("2");
    panel.add(btn2);

    JButton btn3 = EventoBotoes.createButton("3");
    panel.add(btn3);

    JButton btnMult = EventoBotoes.createOperatorButton("x");
    panel.add(btnMult);

    JButton btn0 = EventoBotoes.createButton("0");
    panel.add(btn0);

    JButton btnPonto = EventoBotoes.createButton(".");
    panel.add(btnPonto);

    JButton btnDiv = EventoBotoes.createOperatorButton("/");
    panel.add(btnDiv);

    JButton btnIgual = EventoBotoes.createEqualsButton();
    panel.add(btnIgual);
  }
}