package org.communis.asknet.conroller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/admin/layout")
public class LayoutController {

    private String FIELD_VIEW_PATH = "admin/layout/";

    public LayoutController() {
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView(FIELD_VIEW_PATH + "main");

        // Доступные элементы для построения конфигурации
        ArrayList<String> src = new ArrayList<String>();
        for (int i = 10; i < 20; i++) {
            src.add("Элемент #" + i);
        }
        modelAndView.addObject("src", src);

        // Конфигурация представления
        ArrayList<String> elements = new ArrayList<String>();
        for (int i = 1; i < 10; i++) {
            elements.add("Элемент #" + i);
        }
        modelAndView.addObject("elements", elements);

        return modelAndView;
    }

}
