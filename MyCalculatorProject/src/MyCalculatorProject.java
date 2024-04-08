import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyCalculatorProject implements ActionListener{
	JFrame myFrame;
	JTextField myTextField;
	JButton[] numberedButtons= new JButton[10];
	JButton[] actionButtons= new JButton[9];
	JButton buttonAdd,buttonSub,buttonMul,buttonDiv;
	JButton buttonClr,buttonDel,buttonDec,buttonEqu,buttonNeg;
	JPanel myPanel;
	Font myFont=new Font("Algerian",Font.BOLD,30);
	double input1,input2,finalResult;
	char choosenOperator;
	
	MyCalculatorProject(){
		myFrame=new JFrame("MY_CALCULATOR");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(420,530);
		myFrame.setLayout(null);
		//myFrame.getContentPane().setBackground(Color.BLACK);
		
		myTextField=new JTextField();
		myTextField.setBounds(30,25,340,50);
		myTextField.setEditable(false);
		
		buttonAdd=new JButton("+");
		buttonSub=new JButton("-");
		buttonMul=new JButton("x");
		buttonDiv=new JButton("/");
		buttonClr=new JButton("Clr");
		buttonDel=new JButton("Del");
		buttonEqu=new JButton("=");
		buttonNeg=new JButton("(-)");
		buttonDec=new JButton(".");
		
		actionButtons[0]=buttonAdd;
		actionButtons[1]=buttonSub;
		actionButtons[2]=buttonMul;
		actionButtons[3]=buttonDiv;
		actionButtons[4]=buttonDec;
		actionButtons[5]=buttonEqu;
		actionButtons[6]=buttonDel;
		actionButtons[7]=buttonClr;
		actionButtons[8]=buttonNeg;
		
		for(int i=0;i<9;i++) {
			actionButtons[i].addActionListener(this);
			actionButtons[i].setFont(myFont);
			actionButtons[i].setFocusable(false);
		}
		for(int i=0;i<10;i++) {
			numberedButtons[i]=new JButton(String.valueOf(i));
			numberedButtons[i].addActionListener(this);
			numberedButtons[i].setFont(myFont);
			numberedButtons[i].setFocusable(false);
		}
		buttonNeg.setBounds(50,420,100,50);
		buttonDel.setBounds(150,420,100,50);
		buttonClr.setBounds(250,420,100,50);
		
		myPanel=new JPanel();
		myPanel.setBounds(50,100,300,300);
		myPanel.setLayout(new GridLayout(4,4,8,8));
		//myPanel.setBackground(Color.BLACK);
		//first row in myPanel
		myPanel.add(numberedButtons[7]);
		myPanel.add(numberedButtons[8]);
		myPanel.add(numberedButtons[9]);
		myPanel.add(buttonAdd);
		//second row in myPanel
		myPanel.add(numberedButtons[4]);
		myPanel.add(numberedButtons[5]);
		myPanel.add(numberedButtons[6]);
		myPanel.add(buttonSub);
		//Third row in myPanel
		myPanel.add(numberedButtons[1]);
		myPanel.add(numberedButtons[2]);
		myPanel.add(numberedButtons[3]);
		myPanel.add(buttonMul);
		//Fourth row in myPanel
		myPanel.add(buttonDec);
		myPanel.add(numberedButtons[0]);
		myPanel.add(buttonEqu);
		myPanel.add(buttonDiv);
		
		myFrame.add(myPanel);
		myFrame.add(buttonNeg);
		myFrame.add(buttonDel);
		myFrame.add(buttonClr);
		myFrame.add(myTextField);
		myFrame.setVisible(true);
		
	}

	public static void main(String[] args) {
		
		MyCalculatorProject calci = new MyCalculatorProject();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource()==numberedButtons[i]) {
				myTextField.setText(myTextField.getText().concat(String.valueOf(i)));
			}
		}
		    if(e.getSource()==buttonDec) {
		    	myTextField.setText(myTextField.getText()+".");
		    }
		    if(e.getSource()==buttonAdd) {
		    	input1=Double.parseDouble(myTextField.getText());
		    	choosenOperator='+';
		    	myTextField.setText("");
		    }
		    if(e.getSource()==buttonSub) {
		    	input1=Double.parseDouble(myTextField.getText());
		    	choosenOperator='-';
		    	myTextField.setText("");
		    }
		    if(e.getSource()==buttonMul) {
		    	input1=Double.parseDouble(myTextField.getText());
		    	choosenOperator='x';
		    	myTextField.setText("");
		    }
		    if(e.getSource()==buttonDiv) {
		    	input1=Double.parseDouble(myTextField.getText());
		    	choosenOperator='/';
		    	myTextField.setText("");
		    }
		    if(e.getSource()==buttonEqu) {
		    	input2=Double.parseDouble(myTextField.getText());
		    	switch(choosenOperator) {
		    	case '+':
		    		finalResult=input1+input2;
		    		break;
		    	case '-':
		    		finalResult=input1-input2;
		    		break;
		    	case 'x':
		    		finalResult=input1*input2;
		    		break;
		    	case '/':
		    		finalResult=input1/input2;
		    		break;
		    		}
		    	myTextField.setText(String.valueOf(finalResult));
		    	input1=finalResult;
		    }
		    if(e.getSource()==buttonClr) {
		    	myTextField.setText("");
		    }
		    if(e.getSource()==buttonDel) {
		    	String str=myTextField.getText();
		    	myTextField.setText("");
		    	for(int i=0;i<str.length()-1;i++) {
		    		myTextField.setText(myTextField.getText()+str.charAt(i));
		    	}
		    }
		    if(e.getSource()==buttonNeg) {
		    	double temp=Double.parseDouble(myTextField.getText());
		    	temp*=-1;
		    	myTextField.setText(String.valueOf(temp));
	            }
           }

       }
