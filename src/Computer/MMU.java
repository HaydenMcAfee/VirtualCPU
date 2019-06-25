package Computer;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class MMU {

    //all private and nothing else can manage except for this class

    //Space using dynamic array

    Scanner s = new Scanner(System.in);

    public char[] getRAM() {
        return RAM;
    }

    public void setRAM(char[] RAM) {
        this.RAM = RAM;
    }

    char[] RAM = new char[1000];

    //object creation for having an existing array

    public char[] read(int address) {
        char[] word = new char[8];
        for (int i = 0; i < 8; i++) {
            word[i] += RAM[address + i];
        }
        return word;
    }

    //these are the only functions that are going to be working on the ram
    public void write(char[] code, int address) {
        for (int i = 0; i < code.length; i++) {
            RAM[address + i] += code[i];

        }
    }

    public void store(char[] code, int address) {
        //sending what to be stored and where to store
        //two arguments
        write(code, address);
    }

    public void load(String filePointer) {
        int ch; //initialization of counter for each character when iterating through textfile
        FileReader datafile = null; //creates blank Filereader object
        try {
            datafile = new FileReader(filePointer); //stores file contents to FileReader object named datafile
        } catch (IOException except) {
            System.err.println("IO Exception caught! Enter a correct file name or input n to abort");
            filePointer = s.next();
            if (filePointer.length() == 1 && filePointer.charAt(0) == 'n') {
                System.exit(0);
            }

        }

        String fileText = "";

        try {
            while ((ch = datafile.read()) != -1) {
                fileText += ((char) ch); //typecasting int into char
            }
        } catch (IOException except) {
            System.err.println("IO Exception caught!");
            except.printStackTrace();
        }

        char[] instrctArray = new char[fileText.length()];
        for (int i = 0; i < fileText.length(); i++) {
            instrctArray[i] = fileText.charAt(i);
        }
        setRAM(instrctArray);
    }
}

//Write, load, and store from memory
//32 bit, 8 hex character storage