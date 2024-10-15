package UI.CustomUIElements;

import UI.ProgramConstants.UserInterfaceConstants;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

// A special class to represent the timer labels as they require extra constructing
public class CustomDateAndTimeLabel extends JLabel implements PositionableAndSizeable {

    /* The position of the label relative to the size of the frame
    Fields that store the size and position of the label relative to the size of the frame (will not change)
    In the range [0, 1]
     */
    private final double POS_X, POS_Y, POS_END_X, POS_END_Y;

    public CustomDateAndTimeLabel(String fontName, int fontStyle, int fontSize, double posX,
                                  double posY, double posEndX, double posEndY, int horAlign, int verAlign,
                                  String format, boolean visible) {
        // Record the format
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);

        // Set the position and alignment of the label;
        this.POS_X = posX;
        this.POS_Y = posY;
        this.POS_END_X = posEndX;
        this.POS_END_Y = posEndY;
        setFont(new Font(fontName, fontStyle, fontSize));
        setHorizontalAlignment(horAlign);
        setVerticalAlignment(verAlign);
        setSizeAndPos(UserInterfaceConstants.FRAME_WIDTH, UserInterfaceConstants.FRAME_HEIGHT);
        setVisible(visible);
        addDateComponent(dateFormat);
    }

    // Adds the date element to the label
    private void addDateComponent(SimpleDateFormat dateFormat) {
        String dateTimeString = dateFormat.format(new Date());
        setText(dateTimeString);

        // Create a Timer to update the JLabel every minute (60000 ms) (code borrowed online)
        Timer timer = new Timer(60000, e -> {
            String newDateTimeString = dateFormat.format(new Date());
            setText(newDateTimeString);
        });
        timer.start(); // Start the Timer
    }

    // Set the position and size of the label
    @Override
    public void setSizeAndPos(int frameWidth, int frameHeight) {
        // Sets the size and position
        setBounds((int) Math.round(frameWidth * this.POS_X),
                (int) Math.round(frameHeight * this.POS_Y),
                (int) Math.round(frameWidth * this.POS_END_X - frameWidth * this.POS_X),
                (int) Math.round(frameHeight * this.POS_END_Y - frameHeight * this.POS_Y));
    }
}