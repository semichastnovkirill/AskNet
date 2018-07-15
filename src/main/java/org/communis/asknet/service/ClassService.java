package org.communis.asknet.service;

import org.communis.asknet.dto.ClassWrapper;
import org.communis.asknet.dto.FieldWrapper;
import org.communis.asknet.dto.filters.ClassFilterWrapper;
import org.communis.asknet.entity.Issue;
import org.communis.asknet.exceptions.ServerUnexpectedException;
import org.communis.asknet.exceptions.error.ErrorCodeConstants;
import org.communis.asknet.exceptions.error.ErrorInformationBuilder;
import org.communis.asknet.repository.FieldRepository;
import org.communis.asknet.repository.IssueRepository;
import org.communis.asknet.repository.specifications.ClassSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ClassService {

    private final IssueRepository issueRepository;
    private final FieldRepository fieldRepository;

    public ClassService(IssueRepository issueRepository, FieldRepository fieldRepository)
    {
        this.issueRepository = issueRepository;
        this.fieldRepository = fieldRepository;
    }

    public ClassWrapper getCard(Long id) {
        Issue item = issueRepository.findOne(id);
        return new ClassWrapper(item);
    }

    public Page getByFilter(Pageable pageable, ClassFilterWrapper filter) {
        return issueRepository.findAll(ClassSpecification.build(filter), pageable)
                .map(ClassWrapper::new);
    }

    public Long add(ClassWrapper wrapper) throws ServerUnexpectedException {
        try {
            Issue item = new Issue();
            wrapper.fromWrapper(item);
            item.setDateOpen(new Date());
            item.setDateEdit(new Date());

            for(FieldWrapper w : wrapper.getFields()) {
                item.getFieldList().add(fieldRepository.findOne(w.getId()));
            }

            return issueRepository.save(item).getId();
        } catch (Exception ex) {
            throw new ServerUnexpectedException(ErrorInformationBuilder.build(ErrorCodeConstants.CONFIGURE_ADD_ERROR), ex);
        }
    }

    public Long edit(ClassWrapper wrapper) throws ServerUnexpectedException {
        try {
            Issue item = issueRepository.findOne(wrapper.getId());
            wrapper.fromWrapper(item);
            item.setDateEdit(new Date());

            return issueRepository.save(item).getId();
        } catch (Exception ex) {
            throw new ServerUnexpectedException(ErrorInformationBuilder.build(ErrorCodeConstants.CONFIGURE_UPDATE_ERROR), ex);
        }
    }
}
