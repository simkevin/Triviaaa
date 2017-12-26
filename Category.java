import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

public class Category {
    
    private final String NAME;
    private final LinkedList<Question> QUESTIONS;
    private boolean status;
    
    public Category(BufferedReader r) throws IOException {
        if (r == null) {
            throw new IllegalArgumentException();
        }
        
        NAME = r.readLine();
        QUESTIONS = new LinkedList<Question>();
        
        while(true) {
            String s = r.readLine();
            if (s.equals("next")) {
                break;
            }
            Question q = new Question(r);
            QUESTIONS.add(q);
        }
        status = true;
    }
    
    public String getName() {
        return NAME;
    }
    
    public LinkedList<Question> getQuestions() {
        return QUESTIONS;
    }
    
    public boolean getStatus() {
        return status;
    }
    
    public void flipStatus() {
        status = !status;
    }
}
