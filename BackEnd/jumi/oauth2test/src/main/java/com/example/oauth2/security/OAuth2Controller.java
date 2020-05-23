package com.example.oauth2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
public class OAuth2Controller {

    private static String authorizationRequestBaseUri = "oauth2/authorization";
    Map<String, String> oauth2AuthenticationUrls = new HashMap<>();

//    @Autowired
//    private ClientRegistrationRepository clientRegistrationRepository;
//    @Autowired
//    private OAuth2AuthorizedClientService authorizedClientService;
//
//    //oauth2 리스트 로그인 화면
//    @GetMapping("/oauth_login")
//    public String getLoginPage(Model model) {
//        Iterable<ClientRegistration> clientRegistrations = null;
//        ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository).as(Iterable.class);
//
//        if (type != ResolvableType.NONE && ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
//            clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
//        }
//
//        clientRegistrations.forEach(registration -> oauth2AuthenticationUrls.put(registration.getClientName(),
//                authorizationRequestBaseUri + "/" + registration.getRegistrationId()));
//        model.addAttribute("urls", oauth2AuthenticationUrls);
//
//
//        return "oauth_login";
//    }
//
//    @GetMapping("/loginSuccess")
//    public String getLoginInfo(Model model, OAuth2AuthenticationToken authentication) {
//
//        OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(authentication.getAuthorizedClientRegistrationId(), authentication.getName());
//
//        //client의 사용자 정보 엔드 포인트에 요청을 보내고, userAttributes 맵을 검색
//        String userInfoEndpointUri = client.getClientRegistration()
//                .getProviderDetails()
//                .getUserInfoEndpoint()
//                .getUri();
//
//        if (!StringUtils.isEmpty(userInfoEndpointUri)) {
//            RestTemplate restTemplate = new RestTemplate();
//            HttpHeaders headers = new HttpHeaders();
//            headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken()
//                    .getTokenValue());
//
//            HttpEntity<String> entity = new HttpEntity<String>("", headers);
//
//            ResponseEntity<Map> response = restTemplate.exchange(userInfoEndpointUri, HttpMethod.GET, entity, Map.class);
//            Map userAttributes = response.getBody();
//            model.addAttribute("name", userAttributes.get("name")); //name말고도 다른 속성들도 가져오기 가능
//        }
//
//        return "loginSuccess";
//    }

    // 메인화면
    @GetMapping({"", "/"})
    public String getAuthorizationMessage() {
        return "home";
    }

    // 로그인화면
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // 로그인성공
    @GetMapping({"/loginSuccess","/hello"})
    public String loginSuccess(Model model, OAuth2AuthenticationToken authentication) {
        OAuth2User userprinc = authentication.getPrincipal();
        Map<String, Object> userattr = userprinc.getAttributes();
        model.addAttribute("userID", userattr.values());
        return "hello";
    }

    // 로그인실패
    @GetMapping("/loginFailure")
    public String loginFailure() {
        return "loginFailure";
    }


    // 카카오 oauth 연결끊기(로그아웃X, 앱연결해제) 수정중
    @RequestMapping("/unlink")
    public String unlink() {
        return "redirect:login";
    }

}


