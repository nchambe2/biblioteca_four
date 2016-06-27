import java.io.BufferedReader;
import java.io.IOException;

public class Input {
    private BufferedReader bufferedReader;

    public Input(BufferedReader bufferedReader) {

        this.bufferedReader = bufferedReader;
    }

    public String getUserInput() {
        String optionSelected = "";
        try {
            optionSelected = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  optionSelected;
    }
}
