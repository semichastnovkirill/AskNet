package org.communis.asknet.repository;

import org.communis.asknet.entity.SupportedDataType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SupportedDataTypeRepository extends JpaRepository<SupportedDataType, String>, JpaSpecificationExecutor<SupportedDataType> {
}
