package com.csaba79coder.ui;

import com.csaba79coder.service.Calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemoryButton extends Button implements ActionListener {
    Calculator cl;

    public MemoryButton(int x, int y, int width, int height, String cap, Calculator clc) {
        super(cap);
        setBounds(x,y,width,height);
        this.cl=clc;
        this.cl.add(this);
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent ev) {
        char memop = ((MemoryButton)ev.getSource()).getLabel().charAt(1);

        cl.setClear = true;

        switch(memop) {
            case 'C':
                cl.memLabel.setText(" ");cl.memValue=0.0;
                break;
            case 'R':
                cl.displayLabel.setText(Calculator.getFormattedText(cl.memValue));
                break;
            case 'S':
                cl.memValue = 0.0;
            case '+':
                cl.memValue+=Double.parseDouble(cl.displayLabel.getText());
                if (cl.displayLabel.getText().equals("0") || cl.displayLabel.getText().equals("0.0")  )
                    cl.memLabel.setText(" ");
                else
                    cl.memLabel.setText("M");
                break;
        }
    }
}