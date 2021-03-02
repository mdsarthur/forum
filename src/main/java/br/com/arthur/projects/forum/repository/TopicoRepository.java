package br.com.arthur.projects.forum.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arthur.projects.forum.dto.topico.TopicoDto;
import br.com.arthur.projects.forum.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>
{
	List<TopicoDto> findByCursoNome(String nomeCurso);
	
	Page<TopicoDto> findByCursoNome(String nomeCurso, Pageable paginacao);
	
	Page<TopicoDto> findAllProjectedBy(Pageable paginacao);
}
