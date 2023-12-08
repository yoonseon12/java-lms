package nextstep.courses.domain;

public enum SessionStatus {

    PREPARING(false),
    OPEN(true),
    CLOSED(false);

    private boolean isApplicable;

    SessionStatus(boolean isApplicable) {
        this.isApplicable = isApplicable;
    }

    public boolean canApply() {
        return this.isApplicable;
    }
}
