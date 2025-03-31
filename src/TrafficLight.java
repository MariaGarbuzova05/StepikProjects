import javax.swing.*;
import java.awt.*;

public class TrafficLight extends JFrame {

    public TrafficLight() {
        super("Traffic Light");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);
        setLocationRelativeTo(null);
        add(new TrafficLightPanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TrafficLight::new);
    }

    static class TrafficLightPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Traffic Light Body
            g2d.setColor(Color.DARK_GRAY);
            g2d.fillRoundRect(50, 50, 150, 350, 50, 50); // x, y, width, height, arcWidth, arcHeight

            // Light Bezels
            int lightDiameter = 80;
            int lightSpacing = 100;

            // Red Light
            g2d.setColor(Color.RED);
            g2d.fillOval(85, 80, lightDiameter, lightDiameter);
            g2d.setColor(Color.BLACK); // Black Bezels, to resemble the picture
            g2d.fillRect(15, 75, 35, 35);
            g2d.fillRect(200, 75, 35, 35);

            // Yellow Light
            g2d.setColor(Color.YELLOW);
            g2d.fillOval(85, 80 + lightSpacing, lightDiameter, lightDiameter);
            g2d.setColor(Color.BLACK); // Black Bezels, to resemble the picture
            g2d.fillRect(15, 175, 35, 35);
            g2d.fillRect(200, 175, 35, 35);

            // Green Light
            g2d.setColor(Color.GREEN);
            g2d.fillOval(85, 80 + 2 * lightSpacing, lightDiameter, lightDiameter);
            g2d.setColor(Color.BLACK); // Black Bezels, to resemble the picture
            g2d.fillRect(15, 275, 35, 35);
            g2d.fillRect(200, 275, 35, 35);

            // Pole (Stand)
            g2d.setColor(Color.DARK_GRAY);
            g2d.fillRect(95, 400, 60, 50);
        }
    }
}