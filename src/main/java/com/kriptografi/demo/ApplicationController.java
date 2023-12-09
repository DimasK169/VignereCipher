package com.kriptografi.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicationController {

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("encrypt", new VignereCipher());
        model.addAttribute("decrypt", new VignereCipher());
        return "main";
    }

    @PostMapping("/encrypt")
    public String encrypt(@RequestParam String plaintext, String key, Model model) {
        VignereCipher VignereCipher = new VignereCipher();
        VignereCipher.setPlaintext(plaintext);
        VignereCipher.setKey(key);

        VignereCipher.LowerToUpper(plaintext);
        VignereCipher.LowerToUpper(key);
        String keyword = VignereCipher.generateKey(plaintext, key);
        String cipher_text = VignereCipher.cipherText(plaintext, keyword);

        System.out.println(VignereCipher.toString());
        model.addAttribute("encrypt", new VignereCipher());
        model.addAttribute("decrypt", new VignereCipher());

        model.addAttribute("ciphertext", cipher_text);
        return "main";
    }

    @PostMapping("/decrypt")
    public String decrypt(@RequestParam String ciphertext, String key, Model model) {
        VignereCipher VignereCipher = new VignereCipher();
        VignereCipher.setCiphertext(ciphertext);
        VignereCipher.setKey(key);

        VignereCipher.LowerToUpper(ciphertext);
        VignereCipher.LowerToUpper(key);
        String keyword = VignereCipher.generateKey(ciphertext, key);
        String plain_text = VignereCipher.originalText(ciphertext, keyword);

        System.out.println(VignereCipher.toString());
        model.addAttribute("encrypt", new VignereCipher());
        model.addAttribute("decrypt", new VignereCipher());

        model.addAttribute("plaintext", plain_text);
        return "main";
    }
}
