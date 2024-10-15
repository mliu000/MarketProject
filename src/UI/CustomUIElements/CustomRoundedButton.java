package UI.CustomUIElements;

import UI.ProgramConstants.UserInterfaceConstants;

import javax.swing.*;
import java.awt.*;

// Create a custom rounded button with border
// Rendering code borrowed online
public class CustomRoundedButton extends JButton implements PositionableAndSizeable {

    // Fields that store the size and position of the button relative to the size of the frame (will not change)
    // In the range [0, 1]
    private final double POS_X, POS_Y, POS_END_X, POS_END_Y;

    // The sharpness of the rounded button corners
    private int arcWidth, arcHeight;

    public CustomRoundedButton(String title, String fontName, int fontStyle, int fontSize,
                               double posX, double posY, double posEndX, double posEndY, Color color, boolean visible) {
        // Store the arc size, button size and position in case it needs to readjusted if the frame size changes
        super(title);
        this.POS_X = posX;
        this.POS_Y = posY;
        this.POS_END_X = posEndX;
        this.POS_END_Y = posEndY;

        // Initializes the size and position
        setSizeAndPos(UserInterfaceConstants.FRAME_WIDTH, UserInterfaceConstants.FRAME_HEIGHT);

        // Initializes the font style and color
        setFont(new Font(fontName, fontStyle, fontSize));
        setForeground(color);

        // Set the parameters for the custom button painting (borrowed online)
        setFocusPainted(false);
        setContentAreaFilled(false); // Make the button background transparent
        setBorderPainted(false); // Remove the default border
        setOpaque(false); // Make the button's background transparent
        setPreferredSize(new Dimension(150, 50)); // Default size, can be adjusted
        setVisible(visible);
    }

    // Paint the new button
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (getModel().isArmed()) {
            g2d.setColor(Color.LIGHT_GRAY); // Change color when pressed
        } else {
            g2d.setColor(getBackground()); // Use the button's background color
        }

        // Draw rounded rectangle
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

        super.paintComponent(g); // Paint the button text
    }

    // Paint the border of the new button
    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight); // Draw the border
    }

    // Sets the size and the position of the Button, also rescales it if the window size get dragged (changed)
    @Override
    public void setSizeAndPos(int frameWidth, int frameHeight) {
        // Sets the size and position
        setBounds((int) Math.round(frameWidth * this.POS_X),
                (int) Math.round(frameHeight * this.POS_Y),
                (int) Math.round(frameWidth * this.POS_END_X - frameWidth * this.POS_X),
                (int) Math.round(frameHeight * this.POS_END_Y - frameHeight * this.POS_Y));

        // Sets the arc size of the Button's corners
        this.arcWidth = (int) Math.round(0.04 * frameWidth);
        this.arcHeight = (int) Math.round(0.07 * frameHeight);
    }
}
