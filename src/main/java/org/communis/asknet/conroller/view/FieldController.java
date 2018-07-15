package org.communis.asknet.conroller.view;

import org.communis.asknet.dto.FieldWrapper;
import org.communis.asknet.dto.filters.FieldFilterWrapper;
import org.communis.asknet.service.FieldService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin/field")
public class FieldController {

    private String FIELD_VIEW_PATH = "admin/field/";
    private final FieldService fieldService;

    public FieldController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView list(Pageable pageable, FieldFilterWrapper wrapper) {
        ModelAndView modelAndView = new ModelAndView(FIELD_VIEW_PATH + "list");
        modelAndView.addObject("page", fieldService.getByFilter(pageable, wrapper));
        modelAndView.addObject("filter", wrapper);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView addPage = new ModelAndView(FIELD_VIEW_PATH + "add");
        addPage.addObject("card", new FieldWrapper());
        addPage.addObject("config_type_list", fieldService.getSupportedDataTypes());
        return addPage;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView openPage(@PathVariable("id") Long id) {
        ModelAndView openPage = new ModelAndView(FIELD_VIEW_PATH + "edit");
        openPage.addObject("card", fieldService.getCard(id));
        openPage.addObject("config_type_list", fieldService.getSupportedDataTypes());
        return openPage;
    }
}
