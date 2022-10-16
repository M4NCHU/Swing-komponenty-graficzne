import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener{

    JButton add, exit;
    JTextField first, last, specialization, mark;
    JLabel label, fieldlabel;

    Main(){
        // app title
        super("Dodaj ocenę");
        // frame size
        setBounds(200,100,500,400);
        // exit app, when close button is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // container
        JPanel panel = new JPanel(null);

        // create button that have action to close the app
        add = new JButton("Dodaj ocenę");
        add.addActionListener(this);
        add.setBounds(100, 260, 140,25);
        panel.add(add);

        // create button that close app
        exit = new JButton("Zamknij");
        exit.addActionListener(this);
        exit.setBounds(300, 260, 100,25);
        panel.add(exit);


        fieldlabel = new JLabel("Piersze imię");
        fieldlabel.setBounds(80,30,100,25);
        panel.add(fieldlabel);
        // name field
        first = new JTextField();
        first.setBounds(80,50,100,25);
        panel.add(first);

        fieldlabel = new JLabel("Nazwisko");
        fieldlabel.setBounds(80,80,100,25);
        panel.add(fieldlabel);
        // last field
        last = new JTextField();
        last.setBounds(80,100,100,25);
        panel.add(last);

        fieldlabel = new JLabel("Specjalizacja");
        fieldlabel.setBounds(80,130,100,25);
        panel.add(fieldlabel);
        // specialization field
        specialization = new JTextField();
        specialization.setBounds(80,150,100,25);
        panel.add(specialization);

        fieldlabel = new JLabel("ocena");
        fieldlabel.setBounds(80,180,100,25);
        panel.add(fieldlabel);
        // mark field
        mark = new JTextField();
        mark.setBounds(80,200,100,25);
        panel.add(mark);

        label = new JLabel("");
        label.setBounds(20,300,500,25);
        panel.add(label);

        // method allows to replace content panel of the JFrame
        setContentPane(panel);

        setVisible(true);

    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object object = actionEvent.getSource();
        if (object == add) {
            String sname = first.getText();
            String slast = last.getText();
            String sspec = specialization.getText();
            String smark = mark.getText();


            try{
                int m = Integer.parseInt(smark);
                if (m < 2 || m > 5){
                    label.setText("Nieprawidłowe dane (ocena powinna znajdować się w przedziale od (2-5)) ");
                } else {
                    label.setText("Student: " + sname + slast + " z kierunku: " + sspec + " otrzymuje ocenę: " + smark);
                }
            }
            catch(NumberFormatException e){
                label.setText("Ocena musi być liczbą");
            }
        } else if (object == exit) {
            System.exit(0);
        }
    }
}