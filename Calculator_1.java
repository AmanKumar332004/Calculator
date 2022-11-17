package RealCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  // GUI-> gui stands for Graphical-user-interface
                        // is a user-friendly visual experience builder for java Applications

public class Calculator_1 implements ActionListener{ // this interface is used to recieving action events.
        //  The class is that intrested in processing an action event implements this interface
        // and the object created with that class is registered with a component,using the component's addActionListener method

    // what is ActionListener used in for Java ->You implement an action listener to define what should be done when an user performs certain operation.
    //    example->When the user clicks a button then what should happen on that particular application
    JFrame frame;  // JFrame class is a type of container which inherits the java.awt.Frame class
    // what is the use of JFrame -> JFrame is a top level Container that provides a window on the Screen.
    //                              JFrame is used for providing a graphical user-interface  for java programs
    JTextField textfield; //
    JButton[] numberButtons = new JButton[10]; // JButton-> The JButton class is used to create a labeled button that has platform independent implementation
    JButton[] functionsButton = new JButton[9];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton,negButton;
    JPanel panel;

    Font myfont = new Font("Serif Bold", Font.BOLD,30);

    double num1 = 0,num2,result = 0;
    char operator; // char->The char keyword is a data type that is used to store a single character.
                    // A char value must be surrounded by single quotes, like 'A' or 'c'.

   class arithmeticException extends Exception{
       public String toString(){
           return "Can't Divide by Zero";
       }
   }

    Calculator_1(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,540);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50,25,300,60);
        textfield.setFont(myfont);
        textfield.setEditable(false);

        addButton = new JButton("+"); // making a new button and defining the text on the button
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("del");
        clrButton = new JButton("clr");
        negButton = new JButton("(-)");

        functionsButton[0] = addButton; // adding the buttons in the array named function and assigning them the index number
        functionsButton[1] = subButton;
        functionsButton[2] = mulButton;
        functionsButton[3] = divButton;
        functionsButton[4] = decButton;
        functionsButton[5] = equButton;
        functionsButton[6] = delButton;
        functionsButton[7] = clrButton;
        functionsButton[8] = negButton;

        // for functions button
        for(int i = 0;i<9;i++){
            functionsButton[i].addActionListener(this);
            functionsButton[i].setFont(myfont);
            functionsButton[i].setFocusable(false);
        }

        // for numberbuttons
        for(int i = 0;i<10;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myfont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50,430,80,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.BLACK);

        panel.add(numberButtons[9]);  // starting of 1st row                   // row ==> lete wali ko row kehte hai
        panel.add(numberButtons[8]);
        panel.add(numberButtons[7]);
        panel.add(addButton);        // ending of 1st row
        panel.add(numberButtons[6]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[4]);
        panel.add(subButton);
        panel.add(numberButtons[3]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[1]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(divButton);
        panel.add(equButton);




        frame.add(negButton);
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);

    }
    public static void main(String[] args){
        Calculator_1 calc = new Calculator_1();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<10;i++){
            if(e.getSource() == numberButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()== decButton){
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if(e.getSource() == divButton){
           // num2;
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");

        }
        if(e.getSource() == negButton){
            double temp = Double.parseDouble(textfield.getText());
            temp*=-1;
            textfield.setText(String.valueOf(temp));
        }
        if(e.getSource() == equButton){
            num2 = Double.parseDouble(textfield.getText());

            switch(operator){
                case'+':
                    result = num1+num2;
                    break;
                case'-':
                    result = num1-num2;
                    break;
                case'*':
                    result = num1*num2;
                    break;
                case'/':
                    result = num1/num2;
                    if(num2==0){
                        try{
                            result=num1/num2;
                            throw new arithmeticException();
                        }
                        catch(arithmeticException n){
                            textfield.setText(toString());
                        }
                    }

                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource()==clrButton){
            textfield.setText("");
        }
        if(e.getSource() == delButton){
            String str = textfield.getText();
            textfield.setText("");
            for(int i =0;i<str.length()-1;i++){
                textfield.setText(textfield.getText()+str.charAt(i));
            }
        }

    }
}