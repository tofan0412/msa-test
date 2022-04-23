package com.rank.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ping")
public class CommonController {

    @GetMapping("")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("ping");
    }
}
