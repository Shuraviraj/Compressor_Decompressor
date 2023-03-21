package com.Acciojob.GUI;

import com.Acciojob.compDecomp.Compressor;
import com.Acciojob.compDecomp.Decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {

    JButton compressButton;
    JButton decompressButton;

    public AppFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        compressButton = new JButton("Select file to compress");
        compressButton.setBounds(20, 100, 200, 30);
        compressButton.addActionListener(this);

        decompressButton = new JButton("Select file to decompress");
        decompressButton.setBounds(250, 100, 200, 30);
        decompressButton.addActionListener(this);

        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(1000, 500);
        this.getContentPane().setBackground(Color.decode("#ffb884"));
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compressButton) {
            JFileChooser jFileChooser = new JFileChooser();
            int response = jFileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(jFileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try {
                    Compressor.method(file);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }
        if (e.getSource() == decompressButton) {
            JFileChooser jFileChooser = new JFileChooser();
            int response = jFileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(jFileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try {
                    Decompressor.method(file);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }
    }
}
