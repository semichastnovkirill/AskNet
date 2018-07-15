package org.communis.asknet.repository;

import org.communis.asknet.entity.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ViewRepository extends JpaRepository<View, Long>, JpaSpecificationExecutor<View> {

}
