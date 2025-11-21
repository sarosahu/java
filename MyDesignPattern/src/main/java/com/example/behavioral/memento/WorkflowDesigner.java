package com.example.behavioral.memento;

public class WorkflowDesigner {
    private Workflow workflow;
    // Memento
    public class Memento {
        private String[] steps;
        private String name;
        private Memento() {}
        private Memento(String[] steps, String name) {
            this.steps = steps;
            this.name = name;
        }
        private String[] getSteps() {
            return this.steps;
        }
        private String getName() {
            return this.name;
        }
        private boolean isEmpty() {
            return this.getSteps() == null && this.getName() == null;
        }
    }
    public void createWorkflow(String name) {
        workflow = new Workflow(name);
    }
    public Workflow getWorkflow() {
        return this.workflow;
    }
    public Memento getMemento() {
        if (this.workflow == null) {
            return new Memento();
        }
        return new Memento(this.workflow.getSteps(), workflow.getName());
    }

    public void setMemento(Memento memento) {
        if (memento.isEmpty()) {
            this.workflow = null;
        } else {
            this.workflow = new Workflow(memento.getName(), memento.getSteps());
        }
    }

    public void addStep(String step) {
        workflow.addStep(step);
    }

    public void removeStep(String step) {
        workflow.removeStep(step);
    }

    public void print() {
        System.out.println(workflow);
    }
}
