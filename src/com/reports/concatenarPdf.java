package com.reports;

import com.lowagie.text.pdf.PdfCopyFields;
import com.lowagie.text.pdf.PdfReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class concatenarPdf {

    public String rutaFUMP;

    private byte[] concatenarPdf(List<byte[]> pdfBytes) throws Exception {

// Path del fichero temporal
        // Inicia el JFileChooser
        JFileChooser fc = new JFileChooser();
        // Se crea un filtro de extensiones para que solamente pueda seleccionar archivos PDF
        FileFilter ff = new FileNameExtensionFilter("Archivo PDF", "pdf");
        // Se asigna el filtro al objeto JFileChooser
        fc.setFileFilter(ff);
        // Se muestra la ventana de JFilChooser
        int opcionav = fc.showOpenDialog(new JFrame());
        if (opcionav == JFileChooser.APPROVE_OPTION) {
            File archivoPDF = fc.getSelectedFile();
            rutaFUMP = archivoPDF.getAbsolutePath();
        }
        // Se asigna el archivo seleccionado a un objeto tipo File

// Creamos el fichero pdf necesario.
        FileOutputStream file = new FileOutputStream(rutaFUMP);

// Objeto reader para añadir los pdf.
        PdfReader reader = null;

// Objeto para concatenar los pdf.
        PdfCopyFields copy = new PdfCopyFields(file);

// tamaño total de bytes
        int tam = 0;

// Recorremos los bytes y los vamos concatenando.
        for (byte[] pdfByte : pdfBytes) {
            tam += pdfByte.length;
            reader = new PdfReader(pdfByte);
            copy.addDocument(reader);
        }

        copy.close();

        FileInputStream archivo = new FileInputStream(rutaFUMP);

        byte[] bytesFinal = new byte[tam];

        int c = 0;
        int i = 0;
// Leemos y vamos añadiendo al array de bytes final.
        while ((c = archivo.read()) != -1) {
            bytesFinal[i] = (byte) c;
            i++;
        }
// Cerramos.
        archivo.close();
        file.close();
        File f = new File(rutaFUMP);
// Borramos el fichero.
        if (f.exists()) {
            f.delete();
        }
        return bytesFinal;
    }
}
