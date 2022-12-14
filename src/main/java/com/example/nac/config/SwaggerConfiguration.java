package com.example.nac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    //Swagger 객체 생성
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.nac"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("국회 일정 어플리케이션 RESTful API")
                .description("구현된 API\n" +
                        "\n" +
                        "AccountController\n" +
                        "1. /changepassword/{id}: id에 해당하는 계정의 비밀번호를 변경\n" +
                        "2. /changeid/{curid}: curid에 해당하는 계정의 id를 변경\n" +
                        "3. /changeAccount/{curid}: curid에 해당하는 id로 개인정보를 수정\n" +
                        "\n" +
                        "CalenderController\n" +
                        "1. /calender/date/{date} :date에 해당하는 날자의 일정을 전부 가져옴 [입력 데이터 예시: 2022-10-25]\n" +
                        "2. /calender/month/{date} : date에 해당하는 날짜가 포함되는 월의 일정을 전부 가져옴[입력 데이터 예시: 2022-10-25]\n" +
                        "\n" +
                        "signupcontroller\n" +
                        "1. /SignUp/{id}: id를 사용해서 회원가입(자동으로 아이디/이메일 검사) 0: 정상입력 Errcode 1: 잘못된 입력, 2: 이미 있는 아이디/이메일\n" +
                        "2. /SignUp/isId/{id}: 해당 id로 가입한 이력이 있는지 확인\n" +
                        "3. /SignUp/isEmail/{email}: 해당 email로 가입한 이력이 있는지 확인\n" +
                        "\n" +
                        "logincontroller\n" +
                        "1. /Login/{id}: id를 사용해서 로그인 0: 정상입력 Errcode 1: 잘못된 입력, 2:존재하지 않는 ID 또는 ID, 비밀번호 불일치\n" +
                        "2. /Login/findid/{name}: name,email을 사용해서 ID를 찾음\n" +
                        "3. /Login/findpassword/{id}: id,security를 사용해서 렌덤한 비밀번호를 새로 부여받음\n" +
                        "\n" +
                        "\n" +
                        "일정을 분류해서 표현할 수 있어야함(/calender/month로 가져온 JSON정보중에 분류된 정보만을 표현하고 안되면 연락할것)\n"+
                        "분류 기준: 본회의, 위원회, 공청회, 국회의장, 국회부의장, 국회행사, 기자회견\n"+
                        "추가적인 분류 기준: 영화, 세미나(해당 일정은 시계열 표현에 상이점이 있어 연구가 필요함)\n")
                .version("1.0.0")
                .build();
    }
}
