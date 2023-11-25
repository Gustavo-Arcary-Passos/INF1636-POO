package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ViewSave {
	private static ViewSave instance = null;
	private JButton salvar;

    public static ViewSave getInstance(Tela tela) {
        if (instance == null) {
            instance = new ViewSave (tela);
        }
        return instance;
    }
    
    public ViewSave (Tela tela) {
    	this.salvar = new JButton("Save");
    	this.salvar.setBounds(1024 + 25, 500, 100, 30);
    	this.salvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("CLICOU!");
			}
        });
    	tela.add(salvar);
    }
    
    public JButton get_button() {
    	return this.salvar;
    }
    
    public void set_saving(boolean status) {
    	this.salvar.setEnabled(status);
    }
    
    public boolean get_saving() {
    	return this.salvar.isEnabled();
    }
}
