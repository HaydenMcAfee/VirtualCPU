package Computer;

import Computer.CPU;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class Driver {


    private static MMU mmu = new MMU();
    private static CPU cpu = new CPU();
    private static Process pcb[] = new Process[100];


    public static void main(String[] args) {

        loader(); //loads instructions into ram

//        while (cpu.getpCounter() != -1) {
//            char[] word = cpu.fetch(mmu, cpu.getpCounter());
//            String binaryString = cpu.decode(word);
//            cpu.execute(mmu, binaryString);
//        }
        mmu.DISKDump();
        //if instruction is HLT then pCounter = -1
        //coreDump(mmu);
    }
    //done




    static public void loader() {

        int jobNum;
        int instSize; //number of lines of instructions following
        int priority;
        int inputBuff;
        int outputBuff;
        int tempBuff;
        char[] tmp;
        String line;
        String[] info;
        int offset;
        int current = 0;

        try {
            Scanner in = new Scanner(new FileReader("instructions"));
            offset = 0;

            while (in.hasNext()) {
                //gets instruction attributes
                line = in.nextLine();
                info = line.split(" ");
                jobNum = utils.toDecimal(utils.hexToBinary(info[2].toCharArray()));
                instSize = utils.toDecimal(utils.hexToBinary(info[3].toCharArray()));
                priority = utils.toDecimal(utils.hexToBinary(info[4].toCharArray()));
                offset += instSize;

                //loads instructions
                for (int i = 0; i < instSize; ++i) {
                    line = in.nextLine();
                    line = (line.substring(2, 9));
                    tmp = line.toCharArray();
                    mmu.storeInit(tmp);
                }

                //gets data section attributes
                line = in.nextLine();
                info = line.split(" ");
                inputBuff = utils.toDecimal(utils.hexToBinary(info[2].toCharArray()));
                outputBuff = utils.toDecimal(utils.hexToBinary(info[3].toCharArray()));
                tempBuff = utils.toDecimal(utils.hexToBinary(info[4].toCharArray()));
                offset += (inputBuff + outputBuff + tempBuff);

                Process p = new Process(0,jobNum,0,0,instSize,priority,(inputBuff+instSize),(outputBuff+instSize),(tempBuff+instSize),current);

                pcb[jobNum-1] = p;

                current += offset;

                for (int i = 0; i < (inputBuff + outputBuff + tempBuff); ++i) {
                    line = in.nextLine();
                    line = (line.substring(2, 9));
                    tmp = line.toCharArray();
                    mmu.storeInit(tmp);
                }
                in.nextLine();
            }
        }
        catch (IOException except) {
            System.err.println("IO Exception caught!");
            except.printStackTrace();
        }

    }
}



//driver

//memory management unit specific class osml
//Space using dynamic array
//Write, load, and store from memory
//32 bit, 8 hex character storage
//

