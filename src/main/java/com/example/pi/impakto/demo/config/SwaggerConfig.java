package com.example.pi.impakto.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import java.util.Arrays;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                        )
                )
                .info(new Info()
                        .title("Documentação API: impakto")
                        .version("V1")
                        .description(
                                "Documentação da API do projeto impakto\n" + //
                                "\n" + //
                                "A Impakto Outdoors é uma empresa especializada em\r\n" + //
                                                                        "publicidade outdoor, com foco na gestão e locação de\r\n" + //
                                                                        "outdoors em rodovias. Seu objetivo é maximizar a\r\n" + //
                                                                        "visibilidade das campanhas publicitárias dos nossos\r\n" + //
                                                                        "clientes por meio de uma presença estratégica em\r\n" + //
                                                                        "locais de alta circulação, garantindo que suas\r\n" + //
                                                                        "mensagens sejam vistas por um grande público\r\n" + //
                                                                        "diariamente."))
                .tags(
                    Arrays.asList(
                        new Tag().name("Usuário").description("Requisições entidade Usuario"),
                        new Tag().name("Cliente").description("Requisições da entidade Cliente"),
                        new Tag().name("Contrato").description("Requisições da entidade Contrato"),
                        // new Tag().name("Mapa").description("Requisições da entidade Mapa"),
                        new Tag().name("Notificação").description("Requisições da entidade Notificacao"),
                        new Tag().name("Outdoor").description("Requisições da entidade Outdoor"),
                        new Tag().name("Relatório").description("Requisições da entidade Relatorio"),
                        new Tag().name("Agendamento").description("Requisições da entidade Agendamento"),
                        new Tag().name("Login").description("Fazer login"),
                        new Tag().name("Cadastro").description("Fazer cadastro")
                    )
                );
    }
}
