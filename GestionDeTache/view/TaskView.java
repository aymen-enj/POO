package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controler.TaskController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskView extends JFrame {
    private JTextField taskField;
    private JButton addButton, deleteButton;
    private JTable taskTable;
    private DefaultTableModel tableModel;
    private TaskController controller;

    public TaskView(TaskController controller) {
        this.controller = controller;

        setTitle("To-Do List");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        taskField = new JTextField();
        addButton = new JButton("Add Task");
        deleteButton = new JButton("Delete Task");

        tableModel = new DefaultTableModel(new Object[]{"Task", "Completed"}, 0);
        taskTable = new JTable(tableModel);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(taskField, BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.EAST);
        add(panel, BorderLayout.NORTH);

        add(new JScrollPane(taskTable), BorderLayout.CENTER);
        add(deleteButton, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeTask();
            }
        });

    }

    private void addTask() { 
        String description = taskField.getText().trim();
        if (!description.isEmpty()) {
            controller.addTask(description);
            updateTaskList();
            taskField.setText("");
        }
    }

    private void removeTask() { 
        int selectedRow = taskTable.getSelectedRow();
        if (selectedRow != -1) {
            controller.removeTask(selectedRow);
            updateTaskList();
        }
    }

    public void updateTaskList() {
        tableModel.setRowCount(0);
        for (model.Task task : controller.getTasks()) {
            tableModel.addRow(new Object[]{task.getDescription(), task.isCompleted()});
        }
    }
}
