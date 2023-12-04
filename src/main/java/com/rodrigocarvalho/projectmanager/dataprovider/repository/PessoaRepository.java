package com.rodrigocarvalho.projectmanager.dataprovider.repository;

import com.rodrigocarvalho.projectmanager.dataprovider.repository.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, BigInteger> {

    List<PessoaEntity> findByNomeContaining(String pessoa);

    PessoaEntity findByCpf(String cpf);
}
