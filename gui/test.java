package com.ly;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.io.*;

public class test extends JFrame{

    int size=9;
    JButton []jbs=new JButton[size];
    public static String s = "123124124";

    

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        test d3=new test();
    
       
    }

     public test()
        {
           

           // JTextField jt1=new JTextField();
  //JTextArea jt2=new JTextArea();   
  //JScrollPane jsp=new JScrollPane(jt2); 

   // this.add(jt1);
   // this.add(jt2);
   // this.add(jsp);
   // jt2.setText("aaa");

            
            jbs[0]=new JButton("input1");
            jbs[1]=new JButton("input2");
            jbs[2]=new JButton("ouput");
            jbs[3]=new JButton("-w");
            jbs[4]=new JButton("-c");
            jbs[5]=new JButton("-h");
            jbs[6]=new JButton("-t");
            jbs[7]=new JButton("-n");
            jbs[8]=new JButton("exit");

            Monitor1 input1 = new Monitor1();
            jbs[0].addActionListener(input1);
            Monitor2 input2 = new Monitor2();
            jbs[1].addActionListener(input2);
            Monitor3 output = new Monitor3();
            jbs[2].addActionListener(output);
            
            this.setLayout(new GridLayout(3,3));
            
            for(int i=0;i<size;i++)
            {
                this.add(jbs[i]);
            }
            
            

            this.setTitle("longest word");
            this.setSize(300,300);
            this.setLocation(200,200);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
        }
}


class Monitor1 implements ActionListener{
    public void actionPerformed(ActionEvent event){
        JFrame f  = new JFrame();
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(f);   

        File fo = jfc.getSelectedFile();
        String pathname = fo.getAbsolutePath();

        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Monitor2 implements ActionListener{
    public void actionPerformed(ActionEvent event){
        test.s=JOptionPane.showInputDialog("please input text");
        System.out.println(test.s);
    }
}

class Monitor3 implements ActionListener{
    public void actionPerformed(ActionEvent event){
        System.out.println(test.s);
        JOptionPane.showMessageDialog(null, test.s);
    }
}


