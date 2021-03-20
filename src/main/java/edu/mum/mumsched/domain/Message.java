package edu.mum.mumsched.domain;

public class Message {
    private String mId;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "mId=" + mId +
                ", msg=" + msg +
                '}';
    }
}
