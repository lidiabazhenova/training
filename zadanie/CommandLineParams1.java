public class CommandLineParams1 {
    public static void main(String[] args) {

        for (int i = args.length-1; i >= 0; i--) {
            System.out.println("Аргумент " + (i+1) + " = " + args[i]);
        }
    }
}