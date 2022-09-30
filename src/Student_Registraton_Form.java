import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.Writer;

class MyFrame extends JFrame implements ActionListener {
    JLabel label1, label2, label3, label4, label5, label6, label7, label8;
    JTextField name,RollNo,batch,section,country;
    JRadioButton male,female;
    JCheckBox matric,intermediate,graduate,P_graduate;
    JTextArea address;
    JComboBox country_cb;
    JButton save,print;


    public MyFrame() {

        setTitle("Registration Form");
        setSize(700,700);
        Container c=getContentPane();
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.YELLOW);





       // Creating labels
        label1 = new JLabel("Name");
        label1.setBounds(20, 20, 200, 20);
        c.add(label1);

        label2=new JLabel("RollNo");
        label2.setBounds(20,80,200,20);
        c.add(label2);

        label3=new JLabel("Batch");
        label3.setBounds(20,140,200,20);
        c.add(label3);

        label4=new JLabel("Section");
        label4.setBounds(20,200,200,20);
        c.add(label4);

        label5=new JLabel("Gender");
        label5.setBounds(20,260,200,20);
        c.add(label5);

        label6=new JLabel("Qualification");
        label6.setBounds(20,320,200,20);
        c.add(label6);

        label7=new JLabel("Address");
        label7.setBounds(20,380,200,20);
        c.add(label7);


        label8=new JLabel("Country");
        label8.setBounds(20,440,200,20);
        c.add(label8);

        // Creating textField
        name=new JTextField();
        name.setBounds(100,20,200,20);
        c.add(name);

        RollNo=new JTextField();
        RollNo.setBounds(100,80,200,20);
        c.add(RollNo);




        batch=new JTextField();
        batch.setBounds(100,140,200,20);
        c.add(batch);


        section=new JTextField();
        section.setBounds(100,200,200,20);
        c.add(section);



        //RadioButton for gender
        male=new JRadioButton("Male");
        male.setBounds(100,260,200,20);
        c.add(male);


        female=new JRadioButton("Female");
        female.setBounds(200,260,250,20);
        c.add(female);

        ButtonGroup g=new ButtonGroup();
        g.add(male);
        g.add(female);

        //CheckBox for Qualification
        matric=new JCheckBox("Matric");
        matric.setBounds(100,320,200,20);

        intermediate=new JCheckBox("Intermidate");
        intermediate.setBounds(200,320,200,20);

        graduate=new JCheckBox("Graduate");
        graduate.setBounds(100,340,200,20);

        P_graduate=new JCheckBox("Post Graduate");
        P_graduate.setBounds(200,340,200,20);
        //Checkbox F=new Checkbox();
        c.add(matric);
        c.add(intermediate);
        c.add(graduate);
        c.add(P_graduate);

        //textArea for Address
        address=new JTextArea();
        address.setBounds(100,380,200,40);
        c.add(address);

        //ComboBox for List of Countries
        String[] Country={"Pakistan","China","India","Afganistan","Iran","UAE"};
        country_cb = new JComboBox(Country);
        country_cb.setBounds(100,440,200,20);
        c.add(country_cb);




        // Save,print,JDBC
        save=new JButton("Save");
        save.setBounds(100,500,100,30);
        c.add(save);


        print=new JButton("Print");
        print.setBounds(250,500,100,30);
        c.add(print);

        save.addActionListener(this );
        print.addActionListener(this);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        JSONObject obj = new JSONObject();
        obj.put("Name", name.getText());
        obj.put("RollNo: ", RollNo.getText());
        obj.put("Batch: ", batch.getText());
        obj.put("Section: ", section.getText());

        if(male.isSelected()){
            obj.put("gender",male.getText());

        }else {
            obj.put("gender",female.getText());
        }if(e.getSource()==save){

            try {
                Writer writer = new FileWriter("OutPut.json");
                writer.write(obj.toJSONString());
                try{
                    if(male.isSelected()) {
                        obj.put("Gender: ", male.getText());
                    }
                    else {
                        obj.put("Gender: ", female.getText());
                    }
                }
                catch (Exception ie){
                    ie.printStackTrace();
                }

                writer.close();
            } catch (Exception ie) {
                ie.printStackTrace();
            }
            if(matric.isSelected())
                obj.put("Qualification",matric.getSelectedObjects());
            else if (intermediate.isSelected()) {
                obj.put("Qualification",intermediate.getSelectedObjects());

            } else if (graduate.isSelected()) {
                obj.put("Qualification",graduate.getSelectedObjects());

            }else {
                obj.put("Qualification",P_graduate.getSelectedObjects());
            }
        }
        else if(e.getSource()==print) {
            setTitle("Information Form");
            setSize(600, 600);
            setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            getContentPane().setBackground(Color.ORANGE);
            System.out.println(name.getText());
            System.out.println(RollNo.getText());
            System.out.println(batch.getText());
            System.out.println(section.getText());
            if (male.isSelected())
                System.out.println("Male");
            else
                System.out.println("Female");
        }
        if(matric.isSelected())
            System.out.println("Matric");
        else if (intermediate.isSelected()) {
            System.out.println("Intermediate");

        }else if(graduate.isSelected()){
            System.out.println("Graduate");
        }else{
            System.out.println("PostGraduate");
        }


    }
    }
 class Student_Registration_Form {
    public static void main(String[] args) {

        MyFrame b = new MyFrame();

    }
}

