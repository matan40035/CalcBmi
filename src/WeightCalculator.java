import javax.swing.*;
import java.awt.*;

public class WeightCalculator extends JFrame {
    private JLabel firstNameLabel, lastNameLabel, ageLabel, sexLabel, heightLabel, bodyFrameLabel, actualWeightLabel;
    private JTextField firstNameField, lastNameField, ageField, actualWeightField;
    private JRadioButton maleButton, femaleButton;
    private JSlider heightSlider;
    private JRadioButton smallButton, mediumButton, largeButton;
    private JButton calculateButton;
    private JLabel resultLabel;

    public WeightCalculator() {
        setTitle("Weight Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 1));

        JPanel personalInfoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField(10);
        lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField(10);
        ageLabel = new JLabel("Age:");
        ageField = new JTextField(2);
        personalInfoPanel.add(firstNameLabel);
        personalInfoPanel.add(firstNameField);
        personalInfoPanel.add(lastNameLabel);
        personalInfoPanel.add(lastNameField);
        personalInfoPanel.add(ageLabel);
        personalInfoPanel.add(ageField);
        add(personalInfoPanel);


        JPanel sexPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sexLabel = new JLabel("Sex:");
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        ButtonGroup sexGroup = new ButtonGroup();
        sexGroup.add(maleButton);
        sexGroup.add(femaleButton);
        sexPanel.add(sexLabel);
        sexPanel.add(maleButton);
        sexPanel.add(femaleButton);
        add(sexPanel);

        JPanel heightPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        heightLabel = new JLabel("Height (cm):");
        heightSlider = new JSlider(JSlider.HORIZONTAL, 140, 190, 160);
        heightSlider.setMajorTickSpacing(10);
        heightSlider.setPaintTicks(true);
        heightSlider.setPaintLabels(true);
        heightPanel.add(heightLabel);
        heightPanel.add(heightSlider);
        add(heightPanel);

        // Body Frame Panel
        JPanel bodyFramePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bodyFrameLabel = new JLabel("Body Frame:");
        smallButton = new JRadioButton("Small");
        mediumButton = new JRadioButton("Medium");
        largeButton = new JRadioButton("Large");
        ButtonGroup bodyFrameGroup = new ButtonGroup();
        bodyFrameGroup.add(smallButton);
        bodyFrameGroup.add(mediumButton);
        bodyFrameGroup.add(largeButton);
        bodyFramePanel.add(bodyFrameLabel);
        bodyFramePanel.add(smallButton);
        bodyFramePanel.add(mediumButton);
        bodyFramePanel.add(largeButton);
        add(bodyFramePanel);


        JPanel actualWeightPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        actualWeightLabel = new JLabel("Actual Weight (kg):");
        actualWeightField = new JTextField(5);
        actualWeightPanel.add(actualWeightLabel);
        actualWeightPanel.add(actualWeightField);
        add(actualWeightPanel);


        JPanel calculatePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        calculateButton = new JButton("Calculate");
        calculatePanel.add(calculateButton);
        add(calculatePanel);


        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultLabel = new JLabel("");
        resultPanel.add(resultLabel);
        add(resultPanel);

        calculateButton.addActionListener(e -> calculate());

        setVisible(true);
    }

    private void calculate() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        int age = Integer.parseInt(ageField.getText());
        int height = heightSlider.getValue();
        String bodyFrame = "";
        if (smallButton.isSelected()) {
            bodyFrame = "Small";
        } else if (mediumButton.isSelected()) {
            bodyFrame = "Medium";
        } else if (largeButton.isSelected()) {
            bodyFrame = "Large";
        }
        double actualWeight = Double.parseDouble(actualWeightField.getText());
        double bmi = actualWeight / Math.pow(height / 100, 2);
        String weightStatus;
        if (bmi < 15) {
            weightStatus = "Anorexic";
        } else if (bmi < 18.5) {
            weightStatus = "Underweight";
        } else if (bmi < 25.0) {
            weightStatus = "Normal";
        } else if (bmi < 30.0) {
            weightStatus = "Overweight";
        } else if (bmi < 35.0) {
            weightStatus = "Obese";
        } else {
            weightStatus = "Extreme Obese";
        }
        

        double idealWeight;
        if (bodyFrame.equals("Small")) {
            idealWeight = 0.9 * (height - 100);
        } else if (bodyFrame.equals("Medium")) {
            idealWeight = 0.95 * (height - 100);
        } else {
            idealWeight = 1.0 * (height - 100);
        }

        String result = "<html>Name: " + firstName + " " + lastName + "<br>";
        result += "Age: " + age + "<br>" + "BMI" + bmi + "<br>";
        if (maleButton.isSelected()) {
            result += "Sex: Male<br>";
        } else {
            result += "Sex: Female<br>";
        }
        result += "Height: " + height + " cm<br>";
        result += "Body Frame: " + bodyFrame + "<br>";
        result += "Weight Status: " + weightStatus + "<br>";
        result += "Ideal Weight: " + idealWeight + " kg</html>";
        resultLabel.setText(result);
    }

    public static void main(String[] args) {
        new WeightCalculator();
    }
}
