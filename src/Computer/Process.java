package Computer;

public class Process {

    //status id's
    //NEW = 0
    //RUNNING = 1
    //WAITING = 2
    //READY = 3
    //TERMINATED = 4

    public static int getPc() {
        return pc;
    }

    public static void setPc(int pc) {
        Process.pc = pc;
    }

    public static int getProcess_id() {
        return process_id;
    }

    public static void setProcess_id(int process_id) {
        Process.process_id = process_id;
    }

    public static int getCpu_id() {
        return cpu_id;
    }

    public static void setCpu_id(int cpu_id) {
        Process.cpu_id = cpu_id;
    }

    public static int getStatus() {
        return status;
    }

    public static void setStatus(int status) {
        Process.status = status;
    }

    public static int getInstSize() {
        return instSize;
    }

    public static void setInstSize(int instSize) {
        Process.instSize = instSize;
    }

    public static int getPriority() {
        return priority;
    }

    public static void setPriority(int priority) {
        Process.priority = priority;
    }

    public static int getInputBuff() {
        return inputBuff;
    }

    public static void setInputBuff(int inputBuff) {
        Process.inputBuff = inputBuff;
    }

    public static int getOutputBuff() {
        return outputBuff;
    }

    public static void setOutputBuff(int outputBuff) {
        Process.outputBuff = outputBuff;
    }

    public static int getTempBuff() {
        return tempBuff;
    }

    public static void setTempBuff(int tempBuff) {
        Process.tempBuff = tempBuff;
    }

    public static int getAddrsOff() {
        return addrsOff;
    }

    public static void setAddrsOff(int addrsOff) {
        Process.addrsOff = addrsOff;
    }

    private static int pc;
    private static int process_id;
    private static int cpu_id;
    private static int status;
    private static int instSize; //instruction size
    private static int priority;
    private static int inputBuff; //local address
    private static int outputBuff; //local address
    private static int tempBuff; //local address
    private static int addrsOff;//address offset

    Process () {}

    Process (
                int pc,
                int process_id,
                int cpu_id,
                int status,
                int instSize, //instruction size
                int priority,
                int inputBuff, //local address
                int outputBuff, //local address
                int tempBuff, //local address
                int addrsOff //address offset
        ) {}
}
