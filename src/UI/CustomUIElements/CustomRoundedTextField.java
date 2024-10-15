package UI.CustomUIElements;

import UI.ProgramConstants.UserInterfaceConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

// Class that constructs a rounded text field
public class CustomRoundedTextField extends JTextField implements PositionableAndSizeable, Textable {

    // Stores the position, size (fixed) and the size of the curvature of the corners
    private final double POS_X, POS_Y, POS_END_X, POS_END_Y;
    private int arcWidth, arcHeight;

    public CustomRoundedTextField(String fontName, int fontStyle, int fontSize,
                                  double posX, double posY, double posEndX, double posEndY, int horAlign,
                                  Color color, boolean visible) {
        // Initialize the basic features of the text field
        this.POS_X = posX;
        this.POS_Y = posY;
        this.POS_END_X = posEndX;
        this.POS_END_Y = posEndY;

        setFont(new Font(fontName, fontStyle, fontSize));
        setHorizontalAlignment(horAlign);
        setSizeAndPos(UserInterfaceConstants.FRAME_WIDTH, UserInterfaceConstants.FRAME_HEIGHT);
        setOpaque(false); // Make background transparent
        setForeground(color);
        setVisible(visible);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Paint rounded background
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight);

        // Paint the text field's text
        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Paint rounded border
        g2.setColor(Color.GRAY); // Set your preferred border color
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight);

        g2.dispose();
    }

    @Override
    public boolean contains(int x, int y) {
        // Check if the point is inside the rounded rectangle
        Shape shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight);
        return shape.contains(x, y);
    }

    // Sets the size (as well as resizes) the text field.
    @Override
    public void setSizeAndPos(int frameWidth, int frameHeight) {
        // Sets the size and position
        setBounds((int) Math.round(frameWidth * this.POS_X),
                (int) Math.round(frameHeight * this.POS_Y),
                (int) Math.round(frameWidth * this.POS_END_X - frameWidth * this.POS_X),
                (int) Math.round(frameHeight * this.POS_END_Y - frameHeight * this.POS_Y));

        // Sets the arc size of the Button's corners
        this.arcWidth = (int) Math.round(0.02 * frameWidth);
        this.arcHeight = (int) Math.round(0.03 * frameHeight);
    }

    // Sets the text to blank
    @Override
    public void setBlank() {
        setText("");
    }
}
