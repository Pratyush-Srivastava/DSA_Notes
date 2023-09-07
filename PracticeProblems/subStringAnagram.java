package PracticeProblems;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class subStringAnagram {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long count=0;

        HashMap<Long,Long> map=new HashMap<Long,Long>();
        for(long i=0;i<arr.size();i++){
            long e=arr.get((int)i);
            if(!map.containsKey(e))
            map.put(e,new Long(1));
            else{
                map.put(e,map.get(e)+1);
            }

        }
        System.out.println(map);
        for(Map.Entry<Long,Long> entry: map.entrySet()){
            Long x=entry.getKey();
            Long y=entry.getValue();
            if(r==1){
                count+=((y*(y-1)*(y-2))/6);
            }else{
                if(map.containsKey(x*r) && map.containsKey(x*r*r)){
                count+=(y*map.get(x*r)*map.get(x*r*r));
            }

            }

        }



//    System.out.println(count);
    return count;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        System.out.println(String.valueOf(ans));
       
       }
}
