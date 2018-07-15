package org.communis.asknet.service;

import org.communis.asknet.dto.FieldWrapper;
import org.communis.asknet.dto.SupportedDataTypeWrapper;
import org.communis.asknet.dto.filters.FieldFilterWrapper;
import org.communis.asknet.entity.Field;
import org.communis.asknet.exceptions.ServerUnexpectedException;
import org.communis.asknet.exceptions.error.ErrorCodeConstants;
import org.communis.asknet.exceptions.error.ErrorInformationBuilder;
import org.communis.asknet.repository.FieldRepository;
import org.communis.asknet.repository.SupportedDataTypeRepository;
import org.communis.asknet.repository.specifications.FieldSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FieldService {

    private final FieldRepository fieldRepository;
    private final SupportedDataTypeRepository supportedDataTypeRepository;

    public FieldService(FieldRepository fieldRepository,
                        SupportedDataTypeRepository supportedDataTypeRepository) {
        this.fieldRepository = fieldRepository;
        this.supportedDataTypeRepository = supportedDataTypeRepository;
    }

    public FieldWrapper getCard(Long id) {
        Field configure = fieldRepository.findOne(id);
        return new FieldWrapper(configure);
    }

    public Page getByFilter(Pageable pageable, FieldFilterWrapper filter) {
        return fieldRepository.findAll(FieldSpecification.build(filter), pageable)
                .map(FieldWrapper::new);
    }

    public Long add(FieldWrapper wrapper) throws ServerUnexpectedException {
        try {
            Field item = new Field();
            wrapper.fromWrapper(item);
            item.setDateOpen(new Date());
            item.setDateEdit(new Date());
            item.setType(supportedDataTypeRepository.findOne(wrapper.getType().getId()));

            return fieldRepository.save(item).getId();
        } catch (Exception ex) {
            throw new ServerUnexpectedException(ErrorInformationBuilder.build(ErrorCodeConstants.CONFIGURE_ADD_ERROR), ex);
        }
    }

    public Long edit(FieldWrapper wrapper) throws ServerUnexpectedException {
        try {
            Field item = fieldRepository.findOne(wrapper.getId());
            wrapper.fromWrapper(item);
            item.setDateEdit(new Date());

            return fieldRepository.save(item).getId();
        } catch (Exception ex) {
            throw new ServerUnexpectedException(ErrorInformationBuilder.build(ErrorCodeConstants.CONFIGURE_UPDATE_ERROR), ex);
        }
    }

    public List getSupportedDataTypes() {
        return supportedDataTypeRepository.findAll().stream().map(SupportedDataTypeWrapper::new).collect(Collectors.toList());
    }
}
