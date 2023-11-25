package View;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Hack {
    private static Hack instance = null;
    private JRadioButton option1, option2;
    private JTextField[] textFields;
    private int x;
    private int y;
    private boolean enable;

    public static Hack getInstance(Tela tela, int xis, int ypsilon) {
        if (instance == null) {
            instance = new Hack(tela, xis, ypsilon);
        }
        return instance;
    }

    public Hack(Tela tela, int xis, int ypsilon) {
        this.x = xis;
        this.y = ypsilon;
        option1 = new JRadioButton("Ligado");
        option2 = new JRadioButton("Desligado");

        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        
        option2.setSelected(true);

        textFields = new JTextField[6];
        for (int i = 0; i < 6; i++) {
            textFields[i] = new JTextField(); 
            textFields[i].setHorizontalAlignment(JTextField.CENTER);
            textFields[i].setEnabled(false);
            ((AbstractDocument) textFields[i].getDocument()).setDocumentFilter(new NumberFilter(1));
        }

        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	enable = true;
                enableTextFields(enable);
            }
        });

        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	enable = false;
                enableTextFields(enable);
            }
        });

        option1.setBounds(10 + this.x, 10, 100, 30);
        option2.setBounds(10 + this.x, 50, 100, 30);

        for (int i = 0; i < 3; i++) {
            textFields[i].setBounds(this.x + (i+1) * 40, 10 + this.y, 30, 30);
        }
        JLabel textDefesa = new JLabel("D");
        Font largerFont = new Font(textDefesa.getFont().getName(), Font.PLAIN, 20);

        // Define a nova Fonte para o JTextArea
        textDefesa.setFont(largerFont);
        textDefesa.setBounds(this.x + 10 + 0 * 40, 10 + this.y, 30, 30);
        for (int i = 3; i < 6; i++) {
            textFields[i].setBounds(this.x + (i - 2) * 40, 50 + this.y, 30, 30);
        }
        JLabel textAtaque = new JLabel("A");
        textAtaque.setFont(largerFont);
        textAtaque.setBounds(this.x + 10 + 0 * 40, 50 + this.y, 30, 30);
        
        tela.add(textAtaque);
        tela.add(textDefesa);
        tela.add(option1);
        tela.add(option2);

        for (int i = 0; i < 6; i++) {
            tela.add(textFields[i]);
        }
    }

    private void enableTextFields(boolean enable) {
        for (int i = 0; i < 6; i++) {
            textFields[i].setEnabled(enable);
        }
    }
    
    public boolean get_active() {
    	return enable;
    }
    
    public List<Integer> get_text_fields(){
    	List<Integer> dados = new ArrayList<>();
    	for(JTextField textfield : textFields) {
    		if(textfield.getText().isEmpty()) {
    			dados.add(1);
    		} else {
    			dados.add(Integer.parseInt(textfield.getText()));
    		}
    	}
    	return dados;
    }

    private static class NumberFilter extends DocumentFilter {
    	private int maxLength;

        public NumberFilter(int maxLength) {
            this.maxLength = maxLength;
        }
    	
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                throws BadLocationException {
            if (isValid(string) && (fb.getDocument().getLength() + string.length() <= maxLength)) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            if (isValid(text) && (fb.getDocument().getLength() + text.length() - length <= maxLength)) {
                super.replace(fb, offset, length, text, attrs);
            }
        }

        private boolean isValid(String text) {
            try {
                int value = Integer.parseInt(text);
                return value >= 1 && value <= 6;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }
}
