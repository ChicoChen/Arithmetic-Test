package ca.dal.Frames;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ChooseFrame extends JFrame implements ActionListener,KeyListener{
	
	// name label
	private JLabel nameL =  new JLabel("Name: ");
	// name text field
    private JTextField nameT = new JTextField(6);
    // types label
    private JLabel choiceL = new JLabel("Types: ");
    // contents to put into combo box
    private String []contents = {"Addition","Substraction","Multiplication","Division","Random"};
    // start button
    private JButton start = new JButton("Start");
    // difficulty label
    private JLabel indexL = new JLabel("Difficulty:");
    // difficulty text field
    private JTextField indexT =  new JTextField(6);
    // combo box
    private JComboBox comboBox = null;
    
    private JPanel top = new JPanel();
    private JPanel mid = new JPanel();
    private JPanel bottom = new JPanel();
    private JPanel fin = new JPanel();
    
    public ChooseFrame (){
        this.comboBox = new JComboBox(this.contents);
        this.indexT.setText("1");
        
        this.top.setLayout(new FlowLayout());
        this.mid.setLayout(new FlowLayout());
        this.bottom.setLayout(new FlowLayout());
        this.fin.setLayout(new FlowLayout());
        
        this.setTitle("Arithmetic Test");
        this.setSize(300, 200);
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.getContentPane().setLayout(new GridLayout(4,1));
        
        
        this.comboBox.setEditable(false);
        this.top.add(this.nameL);
        this.top.add(this.nameT);
        this.mid.add(this.choiceL);
        this.mid.add(this.comboBox);
        this.bottom.add(this.indexL);
        this.bottom.add(this.indexT);
        this.fin.add(this.start);
        
        this.add(this.top);
        this.add(this.mid);
        this.add(this.bottom);
        this.add(this.fin);
        this.start.addKeyListener(this);
        this.start.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == this.start){
            
            String nameOfFolder = this.nameT.getText();
            int arithmetic = this.comboBox.getSelectedIndex();//arithmetic kind
            int numberOfDigit = Integer.parseInt(this.indexT.getText());//number of digit
            
            new TestFrame(nameOfFolder,arithmetic,numberOfDigit).setVisible(true);
            this.setVisible(false);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            String nameOfFolder = this.nameT.getText();
            int arithmetic = this.comboBox.getSelectedIndex();//arithmetic kind
            int numberOfDigit = Integer.parseInt(this.indexT.getText());//number of digit
            
            new TestFrame(nameOfFolder,arithmetic,numberOfDigit).setVisible(true);
            this.setVisible(false);
        }
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}
