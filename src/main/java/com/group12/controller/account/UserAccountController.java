package com.group12.controller.account;

/**  Author: Rachael Klein
 *   Student no: 218 057 377
 *   Date: 21-09-2020
 *   Description: Controller for UserAccount
 */

import com.group12.entity.UserAccount;
import com.group12.factory.UserAccountFactory;
import com.group12.service.account.UserAccountService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/userAccount")
public class UserAccountController {

    //have to call userAccount service
    //wired means i am injecting the constructor of service into UserAccount class
    @Autowired
    private UserAccountService userAccountService; // made UserAccountService annotated with Service

    //Business logic 1
    @PostMapping("/create")
    public ResponseEntity<UserAccount> create(@RequestBody UserAccount userAccount) {
        try {
            UserAccount newUserAccount = UserAccountFactory.createUserAccount(userAccount.getEmail(), userAccount.getPassword(),
                    userAccount.isLoginStatus(), userAccount.getRegisterDate());

            return ResponseEntity.ok(userAccountService.create(newUserAccount));
        }catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Business logic 2
    @GetMapping("/read")
    public ResponseEntity<UserAccount> read(@RequestParam String userId){
        UserAccount read = userAccountService.read(userId);

        if(read == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(read);
    }

    //Business logic 3
    @PutMapping("/update")
    public ResponseEntity<UserAccount> update(@RequestBody UserAccount userAccount) {
        UserAccount updated = userAccountService.update(userAccount);

        if(updated == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(updated);
    }

    //Business logic 4
    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam String userId) {
        boolean deleted = userAccountService.delete(userId);

        if(!deleted)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(true);
    }

    //Business logic 5
    @PostMapping("/registerUserAccount")
    public ResponseEntity<UserAccount> registerUserAccount(@RequestParam String email,String verifyemail,String password,String verifypassword) {
        try {
            UserAccount newUserAccount = userAccountService.registerUserAccount(email, verifyemail, password, verifypassword);

            return ResponseEntity.ok(newUserAccount);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Business logic 6
    @PutMapping("/changePassword")
    public ResponseEntity changePassword(String email, String existingPassword, String newPassword, String verifyNewPassword){
        try {
            return ResponseEntity.ok(userAccountService.changePassword(existingPassword, newPassword, verifyNewPassword, email));
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Business logic 7
    @PutMapping("/updateEmailAddress")
    public ResponseEntity updateEmailAddress(String email, String existingPassword, String newEmail, String verifyNewEmail){
        try {
            return ResponseEntity.ok(userAccountService.updateEmailAddress(email, newEmail, verifyNewEmail, existingPassword));
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Business logic 8
    @GetMapping("/forgotPassword")
    public ResponseEntity forgotPassword(String email){
        try {
            return ResponseEntity.ok(userAccountService.forgotPassword(email));
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Business logic 9
    @GetMapping("/getUserAccountViaEmailAddress")
    public ResponseEntity<UserAccount> getUserAccountViaEmailAddress(String email) {
        try {
            return ResponseEntity.ok(userAccountService.getUserAccountViaEmailAddress(email));
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Business logic 10
    @GetMapping("/all")
    public ResponseEntity<Set<UserAccount>> getAll(){
      return ResponseEntity.ok(userAccountService.getAll());
    }
}
