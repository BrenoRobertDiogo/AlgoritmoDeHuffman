import Funcionalidades.interfaceArq;
import javax.swing.*;
public class Principal {
    public static void main(String[] args) throws Exception {
         interfaceArq frame = new interfaceArq();
         frame.setTitle("Mexericas Compactors");
         frame.setVisible(true);
         frame.setBounds(10,10,1000,1000);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setResizable(false);
    } // Final func main
} // Final classe main
