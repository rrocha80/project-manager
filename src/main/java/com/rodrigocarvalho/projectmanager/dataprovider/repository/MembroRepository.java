package com.rodrigocarvalho.projectmanager.dataprovider.repository;

import com.rodrigocarvalho.projectmanager.dataprovider.repository.entity.MembroEntity;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.entity.PessoaEntity;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.entity.ProjetoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;
@Repository
public interface MembroRepository extends JpaRepository<MembroEntity, BigInteger> {
    Optional<MembroEntity> findByProjetoAndPessoa(ProjetoEntity projeto, PessoaEntity pessoa);

}
