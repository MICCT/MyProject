package co.mass.mybatis.notice.service;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NoticeVO {
	private int nid;
	private String id;
	private String name;
	private Date writedate;
	private String title;
	private String contents;
	private int hit;

}
