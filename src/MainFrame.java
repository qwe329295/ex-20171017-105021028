import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame{
    private Container cp;
    private JTextField jtf= new JTextField();
    private JButton btn[]=new JButton[9];
    private JPanel jpn= new JPanel(new GridLayout(3,3));
    private LoginFrame loginFrame;
    public MainFrame(LoginFrame login){
        loginFrame=login;
        init();
    }
    private void init(){
        this.setBounds(100,100,500,600);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(5,5));
        cp.add(jpn,BorderLayout.CENTER);
        cp.add(jtf,BorderLayout.NORTH);
        jtf.setEditable(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loginFrame.setVisible(true);
            }
        });
        for(int i=0;i<9;i++){
            btn[i]= new JButton(Integer.toString(i));
            jpn.add(btn[i]);
            btn[i].addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tmpButton =(JButton) e.getSource();
                    jtf.setText(jtf.getText()+tmpButton.getText());
                }
            });
        }
    }
}
