package Computer;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MMU {

    //all private and nothing else can manage except for this class
    //Space using dynamic array
    Scanner s = new Scanner(System.in);
    private char[] DISK = new char[16384];
    private char[] RAM = new char[8192];
    private int currentLoad = 0;

    //object creation for having an existing array

    public char[] readRAM(int address) {
        char[] word = new char[8];
        for (int i = 0; i < 8; i++) {
            word[i] += RAM[address + i];
        }
        return word;
    }

    public char[] readDISK(int address) {
        char[] word = new char[8];
        for (int i = 0; i < 8; i++) {
            word[i] += RAM[address + i];
        }
        return word;
    }

    //these are the only functions that are going to be working on the ram
    public void writeRAM(char[] code, int address) {
        for (int i = 0; i < code.length; i++) {
            RAM[address + i] = code[i];

        }
    }

    public void writeDISK(char[] code, int address) {
        for (int i = 0; i < code.length; i++) {
            DISK[address + i] = code[i];

        }
    }


    public void storeRAM(char[] code, int address) {
        //sending what to be stored and where to store
        //two arguments
        writeRAM(code, address);
    }

    public void storeDISK(char[] code, int address) {
        //sending what to be stored and where to store
        //two arguments
        writeDISK(code, address);
    }

    public void storeInit(char[] code) {
        //does the storing of the initial loading of the data into the disk
        writeDISK(code, currentLoad);
        currentLoad += 8;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(int currentLoad) {
        this.currentLoad = currentLoad;
    }

    public char[] getDISK() {
        return DISK;
    }

    public void setDISK(char[] DISK) {
        this.DISK = DISK;
    }

    public void coreDump () {
        System.out.print("1. ");
        int counter1 = 0;
        int counter2 = 2;
        for(int i = 0; i < RAM.length; i++){
            counter1++;
            System.out.print(RAM[i]);
            if (counter1 == 8) {
                counter1 = 0;
                counter2++;
                System.out.println();
                System.out.print(counter2 + ". ");
            }
        }
    }

    public void DISKDump () {
        System.out.print("1. ");
        int counter1 = 0;
        int counter2 = 2;
        for(int i = 0; i < DISK.length; i++){
            counter1++;
            System.out.print(DISK[i]);
            if (counter1 == 8) {
                counter1 = 0;
                counter2++;
                System.out.println();
                System.out.print(counter2 + ". ");
            }
        }
    }

//    public void load(String filePointer) {
//        int ch; //initialization of counter for each character when iterating through textfile
//        FileReader datafile = null; //creates blank Filereader object
//
//        try {
//            datafile = new FileReader(filePointer); //stores file contents to FileReader object named datafile
//        } catch (IOException except) {
//            System.err.println("IO Exception caught! Enter a correct file name or input n to abort");
//            filePointer = s.next();
//            if (filePointer.length() == 1 && filePointer.charAt(0) == 'n') {
//                System.exit(0);
//            }
//
//        }
//
//        String fileText = "";
//
//        try {
//            while ((ch = datafile.read()) != -1) {
//                fileText += ((char) ch); //typecasting int into char
//            }
//        } catch (IOException except) {
//            System.err.println("IO Exception caught!");
//            except.printStackTrace();
//        }
//
//        char[] instrctArray = new char[fileText.length()];
//
//        for (int i = 0; i < fileText.length(); i++) {
//            instrctArray[i] = fileText.charAt(i);
//        }
//
//        setRAM(instrctArray);
//
//
//    }

}


//Write, load, and store from memory
//32 bit, 8 hex character storage