package org.communis.asknet.conroller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private String FIELD_VIEW_PATH = "admin/";

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list() {
        return FIELD_VIEW_PATH + "list";
    }

}
