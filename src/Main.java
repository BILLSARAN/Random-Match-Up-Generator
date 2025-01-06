import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args){

        Contestants contestants = new Contestants();
        try(BufferedReader in = new BufferedReader(new FileReader("contestants.txt"))){
            String s;
            while((s = in.readLine())!=null){
                contestants.getContestants().add(s);
            }
        } catch(IOException e){
            System.out.println("Not found");
        }

        ArrayList<String> temp = new ArrayList<>(contestants.getContestants());
        Collections.shuffle(temp);

        if(contestants.getContestants().size() % 2 == 0) {
            try (BufferedWriter out = new BufferedWriter((new FileWriter("battles.txt")))) {
                for (int i = 0; i < temp.size(); i += 2) {
                    out.write(temp.get(i) + " vs " + temp.get(i + 1));
                    out.write("\n");
                }
            } catch (IOException e) {
                System.out.println("Not found");
            }
        }
        else{
            try (BufferedWriter out = new BufferedWriter((new FileWriter("battles.txt")))) {
                for (int i = 0; i < temp.size()-1; i += 2) {
                    out.write(temp.get(i) + " vs " + temp.get(i + 1));
                    out.write("\n");
                }
                out.write("No opponent for " + temp.get(temp.size()-1));
            } catch (IOException e) {
                System.out.println("Not found");
            }
        }


    }
}