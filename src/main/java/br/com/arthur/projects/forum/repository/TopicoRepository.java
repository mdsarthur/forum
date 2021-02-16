package br.com.arthur.projects.forum.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arthur.projects.forum.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>
{
	List<Topico> findByCursoNome(String nomeCurso);
}
