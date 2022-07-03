package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        try {
            File file = new File("D:\\GitHub\\AdvancedProgramming\\Lecture02\\src\\sample\\sample.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                break;
            }
            br.close();

            System.out.println("Output : " + st);
            Map<String, String> mapObject = Arrays.stream(st.split(","))
                    .map(s -> s.split(":"))
                    .collect(Collectors.toMap(s -> s[0], s -> s[1]));

            System.out.println(mapObject.toString());

            Map<String, String> filteredMap = mapObject.entrySet().stream()
                    .filter(x -> x.getKey().contains("tiletitle"))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            System.out.println(filteredMap.toString());

            for (Map.Entry<String, String> tmap : mapObject.entrySet()) {
                System.out.println("Key : " + tmap.getKey());
                System.out.println("Key : " + tmap.getValue());
                if (tmap.getKey().contains("tiletitle")) {
                    System.out.println("Do Something");
                }
            }
            List<String> list = new ArrayList<>();

            mapObject.forEach(
                    (key, value) -> {
                        if (key.contains("tiletitle")) {
                            list.add(key);
                        }
                        else if (key.contains("tiledesc")) {
                            list.add(key);
                        }
                        else if (key.contains("tiletype")) {
                            list.add(key);
                        }else{
                            System.out.println("mooditu iru");
                        }
                    }
            );
               System.out.println("Size : "+list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
