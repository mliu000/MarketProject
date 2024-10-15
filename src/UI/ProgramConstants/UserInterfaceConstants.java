package UI.ProgramConstants;

import java.awt.*;

// Holds the constants, which include the size and background images used for this program
public enum UserInterfaceConstants {;

    // Gets the screen size for the frame, so it can start as full screen on all monitor resolutions
    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

    public static final int FRAME_WIDTH = 1280;
    public static final int FRAME_HEIGHT = 720;

    public static final String LOBBY_IMAGE = "./images/java background v1.png";
    public static final String MENU_IMAGE = "./images/java background v2.png";
}
