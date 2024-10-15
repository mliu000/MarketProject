package UI;

import UI.ProgramConstants.UserInterfaceConstants;
import UI.Windows.Customer.CustomerSignInWindow;
import UI.Windows.General.LobbyWindow;
import UI.Windows.WindowPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

// Creates and manages all the window classes that will be part of the program (backbone class to the UI)
// Uses the singleton approach because no more than one instance of this class is needed.
public class UserInterFace extends JFrame {

    // Field that contains the only instance of this class (singleton)
    private static UserInterFace instance;

    /* ArrayList stores all the different windows that will be shown in the program
    The indices of each of the windows are:
    0: Lobby
    1: Customer Sign in
    2: Customer Main Menu
    3: Customer deposit/Extract balance
    4: Customer purchase item
    5: Customer return item
    6: Customer/Salesman/Admin change password
    7: Customer purchase history
    8: Salesman login
    9: Salesman main menu
    10: Salesman/Admin add item
    11: Salesman/Admin remove item
    12: Salesman/Admin make item on sale
    13: Salesman change password
    14: Admin manipulate customer account
    15: Stats
     */
    private final List<WindowPanel> WINDOW_PANEL_LIST;

    // Constructor that creates all the windows necessary for this program
    private UserInterFace() {
        // Initialize the frame and the list that will store the panels representing the windows.
        setSize(UserInterfaceConstants.FRAME_WIDTH, UserInterfaceConstants.FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Moo's Market");

        WINDOW_PANEL_LIST = new ArrayList<>();

        // Construct the foundation panels
        constructWindowPanels();

        // Set the first panel to be displayed (the lobby window)
        displayWindow(1);
    }

    // Constructs all the windows necessary for the program to run
    private void constructWindowPanels() {
        // Construct all the windows
        WindowPanel lobbyWindow = LobbyWindow.getInstance();
        CustomerSignInWindow customerSignInWindow = CustomerSignInWindow.getInstance();

        // Add
        WINDOW_PANEL_LIST.add(lobbyWindow);
        WINDOW_PANEL_LIST.add(customerSignInWindow);
    }

    // Displays the selected window, then returns it.
    public WindowPanel displayWindow(int index) {
        WindowPanel toDisplay = WINDOW_PANEL_LIST.get(index);

        setContentPane(toDisplay);
        revalidate();
        repaint();

        return toDisplay;
    }

    // Toggles the visibility of this JFrame to specified boolean value
    public void toggleVisibility(boolean visible) {
        this.setVisible(visible);
    }

    // The getter to this singleton class.
    public static UserInterFace getInstance() {
        if (instance == null) {
            instance = new UserInterFace();
        }
        return instance;
    }

}
