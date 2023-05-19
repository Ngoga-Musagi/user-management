package com.z.platform.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.z.platform.dto.UserDto;
import com.z.platform.exception.UserNotFoundException;
import com.z.platform.model.User;
import com.z.platform.repository.UserRepository;
import com.z.platform.service.UserService;
import com.z.platform.service.UserServices;
import com.z.platform.util.FileUploadUtil;
import com.z.platform.util.Utility;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import net.bytebuddy.utility.RandomString;
@Controller
public class AccountVerificationController {

	@Autowired
    private UserService userService;
	@Autowired
	UserRepository repo;
     
    @GetMapping("/verify_account")
    public String showForgotPasswordForm() {
 
    	return "verify_account";
    }
 
    @PostMapping("/verify_account")
    public String processForgotPassword(HttpServletRequest request, Model model) {
    	String email = request.getParameter("email");
//        String token = RandomString.make(30);
         
        try {
            User user=userService.findByEmail(email);
//            String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
//            sendEmail(email, resetPasswordLink);
            
             model.addAttribute("user", user);            
        
        } catch (Exception e) {
            model.addAttribute("error", "Error while searching User email");
        }
             
        return "verification_form";
    }
    @PostMapping("/users/save")
    public RedirectView saveUser(User user,
            @RequestParam("image") MultipartFile multipartFile) throws IOException {
         
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        user.setPhotos(fileName);
         
        repo.update(fileName,user.getEmail());
 
        String uploadDir = "user-photos/" + user.getId();
 
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
         
        return new RedirectView("/verified", true);
    }
    
    @GetMapping("/verified")
    public String listRegisteredUsers(Model model){
        
        return "verified";
    }
}
