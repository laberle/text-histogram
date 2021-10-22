import java.util.Collections;
import java.util.Map;

class HistogramUtils {

    private static Long getMaxValue(Map<String, Long> map) {
        return Collections.max(map.values());
    }

    private static int getMaxKeyLength(Map<String, Long> map) {
        int longest = 0;
        for (String string : map.keySet()) {
            if (string.length() > longest) {
                longest = string.length();
            }
        }
        return longest;
    }

    private static int normalize(long value, long maxValue, long normalizeTo) {
        double normalizedLong = (double) (value * normalizeTo) / maxValue;
        return (int) Math.round(normalizedLong);
    }

    private static String padString(String stringToPad, int length) {
        return String.format("%-" + length + "s", stringToPad);
    }

    public static String buildHistogram(Map<String, Long> map, long width, String character) {
        Long maxValue = getMaxValue(map);
        int maxValueStringLength = maxValue.toString().length();
        int maxKeyStringLength = getMaxKeyLength(map);

        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, Long> entry : map.entrySet()) {
            stringBuilder.append(padString(entry.getKey(), maxKeyStringLength));
            stringBuilder.append(" | ");
            stringBuilder.append(padString(entry.getValue().toString(), maxValueStringLength));
            stringBuilder.append(" | ");
            stringBuilder.append(character.repeat(normalize(entry.getValue(), maxValue, width)));
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

}
