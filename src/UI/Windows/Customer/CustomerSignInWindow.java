package UI.Windows.Customer;

import UI.CustomUIElements.*;
import UI.ProgramConstants.UserInterfaceConstants;
import UI.UserInterFace;
import UI.Windows.WindowPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

// This window is split into 2 sides, the left side asks to create account, the right side asks to log in
// Also singleton
public class CustomerSignInWindow extends WindowPanel {

    // Holds the only instance of the class
    private static CustomerSignInWindow instance;

    // Constructs an instance of the window only if it hasn't been instantiated yet.
    private CustomerSignInWindow() {
        super(UserInterfaceConstants.MENU_IMAGE);
        addButtons();
        addLabels();
        addTextFields();
        addLines();
    }

    // Adds the buttons and their respective action listeners to the panel
    @Override
    protected void addButtons() {
        String fontName = "Verdana";

        // Create the buttons
        CustomRoundedButton backButton = new CustomRoundedButton("Back", fontName, 3, 20,
                0.15, 0.87, 0.25, 0.95, Color.BLACK, true);
        CustomRoundedButton createAccountButton = new CustomRoundedButton("Create Account", fontName, 3,
                30, 0.15, 0.75, 0.4, 0.83, Color.BLACK, true);
        CustomRoundedButton logInButton = new CustomRoundedButton("Log In", fontName, 3,
                30, 0.6, 0.75, 0.85, 0.83, Color.BLACK, true);

        // Add action listeners to the buttons using lambda expression
        backButton.addActionListener((ActionEvent e) -> {
            UserInterFace.getInstance().displayWindow(0);
            setTextFieldBlank();
            clearToggleableLabels();});
        createAccountButton.addActionListener((ActionEvent e) -> {
            CustomLabelWithPos errorLabel = TOGGLEABLE_LABELS.get(0);
            errorLabel.setVisible(true);
            errorLabel.setText("Username too short. Please try again.");
        });

        // Add them to panel
        add(backButton);
        add(createAccountButton);
        add(logInButton);

    }

    // Adds the labels to the panel
    @Override
    protected void addLabels() {
        String fontName = "Verdana";

        // Creates the time and date labels
        CustomDateAndTimeLabel dateAndTimeLabel = new CustomDateAndTimeLabel(fontName, 0, 20,
                0.75, 0.93, 0.99, 0.98,
                4, 3,"MM-dd-yyyy h:mm a", true);

        // Creates the header labels
        CustomLabelWithPos signInLabel = new CustomLabelWithPos("Customer Sign in", fontName, 1,
                70, 0, 0.02 , 1, 0.17,
                0, 0, Color.BLACK, true);
        CustomLabelWithPos createAccountLabel = new CustomLabelWithPos("Create Account", fontName, 1,
                50, 0.05, 0.15, 0.5, 0.35,
                0, 0, Color.BLACK, true);
        CustomLabelWithPos logInLabel = new CustomLabelWithPos("Log In", fontName, 1,
                50, 0.5, 0.2, 0.95, 0.4,
                0, 0, Color.BLACK, true);

        // Creates the prompt labels for both sign up and login
        CustomLabelWithPos createUsernameLabel = new CustomLabelWithPos("Create Username (>= 4 characters long)", fontName, 3,
                15, 0.11, 0.28, 0.45, 0.375,
                2, 3, Color.BLACK, true);
        CustomLabelWithPos createPasswordLabel = new CustomLabelWithPos("Create Password (>= 4 characters long)", fontName, 3,
                15, 0.11, 0.4, 0.45, 0.495,
                2, 3, Color.BLACK, true);
        CustomLabelWithPos confirmPasswordLabel = new CustomLabelWithPos("Confirm Password", fontName, 3,
                15, 0.11, 0.52, 0.45, 0.615,
                2, 3, Color.BLACK, true);
        CustomLabelWithPos enterUsernameLabel = new CustomLabelWithPos("Enter Username", fontName, 3,
                15, 0.56, 0.35, 0.9, 0.445,
                2, 3, Color.BLACK, true);
        CustomLabelWithPos enterPasswordLabel = new CustomLabelWithPos("Enter Password", fontName, 3,
                15, 0.56, 0.48, 0.9, 0.575,
                2, 3, Color.BLACK, true);

        // Creates the message labels that are initially invisible and are displayed during runtime.
        CustomLabelWithPos errorSignUpLabel = new CustomLabelWithPos("",
                fontName, 3, 15, 0.11, 0.695, 0.45, 0.79,
                2, 1, Color.RED, false);
        CustomLabelWithPos errorLogInLabel = new CustomLabelWithPos("",
                fontName, 3, 15, 0.11, 0.655, 0.45, 0.75,
                2, 1, Color.RED, false);

        TOGGLEABLE_LABELS.add(errorSignUpLabel);
        TOGGLEABLE_LABELS.add(errorLogInLabel);

        // Adds them to the panel
        add(dateAndTimeLabel);
        add(signInLabel);
        add(createAccountLabel);
        add(logInLabel);
        add(createUsernameLabel);
        add(createPasswordLabel);
        add(confirmPasswordLabel);
        add(enterUsernameLabel);
        add(enterPasswordLabel);
        add(errorSignUpLabel);
        add(errorLogInLabel);
    }

    private void addTextFields() {
        String fontName = "Verdana";

        // Creates the text fields for both sign up and login (some are password fields)
        CustomRoundedTextField createUsername = new CustomRoundedTextField(fontName, 0, 20,
                0.1, 0.38, 0.45, 0.45, 2, Color.BLACK, true);
        CustomRoundedPasswordField createPassword = new CustomRoundedPasswordField(fontName, 0, 20,
                0.1, 0.5, 0.45, 0.57, 2, Color.BLACK, true);
        CustomRoundedPasswordField confirmPassword = new CustomRoundedPasswordField(fontName, 0, 20,
                0.1, 0.62, 0.45, 0.69, 2, Color.BLACK, true);
        CustomRoundedTextField enterUsername = new CustomRoundedTextField(fontName, 0, 20,
                0.55, 0.45, 0.9, 0.52, 2, Color.BLACK, true);
        CustomRoundedPasswordField enterPassword = new CustomRoundedPasswordField(fontName, 0, 20,
                0.55, 0.58, 0.9, 0.65, 2, Color.BLACK, true);

        // Adds them to panel
        add(createUsername);
        add(createPassword);
        add(confirmPassword);
        add(enterUsername);
        add(enterPassword);

    }

    // Add the lines to the panel for better aesthetics
    @Override
    protected void addLines() {

        CustomLineWithPos line = new CustomLineWithPos(0, 0.02, 0.6, 0.02, Color.BLACK);
        add(line);
    }

    // Gets the instance of the class
    public static CustomerSignInWindow getInstance() {
        if (instance == null) {
            instance = new CustomerSignInWindow();
        }
        return instance;
    }
}
