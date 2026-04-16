package com.ia.aispring.beans;

import com.google.genai.Client;
import javax.net.ssl.SSLContext;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.ssl.DefaultClientTlsStrategy;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.core5.ssl.SSLContexts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

@Configuration
public class GeminiConfig {

    @Value("${gemini.api.key}")
    private String apiKey;

    @Bean
    public Client geminiClient() {
        return Client.builder()
			.apiKey(apiKey)
			.build();
    }
	
	@Bean
	public RestClientCustomizer restClientCustomizer() throws Exception {
		SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, (cert, authType) -> true).build();

		org.apache.hc.client5.http.impl.classic.CloseableHttpClient httpClient = HttpClients.custom()
			.setConnectionManager(PoolingHttpClientConnectionManagerBuilder.create()
				.setTlsSocketStrategy(new DefaultClientTlsStrategy(sslContext, NoopHostnameVerifier.INSTANCE))
				.build())
			.build();

		return restClientBuilder -> {
			restClientBuilder.requestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
		};
	}

}
