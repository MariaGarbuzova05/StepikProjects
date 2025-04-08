import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.RoundRectangle2D;

public class Car extends JFrame {

    public Car() {
        setTitle("Автомобиль");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new CarPanel());

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Car());
    }

    private class CarPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Размеры и положение машины
            int carWidth = 350;
            int carHeight = 150;
            int startX = (getWidth() - carWidth) / 2;
            int startY = (getHeight() - carHeight) / 2;

            // Основной корпус машины
            Color carColor = new Color(231, 255, 28); // Ярко-желтый цвет

            // Контур машины с закруглёнными краями
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));

            // Нижняя часть
            int bodyHeight = 80;
            RoundRectangle2D body = new RoundRectangle2D.Double(
                    startX, startY + carHeight/4,
                    carWidth, bodyHeight,
                    50, 50
            );

            // Верхняя часть (купол)
            int roofWidth = carWidth / 2;
            int roofHeight = carHeight / 2 + 30;
            Arc2D roof = new Arc2D.Double(
                    startX + carWidth/4, startY - 30,
                    roofWidth, roofHeight + 30,
                    0, 180,
                    Arc2D.OPEN
            );

            // Заполняем кузов цветом
            g2d.setColor(carColor);
            g2d.fill(body);

            // Рисуем крышу
            g2d.fill(roof);

            // Рисуем контур
            g2d.setColor(Color.BLACK);
            g2d.draw(body);
            g2d.draw(roof);

            // Разделитель окон
            g2d.setStroke(new BasicStroke(2));
            g2d.drawLine(
                    startX + carWidth/2,
                    startY - 25,
                    startX + carWidth/2,
                    startY + carHeight/4 - 5
            );

            // Окна (левое и правое)
            g2d.setColor(Color.WHITE);

            int windowWidth = roofWidth/2 - 25;
            int windowHeight = roofHeight - 35;

            // Левое окно
            g2d.fillArc(
                    startX + carWidth/4 + 20,
                    startY - 5,
                    windowWidth,
                    windowHeight,
                    0, 180
            );

            // Правое окно
            g2d.fillArc(
                    startX + carWidth/2 + 10,
                    startY - 5,
                    windowWidth,
                    windowHeight,
                    0, 180
            );

            // Контуры окон
            g2d.setColor(Color.BLACK);
            g2d.drawArc(
                    startX + carWidth/4 + 20,
                    startY - 5,
                    windowWidth,
                    windowHeight,
                    0, 180
            );
            g2d.drawArc(
                    startX + carWidth/2 + 10,
                    startY - 5,
                    windowWidth,
                    windowHeight,
                    0, 180
            );
            // Ручка двери
            g2d.setColor(Color.BLACK);
            g2d.fillRect(
                    startX + carWidth/2 + 30,
                    startY + carHeight/2 - 15,
                    10, 5
            );
            // Фара
            int headlightWidth = 25;
            int headlightHeight = 20;
            g2d.setColor(Color.WHITE);
            g2d.fillOval(
                    startX + carWidth - headlightWidth - 10,
                    startY + carHeight/3 + 10,
                    headlightWidth,
                    headlightHeight
            );
            g2d.setColor(Color.BLACK);
            g2d.drawOval(
                    startX + carWidth - headlightWidth - 10,
                    startY + carHeight/3 + 10,
                    headlightWidth,
                    headlightHeight
            );

            // Колеса
            int wheelSize = 50;
            int wheelY = startY + carHeight/4 + bodyHeight - wheelSize/2 + 5;

            g2d.setColor(Color.BLACK);
            g2d.fillOval(
                    startX + 40,
                    wheelY,
                    wheelSize,
                    wheelSize
            );
            g2d.fillOval(
                    startX + carWidth - wheelSize - 40,
                    wheelY,
                    wheelSize,
                    wheelSize
            );

            g2d.setColor(Color.WHITE);
            int innerWheelSize = wheelSize / 3;

            g2d.fillOval(
                    startX + 40 + (wheelSize - innerWheelSize)/2,
                    wheelY + (wheelSize - innerWheelSize)/2,
                    innerWheelSize,
                    innerWheelSize
            );
            g2d.fillOval(
                    startX + carWidth - wheelSize - 40 + (wheelSize - innerWheelSize)/2,
                    wheelY + (wheelSize - innerWheelSize)/2,
                    innerWheelSize,
                    innerWheelSize
            );
            // Линия двери
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.drawLine(
                    startX + carWidth/2,
                    startY + carHeight/4,
                    startX + carWidth/2,
                    startY + carHeight/4 + bodyHeight
            );
        }
    }
}