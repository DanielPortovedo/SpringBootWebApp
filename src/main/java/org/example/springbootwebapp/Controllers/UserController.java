package org.example.springbootwebapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @GetMapping("/userinfo")
    public String displayUserInfo(@RequestHeader(name = "cookie", required = false) String cookie,
                                  @RequestHeader Map<String, String> headers,
                                  Model model) {
        HashMap<String, String> cookies = new HashMap<>();

        if(cookie != null) {
            final String[] cookieParts = cookie.split(";");

            for (String cookiePart : cookieParts) {
                String[] keyValue = cookiePart.trim().split("=");
                if (keyValue.length == 2) {
                    cookies.put(keyValue[0], keyValue[1]);
                }
            }
        }

        model.addAttribute("cookies", cookies);
        model.addAttribute("headers", headers);

        return "userinformation";

    }
}
