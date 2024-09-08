//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.function.client.RestClient;
//
//@Configuration
//public class RestClientConfig {
//
//    @Bean
//    public RestClient restClient() {
//        return RestClient.builder().build();
//    }
//
//    public RestClient clientForBaseUrl(String baseUrl) {
//        return RestClient.builder()
//                .baseUrl(baseUrl)
//                .defaultHeader("Content-Type", "application/json")
//                .build();
//    }
//}
