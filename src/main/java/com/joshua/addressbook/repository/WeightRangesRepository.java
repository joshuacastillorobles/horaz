package com.joshua.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joshua.addressbook.entity.WeightRange;

@Repository
public interface WeightRangesRepository extends JpaRepository<WeightRange, Integer> {

}
