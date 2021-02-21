package br.com.arthur.projects.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arthur.projects.forum.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>
{

	Curso findByNome(String nomeCurso);
	
}
