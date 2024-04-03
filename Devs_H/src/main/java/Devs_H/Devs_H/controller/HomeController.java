package Devs_H.Devs_H.controller;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SubscriptionListResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Principal;

import static Devs_H.Devs_H.api.ApiExample.getService;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "Hello, Home!";
    }

    @GetMapping("/secured")
    public String secured(){
        //return "Hello, Secured!";
        try{
         YouTube youtubeService = getService();
            // Define and execute the API request
            YouTube.Subscriptions.List request = youtubeService.subscriptions()
                    .list("id,snippet");
            SubscriptionListResponse response = request.setChannelId("UC0HPqFDlrI2ngsLEanMWw2A").execute();
        }catch (GeneralSecurityException e){

        }catch (IOException e){

        }
        return "dsds";
    }

    @GetMapping("/user")
    public Principal user(Principal principal){
        System.out.println("username : " + principal.getName());
        return principal;
    }
}
