package com.ia.aispring.service;

import com.ia.aispring.entity.Aluno;
import com.ia.aispring.entity.Curso;
import com.ia.aispring.entity.Matricula;
import com.ia.aispring.entity.dto.GeminiRequest;
import com.ia.aispring.entity.dto.GeminiResponse;
import com.ia.aispring.entity.dto.MatriculaDTO;
import com.ia.aispring.entity.mapper.MatriculaMapper;
import com.ia.aispring.repository.AlunoRepository;
import com.ia.aispring.repository.CursoRepository;
import com.ia.aispring.repository.MatriculaRepository;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MatriculaService {
	
	@Value("${gemini.api.key}")
    private String apiKey;
	
	private final MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;
    private final MatriculaMapper mapper;
	private final RestClient restClient;
	

	public MatriculaService(
			MatriculaRepository matriculaRepository, 
			AlunoRepository alunoRepository, 
			CursoRepository cursoRepository, 
			MatriculaMapper mapper,
			RestClient.Builder builder) {
		this.matriculaRepository = matriculaRepository;
		this.alunoRepository = alunoRepository;
		this.cursoRepository = cursoRepository;
		this.mapper = mapper;
		this.restClient = builder.baseUrl("https://googleapis.com").build();
	}
	
    @Transactional
    public void salvar(MatriculaDTO dto) {
        Matricula matricula = mapper.toEntity(dto);
        Aluno aluno = alunoRepository.findById(dto.idAluno()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
        Curso curso = cursoRepository.findById(dto.idCurso()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado"));

        matricula.setAluno(aluno);
        matricula.setCurso(curso);
		matricula.setDataMatricula(LocalDate.now());
        matriculaRepository.save(matricula);
    }
	
	public String extrairData(String mensagemUsuario) {
        String prompt = "Extraia a data desta frase no formato YYYY-MM-DD. Responda apenas a data: " + mensagemUsuario;
        
        GeminiRequest corpo = GeminiRequest.deMensagem(prompt);

        GeminiResponse response = restClient.post()
                .uri(uriBuilder -> uriBuilder
                    .path("/v1beta/models/gemini-1.5-flash:generateContent")
                    .queryParam("key", apiKey)
                    .build())
                .contentType(MediaType.APPLICATION_JSON)
                .body(corpo)
                .retrieve()
                .body(GeminiResponse.class);

        return response != null ? response.getTextoResposta().trim() : "";
    }
}
