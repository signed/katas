package com.github.signed.kata.chronos;

import com.google.common.collect.Sets;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;

public class DisplayAndEdit {
    private final FocusListener endEditOnFocusLost = new FocusAdapter() {
        @Override
        public void focusLost(FocusEvent e) {
            edit.removeFocusListener(this);
            display();
        }
    };
    private final Set<EditListener> editListeners = Sets.newHashSet();
    private final JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
    private final JLabel display = new JLabel();
    private final JTextField edit = new JTextField();

    public DisplayAndEdit() {
        this.display.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        this.panel.add(display);
        this.panel.add(edit);
        this.edit.setVisible(false);
        this.display.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                edit();
            }
        });

        this.edit.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (KeyEvent.VK_ESCAPE == e.getKeyCode()) {
                    displayAndGrabFocus();
                } else if (KeyEvent.VK_ENTER == e.getKeyCode()) {
                    notifyEditListener();
                    displayAndGrabFocus();
                }

            }
        });
    }

    private void edit() {
        display.setVisible(false);
        edit.setText(display.getText());
        edit.setVisible(true);
        Dimension size = display.getSize();
        edit.setMinimumSize(size);
        edit.setPreferredSize(size);
        edit.setMaximumSize(size);
        edit.setCaretPosition(0);
        edit.setSelectionStart(0);
        edit.setSelectionEnd(Integer.MAX_VALUE);
        edit.requestFocusInWindow();
        edit.addFocusListener(endEditOnFocusLost);
    }

    private void displayAndGrabFocus() {
        display();
        display.requestFocusInWindow();
    }

    private void display() {
        edit.setVisible(false);
        display.setVisible(true);
    }

    public void addEditListener(EditListener editListener) {
        editListeners.add(editListener);
    }

    public void notifyEditListener(){
        for (EditListener editListener : editListeners) {
            editListener.edit();
        }
    }

    public String getUserEditedValue(){
        return edit.getText();
    }

    public void setText(String text){
        this.display.setText(text);
    }

    public JComponent component(){
        return panel;
    }
}