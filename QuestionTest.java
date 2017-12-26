import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.junit.Test;

public class QuestionTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void testQuestionNull() throws IOException {
        Question q = new Question(null);
    }
    
    @Test
    public void testGetQuestionOne() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("TestTxt.txt"));
        r.readLine();
        r.readLine();
        
        Question q = new Question(r);
        String s = "A 1998 study suggests that which of the following explorers "
                + "reached the North Pole?";
      
        assertTrue(s.equals(q.getQuestion()));
    }

    @Test
    public void testGetQuestionMultiple() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("TestTxt.txt"));
        r.readLine();
        r.readLine();
        
        Question q1 = new Question(r);
        r.readLine(); 
        Question q2 = new Question(r);
        r.readLine(); 
        Question q3 = new Question(r);
        
        String s1 = "A 1998 study suggests that which of the following explorers "
                + "reached the North Pole?";
        String s2 = "History students are taught about the \"the fall of "
                + "Constantinople\" in 1453. to who did it fall?";
        String s3 = "Catherine the Great ruled what country?";
        
        assertTrue(s1.equals(q1.getQuestion()));
        assertTrue(s2.equals(q2.getQuestion()));
        assertTrue(s3.equals(q3.getQuestion()));
    }
    
    @Test
    public void testGetAnswersOne() throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("TestTxt.txt"));
        r.readLine();
        r.readLine();
        
        Question q = new Question(r);
        LinkedList<String> ans = q.getAnswers();
        LinkedList<String> expected = new LinkedList<String>();
        expected.add("A. Roald Amundsen");
        expected.add("B. Robert E. Peary");
        expected.add("C. William Barents");
        expected.add("D. Adam Sound");
        
        assertTrue(ans.equals(expected));
    }
    
    @Test
    public void testGetAnswersMultiple() throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("TestTxt.txt"));
        r.readLine();
        r.readLine();
        
        Question q1 = new Question(r);
        r.readLine();
        Question q2 = new Question(r);
        
        LinkedList<String> l1 = q1.getAnswers();
        LinkedList<String> l2 = q2.getAnswers();
        LinkedList<String> expected1 = new LinkedList<String>();
        expected1.add("A. Roald Amundsen");
        expected1.add("B. Robert E. Peary");
        expected1.add("C. William Barents");
        expected1.add("D. Adam Sound"); 
        LinkedList<String> expected2 = new LinkedList<String>();
        expected2.add("A. Christian crusaders");
        expected2.add("B. Mongol hordes");
        expected2.add("C. Ottoman Turks");
        expected2.add("D. Romans");
        
        assertTrue(l1.equals(expected1));
        assertTrue(l2.equals(expected2));
    }
    
    @Test
    public void testKeyOne() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("TestTxt.txt"));
        r.readLine();
        r.readLine();
        
        Question q = new Question(r);
        String key = "B";
        
        assertTrue(key.equals(q.getKey()));
    }
    
    @Test
    public void testKeyMultiple() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("TestTxt.txt"));
        r.readLine();
        r.readLine();
        
        Question q1 = new Question(r);
        r.readLine();
        Question q2 = new Question(r);
        r.readLine();
        Question q3 = new Question(r);
        
        String k1 = "B";
        String k2 = "C";
        String k3 = "D";
        
        assertTrue(k1.equals(q1.getKey()));
        assertTrue(k2.equals(q2.getKey()));
        assertTrue(k3.equals(q3.getKey()));
    }
    
    @Test
    public void testGetStatus() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("TestTxt.txt"));
        r.readLine();
        r.readLine();
        
        Question q = new Question(r);
        
        assertTrue(q.getStatus());
    }
    
    @Test
    public void testFlipStatus() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("TestTxt.txt"));
        r.readLine();
        r.readLine();
        
        Question q = new Question(r);
        q.flipStatus();
        
        assertFalse(q.getStatus());
    }
    
    @Test
    public void testClick() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("TestTxt.txt"));
        r.readLine();
        r.readLine();
        
        Question q = new Question(r);
        q.click();
        
        assertTrue(q.clicked);
    }
}
