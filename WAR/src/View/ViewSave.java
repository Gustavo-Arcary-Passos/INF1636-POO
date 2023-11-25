package View;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ViewSave {
    private static ViewSave instance = null;
    private JButton salvar;
    private JFileChooser fileChooser;
    private boolean primeiroClique = true;
    private java.io.File selectedFile;
    
    public void set_file_selected(java.io.File file){
    	this.selectedFile = file;
    	this.primeiroClique = false;
    }

    public static ViewSave getInstance(Tela tela) {
        if (instance == null) {
            instance = new ViewSave(tela);
        }
        return instance;
    }

    public ViewSave(Tela tela) {
        this.salvar = new JButton("Save");
        this.salvar.setBounds(1024 + 25, 500, 100, 30);

        this.fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de texto (.txt)", "txt");
        this.fileChooser.setFileFilter(filter);
        /**
        this.salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (primeiroClique) {
                	System.out.println("SUAVE!");
                    criarNovoArquivo();
                    primeiroClique = false;
                } else { 
                	salvarDadosNoArquivo();
                }
            }
        });**/
        tela.add(salvar);
    }

    public void criarNovoArquivo(String texto) {
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            this.selectedFile = fileChooser.getSelectedFile();
            garantirExtensaoTxt();
            salvarDadosNoArquivo(texto);
        } else {
            System.out.println("Nenhum arquivo selecionado.");
        }
    }
    
    private void garantirExtensaoTxt() {
        String filePath = selectedFile.getAbsolutePath();
        if (!filePath.toLowerCase().endsWith(".txt")) {
            selectedFile = new java.io.File(filePath + ".txt");
        }
    }

    public void salvarDadosNoArquivo(String texto) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile))) {
            writer.write(texto);
            System.out.println("Dados salvos no arquivo: " + selectedFile.getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
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
    
    public void set_clique(boolean status) {
        this.primeiroClique = status;
    }

    public boolean get_clique() {
        return this.primeiroClique;
    }
}
