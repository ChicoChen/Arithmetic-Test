package ca.dal.Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ca.dal.types.Operation;

public class ResultFrame extends JFrame implements ActionListener {
    
    private String nameOfFolder;
    private double rightAnswers;
    
    private JPanel Top = new JPanel();
    private JLabel queHeader = new JLabel("Questions");
    private JLabel userAnsHeader = new JLabel("Your Answers");
    private JLabel userRemainHeader = new JLabel("Your Remainders");
    private JLabel rightAnsHeader = new JLabel("Right Answers");
    private JLabel rightRemainHeader = new JLabel("Right Remainders");
    
    
    private JPanel Mid = new JPanel();
    private JLabel []question = new JLabel[10];//questions
    private JTextField []rightAns = new JTextField[10];
    private JTextField []rightRemain = new JTextField[10];
    private JTextField []userAns = new JTextField[10];
    private JTextField []userRemain = new JTextField[10];
    
    private TestFrame temp = null;
    
    private Vector<Operation> que;
    
    private JPanel Bottom = new JPanel();
    private JLabel result = null;//confirm button
    private JButton terminate = null;//terminate the program
    private JButton retry  = null;//retry the same questions
    private JButton contin = null;//continue the test
    
    /**
     * constructor method
     * @param kind transfer different kind of test
     * @throws IOException
     */
    public ResultFrame(String nameOfFolder,Vector<Operation> que,TestFrame temp) throws IOException{
        this.setTitle("Arithmetic Test");
        this.setSize(300, 400);
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.temp = temp;
        this.que = que;
        this.nameOfFolder = nameOfFolder;
        this.rightAnswers = 0;
        
        
        for(int i = 0; i < this.question.length; i++){
            this.question[i] = new JLabel();
            this.rightAns[i] = new JTextField();
            this.rightRemain[i] = new JTextField();
            this.userAns[i] = new JTextField();
            this.userRemain[i] = new JTextField();
            this.rightAns[i].setEditable(false);
            this.rightRemain[i].setEditable(false);
            this.userAns[i].setEditable(false);
            this.userRemain[i].setEditable(false);
            this.question[i].setText(Integer.toString(i+1)+").  "+ this.que.elementAt(i).getQueInString());
            if(this.que.elementAt(i).getUserResult1()!=-1){
                this.userAns[i].setText(""+this.que.elementAt(i).getUserResult1());
            } else {
                this.userAns[i].setText("");
            }
            this.rightAns[i].setText(""+this.que.elementAt(i).getRightResult1());
            if(this.que.elementAt(i).getOperationalSymbol() == 4){
                this.rightRemain[i].setText(""+this.que.elementAt(i).getRightResult2());
                if(this.que.elementAt(i).getUserResult2()!=-1){
                    this.userRemain[i].setText(""+this.que.elementAt(i).getUserResult2());
                } else {
                    this.userAns[i].setText("");
                }
            }
        }
        
        this.Top.setLayout(new GridLayout(1,5));
        this.Top.add(this.queHeader);
        this.Top.add(this.userAnsHeader);
        this.Top.add(this.userRemainHeader);
        this.Top.add(this.rightAnsHeader);
        this.Top.add(this.rightRemainHeader);
        this.getContentPane().add(this.Top, BorderLayout.NORTH);
        
        this.Mid.setLayout(new GridLayout(10,5));
        for (int i = 0; i < 10; i++) {
            this.Mid.add(this.question[i]);
            this.Mid.add(this.userAns[i]);
            this.Mid.add(this.userRemain[i]);
            this.Mid.add(this.rightAns[i]);
            this.Mid.add(this.rightRemain[i]);
            if(this.que.elementAt(i).getOperationalSymbol() != 4){
                if(this.que.elementAt(i).getRightResult1() == this.que.elementAt(i).getUserResult1()){
                    this.rightAnswers++;
                }
            } else {
                if(this.que.elementAt(i).getRightResult1() == this.que.elementAt(i).getUserResult1() && this.que.elementAt(i).getRightResult2() == this.que.elementAt(i).getUserResult2()){
                    this.rightAnswers++;
                }
            }
        }
        double Grade = this.rightAnswers*100/10;
        this.getContentPane().add(this.Mid, BorderLayout.CENTER);
        
        this.Bottom.setLayout(new GridLayout(4,1));
        this.result = new JLabel("Your Final Grade: "+Grade);//result label
        this.terminate = new JButton("Quit");//exit the program
        this.retry = new JButton("Do It Again!");
        this.contin = new JButton("Try Another Test!");
        
        this.Bottom.add(this.result);
        this.Bottom.add(this.retry);
        this.Bottom.add(this.contin);
        this.Bottom.add(this.terminate);
        this.getContentPane().add(this.Bottom, BorderLayout.SOUTH);
        
        this.retry.addActionListener(this);
        this.contin.addActionListener(this);
        this.terminate.addActionListener(this);
        this.pack();
        this.setVisible(true);
        
        //nameOfFolder:"/xx"
        nameOfFolder = "" + nameOfFolder;
        
        //Folder:"/xx"
        File Folder = new File(nameOfFolder);
        
        if(!Folder.exists() && !Folder.isDirectory())
        {
            Folder.mkdir();
        }
        Date date = new Date();
        String fileName = Long.toString(date.getTime()) + ".his";
        nameOfFolder = nameOfFolder + "/grade" + fileName;
        //    	Folder:"~/xx/time.his"
        File file = new File(nameOfFolder);
        
        if(!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        //write into file
        FileWriter fileWriter = new FileWriter(nameOfFolder);
        BufferedWriter wri = new BufferedWriter(fileWriter);
        wri.write("Results:\n");
        wri.write("Grades:" + Grade + "\n");
        
        int i = 0;
        for(i = 0; i < 10; i++)
        {
            wri.write(Integer.toString(i+1));
            wri.write(".)");
            wri.write(this.que.elementAt(i).outputAnswerString());
            wri.flush();
        }
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == this.terminate){
            System.exit(0);
        }
        if(e.getSource() == this.retry){
            this.setVisible(false);
            this.temp.setVisible(true);
        }
        if(e.getSource() == this.contin){
            this.setVisible(false);
            new ChooseFrame().setVisible(true);
        }
    }
}
