package ch.bbw.m183.vulnerapp;

import ch.bbw.m183.vulnerapp.datamodel.BlogEntity;
import ch.bbw.m183.vulnerapp.datamodel.UserEntity;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.UUID;

@SpringBootTest
class VulnerApplicationTests {

    @Test
    void contextLoads() {
    }
}

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VulnerApplicationTestsSecond implements WithAssertions {
    @Autowired
    WebTestClient webTestClient;

    @Test
    void blogsArePublic() {
        webTestClient.get().uri("/api/blog")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void createBlog() {
        // Prepare test data
        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setTitle("Test");
        blogEntity.setBody("<img src=a onerror='alert();'>");

        webTestClient.post().uri("/api/blog")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(blogEntity)
                .exchange()
                .expectStatus().isForbidden();
    }

    @Test
    void createUser() {
        // Prepare test data
        UserEntity newUser = new UserEntity();
        newUser.setUsername("test");
        newUser.setFullname("test tester");
        newUser.setPassword("tesst");

        webTestClient.post().uri("/api/admin123/create")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(newUser)
                .exchange()
                .expectStatus().isForbidden();
    }
}