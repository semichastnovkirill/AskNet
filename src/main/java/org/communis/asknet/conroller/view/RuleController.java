package org.communis.asknet.conroller.view;

import org.communis.asknet.dto.RuleWrapper;
import org.communis.asknet.dto.filters.RuleFilterWrapper;
import org.communis.asknet.service.RuleService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin/rule")
public class RuleController {

    private String FIELD_VIEW_PATH = "admin/rule/";
    private final RuleService ruleService;

    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView list(Pageable pageable, RuleFilterWrapper wrapper) {
        ModelAndView modelAndView = new ModelAndView(FIELD_VIEW_PATH + "list");
        modelAndView.addObject("page", ruleService.getByFilter(pageable, wrapper));
        modelAndView.addObject("filter", wrapper);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView addPage = new ModelAndView(FIELD_VIEW_PATH + "add");
        addPage.addObject("card", new RuleWrapper());
        return addPage;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView openPage(@PathVariable("id") Long id) {
        ModelAndView openPage = new ModelAndView(FIELD_VIEW_PATH + "edit");
        openPage.addObject("card", ruleService.getCard(id));
        return openPage;
    }
}
