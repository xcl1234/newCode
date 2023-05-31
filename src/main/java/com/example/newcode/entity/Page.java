package com.example.newcode.entity;

public class Page {
    //当前页码
    private int current=1;
    //显示上限
    private int limit=10;
    //数据总数
    private int rows;
    //查询路径
    private String path;

    @Override
    public String toString() {
        return "Page{" +
                "current=" + current +
                ", limit=" + limit +
                ", rows=" + rows +
                ", path='" + path + '\'' +
                '}';
    }

    public Page() {
    }

    public Page(int current, int limit, int rows, String path) {
        this.current = current;
        this.limit = limit;
        this.rows = rows;
        this.path = path;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current>=1)
            this.current = current;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit>=1&&limit<100)
            this.limit = limit;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows >=0)
            this.rows = rows;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //当前页第一个坐标
    public int getOffset(){
        return (current-1)*limit;
    }

    //总页数
    public int getTotal(){
        if (rows %limit==0)
            return rows /limit;
        else
            return rows /limit+1;
    }

    //下方页数显示的第一个值
    public int getFrom(){
        int from=current-2;
        return from<1 ? 1:from;
    }

    //下方页数显示的最后一个值
    public int getTo(){
        int to=current+2;
        int total=getTotal();
        return to>total ? total:to;
    }


}
