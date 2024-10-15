package UI;

// Launches the lobby (which is the start of my program
public class Launcher {
    public static void main(String[] args) {

        // Singleton layout
        UserInterFace window = UserInterFace.getInstance();
        window.toggleVisibility(true);


    }
}