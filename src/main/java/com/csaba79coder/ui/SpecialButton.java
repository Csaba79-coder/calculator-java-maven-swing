package com.csaba79coder.ui;

import com.csaba79coder.service.Calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpecialButton extends Button implements ActionListener {
    public Calculator cl;

    public SpecialButton(int x, int y, int width, int height, String cap, Calculator clc) {
        super(cap);
        setBounds(x, y, width, height);
        this.cl = clc;
        this.cl.add(this);
        addActionListener(this);
    }

    static String backSpace(String s) {
        String Res = "";
        for (int i = 0; i < s.length() - 1; i++) Res += s.charAt(i);
        return Res;
    }

    public void actionPerformed(ActionEvent ev) {
        String opText = ((SpecialButton) ev.getSource()).getLabel();

        if (opText.equals("Backspc")) {
            String tempText = backSpace(cl.displayLabel.getText());
            if (tempText.equals(""))
                cl.displayLabel.setText("0");
            else
                cl.displayLabel.setText(tempText);
            return;
        }

        if (opText.equals("C")) {
            cl.number = 0.0;
            cl.op = ' ';
            cl.memValue = 0.0;
            cl.memLabel.setText(" ");
        }

        cl.displayLabel.setText("0");
        cl.setClear = true;
    }
}