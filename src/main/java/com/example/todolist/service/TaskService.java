package com.example.todolist.service;

import com.example.todolist.model.Task;
import com.example.todolist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import static org.apache.logging.log4j.util.Strings.isEmpty;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {

    private final TaskRepository repository;

    public Task save (Task task){
        log.info("starting service inclusion ");
        try {
            ValidTitle(task.getTitle());
            var taskSaved = repository.save(task);
            log.info("successful inclusion of the task "+taskSaved);
            return taskSaved;
        }catch (RuntimeException e){
            log.error("Error of RuntimeExpetion ".concat(e.getMessage()));
            throw new RuntimeException(e);
        }catch (Exception e){
            log.error("Error of Exception ".concat(e.getMessage()));
            throw new RuntimeException("Error adding task");
        }
    }

    public Page<Task> findAll(Pageable pageable){
        log.info("starting service get for all ");
        try {
            log.info("successful get for all ");
            return repository.findAll(pageable);
        }catch (Exception e){
            throw new RuntimeException("erro find all".concat(e.getMessage()));
        }
    }

    public Task findById(Long id){
        log.info("starting service get for id ");
        try{
            var task = validExistTask(id);
            log.info("successful get for id: "+task);
            return task;
        }catch (RuntimeException e){
            log.error("Error of RuntimeExpetion: ".concat(e.getMessage()));
            throw new RuntimeException(e);

        }catch (Exception e){
            log.error("Error of Exception: ".concat(e.getMessage()));
            throw new RuntimeException("Error get task ".concat(e.getMessage()));
        }
    }

    public String delete(Long id){
        log.info("starting service delete for id ");
        try{
            var task = validExistTask(id);
            repository.delete(task);
            log.info("delete successful");
            return "DELETED TASK SUCCESSFUL : "+task;
        }catch (RuntimeException e){
            log.error("Error of RuntimeExpetion: ".concat(e.getMessage()));
            throw new RuntimeException(e);
        }catch (Exception e){
            log.error("Error of Exception: ".concat(e.getMessage()));
            throw new RuntimeException("Error get task: ".concat(e.getMessage()));
        }
    }

    public Task uptdateTask(Long id,Task task){
        try{
            ValidTitle(task.getTitle());
            var taskUpdate = uptade(id,task);
            repository.save(taskUpdate);
            log.info("successful update of the task "+taskUpdate);
            return taskUpdate;
        }catch (RuntimeException e){
            throw new RuntimeException(e);
        }
        catch (Exception e){
            throw new RuntimeException("Error for update of task");
        }
    }

    private Task uptade(Long id,Task task){
        var taskExist = validExistTask(id);
        taskExist.setTitle(task.getTitle());
        taskExist.setDescription(task.getDescription());
        taskExist.setCompleted(task.getCompleted());
            return taskExist;
    }

    private Task validExistTask(Long id){
        return repository.findById(id)
                .orElseThrow(()->new RuntimeException("Task not found"));
    }


    private void ValidTitle (String title){
        if (isEmpty(title)){
            throw new RuntimeException("Title cannot be empty");
        }
    }
}
