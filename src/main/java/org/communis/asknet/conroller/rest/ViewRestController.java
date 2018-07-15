package org.communis.asknet.conroller.rest;

import org.communis.asknet.dto.ViewWrapper;
import org.communis.asknet.exceptions.ServerUnexpectedException;
import org.communis.asknet.service.ViewService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin/view")
public class ViewRestController {

    private final ViewService viewService;

    public ViewRestController(ViewService viewService) {
        this.viewService = viewService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Long add(ViewWrapper wrapper) throws ServerUnexpectedException {
        return viewService.add(wrapper);
    }

    @RequestMapping(value = "", method = RequestMethod.PATCH)
    public void edit(ViewWrapper wrapper) throws ServerUnexpectedException {
        viewService.edit(wrapper);
    }

}
