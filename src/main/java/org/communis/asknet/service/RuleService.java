package org.communis.asknet.service;

import lombok.extern.log4j.Log4j2;
import org.communis.asknet.dto.RuleWrapper;
import org.communis.asknet.dto.filters.RuleFilterWrapper;
import org.communis.asknet.entity.Rule;
import org.communis.asknet.exceptions.ServerUnexpectedException;
import org.communis.asknet.exceptions.error.ErrorCodeConstants;
import org.communis.asknet.exceptions.error.ErrorInformationBuilder;
import org.communis.asknet.repository.RuleRepository;
import org.communis.asknet.repository.specifications.RuleSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Log4j2
@Service
public class RuleService {

    private final RuleRepository ruleRepository;

    public RuleService(RuleRepository ruleRepository)
    {
        this.ruleRepository = ruleRepository;
    }

    public RuleWrapper getCard(Long id) {
        Rule item = ruleRepository.findOne(id);
        return new RuleWrapper(item);
    }

    public Page getByFilter(Pageable pageable, RuleFilterWrapper filter) {
        return ruleRepository.findAll(RuleSpecification.build(filter), pageable)
                .map(RuleWrapper::new);
    }

    public Long add(RuleWrapper wrapper) throws ServerUnexpectedException {
        try {
            Rule item = new Rule();
            wrapper.fromWrapper(item);
            item.setDateOpen(new Date());
            item.setDateEdit(new Date());

            return ruleRepository.save(item).getId();
        } catch (Exception ex) {
            throw new ServerUnexpectedException(ErrorInformationBuilder.build(ErrorCodeConstants.CONFIGURE_ADD_ERROR), ex);
        }
    }

    public Long edit(RuleWrapper wrapper) throws ServerUnexpectedException {
        try {
            Rule item = ruleRepository.findOne(wrapper.getId());
            wrapper.fromWrapper(item);
            item.setDateEdit(new Date());

            return ruleRepository.save(item).getId();
        } catch (Exception ex) {
            throw new ServerUnexpectedException(ErrorInformationBuilder.build(ErrorCodeConstants.CONFIGURE_UPDATE_ERROR), ex);
        }
    }

}
