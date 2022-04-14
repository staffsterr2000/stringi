package com.staffsterr2000.stringi.controller;

import com.staffsterr2000.stringi.service.StringService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/strings")
@AllArgsConstructor
public class StringController {

    private final StringService stringService;

    @GetMapping
    public List<String> getStrings() {
        return stringService.getStrings();
    }

    @GetMapping("/compare")
    public String compareStrings() {
        return stringService.compareStrings();
    }

}
