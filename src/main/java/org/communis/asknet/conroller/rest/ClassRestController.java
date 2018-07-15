package org.communis.asknet.conroller.rest;

import org.communis.asknet.dto.ClassWrapper;
import org.communis.asknet.exceptions.ServerUnexpectedException;
import org.communis.asknet.service.ClassService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin/class")
public class ClassRestController {

    private final ClassService classService;

    public ClassRestController(ClassService classService) {
        this.classService = classService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Long add(ClassWrapper wrapper) throws ServerUnexpectedException {
        return classService.add(wrapper);
    }

    @RequestMapping(value = "", method = RequestMethod.PATCH)
    public void edit(ClassWrapper wrapper) throws ServerUnexpectedException {
        classService.edit(wrapper);
    }

}
