package client;

import pojo.Invocation;
import service.BaseService;

import java.io.IOException;

public class Consumer {

    public static void main(String[] args) throws IOException {
        Invocation sayHello = new Invocation(BaseService.class.getName(), "sayHello", new Object[]{"myRPC client"}, new Class[]{String.class});

        HttpClient httpClient = new HttpClient();
        String res = httpClient.post("localhost", 8080, sayHello);
        System.out.println(res);

    }
}
