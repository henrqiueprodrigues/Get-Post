import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;

public class Post {

    public static final String URL_POST= "https://httpbin.org/forms/post";
    public static final String FILE= "C:/Users/Henrique/Documents/Codigod intellij/GetPost/TestePost.jason";

    public static void main(String[] args) throws IOException, InterruptedException {
        //Cria o cliente
        HttpClient client = HttpClient.newHttpClient();

        //cria a requisição
        HttpRequest request = HttpRequest.newBuilder()
                //.POST(HttpRequest.BodyPublishers.ofFile(Path.of(FILE))) causa um erro por causa de metodo não permititdo (405)
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(URL_POST))
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}
