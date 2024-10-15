package UI.Windows;

import UI.CustomUIElements.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

/* A super class that holds the general provides a template for all the subclass JPanels, which
represent the individual panels.
 */
public abstract class WindowPanel extends JPanel {

    private final Image BACKGROUND_IMAGE;

    // Holds the instances labels that will be toggled during runtime, if applicable the subclass
    protected final List<CustomLabelWithPos> TOGGLEABLE_LABELS;

    // Constructor that loads the image and sets the mutual behaviour of all the windows
    public WindowPanel(String imagePath) {
        /* Load the background image, set the layout to null (use absolute positioning) and enable the component
        rescaler.
         */
        BACKGROUND_IMAGE = new ImageIcon(imagePath).getImage();
        TOGGLEABLE_LABELS = new ArrayList<>();
        addComponentRescaler();
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Render the graphics to a higher quality
        // Also borrowed from online
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (BACKGROUND_IMAGE != null) {
            g.drawImage(BACKGROUND_IMAGE, 0, 0, getWidth(), getHeight(), this);
        }
    }

    // Adds a component listener to rescale the elements relative to new frame size if it gets scaled
    private void addComponentRescaler() {
        this.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                int newWidth = getWidth();
                int newHeight = getHeight();

                // For loop that iterates over all scalable components on the JPanel and scales each one accordingly
                for (Component comp: getComponents()) {
                    if (comp instanceof PositionableAndSizeable) {
                        PositionableAndSizeable component = (PositionableAndSizeable) comp;
                        component.setSizeAndPos(newWidth, newHeight);
                    }
                }
            }
        });
    }

    protected void setTextFieldBlank() {
        for (Component comp: getComponents()) {
            if (comp instanceof Textable) {
                Textable textField = (Textable) comp;
                textField.setBlank();;
            }
        }
    }

    // Makes the labels that are toggleable at runtime invisible when you switch out of the window.
    protected void clearToggleableLabels() {
        for (CustomLabelWithPos label: TOGGLEABLE_LABELS) {
            label.setVisible(false);
        }
    }

    // Abstract methods that will be implemented by the subclasses (all windows will have buttons and labels)
    protected abstract void addButtons();
    protected abstract void addLabels();
    protected abstract void addLines();

}
