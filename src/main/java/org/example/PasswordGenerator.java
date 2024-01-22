package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGenerator extends JFrame {

    private PassGenLogic passGenLogic;

    public PasswordGenerator(){
        setTitle("PasswordGenerator");
        setSize(540, 570);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //password generator
        passGenLogic = new PassGenLogic();
        addGuiComponents();
    }

    private void addGuiComponents(){
        JLabel titleLabel = new JLabel("Password Generator");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 10, 540, 39);
        add(titleLabel);

        JTextArea passwordOutput = new JTextArea();
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Arial", Font.BOLD, 32));

        JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25, 97, 479, 70);
        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOutputPane);

        JLabel passwordLengthLabel = new JLabel("Password Length: ");
        passwordLengthLabel.setFont(new Font("Arial", Font.PLAIN, 32));
        passwordLengthLabel.setBounds(25, 215, 272, 39);
        add(passwordLengthLabel);

        JTextArea passwordLengthInput = new JTextArea();
        passwordLengthInput.setEditable(true);
        passwordLengthInput.setFont(new Font("Arial", Font.BOLD, 32));
        passwordLengthInput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordLengthInput.setBounds(310, 215, 192, 39);
        add(passwordLengthInput);

        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setFont(new Font("Arial", Font.PLAIN, 26));
        uppercaseToggle.setBounds(25, 302, 225, 56);
        add(uppercaseToggle);

        JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
        lowercaseToggle.setFont(new Font("Arial", Font.PLAIN, 26));
        lowercaseToggle.setBounds(282, 302, 225,56);
        add(lowercaseToggle);

        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setFont(new Font("Arial", Font.PLAIN, 26));
        numbersToggle.setBounds(25, 373, 225, 56);
        add(numbersToggle);

        JToggleButton symbolsToggle = new JToggleButton("Symbols");
        symbolsToggle.setFont(new Font("Arial", Font.PLAIN, 26));
        symbolsToggle.setBounds(282, 373, 225, 56);
        add(symbolsToggle);

        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Arial", Font.PLAIN, 32));
        generateButton.setBounds(155, 477, 222, 41);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //generate a password only when length > 0 and one of the toggled buttons is selected
                if(passwordLengthInput.getText().length() <= 0) return;
                boolean anyToggleSelected = lowercaseToggle.isSelected() ||
                        uppercaseToggle.isSelected() ||
                        numbersToggle.isSelected() ||
                        symbolsToggle.isSelected();

                //generate password
                int passwordLength = Integer.parseInt(passwordLengthInput.getText());
                if(anyToggleSelected){
                    String generatedPassword = passGenLogic.generatePassword(passwordLength,
                            uppercaseToggle.isSelected(),
                            lowercaseToggle.isSelected(),
                            numbersToggle.isSelected(),
                            symbolsToggle.isSelected());

                    //show password
                    passwordOutput.setText(generatedPassword);
                }
            }
        });
        add(generateButton);
    }
}