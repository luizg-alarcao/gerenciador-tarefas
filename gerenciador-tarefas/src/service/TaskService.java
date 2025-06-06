package service;

import model.Task;
import util.LogUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TaskService {
    private List<Task> tasks = new ArrayList<>();
    private static final Logger logger = LogUtil.getLogger();
    
    public void addTask(String titulo, String descricao) {
    	Task task = new Task(titulo, descricao);
    	tasks.add(task);
    	logger.info("Tarefa adicionada: " + titulo);
    }
    
    public void completeTask(String titulo) {
        for (Task task : tasks) {
            if (task.getTitulo().equalsIgnoreCase(titulo)) {
                task.marcadoConcluido();
                logger.info("Tarefa concluída: " + titulo);
                return;
            }
        }
        
        logger.warning("Tarefa não encontrada para conclusão: " + titulo);
    }
    
    public void listTasks() {
        logger.info("Listando tarefas: ");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
    
}
