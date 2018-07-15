package org.communis.asknet.repository.specifications;

import org.communis.asknet.dto.filters.RuleFilterWrapper;
import org.communis.asknet.entity.Rule;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public abstract class RuleSpecification implements Specification<Rule>
{
    private RuleSpecification(){}

    public static RuleSpecification build(final RuleFilterWrapper filter)
    {
        return new RuleSpecification()
        {
            @Override
            public Predicate toPredicate(Root<Rule> root, CriteriaQuery<?> cq, CriteriaBuilder cb)
            {
                final List predicates = new ArrayList();

                if (filter != null)
                {
                    if (filter.getSearch() != null && !filter.getSearch().isEmpty())
                    {
                        predicates.add(cb.like(cb.upper(root.get("title")), '%' + filter.getSearch().toUpperCase() + '%'));
                    }
                }

                return cb.and((Predicate[]) predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }

}