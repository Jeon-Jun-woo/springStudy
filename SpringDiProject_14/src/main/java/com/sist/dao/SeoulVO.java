package com.sist.dao;

import lombok.Data;

/*
 * 
 *  NO                                        NOT NULL NUMBER
 TITLE                                     NOT NULL VARCHAR2(200)
 POSTER                                    NOT NULL VARCHAR2(500)
 MSG                                       NOT NULL VARCHAR2(4000)
 ADDRESS                                   NOT NULL VARCHAR2(300)
 HIT                                                NUMBER
 */
@Data
public class SeoulVO {
	private int no;
	private String title,msg,address;
}
