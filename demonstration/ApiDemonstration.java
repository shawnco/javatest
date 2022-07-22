package demonstration;
import java.io.*;
import java.net.*;

public class ApiDemonstration implements Demonstration {
    public static String getName() {
        return "API Demonstration";
    }

    public void announceName() {
        System.out.println("~~~ " + getName() + " ~~~");
    }

    String buildJson(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        int pointer;
        while ((pointer = reader.read()) != -1) {
            sb.append((char) pointer);
        }
        return sb.toString();
    }

    public void demonstrate() {
        announceName();
        try {
            String apiUrl = "https://restcountries.com/v3.1/alpha/US";
            InputStream input = new URL(apiUrl).openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String jsonText = buildJson(reader);
            System.out.println(jsonText);
            // I would like to convert it to a JSON object but this requires a 
            // third party library!
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
