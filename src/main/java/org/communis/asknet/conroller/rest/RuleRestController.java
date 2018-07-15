package org.communis.asknet.conroller.rest;

import org.communis.asknet.dto.RuleWrapper;
import org.communis.asknet.exceptions.ServerUnexpectedException;
import org.communis.asknet.service.RuleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin/rule")
public class RuleRestController {

    private final RuleService ruleService;

    public RuleRestController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Long add(RuleWrapper wrapper) throws ServerUnexpectedException {
        return ruleService.add(wrapper);
    }

    @RequestMapping(value = "", method = RequestMethod.PATCH)
    public void edit(RuleWrapper wrapper) throws ServerUnexpectedException {
        ruleService.edit(wrapper);
    }

}
