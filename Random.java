import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class Random {
    
    private final Category hist;
    private final Category cine;
    private final Category sci;
    private final Category lit;
    private final Category food;
    private final Category music;
    private final Category USpres;
    private final Category tv;
    private final Category intrNat;
    private final Category popC;
    private final Category cities;
    private final Category misc;
    private final HashMap<Integer, Category> CATEGORIES;
    
    public Random(BufferedReader r) throws IOException {
        r.readLine();
        hist = new Category(r);
        cine = new Category(r);
        sci = new Category(r);
        lit = new Category(r);
        food = new Category(r);
        music = new Category(r);
        USpres = new Category(r);
        tv = new Category(r);
        intrNat = new Category(r);
        popC = new Category(r);
        cities = new Category(r);
        misc = new Category(r);
        CATEGORIES = new HashMap<Integer, Category>();
        
        CATEGORIES.put(0, hist);
        CATEGORIES.put(1, cine);
        CATEGORIES.put(2, sci);
        CATEGORIES.put(3, lit);
        CATEGORIES.put(4, food);
        CATEGORIES.put(5, music);
        CATEGORIES.put(6, USpres);
        CATEGORIES.put(7, tv);
        CATEGORIES.put(8, intrNat);
        CATEGORIES.put(9, popC);
        CATEGORIES.put(10, cities);
        CATEGORIES.put(11, misc);
    }
    
    public Category getRandomCategory() {
        int x = (int) (Math.random() * 12);
        Category c = CATEGORIES.get(x);
        if (!c.getStatus()) {
            return getRandomCategory();
        }
        else {
            c.flipStatus();
            return c;
        }
    }
    
    public Question[] getRandomQuestions(Category c) {
        Question[] questions = new Question[5];
        for(int i = 0; i < 5; i++) {
            int x = (int) (Math.random() * 20);
            Question q = c.getQuestions().get(x);
            if (!q.getStatus()) {
                i--;
            }
            else {
                questions[i] = q;
                q.flipStatus();
            }
        }
        return questions;
    }
}
