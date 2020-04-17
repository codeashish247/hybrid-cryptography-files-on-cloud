/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hybridcryptfile;
import java.io.*;
import java.util.*;
    

/**
 *
 * @author ashishranjan
 */
public class sequencingFile {
    public void sequenceFind(String fileN) throws FileNotFoundException, IOException{
        try{
            //COunting size of each paragraph
            char ch;
            int i,charCount=0;
            FileReader fr = new FileReader(fileN);
            while((i=fr.read())!=-1){
                if(i==10){
                    System.out.println(charCount);
                    charCount=0;
                }else{
                    ++charCount;
                    System.out.print((char)i);
                }
            }
        }catch(FileNotFoundException fe){
            System.out.println("File Not Found!");
        }  
    }
}
