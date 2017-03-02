package com.eakonovalov.pattern.state;

/**
 * Created by Waine on 02.02.2017.
 */
public abstract class AbstractState implements State {

    private String code;

    public AbstractState(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractState that = (AbstractState) o;

        return code != null ? code.equals(that.code) : that.code == null;
    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }

    /**
     * @param context context
     */
    public void doAction(Context context) {

    }

}
