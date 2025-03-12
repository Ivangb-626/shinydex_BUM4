package eus.ehu.pokemon;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.net.URISyntaxException;
import java.net.URL;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {

    public static String readFile(String filename) {
        String content = "";
        try {
            URL fileURL = Utils.class.getResource(filename);
            if (fileURL != null) {
                content = new String(Files.readAllBytes(Paths.get(fileURL.toURI())));
            } else {
                System.err.println("File not found: " + filename);
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return content;
    }


    public static String query (String url){

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()){
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


