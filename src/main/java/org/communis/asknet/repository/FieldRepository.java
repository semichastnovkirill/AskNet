package org.communis.asknet.repository;

import org.communis.asknet.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FieldRepository extends JpaRepository<Field, Long>, JpaSpecificationExecutor<Field> {

}
