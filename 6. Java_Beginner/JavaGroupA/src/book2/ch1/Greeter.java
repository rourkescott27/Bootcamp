package book2.ch1;
import javax.swing.JOptionPane;

class Greeter
{
    public void sayHello()
    {
        JOptionPane.showMessageDialog(null,
                "Hello World!", "Greeter",
                JOptionPane.INFORMATION_MESSAGE);
//        System.out.println("Hello World");
    }
}
