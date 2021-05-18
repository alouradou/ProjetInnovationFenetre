package com.eb3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    private JButton quit = new JButton();
    private JLabel title = new JLabel();

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
                    "<span style='text-align: center;color: purple; margin: 30px;font-size: 2em;vertical-align: middle;'>Tri des données</span>" +
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

    }

    public void Init_Box(){
        Box header_box =  Box.createHorizontalBox();
        header_box.add(image);
        header_box.add(title);

        Box content_box = Box.createHorizontalBox();
        content_box.add(side_panel);
        content_box.add(new JTable(10,5));

        Box full_box = Box.createVerticalBox();
        full_box.add(header_box);
        full_box.add(content_box);


        this.getContentPane().add(full_box);
        this.setVisible(true);
    }
}
