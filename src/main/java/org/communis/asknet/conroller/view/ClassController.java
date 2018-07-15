package org.communis.asknet.conroller.view;

import org.communis.asknet.dto.ClassWrapper;
import org.communis.asknet.dto.filters.ClassFilterWrapper;
import org.communis.asknet.dto.filters.FieldFilterWrapper;
import org.communis.asknet.service.ClassService;
import org.communis.asknet.service.FieldService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/admin/class")
public class ClassController {

    private String FIELD_VIEW_PATH = "admin/class/";
    private final ClassService classService;
    private final FieldService fieldService;

    public ClassController(ClassService classService, FieldService fieldService) {
        this.classService = classService;
        this.fieldService = fieldService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView list(Pageable pageable, ClassFilterWrapper wrapper) {
        ModelAndView modelAndView = new ModelAndView(FIELD_VIEW_PATH + "list");
        modelAndView.addObject("page", classService.getByFilter(pageable, wrapper));
        modelAndView.addObject("filter", wrapper);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView page = new ModelAndView(FIELD_VIEW_PATH + "add");
        page.addObject("card", new ClassWrapper());

        Pageable pageable = new PageRequest(0, 15);
        List fieldList = fieldService.getByFilter(pageable, new FieldFilterWrapper()).getContent();

        page.addObject("field_list", fieldList);

        return page;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView openPage(@PathVariable("id") Long id) {
        ModelAndView page = new ModelAndView(FIELD_VIEW_PATH + "edit");
        ClassWrapper classWrapper = classService.getCard(id);
        page.addObject("card", classWrapper);

        Pageable pageable = new PageRequest(0, 15);
        List fieldList = fieldService.getByFilter(pageable, new FieldFilterWrapper(classWrapper.getFields())).getContent();
        page.addObject("field_list", fieldList);

        return page;
    }
}
