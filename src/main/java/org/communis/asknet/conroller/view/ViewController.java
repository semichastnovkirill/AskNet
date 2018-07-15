package org.communis.asknet.conroller.view;

import org.communis.asknet.dto.FieldWrapper;
import org.communis.asknet.dto.filters.ViewFilterWrapper;
import org.communis.asknet.service.ViewService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin/view")
public class ViewController {

    private String FIELD_VIEW_PATH = "admin/view/";
    private final ViewService viewService;

    public ViewController(ViewService viewService) {
        this.viewService = viewService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView list(Pageable pageable, ViewFilterWrapper wrapper) {
        ModelAndView modelAndView = new ModelAndView(FIELD_VIEW_PATH + "list");
        modelAndView.addObject("page", viewService.getByFilter(pageable, wrapper));
        modelAndView.addObject("filter", wrapper);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView addPage = new ModelAndView(FIELD_VIEW_PATH + "add");
        addPage.addObject("card", new FieldWrapper());
        addPage.addObject("supportedView", viewService.getSupportedView());
        return addPage;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView openPage(@PathVariable("id") Long id) {
        ModelAndView openPage = new ModelAndView(FIELD_VIEW_PATH + "edit");
        openPage.addObject("card", viewService.getCard(id));
        openPage.addObject("supportedView", viewService.getSupportedView());
        return openPage;
    }
}
