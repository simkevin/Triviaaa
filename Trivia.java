import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Trivia implements Runnable {

	private int score;
	private Category[] catArr;
	private Question[][] questArr;
	private JLabel totalPts;
	private boolean gameOver;

	public void run() {
		final JFrame frame = new JFrame("TRIVIAAA");
		frame.setLocation(0,0);
		
		Random r = null;
		try {
		r = new Random(new BufferedReader(new FileReader("TriviaText.txt")));
		}
		catch (Exception e) {
			throw new RuntimeException();
		}
		
		catArr = new Category[6];
		questArr = new Question[6][5];
		for (int i = 0; i < catArr.length; i++) {
			catArr[i] = r.getRandomCategory();
		}
		for(int i = 0; i < questArr.length; i++) {
			questArr[i] = r.getRandomQuestions(catArr[i]);
		}
		
		final JButton category1 = new JButton(catArr[0].getName());
		final JButton category2 = new JButton(catArr[1].getName());
		final JButton category3 = new JButton(catArr[2].getName());
		final JButton category4 = new JButton(catArr[3].getName());
		final JButton category5 = new JButton(catArr[4].getName());
		final JButton category6 = new JButton(catArr[5].getName());
	
		Container pane = frame.getContentPane();
	    pane.setLayout(new GridLayout(7, 6));
	    JPanel row1 = new JPanel();
	    JPanel row2 = new JPanel();
	    JPanel row3 = new JPanel();
	    JPanel row4 = new JPanel();
	    JPanel row5 = new JPanel();
	    JPanel row6 = new JPanel();
	    
	    gameOver = false;
		score = 0;
		totalPts = new JLabel("Current Score: " + score);
		JPanel points = new JPanel();
		points.add(totalPts);
	    
	    pane.add(row1);
	    pane.add(row2);
	    pane.add(row3);
	    pane.add(row4);
	    pane.add(row5);
	    pane.add(row6);
	    pane.add(points);
	    
	    row1.add(category1);
	    row2.add(category2);
	    row3.add(category3);
	    row4.add(category4);
	    row5.add(category5);
	    row6.add(category6);
	    
	    setupCategory(row1, 0);
	    setupCategory(row2, 1);
	    setupCategory(row3, 2);
	    setupCategory(row4, 3);
	    setupCategory(row5, 4);
	    setupCategory(row6, 5);

		frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	
	private void setupCategory(JPanel row, int r) {
	    for (int i = 0; i < 5; i++) {
	        int ptVal = (i + 1) * 100;
	        JButton question = createButton(ptVal, r, i);
            row.add(question);
	    }
	}
	
	private JButton createButton(final int qVal, final int x, final int y) {
	    JButton currBtn = new JButton("" + qVal);
	    currBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    currBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Question q = questArr[x][y];
                Object[] ans = questArr[x][y].getAnswers().toArray();
                Object x = JOptionPane.showInputDialog(null,
                        q.getQuestion(), "Input",
                        JOptionPane.INFORMATION_MESSAGE, null,
                        ans, ans[0]);
                Object y = null;
                if (q.getKey().equals("A")) {
                    y = ans[0];
                }
                else if (q.getKey().equals("B")) {
                    y = ans[1];
                }
                else if (q.getKey().equals("C")) {
                    y = ans[2];
                }
                else if (q.getKey().equals("D")) {
                    y = ans[3];
                }
                if (x == y) {
                    score += qVal;
                    totalPts.setText("Current Score: " + score);
                    JOptionPane.showMessageDialog(null, "CORRECT!");
                }
                else {
                    score -= qVal;
                    totalPts.setText("Current Score: " + score);
                    JOptionPane.showMessageDialog(null, "WRONG!");
                }
            }
        });
	    return currBtn;
	}
	
	public static void main(String[] args) throws IOException {
		SwingUtilities.invokeLater(new Trivia());
	}
}
