package Day07app;

public enum BookStatus {
    IN_STOCK("存在"),BORROWED("已借出"),LOST("丢失");
    private String desc;
    BookStatus(String desc) {
        this.desc = desc;
    }
    public String getDesc() {
        return desc;
    }
}
