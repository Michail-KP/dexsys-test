package ru.dexsys.command;

public abstract class Command {
    private String arg;
    private final boolean needData;

    protected Command(boolean neededData) {
        this.needData = neededData;
    }

    public boolean isNeedData() {
        return needData;
    }

    public void setArg(String arg) {
        this.arg = arg;
    }

    public String getArg() {
        return arg;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass() == obj.getClass();
    }

    public abstract String execute() throws Exception;
}
