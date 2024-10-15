package UI.Windows.General;

import UI.CustomUIElements.CustomLabelWithPos;
import UI.CustomUIElements.CustomLineWithPos;
import UI.CustomUIElements.CustomRoundedButton;
import UI.CustomUIElements.CustomDateAndTimeLabel;
import UI.ProgramConstants.UserInterfaceConstants;
import UI.UserInterFace;
import UI.Windows.Customer.CustomerSignInWindow;
import UI.Windows.WindowPanel;

import java.awt.*;
import java.awt.event.ActionEvent;

// Singleton class creates the lobby window of the User Interface (only one instance of this class should be present)
public class LobbyWindow extends WindowPanel {

    // The field that holds the instance of the class
    private static LobbyWindow instance;

    // Construct a JPanel with a background image based on the constructor of its immediate superclass
    private LobbyWindow() {
        super(UserInterfaceConstants.LOBBY_IMAGE);
        addButtons();
        addLabels();
    }

    // Creates and adds the buttons to the panel
    @Override
    protected void addButtons() {
        // Helpful local variables for creating the buttons
        int fontSize = 30;
        String fontName = "Verdana";

        // Add the buttons itself
        CustomRoundedButton adminButton = new CustomRoundedButton("Administrator", fontName, 3, fontSize,
                0.5, 0.8,  0.95, 0.95, Color.BLACK, true);
        CustomRoundedButton salesmanButton = new CustomRoundedButton("Salesman", fontName, 3, fontSize,
                0.5, 0.6,  0.95, 0.75, Color.BLACK, true);
        CustomRoundedButton customerButton = new CustomRoundedButton("Customer", fontName, 3, fontSize,
                0.5, 0.4,  0.95, 0.55, Color.BLACK, true);
        CustomRoundedButton exitButton = new CustomRoundedButton("Exit", fontName, 3, 20,
                0.35, 0.53,  0.47, 0.65, Color.RED, true);

        // Set the actions for each button (Using Lambda expression)
        customerButton.addActionListener((ActionEvent e) -> UserInterFace.getInstance().displayWindow(1));
        exitButton.addActionListener((ActionEvent e) -> System.exit(0));

        // Adds all the elements to the panel
        add(adminButton);
        add(salesmanButton);
        add(customerButton);
        add(exitButton);
    }

    // Creates and adds the labels to the panel
    @Override
    protected void addLabels() {
        // Helpful local variables for creating the labels
        String fontName = "Verdana";

        // Create the labels
        CustomLabelWithPos welcomeLabel = new CustomLabelWithPos("Welcome!!!", fontName, 1, 70,
                0, 0.12, 0.5, 0.3, 0, 0, Color.BLACK, true);
        CustomLabelWithPos commandLabel = new CustomLabelWithPos("Choose To Proceed As...", fontName, 1,
                30, 0.5, 0.3, 0.95, 0.9,
                2, 1, Color.BLACK, true);
        CustomLabelWithPos todayIsLabel = new CustomLabelWithPos("Today is:", fontName, 3, 40,
                0.55, 0.05, 0.95, 0.15, 2, 3, Color.BLACK, true);
        CustomDateAndTimeLabel timerLabel = new CustomDateAndTimeLabel(fontName, 0, 40,
                0.55, 0.15, 1, 0.35,
                2, 1, "E MMM dd h:mm a", true);

        // Add the labels to the panel
        add(welcomeLabel);
        add(commandLabel);
        add(todayIsLabel);
        add(timerLabel);
    }

    // Creates and adds the lines to the panel
    @Override
    protected void addLines() {
        CustomLineWithPos welcomeLine = new CustomLineWithPos(0.2, 0.3,
                0.5, 0.3, Color.BLACK);

        add(welcomeLine);
    }

    // The getter method for this singleton class
    public static LobbyWindow getInstance() {
        if (instance == null) {
            instance = new LobbyWindow();
        }
        return instance;
    }
}
