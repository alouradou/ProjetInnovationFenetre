package com.eb3;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Window extends JFrame {

    private JButton quit = new JButton();
    private JLabel title = new JLabel();
    private JLabel fileChoiceLabel = new JLabel();

    private JPanel checkBoxPanel1 = new JPanel();
    private JPanel checkBoxPanel2 = new JPanel();
    private JPanel checkBoxPanel3 = new JPanel();
    private JPanel checkBoxPanel4 = new JPanel();

    private JLabel checkLabel1 = new JLabel();
    private JLabel checkLabel2 = new JLabel();
    private JLabel checkLabel3 = new JLabel();
    private JLabel checkLabel4 = new JLabel();

    private JCheckBox checkBox1 = new JCheckBox();
    private JCheckBox checkBox2 = new JCheckBox();
    private JCheckBox checkBox3 = new JCheckBox();
    private JCheckBox checkBox4 = new JCheckBox();

    private String imgUrl="sncf.png";
    private ImageIcon icone = new ImageIcon(imgUrl);
    private JLabel image;
    private Box side_panel = Box.createVerticalBox();

    private int width = 600;
    private int height = 800;

    public Window(String s){
        super(s);
        this.setSize(width,height);
        this.setLayout(new BorderLayout());

        Init_Buttons();

        Init_Labels();

        Init_Image();

        Init_Box();

        Init_SidePanel();

        setVisible(true);
    }

    public void Init_Buttons(){



        quit = new JButton("Quitter");
        quit.setFocusable(false);
        // positionnement et dimensionnement manuel du bouton
        this.getContentPane().add(quit, BorderLayout.SOUTH);

        // traitement d'un clic sur le bouton : définition d'un Listener/Ecouteur
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // quand on a clique sur le bouton "Quitter", on sort du programme
                System.out.println("Sortie par le bouton Quitter");
                System.exit(0);
            }
        });

    }

    public void Init_Labels(){
        title = new JLabel("<html>" +
                "<span style='color: purple; margin: 30px;font-size: 2em;'>Tri des données</span>" +
                "</html>");
        title.setFocusable(false);
        title.setHorizontalAlignment(JLabel.CENTER);
        this.getContentPane().add(title, BorderLayout.NORTH);



    }


    public void Init_Image(){

        // Création d'un JLabel avec un alignement gauche
        image = new JLabel(icone, JLabel.CENTER);
        //ajoute le JLabel a la JFrame
        getContentPane().add(image);
    }

    public void Init_SidePanel(){
        fileChoiceLabel = new JLabel();
        fileChoiceLabel.setText("<html><span style='color: purple; margin: 30px;'>Choix des fichiers :</span></html>");

        side_panel.setSize(200,300);

        Box checkBoxes = Box.createVerticalBox();
        for (String texts : Arrays.asList("État Objets","État Organes","Alarmes","Dialogues")) {
            JCheckBox cb = new JCheckBox(texts);
            checkBoxes.add(cb, "wrap");

        }

        //Trier par (priorité)
        /*JComboBox priority_cb = new JComboBox(new String[] {"Hello, StackOverflow","Hello, Github"});
        priority_cb.setSize(new Dimension(20,12));
        checkBoxes.add(priority_cb,"wrap");*/

        //Temps avant incident
        Box timeBeforeBox = Box.createVerticalBox();
        timeBeforeBox.setSize(new Dimension(0,20));
        JLabel timeLabel = new JLabel("<html><span style='color: purple;'>Temps avant l'incident :</span></html>");
        JTextField timeBefore = new JTextField();
        JPanel firstTextFieldPanel = new JPanel(); // cf https://stackoverflow.com/questions/5518713/jtextfield-fixed-height
        firstTextFieldPanel.setLayout(new FlowLayout());
        timeBefore.setPreferredSize(new Dimension(50,20));
        firstTextFieldPanel.add(timeBefore);
        timeBeforeBox.add(timeLabel,"wrap");
        timeBeforeBox.add(firstTextFieldPanel,"wrap");

        Box trainNumberBox = Box.createVerticalBox();
        JLabel trainNumberLabel = new JLabel("<html><span style='color: purple;'>Numéro de train :</span></html>");
        trainNumberBox.add(trainNumberLabel,"wrap");
        JPanel secondTextFieldPanel = new JPanel();
        secondTextFieldPanel.setLayout(new FlowLayout());
        JTextField trainNumber = new JTextField();
        trainNumber.setPreferredSize(new Dimension(50,20));
        secondTextFieldPanel.add(trainNumber);
        trainNumberBox.add(secondTextFieldPanel,"wrap");

        Box nbZoneBox = Box.createVerticalBox();
        JLabel nbZoneLabel = new JLabel("<html><span style='color: purple;'>Nombre de zones adjacentes :</span></html>");
        nbZoneBox.add(nbZoneLabel,"wrap");
        JSlider nbZone = new JSlider();
        nbZone.setMinimum(0);
        nbZone.setMaximum(10);//cf p479 livre java
        nbZone.setValue(10);
        nbZone.setPaintLabels(true);
        nbZone.setPaintTicks(true);
        nbZone.setMinorTickSpacing(1);
        nbZone.setMajorTickSpacing(5);
        JLabel nbZonesValue = new JLabel();
        nbZonesValue.setText("Valeur : "+ nbZone.getValue());
        nbZone.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                nbZonesValue.setText("Valeur : "+ ((JSlider)e.getSource()).getValue());
            }
        });
        nbZoneBox.add(nbZone,"wrap");
        nbZoneBox.add(nbZonesValue);

        JButton button_default = new JButton("Choix des options par défaut");


        checkBoxes.setAutoscrolls(true);

        side_panel.add(fileChoiceLabel);

        side_panel.add(checkBoxes,"wrap");
        side_panel.add(timeBeforeBox,"wrap");
        side_panel.add(trainNumberBox,"wrap");
        side_panel.add(nbZoneBox,"wrap");
        side_panel.add(button_default);
    }

    public void Init_Box(){
        Box header_box =  Box.createHorizontalBox();
        header_box.add(image);
        header_box.add(title);

        Box content_box = Box.createHorizontalBox();
        JScrollPane scroll_side = new JScrollPane(side_panel);
        content_box.add(scroll_side);
        content_box.add(new JTable(10,5));

        Box full_box = Box.createVerticalBox();
        full_box.add(header_box);
        full_box.add(content_box);


        this.getContentPane().add(full_box);
        this.setVisible(true);
    }
}