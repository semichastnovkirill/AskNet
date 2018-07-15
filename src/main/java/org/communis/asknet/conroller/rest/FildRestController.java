package org.communis.asknet.conroller.rest;

import org.communis.asknet.dto.FieldWrapper;
import org.communis.asknet.exceptions.ServerUnexpectedException;
import org.communis.asknet.service.FieldService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin/field")
public class FildRestController {

    private final FieldService fieldService;

    public FildRestController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Long add(FieldWrapper wrapper) throws ServerUnexpectedException {
        return fieldService.add(wrapper);
    }

    @RequestMapping(value = "", method = RequestMethod.PATCH)
    public void edit(FieldWrapper wrapper) throws ServerUnexpectedException {
        fieldService.edit(wrapper);
    }

}
