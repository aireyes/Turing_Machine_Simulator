package TuringMachine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BuiltInMachine {

    public String programming;

    public static String[] names =
            {
                    "Every 1, twice 0's",
                    "Binary numbers divisible by 3",
                    "One's complement",
            };

    void initializeComponents() {
        this.programming =
                "-1,0 2,X,>\n" +
                        "1,~ H,~,>\n" +
                        "2,0 3,X,>\n" +
                        "3,0 3,0,>\n" +
                        "3,1 3,1,>\n" +
                        "3,~ 4,~,<\n" +
                        "4,1 5,~,<\n" +
                        "5,0 5,0,<\n" +
                        "5,1 5,1,<\n" +
                        "5,X 1,X,>\n" +
                        "-";
    }

    public BuiltInMachine() {
        initializeComponents();
    }

    public void pick(String desc) throws IOException {
        if (desc.equals("Every 1, twice 0's")) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\airey\\Google Drive\\1ST TERM\\CS142\\Project\\Machines\\two0sone1-java.txt"));
            StringBuffer stringBuffer = new StringBuffer();
            String line = null;

            while((line =bufferedReader.readLine())!=null){

                stringBuffer.append(line).append("\n");
            }
            programming = stringBuffer.toString();
        }
        else if (desc.equals("Binary numbers divisible by 3")) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\airey\\Google Drive\\1ST TERM\\CS142\\Project\\Machines\\divisibleby3-java.txt"));
            StringBuffer stringBuffer = new StringBuffer();
            String line = null;

            while((line =bufferedReader.readLine())!=null){

                stringBuffer.append(line).append("\n");
            }
            programming = stringBuffer.toString();
        } else if (desc.equals("Binary numbers divisible by 3")) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\airey\\Google Drive\\1ST TERM\\CS142\\Project\\Machines\\divisibleby3-java.txt"));
            StringBuffer stringBuffer = new StringBuffer();
            String line = null;

            while((line =bufferedReader.readLine())!=null){

                stringBuffer.append(line).append("\n");
            }
            programming = stringBuffer.toString();
        }
    }

}
