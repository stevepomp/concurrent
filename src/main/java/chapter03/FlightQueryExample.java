package chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlightQueryExample {
    private static List<String> flightCompany = Arrays.asList("CSA", "CEA", "HNA");

    public static void main(String[] args) {
        List<String> results = search("SH", "BJ");
        System.out.println("======results======");
        results.forEach(System.out::println);
    }

    private static List<String> search(String origin, String destination) {
        final List<String> resultList = new ArrayList<>();
        List<FlightQueryTask> tasks = flightCompany.stream().map(f -> createSearchTask(f, origin, destination)).collect(Collectors.toList());
        tasks.forEach(Thread::start);

        tasks.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        tasks.stream().map(FlightQueryTask::get).forEach(resultList::addAll);
        return resultList;
    }

    private static FlightQueryTask createSearchTask(String flight, String origin, String destination) {
        return new FlightQueryTask(flight, origin, destination);
    }
}
