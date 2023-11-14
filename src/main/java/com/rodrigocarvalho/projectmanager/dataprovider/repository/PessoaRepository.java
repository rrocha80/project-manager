package com.rodrigocarvalho.projectmanager.dataprovider.repository;

import com.rodrigocarvalho.projectmanager.dataprovider.repository.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, BigInteger> {
}
