import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EventoBotoes {
  public static StringBuilder currentInput = new StringBuilder();
  public static String operator = "";
  public static double firstNumber = 0;

  public static JButton createButton(String text) {
    JButton button = new JButton(text);

    button.setForeground(new Color(255, 255, 255));
    button.setBackground(new Color(50, 56, 71));
    button.setFocusPainted(false);
    button.setFont(new Font("SansSerif", Font.BOLD, 30));

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        currentInput.append(text);
        Calculadora.visor.setText(currentInput.toString());
      }
    });
    return button;
  }

  public static JButton createOperatorButton(String text) {
    JButton button = new JButton(text);

    button.setForeground(new Color(255, 255, 255));
    button.setBackground(new Color(77, 86, 102));
    button.setFocusPainted(false);
    button.setFont(new Font("SansSerif", Font.BOLD, 30));
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        firstNumber = Double.parseDouble(currentInput.toString());
        operator = text;
        currentInput.setLength(0);
      }
    });
    return button;
  }

  public static JButton createEqualsButton() {
    JButton button = new JButton("=");

    button.setForeground(new Color(255, 255, 255));
    button.setBackground(new Color(77, 86, 102));
    button.setFocusPainted(false);
    button.setFont(new Font("SansSerif", Font.BOLD, 30));
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        double secondNumber = Double.parseDouble(currentInput.toString());
        double result = 0;

        switch (operator) {
          case "+":
            result = Calculos.addition(firstNumber, secondNumber);
            break;
          case "-":
            result = Calculos.subtraction(firstNumber, secondNumber);
            break;
          case "x":
            result = Calculos.multiplication(firstNumber, secondNumber);
            break;
          case "/":
            if (secondNumber != 0) {
              result = Calculos.division(firstNumber, secondNumber);
            } else {
              Calculadora.visor.setText("Erro ao dividir por 0!");
              return;
            }
            break;
        }

        Calculadora.visor.setText(String.valueOf(result));
        currentInput.setLength(0);
      }
    });
    return button;
  }
}