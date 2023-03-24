package io.klvl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController
public class MainController {

    @SuppressWarnings("SameReturnValue")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    private String getIndex() {
        return "I am alive!";
    }

}
