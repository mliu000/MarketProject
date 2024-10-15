package UI.CustomUIElements;

import UI.ProgramConstants.UserInterfaceConstants;

import javax.swing.*;
import java.awt.*;

// Class that is the same as JLabel except it has position and size relative to the size of frame
public class CustomLabelWithPos extends JLabel implements PositionableAndSizeable {

    /* The position of the label relative to the size of the frame
    Fields that store the size and position of the label relative to the size of the frame (will not change)
    In the range [0, 1]
     */
    private final double POS_X, POS_Y, POS_END_X, POS_END_Y;

    public CustomLabelWithPos(String title, String fontName, int fontStyle, int fontSize,
                              double posX, double posY, double posEndX, double posEndY, int horAlign, int verAlign,
                              Color color, boolean visible) {
        super(title);

        // records the position
        this.POS_X = posX;
        this.POS_Y = posY;
        this.POS_END_X = posEndX;
        this.POS_END_Y = posEndY;

        // Sets the size, position and font
        setSizeAndPos(UserInterfaceConstants.FRAME_WIDTH, UserInterfaceConstants.FRAME_HEIGHT);
        setFont(new Font(fontName, fontStyle, fontSize));
        setHorizontalAlignment(horAlign);
        setVerticalAlignment(verAlign);
        setForeground(color);
        setVisible(visible);
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