import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Packageforms extends JFrame{
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JButton button1;
    private JTextField TrackingNumbertext;
    private JLabel f;
    private JTextArea textArea1;
    private JButton Quemar;
    private JTextArea textArea2;
    private JTextField textField1;
    private JTextField textField13;
    private JTextField textField20;
    private JTextField textField14;
    private JTextField textField15;
    private JTextField textField17;
    private JTextField textField19;
    private JTextField textField16;
    private JTextField textField18;
    private JButton crearButton;
    private JButton mostrarButton;
    private JTabbedPane tabbedPane2;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton buscarButton;
    private JTextArea textArea3;
    private JTextField Numerotrack;
    private JButton buscarButton1;
    private JTextArea textArea4;
    private JButton ciudadButton;
    private JButton estadoButton;
    private JButton zipcodeButton;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextArea textArea5;

    private TrackingSystem pck= new TrackingSystem();


    public Packageforms() {
        super ("Paquetería");
        setContentPane(panel1);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(pck.removePackage(TrackingNumbertext.getText())==true){
                    textField1.setText("Se eliminó el paquete exitosamente");
                }else{
                    textField1.setText("No existe ese paquete");
                }

            }
        });
        Quemar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pck.addPackage(new Package(String.valueOf(pck.packages.size()+1),new Address("Street 123","New York","New York","12345"),
                        new Address("Street 56","New York","New York","5678"), LocalDate.now()));
                pck.addPackage(new Package(String.valueOf(pck.packages.size()+1),new Address("Street 183","New York","New York","12441"),
                        new Address("Street 67","New York","New York","1245"), LocalDate.now()));
                pck.addPackage(new Package(String.valueOf(pck.packages.size()+1),new Address("Street 113","New York","New York","51243"),
                        new Address("Street 89","New York","New York","6733"), LocalDate.now()));
                pck.addPackage(new Package(String.valueOf(pck.packages.size()+1),new Address("Street 423","New York","New York","41251"),
                        new Address("Street 23","New York","New York","5652"), LocalDate.now()));
                pck.addPackage(new Package(String.valueOf(pck.packages.size()+1),new Address("Street 165","New York","New York","15214"),
                        new Address("Street 86","New York","New York","6543"), LocalDate.now()));
                pck.addPackage(new Package(String.valueOf(pck.packages.size()+1),new Address("Street 631","New York","New York","12517"),
                        new Address("Street 08","New York","New York","9653"), LocalDate.now()));
                textArea2.setText(+pck.packages.size()+"");

                for(int i=0;i<pck.packages.size();i++){
                    textArea2.setText(textArea2.getText()+pck.Imprimir(i));
                }

            }
        });
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pck.addPackage(new Package(String.valueOf(pck.packages.size()+1),new Address(textField13.getText(),textField14.getText(),
                        textField15.getText(),textField16.getText()),
                        new Address(textField17.getText(),textField18.getText(),textField19.getText(),textField20.getText()), LocalDate.now()));
                JOptionPane.showMessageDialog(null, "Se ha creado correctamente");
            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                for(int i=0;i<pck.packages.size();i++){
                    textArea1.setText(textArea1.getText()+pck.Imprimir(i));
                }
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<pck.packages.size();i++){
                   if(pck.packages.get(i).recipientAddress.street.equals(textField2.getText())&&
                      pck.packages.get(i).recipientAddress.city.equals(textField3.getText())&&
                      pck.packages.get(i).recipientAddress.state.equals(textField4.getText())&&
                      pck.packages.get(i).recipientAddress.zipCode.equals(textField5.getText())
                   ){
                       textArea3.setText("Paquete encontrado"+pck.packages.get(i).toString());
                       break;
                   }else{
                       textArea3.setText("No se encontró el paquete");
                   }
                }
            }
        });
        buscarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textArea4.setText(pck.SearchByTrackingNumber(Numerotrack.getText()).toString());
            }
        });
        ciudadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea5.setText("");
                for(int i=0;i<pck.searchByCity(textField6.getText()).size();i++)
                textArea5.setText(textArea5.getText()+pck.searchByCity(textField6.getText()).get(i).toString());
            }
        });
        estadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea5.setText("");
                for(int i=0;i<pck.searchByCity(textField7.getText()).size();i++)
                    textArea5.setText(textArea5.getText()+pck.searchBystate(textField7.getText()).get(i).toString());
            }
        });
        zipcodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea5.setText("");
                    for(int i=0;i<pck.searchByZipCode(textField8.getText()).size();i++)
                    textArea5.setText(textArea5.getText()+pck.searchByZipCode(textField8.getText()).get(i).toString());

            }
        });
    }
}
