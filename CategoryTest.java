import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.junit.Test;

public class CategoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCategoryNull() throws IOException {
        Category c = new Category(null);
    }
    
    @Test
    public void testNameOne() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("TestTxt.txt"));
        Category history = new Category(r);
        assertTrue("History".equals(history.getName()));
    }
    
    @Test
    public void testNameMultiple() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("TestTxt.txt"));
        Category history = new Category(r);
        Category movies = new Category(r);
        Category science = new Category(r);
        
        assertTrue("History".equals(history.getName()));
        assertTrue("Movies".equals(movies.getName()));
        assertTrue("Science".equals(science.getName()));
    }
    
    @Test
    public void testGetQuestionsOne() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("TestTxt.txt"));
        Category history = new Category(r);
        LinkedList<Question> l = history.getQuestions();
        String first = "A 1998 study suggests that which of the following explorers "
                + "reached the North Pole?";
        String last = "Namibia became a colony of what European nation in 1890, "
                + "under the name South-West Africa?";
        assertEquals(20, l.size());
        assertTrue(first.equals(l.getFirst().getQuestion()));
        assertTrue(last.equals(l.getLast().getQuestion()));
    }
    
    @Test
    public void testGetQuestionsMultiple() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("TestTxt.txt"));
        Category history = new Category(r);
        Category movies = new Category(r);
        Category science = new Category(r);
        
        LinkedList<Question> l1 = history.getQuestions();
        LinkedList<Question> l2 = movies.getQuestions();
        LinkedList<Question> l3 = science.getQuestions();
        
        String s1 = "Namibia became a colony of what European nation in 1890, "
                + "under the name South-West Africa?";
        String s2 = "Julie Andrews won the Academy Award for  best actress in what film?";
        String s3 = "Louis Pasteur developed which vaccine?";
        
        assertEquals(20, l1.size());
        assertEquals(20, l2.size());
        assertEquals(20, l3.size());
        assertEquals(s1, l1.getLast().getQuestion());
        assertEquals(s2, l2.getLast().getQuestion());
        assertEquals(s3, l3.getLast().getQuestion());
    }
    
    @Test
    public void testGetStatus() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("TestTxt.txt"));
        Category c = new Category(r);
        assertTrue(c.getStatus());
    }
    
    @Test
    public void testFlipStatus() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("TestTxt.txt"));
        Category c = new Category(r);
        c.flipStatus();
        assertFalse(c.getStatus());
    }
}
