package ca.dal.Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ca.dal.types.Addition;
import ca.dal.types.Division;
import ca.dal.types.Multiplication;
import ca.dal.types.Operation;
import ca.dal.types.Substraction;

public class TestFrame extends JFrame implements ActionListener, KeyListener {

	private JPanel quesPanel = new JPanel();
    private JLabel queHeader = new JLabel("Questions");
    private JLabel userAnsHeader = new JLabel("Your Answers");
    private JLabel userRemainHeader = new JLabel("Your Remainders");
    private JLabel []question = new JLabel[10];//10 questions in total
    private JTextField []ans = new JTextField[10];// 10 answers in total
    private JTextField []remainders = new JTextField[10];//10 remainders in total
    
    private JButton confirm = new JButton("Submit!");//confirm button
    private Vector<Operation> que = new Vector<Operation>();
    private String nameOfFolder;
    /**
     *default constructor method
     */
    public TestFrame(){
        this("NULL",0,1);
    }
    /**
     * constructor method
     * @param kind transfer different kind of test
     */
    public TestFrame(String nameOfFolder,int arithmetic,int numberOfDigit){
        
        this.setTitle("Arithmetic Test");
        this.setSize(300, 400);
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /**
         * ari
         * 1 +
         * 2 -
         * 3 *
         * 4 /
         * 5 random
         */
        int ari = arithmetic+1;
        int i;
        this.nameOfFolder = nameOfFolder;
        for(i = 0; i < 10; i++)
        {
            if(arithmetic == 4)
            {
                ari = (int)(Math.random()*4)+1;
            }
            if(ari == 1)
            {
                que.add(new Addition(ari,numberOfDigit));
            }
            if(ari == 2)
            {
                que.add(new Substraction(ari, numberOfDigit));
            }
            if(ari == 3)
            {
                que.add(new Multiplication(ari, numberOfDigit));
            }
            if(ari == 4)
            {
                que.add(new Division(ari, numberOfDigit));
            }
        }
        
        for(i = 0; i < this.question.length; i++){
            this.question[i] = new JLabel();
            this.question[i].setText(Integer.toString(i+1)+").  "+ this.que.elementAt(i).getQueInString());
        }
        
        this.quesPanel.setLayout(new GridLayout(11,3));
        this.quesPanel.add(this.queHeader);
        this.quesPanel.add(this.userAnsHeader);
        this.quesPanel.add(this.userRemainHeader);
        
        for(i = 0; i < this.question.length; i++){
            this.quesPanel.add(this.question[i]);
            this.ans[i] = new JTextField(5);
            this.remainders[i] = new JTextField(3);
            this.quesPanel.add(this.ans[i]);
            this.quesPanel.add(this.remainders[i]);
            if(this.que.elementAt(i).getOperationalSymbol() != 4){
                this.remainders[i].setEditable(false);
            }
            this.ans[i].addActionListener(this);
            this.remainders[i].addActionListener(this);
        }
        this.getContentPane().add(this.quesPanel,BorderLayout.CENTER);
        this.getContentPane().add(this.confirm, BorderLayout.SOUTH);
        
        this.confirm.addActionListener(this);
        this.confirm.addKeyListener(this);
        this.pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == this.ans[0]){
            if(this.remainders[0].isEditable()){
                this.remainders[0].requestFocus();
            } else {
                this.ans[1].requestFocus();
            }
        }
        if(e.getSource() == this.remainders[0]){
            this.ans[1].requestFocus();
        }
        if(e.getSource() == this.ans[1]){
            if(this.remainders[1].isEditable()){
                this.remainders[1].requestFocus();
            } else {
                this.ans[2].requestFocus();
            }
        }
        if(e.getSource() == this.remainders[1]){
            this.ans[2].requestFocus();
        }
        if(e.getSource() == this.ans[2]){
            if(this.remainders[2].isEditable()){
                this.remainders[2].requestFocus();
            } else {
                this.ans[3].requestFocus();
            }
        }
        if(e.getSource() == this.remainders[2]){
            this.ans[3].requestFocus();
        }
        if(e.getSource() == this.ans[3]){
            if(this.remainders[3].isEditable()){
                this.remainders[3].requestFocus();
            } else {
                this.ans[4].requestFocus();
            }
        }
        if(e.getSource() == this.remainders[3]){
            this.ans[4].requestFocus();
        }
        if(e.getSource() == this.ans[4]){
            if(this.remainders[4].isEditable()){
                this.remainders[4].requestFocus();
            } else {
                this.ans[5].requestFocus();
            }
        }
        if(e.getSource() == this.remainders[4]){
            this.ans[5].requestFocus();
        }
        if(e.getSource() == this.ans[5]){
            if(this.remainders[5].isEditable()){
                this.remainders[5].requestFocus();
            } else {
                this.ans[6].requestFocus();
            }
        }
        if(e.getSource() == this.remainders[5]){
            this.ans[6].requestFocus();
        }
        if(e.getSource() == this.ans[6]){
            if(this.remainders[6].isEditable()){
                this.remainders[6].requestFocus();
            } else {
                this.ans[7].requestFocus();
            }
        }
        if(e.getSource() == this.remainders[6]){
            this.ans[7].requestFocus();
        }
        if(e.getSource() == this.ans[7]){
            if(this.remainders[7].isEditable()){
                this.remainders[7].requestFocus();
            } else {
                this.ans[8].requestFocus();
            }
        }
        if(e.getSource() == this.remainders[7]){
            this.ans[8].requestFocus();
        }
        if(e.getSource() == this.ans[8]){
            if(this.remainders[8].isEditable()){
                this.remainders[8].requestFocus();
            } else {
                this.ans[9].requestFocus();
            }
        }
        if(e.getSource() == this.remainders[8]){
            this.ans[9].requestFocus();
        }
        if(e.getSource() == this.ans[9]){
            if(this.remainders[9].isEditable()){
                this.remainders[9].requestFocus();
            } else {
                this.confirm.requestFocus();
            }
        }
        if(e.getSource() == this.remainders[9]){
            this.confirm.requestFocus();
        }
        if(e.getSource() == this.confirm){
            for(int i = 0; i < 10; i++){
                if(!ans[i].getText().equals("")){
                    this.que.elementAt(i).setUserResult1(Integer.parseInt((ans[i].getText())));
                } else {
                    this.que.elementAt(i).setUserResult1(-1);
                }
                if(this.que.elementAt(i).getOperationalSymbol() == 4){
                    if(!remainders[i].getText().equals("")){
                        this.que.elementAt(i).setUserResult2(Integer.parseInt((this.remainders[i].getText())));
                    } else {
                        this.que.elementAt(i).setUserResult2(-1);
                    }
                }
            }
            this.setVisible(false);
            try {
                new ResultFrame(this.nameOfFolder,this.que,this);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            for(int i = 0; i < 10; i++){
                if(!ans[i].getText().equals("")){
                    this.que.elementAt(i).setUserResult1(Integer.parseInt((ans[i].getText())));
                } else {
                    this.que.elementAt(i).setUserResult1(-1);
                }
            }
            this.setVisible(false);
            try {
                new ResultFrame(this.nameOfFolder,this.que,this);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

}
