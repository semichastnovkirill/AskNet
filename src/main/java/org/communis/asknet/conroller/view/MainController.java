package org.communis.asknet.conroller.view;

import org.communis.asknet.dto.filters.MainFilterWrapper;
import org.communis.asknet.exceptions.ServerUnexpectedException;
import org.communis.asknet.service.ViewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private final ViewService viewService;

    public MainController(ViewService viewService) {
        this.viewService = viewService;
    }

    @GetMapping({"/", "/index"})
    public ModelAndView index(MainFilterWrapper wrapper) throws ServerUnexpectedException {
        ModelAndView modelAndView = new ModelAndView("index");

        return modelAndView;
    }

}
