import javax.swing.*;
import java.awt.*;

public class FormDepo {

    private Depo<ITransport> depo;

    public FormDepo() {
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 800, 490);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        PanelDepo panelDepo = new PanelDepo();
        depo = new Depo<>(15, panelDepo.getWidth(), panelDepo.getHeight());
        panelDepo.setDepo(depo);
        panelDepo.setBounds(10, 11, 622, 429);
        frame.getContentPane().add(panelDepo);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(642, 257, 132, 183);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel label = new JLabel("Забрать");
        label.setBounds(10, 11, 72, 14);
        panel_1.add(label);

        JLabel lblNewLabel = new JLabel("локомотив");
        lblNewLabel.setBounds(10, 27, 93, 14);
        panel_1.add(lblNewLabel);

        JLabel label_1 = new JLabel("Место:");
        label_1.setBounds(10, 55, 46, 14);
        panel_1.add(label_1);

        JTextField textField = new JTextField();
        textField.setBounds(55, 52, 67, 20);
        panel_1.add(textField);
        textField.setColumns(10);

        PanelLocomotive panelLocomotive = new PanelLocomotive();
        panelLocomotive.setBounds(10, 117, 112, 55);
        panel_1.add(panelLocomotive);

        JButton buttonTake = new JButton("Забрать");
        buttonTake.addActionListener(e -> {
            int locoPosition = Integer.parseInt(textField.getText());
            ITransport loco;
            if ((loco = depo.del(locoPosition)) != null) {
                loco.SetPosition(5, 5, panelLocomotive.getWidth(), panelLocomotive.getHeight());
                panelLocomotive.setTransport(loco);
            } else {
                panelLocomotive.setTransport(null);
            }
            panelLocomotive.repaint();
            panelDepo.repaint();
        });
        buttonTake.setBounds(10, 83, 112, 23);
        panel_1.add(buttonTake);

        JButton buttonParkLoco = new JButton();
        buttonParkLoco.addActionListener(e -> {
            Color firstColor = JColorChooser.showDialog(null, "Choose a Color", Color.WHITE);
            var loco = new Locomotive(
                    (int) (Math.random() * 200) + 100,
                    (int) (Math.random() * 1000) + 1000,
                    firstColor);
            depo.add(loco);
            panelDepo.repaint();
        });
        buttonParkLoco.setLayout(null);
        JLabel label1 = new JLabel("Припарковать");
        label1.setBounds(5, 5, 100, 15);
        JLabel label2 = new JLabel("локомотив");
        label2.setBounds(5, 23, 100, 15);
        buttonParkLoco.add(label1);
        buttonParkLoco.add(label2);
        buttonParkLoco.setBounds(642, 11, 132, 43);
        frame.getContentPane().add(buttonParkLoco);

        JButton buttonParkSteamLoco = new JButton();
        buttonParkSteamLoco.addActionListener(e -> {
            Color firstColor = JColorChooser.showDialog(null, "Choose a Color", Color.WHITE);
            Color secondColor = JColorChooser.showDialog(null, "Choose a Color", Color.WHITE);
            var loco = new SteamLocomotiveWithBumper(
                    (int) (Math.random() * 200) + 100,
                    (int) (Math.random() * 1000) + 1000,
                    firstColor,
                    secondColor,
                    true,
                    true);
            depo.add(loco);
            panelDepo.repaint();
        });
        buttonParkSteamLoco.setLayout(null);
        JLabel label3 = new JLabel("Припарковать");
        label3.setBounds(5, 5, 100, 15);
        JLabel label4 = new JLabel("паровой");
        label4.setBounds(5, 23, 100, 15);
        JLabel label5 = new JLabel("локомотив");
        label5.setBounds(5, 41, 100, 15);
        buttonParkSteamLoco.add(label3);
        buttonParkSteamLoco.add(label4);
        buttonParkSteamLoco.add(label5);
        buttonParkSteamLoco.setBounds(642, 65, 132, 62);
        frame.getContentPane().add(buttonParkSteamLoco);
        frame.setVisible(true);
    }
}
