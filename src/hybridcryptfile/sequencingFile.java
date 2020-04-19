/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hybridcryptfile;
import java.io.*;
import java.util.*;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
    

/**
 *
 * @author ashishranjan
 */
public class sequencingFile {
    
    
    public void createNewDoc(String fileN) throws FileNotFoundException, IOException{
        XWPFDocument document = new XWPFDocument(); 
        try (FileOutputStream fos = new FileOutputStream( new File(fileN+".docx"))) {
            document.write(fos);
        }catch(FileNotFoundException x){
            System.out.println("File Not Found!");
        }
        System.out.println("Document created successully");
    }
    
    public void insertParts(/*String textFile,*/ String docxFile) throws FileNotFoundException, IOException{
        XWPFDocument document = new XWPFDocument(); 
        FileOutputStream fos = new FileOutputStream(docxFile+".docx");
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("tempor orci eu lobortis elementum nibh tellus molestie nunc non blandit massa enim nec dui nunc mattis enim ut tellus elementum sagittis vitae et leo duis ut diam quam nulla porttitor massa id neque aliquam vestibulum morbi blandit cursus risus at ultrices mi tempus imperdiet nulla malesuada pellentesque elit eget gravida cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus mauris vitae ultricies leo integer malesuada nunc vel risus commodo viverra maecenas accumsan lacus vel facilisis volutpat est velit egestas dui id ornare arcu odio ut sem nulla pharetra diam sit amet nisl suscipit adipiscing bibendum est");
        run.addBreak();
        run.setText("tempor orci eu lobortis elementum nibh tellus molestie nunc non blandit massa enim nec dui nunc mattis enim ut tellus elementum sagittis vitae et leo duis ut diam quam nulla porttitor massa id neque aliquam vestibulum morbi blandit cursus risus at ultrices mi tempus imperdiet nulla malesuada pellentesque elit eget gravida cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus mauris vitae ultricies leo integer malesuada nunc vel risus commodo viverra maecenas accumsan lacus vel facilisis volutpat est velit egestas dui id ornare arcu odio ut sem nulla pharetra diam sit amet nisl suscipit adipiscing bibendum est");
        run.addBreak();
        document.write(fos);
        fos.close();
    }
    
    public void insertPic(String imgFile){
        
    }
    
}
