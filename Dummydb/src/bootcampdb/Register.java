package bootcampdb;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Registerform {

    public Registerform(){
        JFrame f=new JFrame("Register Here !!!");

        f.setVisible(true);
        f.setBounds(100,200,300,600);
        Container co=f.getContentPane();
        f.setContentPane(co);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel l=new JLabel("REGISTRATION FORM");
        l.setVisible(true);
        f.add(l);
        l.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,20));
        l.setBounds(500,10,600,60);

        JLabel l_id=new JLabel();
        l_id.setText("EMAIL ID : ");
        l_id.setVisible(true);
        f.add(l_id);
        l_id.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,20));
        f.setLayout(null);
        l_id.setBounds(200,100,250,50);

        JLabel l_name=new JLabel();
        l_name.setText("NAME : ");
        l_name.setVisible(true);
        f.add(l_name);
        l_name.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,20));
        f.setLayout(null);
        l_name.setBounds(200,150,150,50);
        f.setLayout(null);

        JLabel l_pass=new JLabel();
        l_pass.setText("PASSWORD : ");
        l_pass.setVisible(true);
        f.add(l_pass);
        l_pass.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,20));
        f.setLayout(null);
        l_pass.setBounds(200,200,150,50);

        JLabel l_des=new JLabel();
        l_des.setText("DESIGNATION : ");
        l_des.setVisible(true);
        f.add(l_des);
        l_des.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,20));
        f.setLayout(null);
        l_des.setBounds(200,250,250,50);

        JTextField t_id=new JTextField();
        t_id.setVisible(true);
        t_id.setBounds(500,100,300,40);
        f.add(t_id);

        JTextField t_name=new JTextField();
        t_name.setVisible(true);
        t_name.setBounds(500,150,300,40);
        f.add(t_name);

        JPasswordField t_pwd=new JPasswordField();
        t_pwd.setVisible(true);
        t_pwd.setBounds(500,200,300,40);
        f.add(t_pwd);
        t_pwd.setEchoChar('*');

        JRadioButton r1=new JRadioButton("TEACHER");
        JRadioButton r2=new JRadioButton("STUDENT");
        f.add(r1);
        f.add(r2);
        r1.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,12));
        r2.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,12));
        r1.setBounds(500,250,100,40);
        r2.setBounds(700,250,100,40);
        r1.setVisible(true);
        r2.setVisible(true);
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JButton b1=new JButton("SUBMIT");
        f.add(b1);
        b1.setVisible(true);
        b1.setBounds(600,600,100,40);
        b1.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,12));

        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String emailid=t_id.getText();
                String p1=t_pwd.getText();
                String name=t_name.getText();
                String designation="";
                if(r1.isSelected()==true){
                    designation="Teacher";
                }
                if(r2.isSelected()==true){
                    designation="Student";
                }
                if(!new Emailvalidation().idvalidator(emailid)){
                    t_id.setForeground(Color.red);
                    t_id.setBorder(BorderFactory.createLineBorder(Color.red));
                    JOptionPane.showMessageDialog(t_id,"Please enter your email id correctly!!");
                }

                else if(!new validation().validator(name)){
                    t_name.setForeground(Color.red);
                    t_name.setBorder(BorderFactory.createLineBorder(Color.red));
                    JOptionPane.showMessageDialog(t_name,"Please enter name in correct format with Initials!!");
                }

                else if(!new passvalidation().validator(p1)){
                    t_pwd.setForeground(Color.red);
                    t_pwd.setBorder(BorderFactory.createLineBorder(Color.red));
                    JOptionPane.showMessageDialog(t_pwd,"Please enter password in correct format!!");
                }

                else if(r1.isSelected()==false && r2.isSelected()==false){
                    r1.setBorder(BorderFactory.createLineBorder(Color.red));
                    r2.setBorder(BorderFactory.createLineBorder(Color.red));
                    JOptionPane.showMessageDialog(r1,"Please select Designation!!");
                }

                else {
                    Jbeans ob=new Jbeans();
                    ob.setEmail(emailid);
                    ob.setName(name);
                    ob.setPassword(p1);
                    ob.setDesignation(designation);
                    boolean r1=true;
                    if(designation.equals("Teacher")){
                         r1=new dbFunction(designation).insertTableTeacher(ob);
                    }
                    if(designation.equals("Student")){
                         r1=new dbFunction(designation).insertTableStudent(ob);
                    }
                    if(r1)
                        JOptionPane.showMessageDialog(b1,"Your Registration is Successful!!");
                    else
                        JOptionPane.showMessageDialog(b1,"Invalid Details..\n Registration Failed!");
                }
                r1.setBorder(BorderFactory.createLineBorder(Color.black));
                r2.setBorder(BorderFactory.createLineBorder(Color.black));
            }
        });

        JButton b2=new JButton("CANCEL");
        f.add(b2);
        b2.setVisible(true);
        b2.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,12));
        b2.setBounds(200,600,100,40);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
public class Register{
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Registerform();
    }

}