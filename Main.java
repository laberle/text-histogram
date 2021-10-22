import java.util.Map;
import java.util.TreeMap;

class Main {

    private static long WIDTH = 50L;
    private static String DEFAULT_CHARACTER = "█";

    public static void main(String[] args) {
        Map<String, Long> map = initializeMap();
        System.out.println(HistogramUtils.buildHistogram(map, WIDTH, DEFAULT_CHARACTER));
    }

    private static Map<String, Long> initializeMap() {
        Map<String, Long> map = new TreeMap<>();
        map.put("1", 1L);
        map.put("2", 2L);
        map.put("3", 3L);
        map.put("99.999", 100L);
        return map;
    }
}
