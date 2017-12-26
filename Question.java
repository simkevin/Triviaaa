import java.io.*;
import java.util.*;

public class Question {
    
    private final String QUESTION;
    private final LinkedList<String> ANSWERS;
    private final String KEY;
    private boolean status;
    protected boolean clicked;
    
    public Question(BufferedReader r) throws IOException {
        if (r == null) {
            throw new IllegalArgumentException();
        }
        
        QUESTION = r.readLine();
        ANSWERS = new LinkedList<String>();
        String s = r.readLine();
        while(!s.isEmpty()) {
            ANSWERS.add(s);
            s = r.readLine();
        }
        KEY = r.readLine();
        status = true;
        clicked = false;
    }
    
    public String getQuestion() {
        return QUESTION;
    }
    
    public LinkedList<String> getAnswers() {
        return ANSWERS;
    }
    
    public String getKey() {
        return KEY;
    }
    
    public boolean getStatus() {
        return status;
    }
    
    public void flipStatus() {
        status = !status;
    }
    
    public void click() {
        clicked = !clicked;
    }
}
