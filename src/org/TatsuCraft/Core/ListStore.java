package org.TatsuCraft.Core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListStore {
 
    private File storageFile;
    private ArrayList<String> vaules;
   
    public ListStore(File file){
        this.storageFile = file;
        this.vaules = new ArrayList<String>();
       
        if (this.storageFile.exists() ==false){
            try {
                this.storageFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
           
        }
       
    }
    public void load(){
        try {
            DataInputStream imput = new DataInputStream(new FileInputStream(this.storageFile));
            BufferedReader reader = new BufferedReader(new InputStreamReader(imput));
           
            String line;
           
            while ((line = reader.readLine()) != null) {
                if (this.vaules.contains(line) == false) {
                    this.vaules.add(line);
                }
            }
            reader.close();
            imput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        public void save(){
            try {
                FileWriter stream = new FileWriter(this.storageFile);
                BufferedWriter out = new BufferedWriter(stream);
                               
                for (String vaulue : this.vaules){
                    out.write(vaulue);
                    out.newLine();  
                }
               
                out.close();
                stream.close();
               
            } catch (IOException e) {
                e.printStackTrace();
            }
           
    }
    public boolean contains(String value){
        return this.vaules.contains(vaules);
    }
   
    public void add(String value){
        if (this.contains(value) == false){
        this.vaules.add(value);
        }
    }
    public void remove(String value){
        this.vaules.remove(value);
   
    }
   
    public ArrayList<String> getValues(){
        return this.vaules;
    }
}