package com.eb3;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(String s){
        super(s);
        this.setSize(600,500);
        this.setLayout(new BorderLayout());

        Init_buttons();

        Init_Image();

        setVisible(true);
    }

    public void Init_buttons(){


    }


    public void Init_Image(){
        // URL de l'image
        String imgUrl="sncf.png";	// par exemple
        ImageIcon icone = new ImageIcon(imgUrl);

        // Création d'un JLabel avec un alignement gauche
        JLabel image = new JLabel(icone, JLabel.CENTER);
        image.setBounds(0,-30,200,200);	// par exemple
        //ajoute le JLabel a la JFrame
        getContentPane().add(image);
    }
}
