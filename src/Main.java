import com.sun.jdi.Value;
import org.javatuples.Pair;

import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.print("Input: ");
            String value  = sc.next();
            if (!value.equals("") && value.toLowerCase().charAt(0) == 'q') {
                break;
            }
            if(containsNumber(value))
            {
                var list = ConvertToList(value);
                var sortedList = SortedList(list);
                var countChars = CountChars(sortedList);
                countChars.forEach(c ->{
                    System.out.println(c.getValue0() + " appear " + c.getValue1() + " times");
                });
            }else
                System.out.println("Value mus be from A-Z - a-z");
        }
    }
    static List<Character> ConvertToList(String word)
    {
        return word.toLowerCase().chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }

    static List<Character> SortedList(List<Character> characterList)
    {
      return characterList.stream().sorted().collect(Collectors.toList());
    }

    static ArrayList<Pair<Character, Integer>> CountChars(List<Character> characterList)
    {
        ArrayList<Pair<Character, Integer>> countedChars = new ArrayList<Pair<Character, Integer>>();

        Integer count = 0;
        for (int i = 0; i < characterList.size(); i++) {
            if ((i < characterList.size() - 1) && (characterList.get(i) == characterList.get(i + 1)))
            {
                count++;
            }
            else {
                count++;
                countedChars.add(new Pair<>(characterList.get(i), count));
                count = 0;
            }
        }
        return countedChars;
    }
    static boolean containsNumber(String s)
    {
        return  s != null && s.chars().allMatch(Character::isAlphabetic);
    }
}
