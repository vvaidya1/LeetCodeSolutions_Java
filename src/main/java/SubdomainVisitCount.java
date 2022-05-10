import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/subdomain-visit-count/
 * O(n) time | O(n) space where n is length of cpdomains
 */
public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        if (cpdomains == null || cpdomains.length == 0)
            return new ArrayList<>();

        List<String> result = new ArrayList<>();
        Map<String, Integer> frequency = new HashMap<>();
        for (String str : cpdomains) {
            String[] cpdomain = str.split(" ");
            String[] domain = cpdomain[1].split("\\.");
            int count = Integer.parseInt(cpdomain[0]);

            String current = "";
            for (int i = domain.length - 1; i >= 0; --i) {
                current = domain[i] + (i < domain.length - 1 ? "." : "") + current;
                frequency.put(current, frequency.getOrDefault(current, 0) + count);
            }
        }

        frequency.forEach((key, value) -> result.add(value + " " + key));
        return result;
    }
}
