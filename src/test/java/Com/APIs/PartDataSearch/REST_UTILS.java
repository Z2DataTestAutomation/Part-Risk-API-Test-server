package Com.APIs.PartDataSearch;

import org.apache.commons.lang3.RandomStringUtils;

public class REST_UTILS {

    public static String GetkeySearch() {
        String generateString = RandomStringUtils.randomAlphabetic(1);
        return ("bav99" + generateString);
    }

    public static String productID() {
        String generateString = RandomStringUtils.randomAlphabetic(5);
        return (0 + generateString);
    }

    public static String pagesize() {
        String generateString = RandomStringUtils.randomAlphabetic(5);
        return (1 + generateString);
    }

    public static String currentpage() {
        String generateString = RandomStringUtils.randomAlphabetic(5);
        return (1 + generateString);
    }

    public static String sortType() {
        String generateString = RandomStringUtils.randomAlphabetic(5);
        return ("desc" + generateString).toString();

    }

    public static String queryOperators() {
        String generateString = RandomStringUtils.randomAlphabetic(1);
        return ("BeginWith" + generateString);

    }
}