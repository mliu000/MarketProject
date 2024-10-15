package UI.CustomUIElements;

import UI.ProgramConstants.UserInterfaceConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

// Custom class that creates a line
// Some code was borrowed online
public class CustomLineWithPos extends JComponent implements PositionableAndSizeable {

    // Indicates the starting the ending positions of the line (given the x and y-axis), relative to frame size
    private final double POS_X, POS_Y, POS_END_X, POS_END_Y;
    private final Color LINE_COLOR;

    public CustomLineWithPos(double posX, double posY, double posEndX, double posEndY, Color color) {
        this.POS_X = posX;
        this.POS_Y = posY;
        this.POS_END_X = posEndX;
        this.POS_END_Y = posEndY;
        this.LINE_COLOR = color;
        setSizeAndPos(UserInterfaceConstants.FRAME_WIDTH, UserInterfaceConstants.FRAME_HEIGHT);
    }

    // Methods below are used to paint the custom line (the code was borrowed online)

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Enable anti-aliasing for smoother lines
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set the color for the line
        g2d.setColor(LINE_COLOR);

        // Draw the line using Line2D
        Line2D line = new Line2D.Double(
                getWidth() * POS_X,
                getHeight() * POS_Y,
                getWidth() * POS_END_X,
                getHeight() * POS_END_Y
        );
        g2d.draw(line);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 300); // Set a preferred size to make it visible
    }

    @Override
    public void setSizeAndPos(int frameWidth, int frameHeight) {
        // Sets the size and position
        setBounds((int) Math.round(frameWidth * this.POS_X),
                (int) Math.round(frameHeight * this.POS_Y),
                (int) Math.round(frameWidth * this.POS_END_X - frameWidth * this.POS_X),
                (int) Math.round(frameHeight * this.POS_END_Y - frameHeight * this.POS_Y));
    }
}
