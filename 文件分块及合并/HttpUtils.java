package test3;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Response;
import org.asynchttpclient.request.body.multipart.FilePart;
import org.asynchttpclient.request.body.multipart.StringPart;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.asynchttpclient.Dsl.*;

public class HttpUtils {
    private AsyncHttpClient asyncHttpClient;

    public HttpUtils() {
        this(asyncHttpClient());
    }

    public HttpUtils(AsyncHttpClient asyncHttpClient) {
        this.asyncHttpClient = asyncHttpClient;
    }

    public String uploadFile(String filePath) throws ExecutionException, InterruptedException {
        // bound
        Future<Response> whenResponse = asyncHttpClient.preparePost("https://catbox.moe/user/api.php")
                .addBodyPart(new StringPart("reqtype", "fileupload"))
                .addBodyPart(new StringPart("userhash", ""))
                .addBodyPart(new FilePart("fileToUpload", new File(filePath)))
                .execute();
        return whenResponse.get().getResponseBody();
    }
}
