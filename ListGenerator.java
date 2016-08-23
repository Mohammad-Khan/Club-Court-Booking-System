/**
 * The following class has been obtained from open source work available on internet on the following site
 * at http://stackoverflow.com/questions/699878/is-there-an-easy-way-to-output-two-columns-to-the-console-in-java
 * This class is responsible for making a list in arranged manner and order.
 * The idea of this class is taken from a stackoverflow answer by CandiedOrange 
 * @author CandiedOrange
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;  

public class ListGenerator {

    List<List<String>> lines = new ArrayList<>();
    List<Integer> maxLengths = new ArrayList<>();
    int numColumns = -1;

    public ListGenerator addLine(String... line) {

        if (numColumns == -1){
            numColumns = line.length;
            for(int i = 0; i < numColumns; i++) {
                maxLengths.add(0);
            }
        }

        if (numColumns != line.length) {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < numColumns; i++) {
            maxLengths.set(  i, Math.max( maxLengths.get(i), line[i].length() )  );
        }

        lines.add( Arrays.asList(line) );

        return this;
    }

    public void print(){
        System.out.println( toString() );
    }

    public String toString(){
        String result = "";
        for(List<String> line : lines) {
            for(int i = 0; i < numColumns; i++) {
                result += pad( line.get(i), maxLengths.get(i) + 1 );                
            }
            result += System.lineSeparator();
        }
        return result;
    }

    private String pad(String word, int newLength){
        while (word.length() < newLength) {
            word += " ";            
        }       
        return word;
    }
}