package com.twinkle.JakSim.controller.mypage;

import com.twinkle.JakSim.model.dto.account.UserDto;
import com.twinkle.JakSim.model.service.account.AccountService;
import com.twinkle.JakSim.model.service.account.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping("/mypage/api")
@RequiredArgsConstructor
public class MypageRestApi {
    private final AccountService accountService;
    private final FileService fileService;
    @PostMapping("/auth")
    public String authPassword(@RequestBody UserDto userDto, @AuthenticationPrincipal User user){
        return accountService.checkPassword(user.getUsername(), userDto.getPw()) ? user.getUsername() : null;
    }
    @GetMapping("/sessiontime")
    public int getSessionTime(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            long currentTimeMills = System.currentTimeMillis();
            long lastAccessedTimeMills = session.getLastAccessedTime();
            int maxInactiveInterval = session.getMaxInactiveInterval();
            long elapsedTimeInSeconds = (currentTimeMills - lastAccessedTimeMills) / 1000;
            return maxInactiveInterval - (int) elapsedTimeInSeconds;
        }
        return 0;
    }

    @GetMapping("/user-info")
    public UserDetails getUserInfo(@AuthenticationPrincipal User user){
        return user;
    }

    @PutMapping("/profile/update")
    public boolean getData(@AuthenticationPrincipal User user, @RequestParam("file") MultipartFile data, @RequestParam("email") String email){
        System.out.println(data);
        System.out.println(email);

        return accountService.updateEmail(email, user.getUsername()) && fileService.updateProfileImage(data);
    }
}
