import javax.swing.*;
import java.awt.*;

public class Snowman extends JFrame {

    public Snowman() {
        super("Snowman");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 600);
        setLocationRelativeTo(null);
        add(new SnowmanPanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Snowman::new);
    }

    static class SnowmanPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Snowman Body

            // Bottom Circle
            g2d.setColor(Color.WHITE);
            g2d.fillOval(100, 350, 220, 200);
            g2d.setColor(Color.BLACK);
            g2d.drawOval(100, 350, 220, 200); // Draw outline


            // Middle Circle
            g2d.setColor(Color.WHITE);
            g2d.fillOval(125, 230, 170, 150);
            g2d.setColor(Color.BLACK);
            g2d.drawOval(125, 230, 170, 150);


            // Head Circle
            g2d.setColor(Color.WHITE);
            g2d.fillOval(150, 150, 110, 100);
            g2d.setColor(Color.BLACK);
            g2d.drawOval(150, 150, 110, 100);

            // Hat
            g2d.setColor(Color.WHITE);
            g2d.fillRect(145, 130, 120, 40); // Top of the hat
            g2d.fillRect(165, 100, 80, 30); // Body of the hat
            g2d.setColor(Color.BLACK);
            g2d.drawRect(145, 130, 120, 40); // Top of the hat
            g2d.drawRect(165, 100, 80, 30); // Body of the hat


            // Eyes
            g2d.drawOval(190, 185, 10, 10);
            g2d.drawOval(220, 185, 10, 10);

            // Nose
            g2d.setColor(Color.WHITE);
            g2d.fillPolygon(new int[]{205, 205, 275}, new int[]{200, 210, 205}, 3);
            g2d.setColor(Color.BLACK); // Or use a suitable color for the nose
            g2d.drawPolygon(new int[]{205, 205, 275}, new int[]{200, 210, 205}, 3); // Simple triangle

            // Mouth
            g2d.setColor(Color.BLACK);
            g2d.drawOval(190, 220, 8, 8);
            g2d.drawOval(200, 225, 8, 8);
            g2d.drawOval(210, 225, 8, 8);
            g2d.drawOval(220, 220, 8, 8);

            // Buttons
            g2d.drawOval(215, 280, 8, 8);
            g2d.drawOval(215, 300, 8, 8);
            g2d.drawOval(215, 320, 8, 8);

            // Arms
            g2d.setStroke(new BasicStroke(5)); // Set a thicker stroke for the arms
            g2d.drawLine(60, 250, 135, 290);  // Left arm
            g2d.drawLine(295, 290, 370, 250); // Right arm

            // Fingers (Left)
            g2d.drawLine(60, 250, 60, 240);
            g2d.drawLine(60, 250, 50, 260);
            g2d.drawLine(60, 250, 50, 240);

            // Fingers (Right)
            g2d.drawLine(370, 250, 370, 240);
            g2d.drawLine(370, 250, 380, 260);
            g2d.drawLine(370, 250, 380, 240);


        }
    }
}