package com.csaba79coder.service;

import com.csaba79coder.ui.DigitButton;
import com.csaba79coder.ui.MemoryButton;
import com.csaba79coder.ui.OperatorButton;
import com.csaba79coder.ui.SpecialButton;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calculator extends Frame {

    public boolean setClear = true;
    public double number, memValue;
    public char op;

    public String digitButtonText[] = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", "+/-", "."};
    public String operatorButtonText[] = {"/", "sqrt", "*", "%", "-", "1/X", "+", "="};
    public String memoryButtonText[] = {"MC", "MR", "MS", "M+"};
    public String specialButtonText[] = {"Backspc", "C", "CE"};

    public DigitButton digitButton[] = new DigitButton[digitButtonText.length];
    public OperatorButton operatorButton[] = new OperatorButton[operatorButtonText.length];
    public MemoryButton memoryButton[] = new MemoryButton[memoryButtonText.length];
    public SpecialButton specialButton[] = new SpecialButton[specialButtonText.length];

    public Label displayLabel = new Label("0", Label.RIGHT);
    public Label memLabel = new Label(" ", Label.RIGHT);

    public final int FRAME_WIDTH = 325, FRAME_HEIGHT = 325;
    public final int HEIGHT = 30, WIDTH = 30, H_SPACE = 10, V_SPACE = 10;
    public final int TOPX = 30, TOPY = 50;

    public Calculator(String frameText) {
        super(frameText);

        int tempX = TOPX, y = TOPY;
        displayLabel.setBounds(tempX, y, 240, HEIGHT);
        displayLabel.setBackground(Color.BLUE);
        displayLabel.setForeground(Color.WHITE);
        add(displayLabel);

        memLabel.setBounds(TOPX, TOPY + HEIGHT + V_SPACE, WIDTH, HEIGHT);
        add(memLabel);

        tempX = TOPX;
        y = TOPY + 2 * (HEIGHT + V_SPACE);
        for (int i = 0; i < memoryButton.length; i++) {
            memoryButton[i] = new MemoryButton(tempX, y, WIDTH, HEIGHT, memoryButtonText[i], this);
            memoryButton[i].setForeground(Color.RED);
            y += HEIGHT + V_SPACE;
        }

        tempX = TOPX + 1 * (WIDTH + H_SPACE);
        y = TOPY + 1 * (HEIGHT + V_SPACE);
        for (int i = 0; i < specialButton.length; i++) {
            specialButton[i] = new SpecialButton(tempX, y, WIDTH * 2, HEIGHT, specialButtonText[i], this);
            specialButton[i].setForeground(Color.RED);
            tempX = tempX + 2 * WIDTH + H_SPACE;
        }

        int digitX = TOPX + WIDTH + H_SPACE;
        int digitY = TOPY + 2 * (HEIGHT + V_SPACE);
        tempX = digitX;
        y = digitY;
        for (int i = 0; i < digitButton.length; i++) {
            digitButton[i] = new DigitButton(tempX, y, WIDTH, HEIGHT, digitButtonText[i], this);
            digitButton[i].setForeground(Color.BLUE);
            tempX += WIDTH + H_SPACE;
            if ((i + 1) % 3 == 0) {
                tempX = digitX;
                y += HEIGHT + V_SPACE;
            }
        }

        int opsX = digitX + 2 * (WIDTH + H_SPACE) + H_SPACE;
        int opsY = digitY;
        tempX = opsX;
        y = opsY;
        for (int i = 0; i < operatorButton.length; i++) {
            tempX += WIDTH + H_SPACE;
            operatorButton[i] = new OperatorButton(tempX, y, WIDTH, HEIGHT, operatorButtonText[i], this);
            operatorButton[i].setForeground(Color.RED);
            if ((i + 1) % 2 == 0) {
                tempX = opsX;
                y += HEIGHT + V_SPACE;
            }
        }

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });

        setLayout(null);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setVisible(true);
    }

    public static String getFormattedText(double temp) {
        String resText = "" + temp;
        if (resText.lastIndexOf(".0") > 0)
            resText = resText.substring(0, resText.length() - 2);
        return resText;
    }
}