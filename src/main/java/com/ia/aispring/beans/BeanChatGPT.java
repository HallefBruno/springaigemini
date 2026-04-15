package com.ia.aispring.beans;
public class BeanChatGPT {

//    //@Bean
//    public RestClientCustomizer restClientCustomizer() throws Exception {
//        SSLContext sslContext = SSLContexts.custom()
//			.loadTrustMaterial(null, (cert, authType) -> true)
//			.build();
//
//        CloseableHttpClient httpClient = HttpClients.custom()
//			.setConnectionManager(PoolingHttpClientConnectionManagerBuilder.create()
//				.setTlsSocketStrategy(new DefaultClientTlsStrategy(sslContext, NoopHostnameVerifier.INSTANCE))
//				.build())
//			.build();
//
//        return restClientBuilder -> restClientBuilder.requestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
//    }
//
//    //@Bean
//    public ChatClient chatClient(ChatClient.Builder builder) {
//        return builder.build();
//    }
}
