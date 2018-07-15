package org.communis.asknet.repository;

import org.communis.asknet.entity.SupportedView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SupportedViewRepository extends JpaRepository<SupportedView, String>, JpaSpecificationExecutor<SupportedView> {

    List<SupportedView> findAllByDefaultUseTrueAndGroupingIn(List<String> groups);
}
