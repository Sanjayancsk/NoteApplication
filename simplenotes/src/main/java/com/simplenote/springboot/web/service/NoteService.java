package com.simplenote.springboot.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.simplenote.springboot.web.model.Note;


@Service
public class NoteService {
    private static List<Note> notes = new ArrayList<Note>();
    private static int noteCount = 3;

    static {
        notes.add(new Note(1, "BreakFast", "Sanwitch", new Date(),
                ""));
        notes.add(new Note(2, "Lunch", "Meals", new Date(), ""));
        notes.add(new Note(3, "Dinner", "Pizza's", new Date(),
                ""));
    }

    public List<Note> retrieveTodos(String user) {
        List<Note> filteredTodos = new ArrayList<Note>();
        for (Note todo : notes) {
            if (todo.getUser().equalsIgnoreCase(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
    
    public Note retrieveTodo(int id) {
        for (Note todo : notes) {
            if (todo.getId()==id) {
                return todo;
            }
        }
        return null;
    }

    public void updateTodo(Note todo){
    		notes.remove(todo);
    		notes.add(todo);
    }

    public void addTodo(String name, String title, Date targetDate,
            String detail) {
        notes.add(new Note(++noteCount, name, title, targetDate,detail));
    }

    public void deleteTodo(int id) {
        Iterator<Note> iterator = notes.iterator();
        while (iterator.hasNext()) {
            Note todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }
}