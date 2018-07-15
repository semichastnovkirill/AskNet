package org.communis.asknet.service;

import lombok.extern.log4j.Log4j2;
import org.communis.asknet.dto.SupportedViewWrapper;
import org.communis.asknet.dto.ViewWrapper;
import org.communis.asknet.dto.filters.ViewFilterWrapper;
import org.communis.asknet.entity.View;
import org.communis.asknet.exceptions.ServerUnexpectedException;
import org.communis.asknet.exceptions.error.ErrorCodeConstants;
import org.communis.asknet.exceptions.error.ErrorInformationBuilder;
import org.communis.asknet.repository.SupportedViewRepository;
import org.communis.asknet.repository.ViewRepository;
import org.communis.asknet.repository.specifications.ViewSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
public class ViewService {

    private final SupportedViewRepository supportedViewRepository;
    private final ViewRepository viewRepository;

    public ViewService(SupportedViewRepository supportedViewRepository,
                       ViewRepository viewRepository)
    {
        this.supportedViewRepository = supportedViewRepository;
        this.viewRepository = viewRepository;
    }

    public ViewWrapper getCard(Long id) {
        View item = viewRepository.findOne(id);
        return new ViewWrapper(item);
    }

    public Page getByFilter(Pageable pageable, ViewFilterWrapper filter) {
        return viewRepository.findAll(ViewSpecification.build(filter), pageable)
                .map(ViewWrapper::new);
    }

    public Long add(ViewWrapper wrapper) throws ServerUnexpectedException {
        try {
            View item = new View();
            wrapper.fromWrapper(item);
            item.setDateOpen(new Date());
            item.setDateEdit(new Date());

            return viewRepository.save(item).getId();
        } catch (Exception ex) {
            throw new ServerUnexpectedException(ErrorInformationBuilder.build(ErrorCodeConstants.CONFIGURE_ADD_ERROR), ex);
        }
    }

    public Long edit(ViewWrapper wrapper) throws ServerUnexpectedException {
        try {
            View item = viewRepository.findOne(wrapper.getId());
            wrapper.fromWrapper(item);
            item.setDateEdit(new Date());

            return viewRepository.save(item).getId();
        } catch (Exception ex) {
            throw new ServerUnexpectedException(ErrorInformationBuilder.build(ErrorCodeConstants.CONFIGURE_UPDATE_ERROR), ex);
        }
    }

    public List getSupportedView() {
        return supportedViewRepository.findAll().stream().map(SupportedViewWrapper::new).collect(Collectors.toList());
    }

}
