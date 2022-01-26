import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Get {
    public static final String URL_GET= "https://jsonplaceholder.typicode.com/posts";
    public static void main(String[] args) throws IOException, InterruptedException {
        //Cria o cliente
        HttpClient client = HttpClient.newHttpClient();

        //cria a requisição
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(URL_GET))
                .build();

        //Envia uma solicitação
        HttpResponse response= client.send(request,HttpResponse.BodyHandlers.ofString());

        System.out.println(response);
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}
