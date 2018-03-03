package zuul.fallback;

 import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;


import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

 @Component
public class ZuulFallBack implements ZuulFallbackProvider {

	@Override
	public ClientHttpResponse fallbackResponse() {
	
		return new ClientHttpResponse(){

			@Override
			public InputStream getBody() throws IOException {
 				return  new ByteArrayInputStream("改微服务不可用，请稍后再试！".getBytes());
			}

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders head=new HttpHeaders();
				MediaType mt= new MediaType("application","json",Charset.forName("UTF-8"));
				head.setContentType(mt);
				return head;
			}

			@Override
			public void close() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public int getRawStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return this.getStatusCode().value();
			}

			@Override
			public HttpStatus getStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return  HttpStatus.OK;
			}

			@Override
			public String getStatusText() throws IOException {
				// TODO Auto-generated method stub
				return  this.getStatusCode().getReasonPhrase();
			}
			
			
			
		};
	}
   /**
    * 回退的微服务
    */
	@Override
	public String getRoute() {
 		return "microservice-simple-provider-user-eureka-mytadata";
	}

}
