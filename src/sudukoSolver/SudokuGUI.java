package sudukoSolver;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class SudokuGUI extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 18658658L;
protected static int[][] entryData;
	public SudokuGUI() {
entryData=new int[9][9];
		initUI();

	}

	private void initUI() {
		

		Font font = new Font("Courier", Font.BOLD, 40);

		setFont(font);

		JPanel top = new JPanel();
		top.setLayout(new FlowLayout());
		top.setPreferredSize(new Dimension(0, 100));
		top.setAlignmentX(CENTER_ALIGNMENT);
		top.setAlignmentY(CENTER_ALIGNMENT);
		Button b = new Button("solve");
		top.add(b);
		b.setFont(font);
		top.add(new Button("fs"));
		
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(9, 9));
	
		Insets in = new Insets(0, 35, 0, 0);
		for (int i = 0; i < 81; i++) {
			JTextField a = new JTextField();
			
			a.setFont(font);
			a.setMargin(in);
			a.setBackground(Color.GREEN);
			grid.add(a);
			
		}
		JPanel q=new JPanel();
		JPanel p=new JPanel();
		setLayout(new BorderLayout());
		q.setPreferredSize(new Dimension(0, 100));
		p.setPreferredSize(new Dimension(100, 10));
		add(top, BorderLayout.NORTH);
		add(grid, BorderLayout.CENTER);
		add(q,BorderLayout.SOUTH);
		add(p, BorderLayout.EAST);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
