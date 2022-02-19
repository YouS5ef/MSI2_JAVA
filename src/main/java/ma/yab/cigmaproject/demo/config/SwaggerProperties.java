package ma.yab.cigmaproject.demo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@ConfigurationProperties(prefix = "swagger.ui")
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class SwaggerProperties {
    String title = "Users manager";
    String description = "Add and Users list";
    String version = "0.0.7";
    String contactName = "Youssef ABERRAH";
    String contactEmail = "youssef.aberrah@gmail.com";
    String contactUrl = "http://youssefAB.com";

}
