/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */

package hybridcryptfile;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
    

/**
 *
 * @author ashishranjan
 */
public class HybridCryptFile {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws org.apache.poi.openxml4j.exceptions.InvalidFormatException
     */
    public static void main(String[] args) throws IOException, InvalidFormatException {
        
        
        //Paragraph Extraction and Creation of .txt files from it
        int txtInd = 1;
        FileInputStream fis = new FileInputStream("test.docx");
        FileOutputStream fos = null;
	XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
        List<XWPFParagraph> paragraphList = xdoc.getParagraphs();
        for (XWPFParagraph paragraph : paragraphList) {
            fos = new FileOutputStream(txtInd+".txt");
            fos.write((paragraph.getText()).getBytes(), 0, (paragraph.getText()).length());
            fos.close();
            System.out.println(paragraph.getText());
            System.out.println("********************************************************************"+txtInd+".txt file created and written!");
            ++txtInd;
        }
        
        
        
//        sequencingFile f = new sequencingFile();
//        f.sequenceFind("file.txt");
        
        
        
        //Complete text Extraction from .docx file
//        FileInputStream fis = null;
//        FileOutputStream fos = null;
//        try {
//            fis = new FileInputStream("test.docx");
//            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
//            XWPFWordExtractor extractor;
//            extractor = new XWPFWordExtractor(xdoc);
//            fos = new FileOutputStream("file.txt");
//            String text = extractor.getText();
//            fos.write(text.getBytes(), 0, text.length());
//            fos.close();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(HybridCryptFile.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                fis.close();
//            } catch (IOException ex) {
//                Logger.getLogger(HybridCryptFile.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        
        //Images Extraction from .docx file
        fis = new FileInputStream("test.docx");
        xdoc = new XWPFDocument(OPCPackage.open(fis));
        List pic = xdoc.getAllPictures();
	if (!pic.isEmpty()) {
            System.out.print(pic.get(0));
	}
        Iterator iterator=pic.iterator();
        int i=0;
        while(iterator.hasNext()){
            XWPFPictureData pict;
            pict = (XWPFPictureData) iterator.next();
            byte[] bytepic=pict.getData();
            BufferedImage imag= ImageIO.read(new ByteArrayInputStream(bytepic));
            ImageIO.write(imag, "jpg", new File(i+".jpg"));
            ++i;
        }
    }
}
