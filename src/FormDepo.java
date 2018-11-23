import javax.swing.*;
import java.awt.*;

public class FormDepo {

//    private Depo<ITransport> depo;
    private MultiLevelDepo depo;
    private final int countLevel = 5;

    public FormDepo() {
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 800, 490);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panelTakeLoco = new JPanel();
        panelTakeLoco.setBounds(642, 257, 132, 183);
        frame.getContentPane().add(panelTakeLoco);
        panelTakeLoco.setLayout(null);

        PanelDepo panelDepo = new PanelDepo();
        depo = new MultiLevelDepo(countLevel, panelDepo.getWidth(), panelDepo.getHeight());
        panelDepo.setDepo(depo.get(0));
        panelDepo.setBounds(10, 11, 622, 429);
        frame.getContentPane().add(panelDepo);

        DefaultListModel listModel = new DefaultListModel();
        for (int i = 1; i <= countLevel; i++) {
            listModel.addElement("Уровень " + i);
        }

        JList list = new JList(listModel);
        list.setBounds(642, 11, 132, 107);
        frame.getContentPane().add(list);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(e -> {
            panelDepo.setDepo(depo.get(list.getSelectedIndex()));
            panelDepo.repaint();
        });

        JLabel label = new JLabel("Забрать");
        label.setBounds(10, 11, 72, 14);
        panelTakeLoco.add(label);

        JLabel lblNewLabel = new JLabel("локомотив");
        lblNewLabel.setBounds(10, 27, 93, 14);
        panelTakeLoco.add(lblNewLabel);

        JLabel label_1 = new JLabel("Место:");
        label_1.setBounds(10, 55, 46, 14);
        panelTakeLoco.add(label_1);

        JTextField textField = new JTextField();
        textField.setBounds(55, 52, 67, 20);
        panelTakeLoco.add(textField);
        textField.setColumns(10);

        PanelLocomotive panelLocomotive = new PanelLocomotive();
        panelLocomotive.setBounds(10, 117, 112, 55);
        panelTakeLoco.add(panelLocomotive);

        JButton buttonTake = new JButton("Забрать");
        buttonTake.addActionListener(e -> {
            int locoPosition = Integer.parseInt(textField.getText());
            ITransport loco;
            if ((loco = depo.get(list.getSelectedIndex()).del(locoPosition)) != null) {
                loco.SetPosition(5, 5, panelLocomotive.getWidth(), panelLocomotive.getHeight());
                panelLocomotive.setTransport(loco);
            } else {
                panelLocomotive.setTransport(null);
            }
            panelLocomotive.repaint();
            panelDepo.repaint();
        });
        buttonTake.setBounds(10, 83, 112, 23);
        panelTakeLoco.add(buttonTake);

        JButton buttonParkLoco = new JButton();
        buttonParkLoco.addActionListener(e -> {
            Color firstColor = JColorChooser.showDialog(null, "Choose a Color", Color.WHITE);
            var loco = new Locomotive(
                    (int) (Math.random() * 200) + 100,
                    (int) (Math.random() * 1000) + 1000,
                    firstColor);
            depo.get(list.getSelectedIndex()).add(loco);
            panelDepo.repaint();
        });
        buttonParkLoco.setLayout(null);

        JLabel label1 = new JLabel("Припарковать");
        label1.setBounds(5, 5, 100, 15);
        JLabel label2 = new JLabel("локомотив");
        label2.setBounds(5, 23, 100, 15);
        buttonParkLoco.add(label1);
        buttonParkLoco.add(label2);

        buttonParkLoco.setBounds(642, 121, 132, 43);
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
            depo.get(list.getSelectedIndex()).add(loco);
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

        buttonParkSteamLoco.setBounds(642, 175, 132, 62);
        frame.getContentPane().add(buttonParkSteamLoco);
        frame.setVisible(true);
    }
}
