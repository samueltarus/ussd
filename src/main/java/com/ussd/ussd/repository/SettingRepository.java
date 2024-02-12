package com.ussd.ussd.repository;

import com.ussd.ussd.model.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingRepository extends JpaRepository<Setting,Long> {
}
