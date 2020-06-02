package com.flowz.roomdatabasewithkotlin;

import java.lang.System;

@androidx.room.Entity()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/flowz/roomdatabasewithkotlin/Emp_Entity;", "", "()V", "emp_id", "", "getEmp_id", "()I", "setEmp_id", "(I)V", "emp_name", "", "getEmp_name", "()Ljava/lang/String;", "setEmp_name", "(Ljava/lang/String;)V", "emp_post", "getEmp_post", "setEmp_post", "app_debug"})
public final class Emp_Entity {
    @androidx.room.PrimaryKey()
    private int emp_id;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "EMP_NAME")
    private java.lang.String emp_name;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "EMP_POST")
    private java.lang.String emp_post;
    
    public final int getEmp_id() {
        return 0;
    }
    
    public final void setEmp_id(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmp_name() {
        return null;
    }
    
    public final void setEmp_name(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmp_post() {
        return null;
    }
    
    public final void setEmp_post(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public Emp_Entity() {
        super();
    }
}