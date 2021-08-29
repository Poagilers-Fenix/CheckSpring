package br.com.fiap.epictask.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

import br.com.fiap.epictask.model.Task;
import br.com.fiap.epictask.repository.TaskRepository;

@RestController //-> indica que não vai acionar uma view
@RequestMapping("/api/task")
public class ApiTaskController {
	
	@Autowired
	private TaskRepository repository;
	
	@GetMapping //required -> diz que title nao é obrigatorio
	public Page<Task> index(@RequestParam(required = false) String title,
			 @PageableDefault Pageable pageable) {
		
		if (title == null ) 
			return repository.findAll(pageable);
		
		return repository.findByTitleLike("%" + title + "%", pageable);
	}
	
	@PostMapping
	public ResponseEntity<Task> create(
			@RequestBody Task task,
			UriComponentsBuilder uriBuilder
			) {
		repository.save(task);
		
		URI uri = uriBuilder
				.path("api/task/{id}")
				.buildAndExpand(task.getId())
				.toUri();
		 
		return ResponseEntity.created(uri).body(task); //endereco unico do recurso
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Task> get(@PathVariable Long id) {
		Optional<Task> task = repository.findById(id);
		if(task.isPresent())
			return ResponseEntity.ok(task.get());
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Task> delete(@PathVariable Long id) {
		Optional<Task> task = repository.findById(id);
		if(task.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok(null);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Task> edit(@PathVariable Long id, @RequestBody Task task){				
		task.setId(id);
		Task newTask = repository.save(task);
		return ResponseEntity.ok(newTask);
	}

}
