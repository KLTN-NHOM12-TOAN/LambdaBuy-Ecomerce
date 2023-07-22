package com.kltn.nhom12.LambdaBuyDesktop.bean;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.kltn.SpringAPILambdaBuy.entities.UserEntity;

public class MenuBean {
    private String kind;
    private JPanel jpn;
    private JLabel jlb;
    private UserEntity user;

    public MenuBean() {
    }

    public MenuBean(String kind, JPanel jpn, JLabel jlb) {
        this.kind = kind;
        this.jpn = jpn;
        this.jlb = jlb;
    }
    
    
    public MenuBean(String kind, JPanel jpn, JLabel jlb, UserEntity user) {
		super();
		this.kind = kind;
		this.jpn = jpn;
		this.jlb = jlb;
		this.user = user;
	}

	public MenuBean(String kind){
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }

    public JLabel getJlb() {
        return jlb;
    }

    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}    
}
