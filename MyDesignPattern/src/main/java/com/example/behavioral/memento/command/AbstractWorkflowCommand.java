package com.example.behavioral.memento.command;

import com.example.behavioral.memento.WorkflowDesigner;

public abstract class AbstractWorkflowCommand implements WorkflowCommand {
    protected WorkflowDesigner.Memento memento;
    protected WorkflowDesigner receiver;

    public AbstractWorkflowCommand(WorkflowDesigner designer) {
        this.receiver = designer;
    }

    @Override
    public void undo() {
        receiver.setMemento(memento);
    }
}
